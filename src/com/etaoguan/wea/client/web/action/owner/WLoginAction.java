package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWAuthorityService;
import com.etaoguan.wea.client.web.service.IWOwnerAdminService;
import com.etaoguan.wea.client.web.service.IWOwnerService;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.OwnerAdmin;


@SuppressWarnings("serial")
@Service("ownerWLoginAction") @Scope("prototype")
public class WLoginAction extends WOwnerBaseAction{
	
	@Resource(name="wownerAdminService")
	private IWOwnerAdminService iwOwnerAdminService;
	
	@Resource(name="wownerService")
	private IWOwnerService iwOwnerService;
	
	@Resource(name="wauthorityService")
	private IWAuthorityService iwAuthorityService;
	
	@Action(value="WRegcode")
	public String regcode() throws IOException, ServletException{
		String regCode=getSessionAttribute("REG_CODE").toString().toLowerCase();
		weaResponse.setRespData(regCode);
		return JSONRESPONSE;
	}
	
	@Action(value="wLogin",results = { @Result(name = "success", type = "dispatcher",location="/owner/wListOrders.action"),@Result(name = "error", type = "dispatcher",location="/owner/login.jsp")})
	public String login() throws IOException {
		
//		 String captchaimage = getRequestParamValue("captchaimage");
//		 try {
//		 	if (!captchaimage.equals(null) && !captchaimage.trim().equals("")) {
//		 			String reg_code=getSessionAttribute("REG_CODE").toString();
//		 		if (!captchaimage.toLowerCase().equals(reg_code.toLowerCase())) {
//		 			//返回页面
//		 			weaResponse.setFailStatus();
//		 			weaResponse.setMessage("验证码错误，请重试");
//		 			return ERROR;
//		 		}
//		 	}else {
//		 		//返回页面 提示请输入验证码
//		 		weaResponse.setFailStatus();
//		 		weaResponse.setMessage("请输入验证码");
//		 		return ERROR;
//		 	}
//		 } catch (Exception e) {
//		 	weaResponse.setFailStatus();
//		 	weaResponse.setMessage("验证码错误，请重试!");
//		 	return ERROR;
//		 }
//		 boolean activeOwner = iwOwnerService.isActiveOwner(ownerNum);
//		 if(!activeOwner){
//		 	weaResponse.setFailStatus();
//		 	weaResponse.setMessage("企业未经授权");
//		 	return ERROR;
//		 }
//		
//		
//		 String adminName = getRequestParamValue("adminName");
//		 String adminPwd = getRequestParamValue("adminPwd");
		
		
		 String adminName = "taoguan";
		  String adminPwd = "888888";
		
		

		OwnerAdmin ownerAdmin = iwOwnerAdminService.getLoginOwnerAdmin(adminName,adminPwd,ownerNum);
		if(ownerAdmin==null){
			weaResponse.setFailStatus();
			weaResponse.setMessage("用户名或密码错误！");
			return ERROR;
		}else{

			iwOwnerAdminService.updateOwnerAdminLoginDate(ownerAdmin.getAdminId(), new Date());
			setLoginSessionAttribute(WeaConstant.CUROWNERADMIN,ownerAdmin);
			setSessionAttribute("ownerInSession", iwOwnerService.getOwner(ownerNum));
			
			/*企业权限列表*/
			setSessionAttribute("whichAuthority", "");
			setSessionAttribute("whichAuthority", iwAuthorityService.lookWAuthority(ownerNum));
			
			return SUCCESS;


		}
		
	}
	@Action(value="wLogout",results = { @Result(name = "success", type = "dispatcher",location="/owner/login.jsp")})
	public String logout() throws IOException, ServletException{
		removeSessionAttribute(WeaConstant.CUROWNERADMIN);
		return SUCCESS;
	}
}
