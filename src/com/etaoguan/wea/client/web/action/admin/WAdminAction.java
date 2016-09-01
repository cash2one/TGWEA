package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWAdminService;
import com.etaoguan.wea.client.web.vo.WAdmin;
import com.etaoguan.wea.client.web.vo.WAdminGroup;
import com.etaoguan.wea.client.web.vo.WAdminRole;
import com.etaoguan.wea.vo.Admin;
import com.etaoguan.wea.vo.AdminGroup;
import com.etaoguan.wea.vo.AdminRole;


@WeaModule(mname="系统管理员管理")
@Service("adminWAdminAction") @Scope("prototype")
public class WAdminAction extends WCommonBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	@Resource(name="wadminService")
	private IWAdminService iwAdminService;
	
	private WAdmin wadmin;
	
	private WAdminGroup wadminGroup;
	
	private WAdminRole wadminRole;

	
	@WeaFunction(fname="查看管理员组列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListGroups",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_groups.jsp")})
	public String listGroups() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="查看管理员组列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListGroupsData")
	public String listGroupsData() throws IOException {
		List<AdminGroup>  adminGroupList = iwAdminService.getAllGroups();
		weaResponse.setRows(adminGroupList);
		weaResponse.setTotal(adminGroupList.size());
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改管理员组",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditGroup",results = { @Result(name = "success", type = "dispatcher",location="/admin/edit_group.jsp")})
	public String editGroup() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改管理员组",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditGroup")
	public String saveEditGroup() throws IOException {

		iwAdminService.saveOrUpdateGroup(wadminGroup);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取管理员组信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditGroupInitData")
	public String getEditGroupInitData() throws IOException {
		String groupId = getRequestParamValue("groupId");
		Map initGroupDataMap = iwAdminService.getEditGroupInitData(groupId);
		weaResponse.setRespData(initGroupDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除管理员组",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelGroup")
	public String delGroup() throws IOException {
		String groupId = getRequestParamValue("groupId");
		iwAdminService.delGroup(Integer.parseInt(groupId));
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看系统管理员列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListAdmins",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_admins.jsp")})
	public String listAdmins() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="查看系统管理员列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListAdminsData")
	public String listAdminsData() throws IOException {
		List<Admin>  adminList = iwAdminService.getAllAdmins();
		weaResponse.setRows(adminList);
		weaResponse.setTotal(adminList.size());
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改系统管理员",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditAdmin",results = { @Result(name = "success", type = "dispatcher",location="/admin/edit_admin.jsp")})
	public String editAdmin() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改系统管理员",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditAdmin")
	public String saveEditAdmin() throws IOException {

		iwAdminService.saveOrUpdateAdmin(wadmin);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取系统管理员信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditAdminInitData")
	public String getEditAdminInitData() throws IOException {
		String adminId = getRequestParamValue("adminId");
		Map initAdminDataMap = iwAdminService.getEditAdminInitData(adminId);
		weaResponse.setRespData(initAdminDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除系统管理员",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelAdmin")
	public String delAdmin() throws IOException {
		String adminId = getRequestParamValue("adminId");
		iwAdminService.delAdmin(Integer.parseInt(adminId));
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看管理员角色列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListRoles",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_roles.jsp")})
	public String listRoles() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="查看管理员角色列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListRolesData")
	public String listRolesData() throws IOException {
		List<AdminRole>  adminRoleList = iwAdminService.getAllRoles();
		weaResponse.setRows(adminRoleList);
		weaResponse.setTotal(adminRoleList.size());
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="修改管理员角色",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditRole",results = { @Result(name = "success", type = "dispatcher",location="/admin/edit_role.jsp")})
	public String editRole() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改管理员角色",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditRole")
	public String saveEditRole() throws IOException {

		iwAdminService.saveOrUpdateRole(wadminRole);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取管理员角色信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditRoleInitData")
	public String getEditRoleInitData() throws IOException {
		String roleId = getRequestParamValue("roleId");
		Map initRoleDataMap = iwAdminService.getEditRoleInitData(roleId);
		weaResponse.setRespData(initRoleDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除管理员角色",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelRole")
	public String delRole() throws IOException {
		String roleId = getRequestParamValue("roleId");
		iwAdminService.delRole(Integer.parseInt(roleId));
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="更新管理员密码",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveAdminPwd")
	public String saveAdminPwd() throws IOException {
		String adminId = getRequestParamValue("adminId");
		String oldPwd = getRequestParamValue("oldPwd");
		String newPwd = getRequestParamValue("newPwd");
		iwAdminService.updateResetAdminPwd(adminId,oldPwd,newPwd);
		return JSONRESPONSE;
	}
	public WAdmin getWadmin() {
		return wadmin;
	}
	public void setWadmin(WAdmin wadmin) {
		this.wadmin = wadmin;
	}
	public WAdminGroup getWadminGroup() {
		return wadminGroup;
	}
	public void setWadminGroup(WAdminGroup wadminGroup) {
		this.wadminGroup = wadminGroup;
	}
	public WAdminRole getWadminRole() {
		return wadminRole;
	}
	public void setWadminRole(WAdminRole wadminRole) {
		this.wadminRole = wadminRole;
	}

}
