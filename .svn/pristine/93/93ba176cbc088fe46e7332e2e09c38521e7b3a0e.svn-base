package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.TableCodeName;


public interface ITableCodeNameService {
	
	@SuppressWarnings("rawtypes")
	public DataSet getTableCodeNameDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public List<TableCodeName> getAvailableTableCodeNameList(String tableName,String columnName);
	
	public List<TableCodeName> getAppSettingAvailableTableCodeNameList();

	public List<TableCodeName> getOwnerSettingAvailableTableCodeNameList(String ownerNum);
	
	public TableCodeName getTableCodeName(String tableName, String columnName,
			String columnCode);
	
	public List<TableCodeName> getTableCodeNameList(String tableName, String columnName);
	
	public void updateTableCodeName(TableCodeName codeName);
	
	public void saveTableCodeName(TableCodeName codeName);
	
	public void deleteTableCodeName(String tableName,String columnName,String columnCode);
	
	public List<TableCodeName> getAllTableCodeNameList();
	
	public List<TableCodeName> getAppSettingTableCodeNameList();
	
	public List<TableCodeName> getOwnerSettingTableCodeNameList();


}
