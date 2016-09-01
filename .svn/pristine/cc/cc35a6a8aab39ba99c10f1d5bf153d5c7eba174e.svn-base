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
import com.etaoguan.wea.client.web.service.IWReturnedInvService;
import com.etaoguan.wea.client.web.vo.ReturnedInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.ReturnedInvoice;
import com.etaoguan.wea.vo.ReturnedInvoiceItem;


@SuppressWarnings("serial")
@WeaModule(mname="回库单管理")
@Service("ownerWReturnedInvAction") @Scope("prototype")
public class WReturnedInvAction extends WOwnerBaseAction{

	@Resource(name="wreturnedInvService")
	private IWReturnedInvService iWReturnedInvService;
	
	private ReturnedInvSearch returnedInvSearch = new ReturnedInvSearch();
	
	private ReturnedInvoice returnedInv;
	
	@WeaFunction(fname="查看回库单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListReturnedInvs",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_returnedinvs.jsp")})
	public String listReturnedInvs() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看回库单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListReturnedInvsData")
	public String listReturnedInvsData() throws IOException {
		returnedInvSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWReturnedInvService.listReturnedInvs(returnedInvSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取回库单列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListReturnedInvsSearchInitData")
	public String getListReturnedInvsSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listReturnedInvsData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iWReturnedInvService.getListReturnedInvsSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="查看回库单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListReturnedInvItemsData")
	public String listReturnedInvItemsData() throws IOException {
		String retInvNum = getRequestParamValue("retInvNum");
		List<ReturnedInvoiceItem>  returnedInvoiceItemList= iWReturnedInvService.getReturnedInvItems(retInvNum);
		weaResponse.setRespData(returnedInvoiceItemList);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="更新回库单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditReturnedInv",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_returnedinv.jsp")})
	public String editReturnedInv() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="更新回库单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditReturnedInv")
	public String saveEditReturnedInv() throws IOException {
		returnedInv.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iWReturnedInvService.saveOrUpdateReturnedInv(returnedInv);
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取回库单信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditReturnedInvInitData")
	public String getEditReturnedInvInitData() throws IOException {
		String orderNum = getRequestParamValue("orderNum");
		String retInvNum = getRequestParamValue("retInvNum");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		Map initReturnedInvDataMap = iWReturnedInvService.getEditReturnedInvInitData(ownerNum,orderNum,retInvNum);
		weaResponse.setRespData(initReturnedInvDataMap);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除回库单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelReturnedInv")
	public String delReturnedInv() throws IOException {
		String retInvNum = getRequestParamValue("retInvNum");
		iWReturnedInvService.delReturnedInv(retInvNum);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="回库单入库",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wConfirmReturnedInvPutinStock")
	public String confirmReturnedInvPutinStock() throws IOException {
		String retInvNum = getRequestParamValue("retInvNum");
		String whNum = getRequestParamValue("whNum");
		iWReturnedInvService.saveReturnedInvStockChange(retInvNum,whNum);
		return JSONRESPONSE;
	}

	public ReturnedInvSearch getReturnedInvSearch() {
		return returnedInvSearch;
	}

	public void setReturnedInvSearch(ReturnedInvSearch returnedInvSearch) {
		this.returnedInvSearch = returnedInvSearch;
	}

	public ReturnedInvoice getReturnedInv() {
		return returnedInv;
	}

	public void setReturnedInv(ReturnedInvoice returnedInv) {
		this.returnedInv = returnedInv;
	}





}
