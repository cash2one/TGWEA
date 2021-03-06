package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IWechatMenuDao;
import com.etaoguan.wea.service.IWechatMenuService;
import com.etaoguan.wea.vo.WechatMenu;

@Service("wechatMenuService")
public class WechatMenuService  extends BaseService implements IWechatMenuService {
	
	@Autowired
	private IWechatMenuDao iWechatMenuDao;

	@Override
	public void addWechatMenu(WechatMenu wechatMenu) {
		wechatMenu.setCreateBy(getCurrentOperator());
		wechatMenu.setUpdateBy(getCurrentOperator());
		iWechatMenuDao.addWechatMenu(wechatMenu);

	}

	@Override
	public void delWechatMenu(String ownerNum,long menuId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("menuId",menuId);
		iWechatMenuDao.delWechatMenu(dataCriteria);
	}

	@Override
	public List<WechatMenu> getWechatMenusByOwnerNum(String ownerNum){
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iWechatMenuDao.getWechatMenus(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List getChildWechatMenuIds(long parentMenuId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("parentMenuId",parentMenuId);
		return iWechatMenuDao.getWechatMenuIds(dataCriteria);
	}

	@Override
	public boolean haveChildWechatMenu(long parentMenuId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("parentMenuId",parentMenuId);
		if(iWechatMenuDao.getWechatMenuCount(dataCriteria)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<WechatMenu> listChildWechatMenu(long parentMenuId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("parentMenuId",parentMenuId);
		return iWechatMenuDao.getWechatMenus(dataCriteria);
	}

	@Override
	public List<WechatMenu> listTopLevelWechatMenu(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("parentMenuId",0);
		return iWechatMenuDao.getWechatMenus(dataCriteria);
	}

	@Override
	public void updateWechatMenu(WechatMenu wechatMenu) {
		wechatMenu.setUpdateBy(getCurrentOperator());
		iWechatMenuDao.updateWechatMenu(wechatMenu);

	}

	@Override
	public WechatMenu getWechatMenu(long menuId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("menuId",menuId);
		return iWechatMenuDao.getWechatMenu(dataCriteria);
	}

}
