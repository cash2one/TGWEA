package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IWechatMenuDao;
import com.etaoguan.wea.vo.WechatMenu;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class WechatMenuDao extends SpringBaseDao implements IWechatMenuDao{

	@Override
	@Resource(name="wechatSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addWechatMenu(WechatMenu wechatMenu) {
		this.getSqlMapClientTemplate().insert("createWechatMenu", wechatMenu);
		
	}

	@Override
	public void delWechatMenu(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteWechatMenu", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Long> getWechatMenuIds(DataCriteria dataCriteria) {
		
		return this.getSqlMapClientTemplate().queryForList("getWechatMenuIdList", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<WechatMenu> getWechatMenus(DataCriteria dataCriteria) {
		
		return this.getSqlMapClientTemplate().queryForList("getWechatMenuList", dataCriteria.getParams());
	}

	@Override
	public int getWechatMenuCount(DataCriteria dataCriteria) {
	
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getWechatMenuCount", dataCriteria.getParams());
	}

	@Override
	public void updateWechatMenu(WechatMenu wechatMenu) {
		this.getSqlMapClientTemplate().update("updateWechatMenu", wechatMenu);
		
	}

	@Override
	public WechatMenu getWechatMenu(DataCriteria dataCriteria) {

		return (WechatMenu) this.getSqlMapClientTemplate().queryForObject("getWechatMenu", dataCriteria.getParams());
	}

}
