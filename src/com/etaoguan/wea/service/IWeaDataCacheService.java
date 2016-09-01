package com.etaoguan.wea.service;

import java.util.Map;

public interface IWeaDataCacheService {
	
	public void cacheWeaAccessAuthMap();
	
	@SuppressWarnings("rawtypes")
	public Map getWeaAccessAuthMap();
	
	public void cacheWeaTradeMap();
	
	@SuppressWarnings("rawtypes")
	public Map getWeaTradeMap();
	
	public void cacheTableCodeName();
	

}
