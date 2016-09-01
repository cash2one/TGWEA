package com.etaoguan.wea.client.web.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.BatchFlagChange;
import com.etaoguan.wea.client.web.vo.ProdImgNode;
import com.etaoguan.wea.client.web.vo.ProdSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.service.IProductService;
import com.etaoguan.wea.vo.Product;


public interface IWProductService extends IProductService{
	
	/**
	 * @param productSearch
	 * @param sortParam
	 * @param wpagingRequest
	 * @return 产品信息
	 */
	@SuppressWarnings("rawtypes")
	public WPage listProductsbyid(ProdSearch prodSearch,SortParam sortParam, WPagingRequest mpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public WPage listProducts(ProdSearch productSearch,SortParam sortParam,WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public WPage listCompProducts(ProdSearch productSearch,SortParam sortParam, WPagingRequest wpagingRequest);

	@SuppressWarnings("rawtypes")
	public Map getListProdsSearchInitData(String ownerNum);
	
	@SuppressWarnings("rawtypes")
	public Map getEditProdInitData(String ownerNum,String prodNum);
	
	public void updateBatchTopFlag(BatchFlagChange batchFlagChange);
	
	public void updateBatchNewFlag(BatchFlagChange batchFlagChange);
	
	public void updateBatchHotFlag(BatchFlagChange batchFlagChange);
	
	/** 公开，隐藏
	 * @param batchFlagChange
	 */
	public void updateBatchIsPublic(BatchFlagChange batchFlagChange);
	
	public void updateBatchShowFlag(BatchFlagChange batchFlagChange);
	
	public void delBatchProduct(String[] prodNums);
	
	public void saveOrUpdateProduct(Product product,List<ProdImgNode> prodImgNodeList);
	
	public ProdImgNode genOwnerProdTmpImgNThumbFile(FileGenRequest fileGenRequest,String thumbWidth, String ownerNum) throws IOException;
}
