package com.etaoguan.wea.report.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.impl.SpringBaseDao;
import com.etaoguan.wea.report.dao.IDailyReportDao;
import com.etaoguan.wea.report.vo.DailyReport;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli
 * 报表
 */
@Repository
public class DailyReportDao extends SpringBaseDao implements IDailyReportDao{

	@Override
	@Resource(name="dailyReportSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	

	/* (non-Javadoc)报表信息列表
	 * @see com.etaoguan.wea.report.dao.IReportDao#getReportsDao(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<DailyReport> getDailyReportsDao(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("dailyReportList", dataCriteria.getParams());
	}




}
