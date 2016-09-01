package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.web.vo.WAdmin;
import com.etaoguan.wea.client.web.vo.WAdminGroup;
import com.etaoguan.wea.client.web.vo.WAdminRole;
import com.etaoguan.wea.service.IAdminService;

public interface IWAdminService extends IAdminService{

	@SuppressWarnings("rawtypes")
	public Map getEditAdminInitData(String adminId);
	
	public void saveOrUpdateAdmin(WAdmin wAdmin);
	
	@SuppressWarnings("rawtypes")
	public Map getEditGroupInitData(String groupId);
	
	public void saveOrUpdateGroup(WAdminGroup wAdminGroup);
	
	@SuppressWarnings("rawtypes")
	public Map getEditRoleInitData(String roleId);
	
	public void saveOrUpdateRole(WAdminRole wAdminRole);
	
	public void updateResetAdminPwd(String adminId,String oldPwd,String newPwd);
}
