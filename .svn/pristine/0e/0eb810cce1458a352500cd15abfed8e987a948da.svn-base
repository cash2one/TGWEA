package com.etaoguan.wea.service;

import java.util.Date;
import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.ProdDiffer;
import com.etaoguan.wea.vo.ProdExternal;
import com.etaoguan.wea.vo.ProdFeature;
import com.etaoguan.wea.vo.ProdImg;
import com.etaoguan.wea.vo.Product;

public interface IProductService {

	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 产品信息
	 */
	@SuppressWarnings("rawtypes")
	public DataSet listProductsbyid(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	public void addProduct(Product product);
	
	public Product getProduct(String prodNum);
	
	public List<Product> getProducts(List<String> prodNums);
	
	public List<String> getUpdatedProdNums(Date updateDate);
	
	public int getProdMaxPosSeqence(String ownerNum);
	
	public void updateProduct(Product product);
	
	public void delProduct(String prodNum);
	
	public void addProdImgs(List<ProdImg> prodImgs);
	
	public void addProdImg(ProdImg prodImg);
	
	public int getProdMaxImgSequence(String prodNum);
	
	public void delProdImg(String prodNum,int imgSeq);
	
	public void updateImgSeqence(String prodNum,int preProdImgSeq,int prodImgSeq);
	
	public List<ProdImg> listProdImgs(String prodNum);
	
	@SuppressWarnings("rawtypes")
	public DataSet listProducts(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	@SuppressWarnings("rawtypes")
	public DataSet listCompProducts(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void updateDispStockBalance(String prodNum, int stockBalance);

	public void updateShowFlag(String prodNum, int showFlag);
	
	public void updateHotFlag(String prodNum, int hotFlag);
	
	public void updateNewFlag(String prodNum, int newFlag);

	public void updateTopFlag(String prodNum, int topFlag);
	
	public void updateShowFlag(String[] prodNums, int showFlag);
	
	public void updateHotFlag(String[] prodNums, int hotFlag);
	
	/** 公开，隐藏
	 * @param prodNums
	 * @param isPublic
	 */
	public void updateIsPublic(String[] prodNums, int isPublic);
	
	public void updateNewFlag(String[] prodNums, int newFlag);

	public void updateTopFlag(String[] prodNums, int topFlag);
	
	public void updatePosSeqence(String preProdNum, String prodNum);
	
	public List<ProdFeature> listProdFeatures(String prodNum);
	
	public List<ProdExternal> listProdExternals(String prodNum);
	
	public List<ProdDiffer> listProdDiffers(String prodNum);
	
	public void delProdFeature(String prodNum,String featureName);
	
	public void addProdFeatures(List<ProdFeature> prodFeatures);
	
	public void addProdFeature(ProdFeature prodFeature);
	
	public void updateProdFeature(ProdFeature prodFeature);
	
	public void updateProdStdPrice(String prodNum,double stdPrice);
}
