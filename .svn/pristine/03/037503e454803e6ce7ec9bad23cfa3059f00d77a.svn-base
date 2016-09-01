package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.TableCodeName;


/**
 * 表字段值信息Dao接口
 * @author 刘卿
 */
public interface ITableCodeNameDao
{
	/**
	 * 获取表字段值信息
	 */
	public TableCodeName getTableCodeName(DataCriteria dataCriteria);
	
	/**
	 * 获取表字段值信息列表
	 */
	public List<TableCodeName> getTableCodeNameList(DataCriteria dataCriteria);
	
	/**
	 * 获取可用表字段值信息列表
	 */
	public List<TableCodeName> getAvailableTableCodeNameList(DataCriteria dataCriteria);
	
	/**
	 * 获取分页表字段值信息
	 * @param id
	 */
	@SuppressWarnings("rawtypes")
	public DataSet getTableCodeNameDataSet(DataCriteria dataDataCriteria,OffsetRequest offsetRequest);
	
	/**
	 * 删除表字段值信息
	 * @param id
	 */
	public void deleteTableCodeName(DataCriteria dataCriteria);
	/**
	 * 保存表字段值信息
	 */
	public void saveTableCodeName(TableCodeName tableCodeName);

	/**
	 * 修改表字段值信息
	 */
	public void updateTableCodeName(TableCodeName tableCodeName);



}