package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWWechatMenuService;
import com.etaoguan.wea.vo.WechatMenu;


@SuppressWarnings("serial")
@WeaModule(mname="微站菜单管理")
@Service("ownerWWechatMenuAction") @Scope("prototype")
public class WWechatMenuAction extends WOwnerBaseAction{

	private WechatMenu wechatMenu;
	
	private long[] menuIds;

	@Resource(name="wwechatMenuService")
	private IWWechatMenuService iwWechatMenuService;

	@WeaFunction(fname="查看微站菜单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatMenus",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_wechatmenus.jsp")})
	public String listWechatMenus() throws IOException {

		return SUCCESS;
	}
	
	@WeaFunction(fname="查看微站菜单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWechatMenusData")
	public String listWechatMenusData() throws IOException {
		List<WechatMenu> wechatMenus = iwWechatMenuService.getWechatMenusIncRootByOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(wechatMenus);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="批量删除微站菜单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelBatchWechatMenu")
	public String delBatchWechatMenu() throws IOException {
		iwWechatMenuService.delBatchWechatMenu(getCurrentOwnerAdmin().getOwnerNum(), menuIds);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="更新微站菜单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditWechatMenu")
	public String saveEditWechatMenu() throws IOException {
		wechatMenu.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwWechatMenuService.saveOrUpdateWechatMenu(wechatMenu);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="获取微站菜单",oname=WeaFunction.Operation.READ)
	@Action(value="wGetWechatMenuData")
	public String getWechatMenuData() throws IOException {
		String menuId = getRequestParamValue("menuId");
		WechatMenu wechatMenu = iwWechatMenuService.getWechatMenu(Long.parseLong(menuId));
		weaResponse.setRespData(wechatMenu);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="同步微站菜单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSyncWechatMenu")
	public String syncWechatMenu() throws IOException {
		iwWechatMenuService.syncWechatMenu(getCurrentOwnerAdmin().getOwnerNum());
		return JSONRESPONSE;
	}
	
	public WechatMenu getWechatMenu() {
		return wechatMenu;
	}

	public void setWechatMenu(WechatMenu wechatMenu) {
		this.wechatMenu = wechatMenu;
	}

	public long[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(long[] menuIds) {
		this.menuIds = menuIds;
	}

	


}
