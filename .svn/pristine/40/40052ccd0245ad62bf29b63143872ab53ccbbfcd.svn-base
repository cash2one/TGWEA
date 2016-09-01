package com.etaoguan.wea.client.mobile.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMOwnerAdminService;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.OwnerAdmin;

@SuppressWarnings("serial")
@WeaModule(mname="企业管理员管理")
@Service("ownerMAdminAction") @Scope("prototype")
public class MAdminAction extends MOwnerBaseAction{
	
	@Resource(name="mownerAdminService")
	private IMOwnerAdminService imOwnerAdminService;
	
	private OwnerAdmin ownerAdmin;
	
	@WeaFunction(fname="更新企业管理员密码(移动端)",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mUpdateOwnerAdminPwd")
	public String updateOwnerAdminPwd() throws IOException {
		
	
		String oldPwd = getRequestParamValue("oldPwd");
		String newPwd = getRequestParamValue("newPwd");
		OwnerAdmin currOwnerAdmin = getCurrentOwnerAdmin();
		if(currOwnerAdmin.getAdminPwd().equals(oldPwd)){
			imOwnerAdminService.updateOwnerAdminPwd(currOwnerAdmin.getAdminId(),newPwd);
			currOwnerAdmin = imOwnerAdminService.getOwnerAdmin(currOwnerAdmin.getAdminId());
			setSessionAttribute(WeaConstant.CUROWNERADMIN, currOwnerAdmin);
		}else{
			weaResponse.setFailStatus();
			weaResponse.setMessage("旧密码输入错误，修改失败！");
		}
		
		return JSONRESPONSE;
	}

	public OwnerAdmin getOwnerAdmin() {
		return ownerAdmin;
	}

	public void setOwnerAdmin(OwnerAdmin ownerAdmin) {
		this.ownerAdmin = ownerAdmin;
	}


}
