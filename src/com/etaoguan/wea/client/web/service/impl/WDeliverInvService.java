package com.etaoguan.wea.client.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWDeliverInvService;
import com.etaoguan.wea.client.web.service.IWWareHouseService;
import com.etaoguan.wea.client.web.vo.DeliverInvSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.DeliverInvService;
@Service("wdeliverInvService")
public class WDeliverInvService extends DeliverInvService implements IWDeliverInvService{

	@Autowired
	IWWareHouseService iWWareHouseService;
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listDeliverInvs(DeliverInvSearch deliverInvSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum", deliverInvSearch.getCustNum());
		dataCriteria.setParam("referOrderNum", deliverInvSearch.getReferOrderNum());
		dataCriteria.setParam("ownerNum", deliverInvSearch.getOwnerNum());
		DataSet dataSet = listDeliverInvs(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getListDeliverInvsSearchInitData(String ownerNum) {
		Map dataMap = new HashMap();
		dataMap.put("warehouses",iWWareHouseService.getAllWarehouses(ownerNum));
		return dataMap;
	}
}
