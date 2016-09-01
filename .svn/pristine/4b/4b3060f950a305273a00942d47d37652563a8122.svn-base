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
import com.etaoguan.wea.client.web.service.IWStkAllocInvService;
import com.etaoguan.wea.client.web.vo.StkAllocInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.StockAllocateInvoice;
import com.etaoguan.wea.vo.StockAllocateInvoiceItem;


@SuppressWarnings("serial")
@WeaModule(mname="调拨单管理")
@Service("ownerWStkAllocAction") @Scope("prototype")
public class WStkAllocAction extends WOwnerBaseAction{

	@Resource(name="wstkAllocInvService")
	private IWStkAllocInvService iWStkAllocInvService;
	
	private StkAllocInvSearch stkAllocInvSearch = new StkAllocInvSearch();
	
	private StockAllocateInvoice stkAllocInv;
	
	@WeaFunction(fname="查看调拨单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListStkAllocInvs",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_stkallocinvs.jsp")})
	public String listStkAllocInvs() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看调拨单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListStkAllocInvsData")
	public String listStkAllocInvsData() throws IOException {
		stkAllocInvSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWStkAllocInvService.listStkAllocInvs(stkAllocInvSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取调拨单列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListStkAllocInvsSearchInitData")
	public String getListStkAllocInvsSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listStkAllocInvsData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iWStkAllocInvService.getListStkAllocInvsSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="查看调拨单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListStkAllocInvItemsData")
	public String listStkAllocInvItemsData() throws IOException {
		String stkAllocNum = getRequestParamValue("stkAllocNum");
		List<StockAllocateInvoiceItem>  stkAllocInvItemList= iWStkAllocInvService.getStkAllocInvItems(stkAllocNum);
		weaResponse.setRespData(stkAllocInvItemList);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="更新调拨单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditStkAllocInv",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_stkallocinv.jsp")})
	public String editStkAllocInv() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="更新调拨单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditStkAllocInv")
	public String saveEditStkAlloc() throws IOException {
		stkAllocInv.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iWStkAllocInvService.saveOrUpdateStkAllocInv(stkAllocInv);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取调拨单信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditStkAllocInvInitData")
	public String getEditStkAllocInvInitData() throws IOException {
		String stkAllocNum = getRequestParamValue("stkAllocNum");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		Map initStkAllocInvDataMap = iWStkAllocInvService.getEditStkAllocInvInitData(ownerNum,stkAllocNum);
		weaResponse.setRespData(initStkAllocInvDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除调拨单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelStkAllocInv")
	public String delStkAllocInv() throws IOException {
		String stkAllocNum = getRequestParamValue("stkAllocNum");
		iWStkAllocInvService.delStkAllocInv(stkAllocNum);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="调拨单出入库",oname=WeaFunction.Operation.DELETE)
	@Action(value="wConfirmStkAllocInvPutinStock")
	public String confirmStkAllocInvPutinStock() throws IOException {
		String stkAllocNum = getRequestParamValue("stkAllocNum");
		iWStkAllocInvService.saveStkAllocInvStockChange(stkAllocNum);
		return JSONRESPONSE;
	}

	public StkAllocInvSearch getStkAllocInvSearch() {
		return stkAllocInvSearch;
	}

	public void setStkAllocInvSearch(StkAllocInvSearch stkAllocInvSearch) {
		this.stkAllocInvSearch = stkAllocInvSearch;
	}

	public StockAllocateInvoice getStkAllocInv() {
		return stkAllocInv;
	}

	public void setStkAllocInv(StockAllocateInvoice stkAllocInv) {
		this.stkAllocInv = stkAllocInv;
	}



}
