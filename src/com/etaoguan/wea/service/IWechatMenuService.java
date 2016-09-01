package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.vo.WechatMenu;

public interface IWechatMenuService {
	
	public void addWechatMenu(WechatMenu wechatMenu);
	
	public void updateWechatMenu(WechatMenu wechatMenu);
	
	public void delWechatMenu(String ownerNum,long menuId);
	
	public WechatMenu getWechatMenu(long menuId);
	
	public boolean haveChildWechatMenu(long parentMenuId);
	
	@SuppressWarnings("rawtypes")
	public List getChildWechatMenuIds(long parentMenuId);
	
	public List<WechatMenu> listChildWechatMenu(long parentMenuId);
	
	public List<WechatMenu> listTopLevelWechatMenu(String ownerNum);
	
	public List<WechatMenu> getWechatMenusByOwnerNum(String ownerNum);

}
