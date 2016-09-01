package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWAuthorityService;
import com.etaoguan.wea.client.web.service.IWOwnerService;
import com.etaoguan.wea.vo.Authority;
import com.etaoguan.wea.vo.Owner;

/**
 * @author cunli 企业权限管理
 */
@SuppressWarnings("serial")
@WeaModule(mname="企业权限管理")
@Service("ownerAuthorityAction") @Scope("prototype")
public class WOwnerAuthorityAction extends WCommonBaseAction {
	
	@Resource(name="wownerService")
	private IWOwnerService iwOwnerService;
	
	@Resource(name="wauthorityService")
	private IWAuthorityService iwAuthorityService;

	private Authority authority;
	
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	
	@WeaFunction(fname="显示企业权限",oname=WeaFunction.Operation.READ)
	@Action(value="wShowAuthority")
	public String showAuthority() throws IOException {
		
		
		authority = iwAuthorityService.lookAuthority(authority.getOwnerNum());
		if (authority != null) {
			String auth = authority.getWhichAuthority();
			if (StringUtils.isBlank(authority.getWhichAuthority())) {
				for (int i = 0; i < 50; i++) {
					auth+=",";
				}
			}
			String[] wauth = auth.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < wauth.length; i++) {
				list.add(Integer.parseInt(wauth[i].trim()));
			}
			weaResponse.setRespData(list);
		}
		
		
		return JSONRESPONSE;
	}
	@WeaFunction(fname="保存企业权限",oname=WeaFunction.Operation.CREATE)
	@Action(value="wSaveAuthority")
	public String SaveAuthority() throws IOException {
		String ownerNum=authority.getOwnerNum();
		iwAuthorityService.removeWAuthority(ownerNum);
		iwAuthorityService.saveAuthority(authority);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="企业列表",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wShowAllOwner")
	public String showAllOwner() throws IOException {
		List<Owner> lOwners=iwOwnerService.getAllOwner();
		weaResponse.setRespData(lOwners);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname = "权限管理页", oname = WeaFunction.Operation.READ)
	@Action(value = "wOwnerAuthority", results = { @Result(name = "success", type = "dispatcher", location = "/admin/authority/ownerAuthority.jsp") })
	public String ownerAuthority() throws IOException {
		return SUCCESS;
	}
}
