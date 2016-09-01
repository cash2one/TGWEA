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
import com.etaoguan.wea.client.web.service.IWWareHouseService;
import com.etaoguan.wea.vo.WareHouse;

@SuppressWarnings("serial")
@WeaModule(mname="仓库管理")
@Service("ownerWWarehouseAction") @Scope("prototype")
public class WWarehouseAction extends WOwnerBaseAction{

	@Resource(name="wwareHouseService")
	private IWWareHouseService iwWareHouseService;
	
	private WareHouse wareHouse;
	
	@WeaFunction(fname="查看仓库列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWarehouses",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_warehouses.jsp")})
	public String listWarehouses() throws IOException {

		return SUCCESS;
	}
	@WeaFunction(fname="查看仓库列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListWarehousesData")
	public String listWarehousesData() throws IOException {

		List<WareHouse>  wareHouseList = iwWareHouseService.getAllWarehouses(getCurrentOwnerAdmin().getOwnerNum());
		weaResponse.setRows(wareHouseList);
		weaResponse.setTotal(wareHouseList.size());
		return JSONRESPONSE;
	}
	
	@WeaFunction(fname="更新仓库",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveWarehouse")
	public String saveWarehouse() throws IOException {
		wareHouse.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwWareHouseService.saveOrUpdateProduct(wareHouse);
		return JSONRESPONSE;
	}

	@WeaFunction(fname="删除仓库",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelWarehouse")
	public String delWarehouse() throws IOException {
		String whNum = getRequestParamValue("whNum");
		iwWareHouseService.delWareHouse(whNum,getCurrentOwnerAdmin().getOwnerNum());
		return JSONRESPONSE;
	}

	public WareHouse getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}


}
