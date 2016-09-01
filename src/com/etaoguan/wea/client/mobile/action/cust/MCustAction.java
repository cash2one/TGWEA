package com.etaoguan.wea.client.mobile.action.cust;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMCustService;
import com.etaoguan.wea.client.mobile.vo.Mcustomer;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.Customer;

@WeaModule(mname="客户管理")
@Service("custMCustAction") @Scope("prototype")
public class MCustAction extends MOwnerBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	private Customer customer;
	private Mcustomer mcustomer;
	
	public Mcustomer getMcustomer() {
		return mcustomer;
	}

	public void setMcustomer(Mcustomer mcustomer) {
		this.mcustomer = mcustomer;
	}

	@Resource(name="mcustService")
	private IMCustService imCustService;
	

	@Action(value="mRegCust")
	public String regCust() throws Exception{
		String sessionCode = (String) getSessionAttribute("checkCode");
		if (StringUtils.isBlank(sessionCode)) {
			weaResponse.setFailStatus();
			weaResponse.setMessage("验证码错误！");
		}else {
			
			String checkCode = mcustomer.getCheckCode().toLowerCase();
			if (!checkCode.equals("")) {
				String lowerCode = sessionCode.toLowerCase();
					if (checkCode.equals(lowerCode)) {
						mcustomer.getCustomer().setOwnerNum(ownerNum);
						imCustService.addCust(mcustomer.getCustomer());
					}else {
						weaResponse.setFailStatus();
						weaResponse.setMessage("验证码错误！");
					}
			} else {
				weaResponse.setFailStatus();
				weaResponse.setMessage("请填写验证码！");
			}
		}
	
		
		
		return JSONRESPONSE;
	}
	
	@Action(value="mExistCustname")
	public String existCustName() throws Exception {
			String custName = getRequest().getParameter("custName");
			weaResponse.setRespData(imCustService.existCustName(ownerNum,custName));
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="更新客户密码(移动端)",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mUpdateCustPwd")
	public String updateCustPwd() {
		
		String oldPwd = getRequest().getParameter("oldPwd");
		String newPwd = getRequest().getParameter("newPwd");
		Customer currCust = getCurrentCust();
		if(currCust.getPassword().equals(oldPwd)){
			imCustService.updateCustPwd(getCurrentCust().getCustNum(), newPwd);
			customer = imCustService.getLoginCust(getCurrentCust().getCustNum());
			setSessionAttribute(WeaConstant.CURCUST, customer);
		}else{
			weaResponse.setFailStatus();
			weaResponse.setMessage("旧密码输入错误，修改失败！");
		}
		
		return JSONRESPONSE;
	}
	@WeaFunction(fname="更新客户(移动端)",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mUpdateCust")
	public String updateCust() throws Exception {
			customer.setCustNum(getCurrentCust().getCustNum());
			imCustService.updateCust(customer);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="获取客户详情(移动端)",oname=WeaFunction.Operation.READ)
	@Action(value="mGetCust")
	public String getCust() throws Exception {
			Customer cust = imCustService.getCust(getCurrentCust().getCustNum());
			weaResponse.setRespData(cust);
		
		return JSONRESPONSE;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
