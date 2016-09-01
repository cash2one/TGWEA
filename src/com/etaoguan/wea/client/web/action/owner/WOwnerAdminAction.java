package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWOwnerAdminService;
import com.etaoguan.wea.vo.OwnerAdmin;

@WeaModule(mname="企业管理员管理")
@Service("ownerWOwnerAdminAction") @Scope("prototype")
public class WOwnerAdminAction extends WOwnerBaseAction{
	
	private static final long serialVersionUID = -7865147477441875751L;
	private OwnerAdmin ownerAdmin;
	
	public OwnerAdmin getOwnerAdmin() {
		return ownerAdmin;
	}

	public void setOwnerAdmin(OwnerAdmin ownerAdmin) {
		this.ownerAdmin = ownerAdmin;
	}
	
	@WeaFunction(fname="删除owner管理员",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelOwneradmin")
	public String delOwneradmin() throws IOException {
		iwOwnerAdminService.deleteOwnerAdminService(Integer.parseInt(getRequestParamValue("adminId")));
		return JSONRESPONSE;
	}
	@WeaFunction(fname="添加owner管理员",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveOwneradmin")
	public String saveOwneradmin() throws IOException {
		
		String ownerNum=getCurrentOwnerAdmin().getOwnerNum();
		
		String adminName = ownerAdmin.getAdminName().trim();
		boolean dcheck = iwOwnerAdminService.duplicateCheck(ownerNum, adminName);//检查这个名字是否已经存在
		if (dcheck) {//名字已存在，给与提示
			weaResponse.setFailStatus();
			weaResponse.setMessage("请不要添加重复的用户名！");
		}else {//添加管理员
			ownerAdmin.setOwnerNum(ownerNum);
			ownerAdmin.setAdminPwd("888888");
			ownerAdmin.setReserveFlag(1);
			iwOwnerAdminService.addOwnerAdmin(ownerAdmin);
		}
		
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="获取 管理员列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListAdminData")
	public String listAdminData() throws IOException {
		List<OwnerAdmin> ownerAdmins=iwOwnerAdminService.getOwnerAdminsByOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRows(ownerAdmins);
		weaResponse.setTotal(ownerAdmins.size());
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看管理员列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListOwnerAdmin",results = { @Result(name = "success", type = "dispatcher",location="/owner/account/list_admins.jsp")})
	public String listOwnerAdmin() throws IOException {
		
		return SUCCESS;
	}
	@Resource(name="wownerAdminService")
	private IWOwnerAdminService iwOwnerAdminService;
	@WeaFunction(fname="更新企业管理员密码",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditOwnerAdminPwd",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_adminpwd.jsp")})
	public String editOwnerPwd() throws IOException, ServletException {
		return SUCCESS;

	}
	@WeaFunction(fname="更新企业管理员密码",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveOwnerAdminPwd")
	public String saveOwnerPwd() throws IOException {
		
		String oldPwd = getRequestParamValue("oldPwd");
		String newPwd = getRequestParamValue("newPwd");
		OwnerAdmin ownerAdmin = getCurrentOwnerAdmin();//获取登录时系统记录的用户信息
		if(ownerAdmin.getAdminPwd().equals(oldPwd)){//如果 当前输入的密码和登录时系统记录的密码相同，就执行更新密码操作
			iwOwnerAdminService.updateOwnerAdminPwd(ownerAdmin.getAdminId(), newPwd);
			ownerAdmin.setAdminPwd(newPwd);
		}else{//如果不相同就在页面提示信息
			weaResponse.setFailStatus();
			weaResponse.setMessage("旧密码输入错误，修改失败！");
		}
		return JSONRESPONSE;
	}

}
