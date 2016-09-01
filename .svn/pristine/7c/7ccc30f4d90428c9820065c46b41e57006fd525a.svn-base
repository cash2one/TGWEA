package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.TableCodeNameSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.ITableCodeNameService;
import com.etaoguan.wea.vo.TableCodeName;

public interface IWTableCodeNameService extends ITableCodeNameService{

	@SuppressWarnings("rawtypes")
	public WPage listTableCodeNames(TableCodeNameSearch tableCodeNameSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);
	@SuppressWarnings("rawtypes")
	public Map getListTableCodeNamesSearchInitData();
	
	public void saveOrUpdateTableCodeName(TableCodeName tableCodeName);
}
