package com.etaoguan.wea.client.web.service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.SpecialProdCustRefSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.service.ISpecialProdCustRefService;

/**
 * @author cunli
 * 特供产品表
 */
public interface IWSpecialProdCustRefService extends ISpecialProdCustRefService{
	
	/**
	 * @param groupName
	 * @return 根据组名查询特供产品，获得属于某个人的特供产品列表
	 */
	@SuppressWarnings("rawtypes")
	public WPage specialprods(SpecialProdCustRefSearch search,SortParam sortParam,WPagingRequest wpagingRequest);
	
}
