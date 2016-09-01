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
import com.etaoguan.wea.client.web.service.IWGodownInvService;
import com.etaoguan.wea.client.web.vo.GodownInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.GodownInvoice;
import com.etaoguan.wea.vo.GodownInvoiceItem;


@WeaModule(mname="入库单管理")
@Service("ownerWGodownInvAction") @Scope("prototype")
public class WGodownInvAction extends WOwnerBaseAction{

	private static final long serialVersionUID = -8561160666268210449L;

	@Resource(name="wgodownInvService")
	private IWGodownInvService iWGoDownInvService;
	
	private GodownInvSearch godownInvSearch = new GodownInvSearch();
	
	private GodownInvoice godownInvoice;
	 
	@WeaFunction(fname="查看入库单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListGodownInvs",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_godowninvs.jsp")})
	public String listGodownInvs() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看入库单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListGodownInvsData")
	public String listGodownInvsData() throws IOException {
		godownInvSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWGoDownInvService.listGodownInvs(godownInvSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取入库单列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListGodownInvsSearchInitData")
	public String getListGodownInvsSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listGodownInvsData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iWGoDownInvService.getListGodownInvsSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="查看入库单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListGodownInvItemsData")
	public String listGodownInvItemsData() throws IOException {
		String gdNum = getRequestParamValue("gdNum");
		List<GodownInvoiceItem>  godownInvoiceItemList= iWGoDownInvService.getGodownInvItems(gdNum);
		weaResponse.setRespData(godownInvoiceItemList);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="更新入库单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditGodownInv",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_godowninv.jsp")})
	public String editGodownInv() throws IOException {
		return SUCCESS;
	}
	
	@WeaFunction(fname="更新入库单",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditGodownInv")
	public String saveEditGodown() throws IOException {
		godownInvoice.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iWGoDownInvService.saveOrUpdateGodownInv(godownInvoice);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取入库单信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditGodownInvInitData")
	public String getEditGodownInvInitData() throws IOException {
		String gdNum = getRequestParamValue("gdNum");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		Map initGodownInvDataMap = iWGoDownInvService.getEditGodownInvInitData(ownerNum,gdNum);
		weaResponse.setRespData(initGodownInvDataMap);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="删除入库单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelGodownInv")
	public String delGodownInv() throws IOException {
		String gdNum = getRequestParamValue("gdNum");
		iWGoDownInvService.delGodownInv(gdNum);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="入库单入库",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wConfirmGodownInvPutinStock")
	public String confirmGodownInvPutinStock() throws IOException {
		String gdNum = getRequestParamValue("gdNum");
		iWGoDownInvService.saveGodownInvStockChange(gdNum);
		return JSONRESPONSE;
	}

	public GodownInvoice getGodownInvoice() {
		return godownInvoice;
	}

	public void setGodownInvoice(GodownInvoice godownInvoice) {
		this.godownInvoice = godownInvoice;
	}

	public GodownInvSearch getGodownInvSearch() {
		return godownInvSearch;
	}

	public void setGodownInvSearch(GodownInvSearch godownInvSearch) {
		this.godownInvSearch = godownInvSearch;
	}



}
