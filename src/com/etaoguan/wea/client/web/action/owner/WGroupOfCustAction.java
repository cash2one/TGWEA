package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWGroupOfCustService;
import com.etaoguan.wea.client.web.vo.WGroupOfCust;
import com.etaoguan.wea.vo.GroupOfCust;

@SuppressWarnings("serial")
@WeaModule(mname="特供客户组管理")
@Service("wGroupOfCustAction") @Scope("prototype")
public class WGroupOfCustAction extends WOwnerBaseAction{

	private WGroupOfCust wGroupOfCust;
	
	public WGroupOfCust getwGroupOfCust() {
		return wGroupOfCust;
	}

	public void setwGroupOfCust(WGroupOfCust wGroupOfCust) {
		this.wGroupOfCust = wGroupOfCust;
	}

	@Resource(name="wGroupOfCustService")
	private  IWGroupOfCustService iwGroupOfCustService;
	
	@WeaFunction(fname="初始化特供客户组信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditGroupInitData")
	public String getEditGroupInitData() throws IOException {
		String groupNum = getRequestParamValue("groupNum");
		GroupOfCust groupOfCust  = iwGroupOfCustService.listGroup(groupNum);
		weaResponse.setRespData(groupOfCust);
		
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="添加或修改特供客户组",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveOrEditGroupOfCust")
	public String saveEditGroupOfCust() throws IOException {
		
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		String custId = getRequestParamValue("custId");
		String groupName = getRequestParamValue("groupName");
		String memo = getRequestParamValue("memo");
		String groupNum =getRequestParamValue("groupNum");
		
		
		if (!StringUtils.isEmpty(groupNum)) {//修改特供客户组
			
			iwGroupOfCustService.removeGroup(groupNum);//先删除，再添加
			
			String cid[] = custId.split(",");
			String groupNumRandom = new Date().getTime()+String.valueOf(new Random().nextInt(10000));
			for (int i = 0; i < cid.length; i++) {
				GroupOfCust groupOfCust = new GroupOfCust();
				groupOfCust.setCustId(cid[i]);
				groupOfCust.setOwnerNum(ownerNum);
				groupOfCust.setGroupNum(groupNumRandom);
				groupOfCust.setGroupName(groupName);
				groupOfCust.setMemo(memo);
				
				iwGroupOfCustService.addGroupOfCust(groupOfCust);
			}
		}else {//添加特供客户组
			String cid[] = custId.split(",");
			String groupNumRandom = new Date().getTime()+String.valueOf(new Random().nextInt(10000));
			for (int i = 0; i < cid.length; i++) {
				GroupOfCust groupOfCust = new GroupOfCust();
				groupOfCust.setCustId(cid[i]);
				groupOfCust.setOwnerNum(ownerNum);
				groupOfCust.setGroupNum(groupNumRandom);
				groupOfCust.setGroupName(groupName);
				groupOfCust.setMemo(memo);
				
				iwGroupOfCustService.addGroupOfCust(groupOfCust);
			}
		}
	
		
		return JSONRESPONSE;
	}
	
	
	@WeaFunction(fname="删除特供客户组",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelGroupOfCust")
	public String delGroupOfCust() throws IOException {
		int id = Integer.parseInt(getRequestParamValue("id"));
		System.out.println();
		iwGroupOfCustService.delGroupOfCust(id);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改推送组",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditGroupOfCust",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_groupOfCust.jsp")})
	public String editGroupOfCust() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="查看特供客户组列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListGroupOfCust",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_groupOfCust.jsp")})
	public String ListGroupOfCust() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="显示特供客户组列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListSearchGroupOfCustsData")
	public String listSearchGroupOfCustsData() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		List<GroupOfCust> groupOfCusts = iwGroupOfCustService.listSearchGroupOfCusts(ownerNum);
		weaResponse.setRows(groupOfCusts);
		weaResponse.setTotal(groupOfCusts.size());
		weaResponse.setRespData(groupOfCusts);
		
		return JSONRESPONSE;
	}
	

}
