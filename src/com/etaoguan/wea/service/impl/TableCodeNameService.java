package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.ITableCodeNameDao;
import com.etaoguan.wea.service.ITableCodeNameService;
import com.etaoguan.wea.vo.TableCodeName;



@Service("tableCodeNameService")
public class TableCodeNameService extends BaseService implements ITableCodeNameService {
	
	
	@Autowired
	private ITableCodeNameDao tableCodeNameDao;

	@Override
	public void deleteTableCodeName(String tableName, String columnName,
			String columnCode) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", tableName);
		dataCriteria.setParam("columnName", columnName);
		dataCriteria.setParam("columnCode", columnCode);
		tableCodeNameDao.deleteTableCodeName(dataCriteria);
		
	}


	@Override
	public List<TableCodeName> getAppSettingTableCodeNameList() {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", "app_setting");
		dataCriteria.setParam("columnName", "param_name");
		return tableCodeNameDao.getTableCodeNameList(dataCriteria);
	}

	@Override
	public List<TableCodeName> getOwnerSettingTableCodeNameList() {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", "owner_setting");
		dataCriteria.setParam("columnName", "param_name");
		return tableCodeNameDao.getTableCodeNameList(dataCriteria);
	}
	

	@Override
	public List<TableCodeName> getAppSettingAvailableTableCodeNameList() {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", "app_setting");
		dataCriteria.setParam("columnName", "param_name");
		return tableCodeNameDao.getAvailableTableCodeNameList(dataCriteria);
	}


	@Override
	public List<TableCodeName> getAvailableTableCodeNameList(String tableName,
			String columnName) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", tableName);
		dataCriteria.setParam("columnName", columnName);
		return tableCodeNameDao.getAvailableTableCodeNameList(dataCriteria);
	}

	@Override
	public List<TableCodeName> getOwnerSettingAvailableTableCodeNameList(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", "owner_setting");
		dataCriteria.setParam("columnName", "param_name");
		dataCriteria.setClause("owner_num = '"+ownerNum+"'");
		return tableCodeNameDao.getAvailableTableCodeNameList(dataCriteria);
	}


	@Override
	@SuppressWarnings("rawtypes")
	public DataSet getTableCodeNameDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {

		return tableCodeNameDao.getTableCodeNameDataSet(dataCriteria, offsetRequest);
	}


	@Override
	public TableCodeName getTableCodeName(String tableName, String columnName,
			String columnCode) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", tableName);
		dataCriteria.setParam("columnName", columnName);
		dataCriteria.setParam("columnCode", columnCode);
		return tableCodeNameDao.getTableCodeName(dataCriteria);
	}


	@Override
	public void saveTableCodeName(TableCodeName codeName) {
		tableCodeNameDao.saveTableCodeName(codeName);
		
	}


	@Override
	public void updateTableCodeName(TableCodeName codeName) {
		tableCodeNameDao.updateTableCodeName(codeName);
		
	}

	@SuppressWarnings("rawtypes")
	public DataSet listTableCodeNames(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		
		return tableCodeNameDao.getTableCodeNameDataSet(dataCriteria, offsetRequest);
	}
	
	@Override
	public List<TableCodeName> getAllTableCodeNameList() {
		DataCriteria dataCriteria = new DataCriteria();
		return tableCodeNameDao.getTableCodeNameList(dataCriteria);
	}

	@Override
	public List<TableCodeName> getTableCodeNameList(String tableName,
			String columnName) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", tableName);
		dataCriteria.setParam("columnName", columnName);
		return tableCodeNameDao.getTableCodeNameList(dataCriteria);
	}



}
