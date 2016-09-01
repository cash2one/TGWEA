package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWCustService;
import com.etaoguan.wea.client.web.vo.CustSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.Customer;

@WeaModule(mname="客户管理")
@Service("ownerWCustAction") @Scope("prototype")
public class WCustAction extends WOwnerBaseAction{

	private static final long serialVersionUID = 3686911166400899579L;
	@Resource(name="wcustService")
	private IWCustService iwCustService;
	
	private String[] custNums;
	
	private Customer cust;

	private CustSearch custSearch = new CustSearch();

	@WeaFunction(fname="搜索选择客户",oname=WeaFunction.Operation.READ)
	@Action(value="wListSearchCusts",results = { @Result(name = "success", type = "dispatcher",location="/owner/select_cust.jsp")})
	public String listSearchCusts() throws IOException {
		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="搜索选择客户",oname=WeaFunction.Operation.READ)
	@Action(value="wListSearchCustsData")
	public String listSearchCustsData() throws IOException {
		custSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwCustService.listSearchCusts(custSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="查看客户列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListCusts",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_custs.jsp")})
	public String listCusts() throws IOException {
		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取客户列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListCustsSearchInitData")
	public String getListCustsSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listCustsData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iwCustService.getListCustsSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	@SuppressWarnings({ "rawtypes"})
	@WeaFunction(fname="查看客户列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListCustsData")
	public String listCustsData() throws IOException {
		custSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwCustService.listCusts(custSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="重置客户密码",oname=WeaFunction.Operation.UPDATE)
	@Action(value="mResetCustPwd")
	public String resetCustPwd() throws IOException {
		String custNum = getRequestParamValue("custNum");
		iwCustService.updateResetCustPwd(custNum);

		return JSONRESPONSE;
	}
	@WeaFunction(fname="批量删除客户",oname=WeaFunction.Operation.DELETE)
	@Action(value="wBatchDelCust")
	public String batchDelCust() throws IOException {
		iwCustService.delBatchCust(custNums);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="修改客户",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditCust",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_cust.jsp")})
	public String editCust() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="修改客户",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditCust")
	public String saveEditCust() throws IOException {
		cust.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwCustService.saveOrUpdateCust(cust);
		return JSONRESPONSE;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取客户信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditCustInitData")
	public String getEditCustInitData() throws IOException {
		String custNum = getRequestParamValue("custNum");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		Map initCustDataMap = iwCustService.getEditCustInitData(ownerNum,custNum);
		weaResponse.setRespData(initCustDataMap);
		return JSONRESPONSE;
	}
	
	public CustSearch getCustSearch() {
		return custSearch;
	}

	public void setCustSearch(CustSearch custSearch) {
		this.custSearch = custSearch;
	}

	public String[] getCustNums() {
		return custNums;
	}

	public void setCustNums(String[] custNums) {
		this.custNums = custNums;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	

}
