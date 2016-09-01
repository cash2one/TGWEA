package com.etaoguan.wea.report.service;

import java.util.List;

import com.etaoguan.wea.report.vo.DailyReport;


/**
 * @author cunli
 * 报表
 */
public interface IDailyReportService {
	
	/**
	 * @param createdatefrom
	 * @param createDateTo
	 * @param custNum
	 * @param ownerNum
	 * @return 报表信息列表
	 */
	public List<DailyReport> getDailyReportsService(String createdatefrom,String createDateTo, String custNum, String ownerNum);

}

