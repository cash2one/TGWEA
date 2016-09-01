package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IProductGpsDao;
import com.etaoguan.wea.vo.ProductGps;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli
 * 产品定位
 */
@Repository
public class ProductGpsDao extends SpringBaseDao implements IProductGpsDao {

	@Override
	@Resource(name = "prodGpsSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient) {

		super.setSqlMapClient(sqlMapClient);
	}

	/**
	 * @param dataCriteria
	 * @param offsetRequest
	 * @return 产品定位 列表
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getProductGps(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();

		Integer count = (Integer) this.getSqlMapClientTemplate()
				.queryForObject("getProdcutsGpsCount", params);

		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<ProductGps> ProductGpsList = this.getSqlMapClientTemplate()
				.queryForList("getProdcutsGpsDatSet", params);

		DataSet<ProductGps> dataSet = new DataSet<ProductGps>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(ProductGpsList);
		return dataSet;
	}


	/* (non-Javadoc)删除产品定位
	 * @see com.etaoguan.wea.dao.IProductGpsDao#delProductGps(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void delProductGps(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteproductGps", dataCriteria.getParams());
	}

	/* (non-Javadoc)添加产品定位
	 * @see com.etaoguan.wea.dao.IProductGpsDao#addProductgps(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void addProductgps(ProductGps productGps) {
		this.getSqlMapClientTemplate().insert("addGps",productGps);
		
	}

	/* (non-Javadoc)获取产品定位列表
	 * @see com.etaoguan.wea.dao.IProductGpsDao#productGps(com.etaoguan.wea.vo.ProductGps)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductGps> productGps(ProductGps productGps) {
		return this.getSqlMapClientTemplate().queryForList("getProductGpsList", productGps);
	}

}
