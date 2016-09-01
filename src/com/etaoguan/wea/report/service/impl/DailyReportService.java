package com.etaoguan.wea.report.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.report.dao.IDailyReportDao;
import com.etaoguan.wea.report.service.IDailyReportService;
import com.etaoguan.wea.report.vo.DailyReport;
import com.etaoguan.wea.service.impl.BaseService;

/**
 * @author cunli
 * 报表
 */
@Service("dailyReportService")
public class DailyReportService  extends BaseService implements IDailyReportService {

	@Autowired
	private IDailyReportDao iReportDao;


	/* (non-Javadoc)报表信息列表
	 * @see com.etaoguan.wea.report.service.IReportService#getReportsDao(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<DailyReport> getDailyReportsService(String createdatefrom,String createDateTo, String custNum, String ownerNum) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DataCriteria dataCriteria = new DataCriteria();
		try {
			Date createDate=simpleDateFormat.parse(createdatefrom);
			Date updateDate=simpleDateFormat.parse(createDateTo);
			dataCriteria.setParam("createDate",createDate);
			dataCriteria.setParam("updateDate",updateDate);
			dataCriteria.setParam("custNum",custNum);
			dataCriteria.setParam("ownerNum",ownerNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return iReportDao.getDailyReportsDao(dataCriteria);
	}
	


}
