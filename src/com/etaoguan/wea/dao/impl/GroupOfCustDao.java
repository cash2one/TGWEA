package com.etaoguan.wea.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IGroupOfCustDao;
import com.etaoguan.wea.vo.GroupOfCust;
import com.ibatis.sqlmap.client.SqlMapClient;


@Repository
public class GroupOfCustDao extends SpringBaseDao implements IGroupOfCustDao{

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(GroupOfCustDao.class);
			
	@Override
	@Resource(name="groupOfCustSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addGroupOfCust(GroupOfCust groupOfCust) {
		this.getSqlMapClientTemplate().insert("createGroupOfCust", groupOfCust);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<GroupOfCust> getGroupOfCust(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getGroupOfCustDatSet", dataCriteria.getParams());
	}

	@Override
	public void delGroupOfCust(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteGroupOfCust", dataCriteria.getParams());
	}

	@Override
	public void delGroup(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteGroup", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<GroupOfCust> getGroupInfo(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getGroupInfo", dataCriteria.getParams());
	}

	/* (non-Javadoc)获取组名
	 * @see com.etaoguan.wea.dao.IGroupOfCustDao#nameOfGroup(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public GroupOfCust nameOfGroup(DataCriteria dataCriteria) {
		return (GroupOfCust) this.getSqlMapClientTemplate().queryForObject("nameOfGroup", dataCriteria.getParams());
	}


}
