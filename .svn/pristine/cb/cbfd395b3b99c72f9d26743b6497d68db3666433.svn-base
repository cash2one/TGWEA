package com.etaoguan.wea.client.web.service;

import java.util.List;

import com.etaoguan.wea.service.IWechatMenuService;
import com.etaoguan.wea.vo.WechatMenu;

public interface IWWechatMenuService extends IWechatMenuService{

	public void saveOrUpdateWechatMenu(WechatMenu wechatMenu);
	
	public List<WechatMenu> getWechatMenusIncRootByOwnerNum(String ownerNum);
	
	public void delBatchWechatMenu(String ownerNum,long[] menuIds);
	
	public void syncWechatMenu(String ownerNum);
}
