package com.etaoguan.wea.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IE688Dao;
import com.etaoguan.wea.e688.vo.MemberInfo;
import com.etaoguan.wea.e688.vo.OfferDescription;
import com.etaoguan.wea.e688.vo.OfferDetailInfo;
import com.etaoguan.wea.e688.vo.OfferImageInfo;
import com.etaoguan.wea.e688.vo.PriceRangeInfo;
import com.etaoguan.wea.e688.vo.ProductCategory;
import com.etaoguan.wea.e688.vo.ProductDiffer;
import com.etaoguan.wea.e688.vo.ProductFeatureInfo;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;


@Repository("e688Dao")@Scope("prototype")
public class E688Dao extends SpringBaseDao implements IE688Dao{
	final int batchSize = 1000;
	final int offerBatchSize = 500;
	@Override
	@Resource(name="e688SqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	public void saveMemberInfo(MemberInfo memberInfo) {
		this.getSqlMapClientTemplate().insert("createMemberInfo", memberInfo);
	}

	public void saveOfferDetailInfo(final List<OfferDetailInfo> offerDetailInfos) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				// 每次提交最大条数
				int count = 0;
				for (OfferDetailInfo offerDetailInfo : offerDetailInfos) {
					executor.insert("createOfferDetailInfo", offerDetailInfo);
					// 每1000条数据提交一次
					if (++count % offerBatchSize == 0) {

						executor.executeBatch();
					}
				}
				// 提交剩余的数据
				executor.executeBatch();
				return null;
			}
			
		});
		
	}

	public void saveOfferImageInfo(final List<OfferImageInfo> OfferImageInfos) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				// 每次提交最大条数
				int count = 0;
				for (OfferImageInfo offerImageInfo : OfferImageInfos) {
					executor.insert("createOfferImageInfo", offerImageInfo);
					// 每1000条数据提交一次
					if (++count % batchSize == 0) {

						executor.executeBatch();
					}
				}
				// 提交剩余的数据
				executor.executeBatch();
				return null;
			}
			
		});
	}

	public void saveProductFeatureInfo(final List<ProductFeatureInfo> productFeatureInfos) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				// 每次提交最大条数
				int count = 0;
				for (ProductFeatureInfo productFeatureInfo : productFeatureInfos) {
					executor.insert("createProductFeatureInfo", productFeatureInfo);
					// 每1000条数据提交一次
					if (++count % batchSize == 0) {

						executor.executeBatch();
					}
				}
				// 提交剩余的数据
				executor.executeBatch();
				return null;
			}
			
		});
	}

	public void saveEnterpriseCategory(final List<ProductCategory> productCategorys) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				// 每次提交最大条数
				int count = 0;
				for (ProductCategory enterpriseCategory : productCategorys) {
					executor.insert("createProductCategory", enterpriseCategory);
					// 每1000条数据提交一次
					if (++count % batchSize == 0) {

						executor.executeBatch();
					}
				}
				// 提交剩余的数据
				executor.executeBatch();
				return null;
			}
			
		});
	}

	@SuppressWarnings("rawtypes")
	public List getCategoryIdByOfferDatailInfo(DataCriteria dataCriteria) {

		List offerCategoryIds=getSqlMapClientTemplate().queryForList("getOfferCategoryId", dataCriteria.getParams());
		return offerCategoryIds;
	}

	public void savePriceRangeInfo(final List<PriceRangeInfo> priceRangeInfos) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				// 每次提交最大条数
				int count = 0;
				for (PriceRangeInfo priceRangeInfo : priceRangeInfos) {
					executor.insert("createPriceRangeInfo", priceRangeInfo);
					// 每1000条数据提交一次
					if (++count % batchSize == 0) {

						executor.executeBatch();
					}
				}
				// 提交剩余的数据
				executor.executeBatch();
				return null;
			}
			
		});
		
	}

	/* (non-Javadoc)调用存储过程copy中间表1688数据 to企业数据库
	 * @see com.etaoguan.wea.dao.IE688Dao#syncE688Data2Wea(com.etaoguan.wea.common.DataCriteria)
	 */
	public void syncE688Data2Wea(final DataCriteria dataCriteria) {
		//getSqlMapClientTemplate().insert("syncE688Data2Wea", dataCriteria.getParams());
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)

			throws SQLException {
				try{
					executor.insert("syncE688Data2Wea", dataCriteria.getParams());
				}catch(SQLException ex){
					ex.printStackTrace();
					throw ex;
				}	
				return null;
			}
		});
	}

	public void deleteE688Data(final DataCriteria dataCriteria) {
//		getSqlMapClientTemplate().delete("deleteE688Data", dataCriteria.getParams());
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)

			throws SQLException {
				try{
					executor.delete("deleteE688Data", dataCriteria.getParams());
				}catch(SQLException ex){
					ex.printStackTrace();
					throw ex;
				}	
				return null;
			}
		});
	}

	@Override
	public void saveProductDiffer(final List<ProductDiffer> productDifferList) {
		// TODO Auto-generated method stub
		/*this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				// 每次提交最大条数
				int count = 0;
				for (ProductDiffer productDiffer : productDifferList) {
					executor.insert("createProductDiffer", productDiffer);
					// 每1000条数据提交一次
					if (++count % batchSize == 0) {

						executor.executeBatch();
					}
				}
				// 提交剩余的数据
				executor.executeBatch();
				return null;
			}
			
		});*/
		for (ProductDiffer productDiffer : productDifferList) {
			try{
				this.getSqlMapClientTemplate().insert("createProductDiffer", productDiffer);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void saveOfferDescription(final List<OfferDescription> offerDescriptionList) {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				// TODO Auto-generated method stub
				executor.startBatch();
				// 每次提交最大条数
				int count = 0;
				for (OfferDescription offerDescription : offerDescriptionList) {
					executor.insert("createOfferDescription", offerDescription);
					// 每1000条数据提交一次
					if (++count % batchSize == 0) {

						executor.executeBatch();
					}
				}
				// 提交剩余的数据
				executor.executeBatch();
				return null;
			}
			
		});
		
	}

}
