package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProductDao;
import com.etaoguan.wea.vo.ProdDiffer;
import com.etaoguan.wea.vo.ProdExternal;
import com.etaoguan.wea.vo.ProdFeature;
import com.etaoguan.wea.vo.ProdImg;
import com.etaoguan.wea.vo.Product;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli
 * 产品信息
 */
@Repository
public class ProductDao extends SpringBaseDao implements IProductDao{

	@Override
	@Resource(name="prodSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void addProdImg(ProdImg prodImg) {
		this.getSqlMapClientTemplate().insert("createProdImg", prodImg);
	}

	@Override
	public void addProduct(Product product) {
		this.getSqlMapClientTemplate().insert("createProduct", product);
	}

	@Override
	public void delProdImg(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delProdImgByMap", dataCriteria.getParams());
	}

	@Override
	public void delProduct(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delProduct", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProdImg> getProdImgs(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getProdImgList", dataCriteria.getParams());
	}

	@Override
	public int getProdMaxImgSequence(DataCriteria dataCriteria) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("getProdMaxImgSequence", dataCriteria.getParams());
	}

	@Override
	public int getProdMaxPosSeqence(DataCriteria dataCriteria) {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("getProdMaxPosSeqence", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getProducts(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();

		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getProductCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<Product> prodList = this.getSqlMapClientTemplate().queryForList("getProductDatSet", params);
		
		DataSet<Product> dataSet = new DataSet<Product>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(prodList);
		return dataSet;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getCompProducts(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getCompProductCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<Product> prodList = this.getSqlMapClientTemplate().queryForList("getCompProductDatSet", params);
		
		DataSet<Product> dataSet = new DataSet<Product>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(prodList);
		return dataSet;
	}
	
	@Override
	public void updateProdImg(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateProdImg", dataCriteria.getParams());
		
	}

	@Override
	public void updateProduct(Product product) {
		this.getSqlMapClientTemplate().update("updateProduct", product);
		
	}

	@Override
	public void updateProduct(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateProductByMap", dataCriteria.getParams());
		
	}

	@Override
	public Product getProduct(DataCriteria dataCriteria) {
		return (Product)this.getSqlMapClientTemplate().queryForObject("getProduct", dataCriteria.getParams());
		
	}

	@Override
	public void delProdFeature(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delProdFeatureByMap", dataCriteria.getParams());
		
	}
	
	@Override
	public void delProdDiffer(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("delProdDifferByMap", dataCriteria.getParams());
		
	}

	@Override
	public ProdFeature getProdFeature(DataCriteria dataCriteria) {
		return (ProdFeature)this.getSqlMapClientTemplate().queryForObject("getProdFeature", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProdFeature> getProdFeatures(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getProdFeatureList", dataCriteria.getParams());
	}

	@Override
	public void updateProdFeature(ProdFeature prodFeature) {
		this.getSqlMapClientTemplate().update("updateProdFeature", prodFeature);
		
	}

	@Override
	public void addProdFeature(ProdFeature prodFeature) {
		this.getSqlMapClientTemplate().insert("createProdFeature", prodFeature);
		
	}

	@Override
	public ProdImg getProdImg(DataCriteria dataCriteria) {
		return (ProdImg)this.getSqlMapClientTemplate().queryForObject("getProdImg", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getProducts(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getProducts", dataCriteria.getParams());
	}

	@Override
	public ProdExternal getProdExternal(DataCriteria dataCriteria) {
		return (ProdExternal)this.getSqlMapClientTemplate().queryForObject("getProdExternal", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProdExternal> getProdExternals(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getProdExternalList", dataCriteria.getParams());
	}

	/* (non-Javadoc)根据用户ID获取产品列表信息
	 * @see com.etaoguan.wea.dao.IProductDao#getProductsBycustNum(com.etaoguan.wea.common.DataCriteria, com.etaoguan.wea.common.OffsetRequest)
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getProductsBycustNum(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getProductbyidCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<Product> prodList = this.getSqlMapClientTemplate().queryForList("getProductbyidDatSet", params);
		
		DataSet<Product> dataSet = new DataSet<Product>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(prodList);
		return dataSet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getProdNums(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getProdNums", dataCriteria.getParams());
	}

	@Override
	public void addProdDiffer(ProdDiffer prodDiffer) {
		this.getSqlMapClientTemplate().insert("createProdDiffer", prodDiffer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdDiffer> getProdDiffers(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getProdDifferList", dataCriteria.getParams());
	}

	
}
