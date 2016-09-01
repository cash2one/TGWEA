package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.ICustDao;
import com.etaoguan.wea.vo.Customer;
import com.ibatis.sqlmap.client.SqlMapClient;


@Repository
public class CustDao extends SpringBaseDao implements ICustDao{

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(CustDao.class);
			
	@Override
	@Resource(name="custSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addCust(Customer cust) {
		this.getSqlMapClientTemplate().insert("createCust", cust);
	}

	@Override
	public Customer geCust(DataCriteria dataCriteria) {
		return (Customer)this.getSqlMapClientTemplate().queryForObject("getCust", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getCustDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {

		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getCustCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<Customer> custList = this.getSqlMapClientTemplate().queryForList("getCustDatSet", params);
		
		DataSet<Customer> dataSet = new DataSet<Customer>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(custList);
		return dataSet;
	}

	@Override
	public void updateCust(Customer cust) {
		this.getSqlMapClientTemplate().update("updateCust", cust);
	}

	@Override
	public void updateCust(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateCustByMap", dataCriteria.getParams());
	}

	@Override
	public Customer geLoginCust(DataCriteria dataCriteria) {
		return (Customer)this.getSqlMapClientTemplate().queryForObject("getLoginCust", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getCusts(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getCusts", dataCriteria.getParams());
	}

}
