package com.etaoguan.wea.client.mobile.action.cust;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMCustService;
import com.etaoguan.wea.client.mobile.service.IMOwnerService;
import com.etaoguan.wea.client.mobile.service.IMPushMessageService;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.Customer;

@Service("custMLoginAction") @Scope("prototype")
public class MLoginAction extends MOwnerBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	private Customer customer;
	
	@Resource(name="mcustService")
	private IMCustService imCustService;
	@Resource(name="mownerService")
	private IMOwnerService imOwnerService;
	@Resource(name="mpushMessageService")
	private IMPushMessageService imPushMessageService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Action(value="mLogin")
	public String login() throws IOException {

		String custName = getRequestParamValue("custName");
		String custPwd = getRequestParamValue("custPwd");
		Customer cust = imCustService.getLoginCust(ownerNum,custName,custPwd);
		if(cust==null||!ownerNum.equals(cust.getOwnerNum())){
			weaResponse.setFailStatus();
			weaResponse.setMessage("用户名或密码错误！");
		}else{
			boolean activeOwner = imOwnerService.isActiveOwner(ownerNum);
			if(!activeOwner){
				weaResponse.setFailStatus();
				weaResponse.setMessage("企业未经授权");
			}else{
				imCustService.updateCustLoginDate(cust.getCustNum(), new Date());
				setLoginSessionAttribute(WeaConstant.CURCUST,cust);
				Map tagNAlias = new HashMap();
				tagNAlias.put("alias", imPushMessageService.getCustPushGroupNums(cust.getCustNum()));
				tagNAlias.put("tag", cust.getCustNum());
				weaResponse.setRespData(tagNAlias);
			}

		}
		return JSONRESPONSE;
		
	}
	
	@Action(value="mGetLoginStatus")
	public String getLoginStatus() throws IOException, ServletException{
		if(getCurrentCust()==null){
			weaResponse.setFailStatus();
			weaResponse.setMessage("无登录客户");
		}
		return JSONRESPONSE;
	}
	
	
	@Action(value="mLogout")
	public String logout() throws IOException, ServletException{
		removeSessionAttribute(WeaConstant.CURCUST);
		return JSONRESPONSE;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
