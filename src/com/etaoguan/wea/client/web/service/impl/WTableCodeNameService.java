package com.etaoguan.wea.client.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWTableCodeNameService;
import com.etaoguan.wea.client.web.vo.TableCodeNameSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.service.impl.TableCodeNameService;
import com.etaoguan.wea.vo.TableCodeName;

@Service("wtableCodeNameService")
public class WTableCodeNameService extends TableCodeNameService implements IWTableCodeNameService{

	@Override
	@SuppressWarnings("rawtypes")
	public WPage listTableCodeNames(TableCodeNameSearch tableCodeNameSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("tableName", tableCodeNameSearch.getTableName());
		DataSet dataSet = listTableCodeNames(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getListTableCodeNamesSearchInitData() {
		Map dataMap = new HashMap();
		dataMap.put("tableCodeNames",WeaDataCache.getCache().getTableColumnMap());
		return dataMap;
	}
	
	@Override
	public void saveOrUpdateTableCodeName(TableCodeName tableCodeName){
		deleteTableCodeName(tableCodeName.getTableName(), tableCodeName.getColumnName(), tableCodeName.getColumnCode());
		saveTableCodeName(tableCodeName);
	}
}
