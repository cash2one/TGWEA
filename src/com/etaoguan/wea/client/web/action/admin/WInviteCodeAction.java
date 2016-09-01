package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWAdminService;
import com.etaoguan.wea.util.WeaCryptUtil;


/**
 * @author cunli
 * 邀请码
 */
@SuppressWarnings("serial")
@Service("inviteCodeAction") @Scope("prototype")
public class WInviteCodeAction extends WCommonBaseAction{
	
	@Resource(name="wadminService")
	private IWAdminService iwAdminService;
	
	@Action(value="wCreateInviteCode",results = { @Result(name = "success", type = "dispatcher",location="/admin/inviteCode/create_invite_code.jsp")})
	public String createInviteCode() throws IOException {

		return SUCCESS;
	}
	
	@WeaFunction(fname="生成邀请码",oname=WeaFunction.Operation.READ)
	@Action(value="wCreateCode")
	public String createCode() throws IOException {
		String cd=getRequestParamValue("codedate");
		int codedate = Integer.parseInt(cd);
		 Calendar c = Calendar.getInstance();
		  c.add(Calendar.DAY_OF_MONTH, codedate+1);
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		  String dt = simpleDateFormat.format(c.getTime());
		  
		String inviteCode = WeaCryptUtil.genE688InviteCode(dt);
		weaResponse.setRespData(inviteCode);
		return JSONRESPONSE;
	}
	 

}
