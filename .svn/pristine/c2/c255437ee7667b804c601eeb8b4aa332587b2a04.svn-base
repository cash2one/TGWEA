package com.etaoguan.wea.client.web.action.admin;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWTableCodeNameService;
import com.etaoguan.wea.client.web.vo.TableCodeNameSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.TableCodeName;


@SuppressWarnings("serial")
@WeaModule(mname="表字段值管理")
@Service("adminWTableCodeNameAction") @Scope("prototype")
public class WTableCodeNameAction extends WCommonBaseAction{

	@Resource(name="wtableCodeNameService")
	private IWTableCodeNameService iwTableCodeNameService;
	
	private TableCodeNameSearch tableCodeNameSearch;
	
	private TableCodeName tableCodeName;

	
	@WeaFunction(fname="查看表字段值列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListTableCodeNames",results = { @Result(name = "success", type = "dispatcher",location="/admin/list_codenames.jsp")})
	public String listTableCodeNames() throws IOException {
		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看表字段值列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListTableCodeNamesData")
	public String listTableCodeNamesData() throws IOException {
		WPage wpage = iwTableCodeNameService.listTableCodeNames(tableCodeNameSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取表字段值列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListTableCodeNamesSearchInitData")
	public String getListTableCodeNamesSearchInitData() throws IOException {

		Map initSearchDataMap = iwTableCodeNameService.getListTableCodeNamesSearchInitData();
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="修改表字段值",oname=WeaFunction.Operation.CREATE)
	@Action(value="wSaveEditTableCodeName")
	public String saveOrUpdateTableCodeName() throws IOException {

		iwTableCodeNameService.saveOrUpdateTableCodeName(tableCodeName);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除表字段值",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelTableCodeName")
	public String deleteTableCodeName() throws IOException {

		iwTableCodeNameService.deleteTableCodeName(tableCodeName.getTableName(), tableCodeName.getColumnName(), tableCodeName.getColumnCode());
		return JSONRESPONSE;
	}

	
	public TableCodeNameSearch getTableCodeNameSearch() {
		return tableCodeNameSearch;
	}
	public void setTableCodeNameSearch(TableCodeNameSearch tableCodeNameSearch) {
		this.tableCodeNameSearch = tableCodeNameSearch;
	}
	public TableCodeName getTableCodeName() {
		return tableCodeName;
	}
	public void setTableCodeName(TableCodeName tableCodeName) {
		this.tableCodeName = tableCodeName;
	}
	




}
