package com.etaoguan.wea.client.mobile.action.owner;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMOwnerAdminService;
import com.etaoguan.wea.client.mobile.service.IMOwnerService;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.OwnerAdmin;



@SuppressWarnings("serial")
@Service("ownerMLoginAction") @Scope("prototype")
public class MLoginAction extends MOwnerBaseAction{
	
	@Resource(name="mownerAdminService")
	private IMOwnerAdminService imOwnerAdminService;
	
	@Resource(name="mownerService")
	private IMOwnerService imOwnerService;

	@Action(value="mLogin")
	public String login() throws IOException {

		String adminName = getRequestParamValue("adminName");
		String adminPwd = getRequestParamValue("adminPwd");
		OwnerAdmin ownerAdmin = imOwnerAdminService.getLoginOwnerAdmin(adminName,adminPwd,ownerNum);
		if(ownerAdmin==null||!ownerNum.equals(ownerAdmin.getOwnerNum())){
			weaResponse.setFailStatus();
			weaResponse.setMessage("用户名或密码错误！");
		}else{
			boolean activeOwner = imOwnerService.isActiveOwner(ownerNum);
			if(!activeOwner){
				weaResponse.setFailStatus();
				weaResponse.setMessage("企业未经授权");
			}else{
			
				imOwnerAdminService.updateOwnerAdminLoginDate(ownerAdmin.getAdminId(), new Date());
				setLoginSessionAttribute(WeaConstant.CUROWNERADMIN,ownerAdmin);
			}

		}
		return JSONRESPONSE;
		
	}
	
	@Action(value="mGetLoginStatus")
	public String getLoginStatus() throws IOException, ServletException{
		if(getCurrentOwnerAdmin()==null){
			weaResponse.setFailStatus();
		}
		return JSONRESPONSE;
	}
	
	@Action(value="mLogout")
	public String logout() throws IOException, ServletException{
		removeSessionAttribute(WeaConstant.CUROWNERADMIN);
		return JSONRESPONSE;
	}


}
