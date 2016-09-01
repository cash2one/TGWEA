package com.etaoguan.wea.report.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.report.vo.DailyReport;

/**
 * @author cunli
 * 报表
 */
public interface IDailyReportDao {

	/**
	 * @param dataCriteria
	 * @return 报表信息列表
	 */
	public List<DailyReport> getDailyReportsDao(DataCriteria dataCriteria);
	
}
