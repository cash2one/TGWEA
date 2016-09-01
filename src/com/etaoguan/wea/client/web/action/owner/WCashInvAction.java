package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWCashInvService;
import com.etaoguan.wea.client.web.vo.CashInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.CashInvoice;
import com.etaoguan.wea.vo.CashInvoiceItem;

@SuppressWarnings("serial")
@WeaModule(mname="收款单管理")
@Service("ownerWCashInvAction") @Scope("prototype")
public class WCashInvAction extends WOwnerBaseAction{

	@Resource(name="wcashInvService")
	private IWCashInvService iWCashInvService;
	
	private CashInvSearch cashInvSearch = new CashInvSearch();
	
	private CashInvoice cashInv;
	 
	@WeaFunction(fname="查看收款单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListCashInvs",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_cashinvs.jsp")})
	public String listCashInvs() throws IOException {

		return SUCCESS;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看收款单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListCashInvsData")
	public String listCashInvsData() throws IOException {
		cashInvSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWCashInvService.listCashInvs(cashInvSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取收款单列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListCashInvsSearchInitData")
	public String getListCashInvsSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listCashInvsData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iWCashInvService.getListCashInvsSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="查看收款单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListCashInvItemsData")
	public String listCashInvItemsData() throws IOException {
		String cashNum = getRequestParamValue("cashNum");
		List<CashInvoiceItem>  cashInvoiceItemList= iWCashInvService.getCashInvItems(cashNum);
		weaResponse.setRespData(cashInvoiceItemList);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="修改收款单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditCashInv",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_cashinv.jsp")})
	public String editCashInv() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="修改收款单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditCashInv")
	public String saveEditCashInv() throws IOException {
		cashInv.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iWCashInvService.saveOrUpdateCashInv(cashInv);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取收款单信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditCashInvInitData")
	public String getEditCashInvInitData() throws IOException {
		String orderNum = getRequestParamValue("orderNum");
		String cashInvNum = getRequestParamValue("cashNum");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		Map initCashInvDataMap = iWCashInvService.getEditCashInvInitData(ownerNum,orderNum,cashInvNum);
		weaResponse.setRespData(initCashInvDataMap);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="删除收款单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelCashInv")
	public String delCashInv() throws IOException {
		String cashInvNum = getRequestParamValue("cashNum");
		iWCashInvService.delCashInv(cashInvNum);
		return JSONRESPONSE;
	}

	public CashInvSearch getCashInvSearch() {
		return cashInvSearch;
	}

	public void setCashInvSearch(CashInvSearch cashInvSearch) {
		this.cashInvSearch = cashInvSearch;
	}

	public CashInvoice getCashInv() {
		return cashInv;
	}

	public void setCashInv(CashInvoice cashInv) {
		this.cashInv = cashInv;
	}




}
