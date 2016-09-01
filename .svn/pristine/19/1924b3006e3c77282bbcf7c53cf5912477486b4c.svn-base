package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.report.service.IDailyReportService;
import com.etaoguan.wea.report.vo.DailyReport;

@SuppressWarnings("serial")
@WeaModule(mname="报表统计")
@Service("listStatisticsAction") @Scope("prototype")
public class WListReportAction extends WOwnerBaseAction{

	@Resource(name="dailyReportService")
	private IDailyReportService iDailyReportService;
	
	@WeaFunction(fname="去 查看收款单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListDailyReport",results = { @Result(name = "success", type = "dispatcher",location="/owner/report/listDailyReport.jsp")})
	public String listStatistics(){

		return SUCCESS;
	}
	
	@WeaFunction(fname="收款单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListDailyReportData")
	public String listStatisticsData() throws IOException {
		
		String createdatefrom = getRequestParamValue("createdatefrom");
		String createDateTo = getRequestParamValue("createDateTo");
		String custNum = getRequestParamValue("custNum");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		
		List<DailyReport> reports = iDailyReportService.getDailyReportsService(createdatefrom, createDateTo, custNum, ownerNum);
		weaResponse.setRespData(reports);
		
		return JSONRESPONSE;
	}

}
