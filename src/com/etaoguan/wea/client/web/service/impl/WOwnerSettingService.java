package com.etaoguan.wea.client.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWOwnerSettingService;
import com.etaoguan.wea.client.web.service.IWTableCodeNameService;
import com.etaoguan.wea.client.web.vo.OwnerSettingSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.OwnerSettingService;
import com.etaoguan.wea.vo.OwnerSetting;
import com.etaoguan.wea.vo.TableCodeName;

@Service("wownerSettingService")
public class WOwnerSettingService extends OwnerSettingService implements IWOwnerSettingService{
	
	@Autowired
	private IWTableCodeNameService iWTableCodeNameService;
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listOwnerSettings(OwnerSettingSearch ownerSettingSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerSettingSearch.getOwnerNum());
		DataSet dataSet = listOwnerSettings(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}

	@Override
	public void saveOrUpdateOwnerSetting(OwnerSetting ownerSetting) {
		if(ownerSetting.getSettingId()==0){
			addOwnerSetting(ownerSetting);
		}else{
			updateOwnerSetting(ownerSetting);
		}
		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getListOwnerSettingSearchInitData() {
		Map dataMap = new HashMap();
		List<TableCodeName>  ownerSettingTableNames= iWTableCodeNameService.getOwnerSettingTableCodeNameList();
		dataMap.put("ownerSettingTableNames",ownerSettingTableNames);
		return dataMap;

	}
}
