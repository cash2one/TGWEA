package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.vo.WareHouse;

public interface IWareHouseDao {

	public void addWareHouse(WareHouse wareHouse);
	
	public void updateWareHouse(WareHouse wareHouse);
	
	public void delWareHouse(DataCriteria dataCriteria);
	
	public List<WareHouse> getAllWarehouses(DataCriteria dataCriteria);
	
	public WareHouse getWarehouse(DataCriteria dataCriteria);
	
}
