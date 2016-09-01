package com.etaoguan.wea.client.mobile.service;

import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.mobile.vo.ProdSearch;
import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.service.IProductService;


public interface IMProductService extends IProductService{
	
	@SuppressWarnings("rawtypes")
	public MPage listProducts(ProdSearch productSearch,SortParam sortParam,MPagingRequest mpagingRequest);
	/**
	 * @param productSearch
	 * @param sortParam
	 * @param mpagingRequest
	 * @return 根据用户id获取产品信息
	 */
	@SuppressWarnings("rawtypes")
	public MPage listProductsbyid(ProdSearch productSearch,SortParam sortParam,MPagingRequest mpagingRequest);


}
