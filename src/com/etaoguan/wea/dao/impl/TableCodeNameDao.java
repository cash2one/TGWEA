package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.ITableCodeNameDao;
import com.etaoguan.wea.vo.TableCodeName;
import com.ibatis.sqlmap.client.SqlMapClient;



/**
 * 表字段值信息Dao实现
 * @author 刘卿
 * 感谢ibatis的持久层框架
 */
@Repository
public class TableCodeNameDao extends SpringBaseDao implements ITableCodeNameDao
{

	@Override
	@Resource(name="basicBataSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	
	@Override
	public void deleteTableCodeName(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("deleteCodeName", dataCriteria.getParams());
	}

	
	@Override
	public TableCodeName getTableCodeName(DataCriteria dataCriteria) {
		return (TableCodeName)this.getSqlMapClientTemplate().queryForObject("getCodeName",dataCriteria.getParams());
	}

	
	@Override
	public void saveTableCodeName(TableCodeName tableCodeName) {
		this.getSqlMapClientTemplate().insert("createCodeName", tableCodeName);
	}

	
	@Override
	public void updateTableCodeName(TableCodeName tableCodeName) {
		this.getSqlMapClientTemplate().update("updateCodeName",tableCodeName);
		
	}

	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getTableCodeNameDataSet(DataCriteria dataCriteria, OffsetRequest offsetRequest) {
		
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getCodeNameCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<TableCodeName> retInvList = this.getSqlMapClientTemplate().queryForList("getCodeNameDataSet", params);
		
		DataSet<TableCodeName> dataSet = new DataSet<TableCodeName>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(retInvList);
		return dataSet;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<TableCodeName> getTableCodeNameList(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getCodeNameList", dataCriteria.getParams());
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<TableCodeName> getAvailableTableCodeNameList(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getAvailableCodeNameList", dataCriteria.getParams());
	}


}