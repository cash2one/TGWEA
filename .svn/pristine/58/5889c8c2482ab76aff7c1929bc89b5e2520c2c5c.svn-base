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
import com.etaoguan.wea.client.web.service.IWDeliverInvService;
import com.etaoguan.wea.client.web.vo.DeliverInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.vo.DeliverInvlogistics;
import com.etaoguan.wea.vo.DeliverInvoiceItem;


@WeaModule(mname="送货单管理")
@Service("ownerWDeliverInvAction") @Scope("prototype")
public class WDeliverInvAction extends WOwnerBaseAction{

	private static final long serialVersionUID = 9190911022913818525L;

	@Resource(name="wdeliverInvService")
	private IWDeliverInvService iWDeliverInvService;
	
	private DeliverInvSearch deliverInvSearch = new DeliverInvSearch();
	
	private DeliverInvlogistics deliverInvlogistics;
	private String orderNum;
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@WeaFunction(fname="查看送货单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListDeliverInvs",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_deliverinvs.jsp")})
	public String listDeliverInvs() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看送货单列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListDeliverInvsData")
	public String listDeliverInvsData() throws IOException {
		deliverInvSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iWDeliverInvService.listDeliverInvs(deliverInvSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取送货单列表查询条件",oname=WeaFunction.Operation.READ)
	@Action(value="wGetListDeliverInvsSearchInitData")
	public String getListDeliverInvsSearchInitData() throws IOException {
		String trackKey = this.getClass().getName()+".listDeliverInvsData";
		setPageSearchMap(trackKey);
		Map initSearchDataMap = iWDeliverInvService.getListDeliverInvsSearchInitData(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRespData(initSearchDataMap);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="查看送货单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListDeliverInvItemsData")
	public String listDeliverInvItemsData() throws IOException {
		String deliverNum = getRequestParamValue("deliverNum");
		List<DeliverInvoiceItem>  deliverInvoiceItemList= iWDeliverInvService.getDeliverInvItems(deliverNum);
		weaResponse.setRespData(deliverInvoiceItemList);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="查看送货单明细",oname=WeaFunction.Operation.READ)
	@Action(value="wListSearchDeliverInvItemsData")
	public String listSearchDeliverInvItemsData() throws IOException {
		String deliverNum = getRequestParamValue("deliverNum");
		List<DeliverInvoiceItem>  deliverInvoiceItemList= iWDeliverInvService.getDeliverInvItems(deliverNum);
		weaResponse.setRows(deliverInvoiceItemList);
		weaResponse.setTotal(deliverInvoiceItemList.size());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="更新送货单物流信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUpdateDeliverInvlogistics")
	public String updateDeliverInvlogistics() throws IOException {
		String deliverNum = getRequestParamValue("deliverNum");
		iWDeliverInvService.updateDeliverInvlogistics(deliverNum, deliverInvlogistics);
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="删除送货单",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelDeliverInv")
	public String delDeliverInv() throws IOException {
		String deliverNum = getRequestParamValue("deliverNum");
		iWDeliverInvService.delDeliverInv(deliverNum);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="生成送货单",oname=WeaFunction.Operation.CREATE)
	@Action(value="wGenDeliverInv")
	public String genDeliverInv() {
		try {
			iWDeliverInvService.addGenDeliverInvByOrderNum(orderNum);
		} catch (Exception e) {
		}
		return JSONRESPONSE;
	}
	@WeaFunction(fname="送货单出库",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wConfirmDeliverInvPutonStock")
	public String confirmDeliverInvPutonStock() throws IOException {
		String deliverNum = getRequestParamValue("deliverNum");
		String whNum = getRequestParamValue("whNum");
		iWDeliverInvService.saveDeliverInvStockChange(deliverNum, whNum);
		return JSONRESPONSE;
	}


	public DeliverInvSearch getDeliverInvSearch() {
		return deliverInvSearch;
	}

	public void setDeliverInvSearch(DeliverInvSearch deliverInvSearch) {
		this.deliverInvSearch = deliverInvSearch;
	}

	public DeliverInvlogistics getDeliverInvlogistics() {
		return deliverInvlogistics;
	}

	public void setDeliverInvlogistics(DeliverInvlogistics deliverInvlogistics) {
		this.deliverInvlogistics = deliverInvlogistics;
	}


}
