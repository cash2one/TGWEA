package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.dao.IOrderPayInfoDao;
import com.etaoguan.wea.vo.OrderPayInfo;
import com.ibatis.sqlmap.client.SqlMapClient;


/**
 * @author cunli 支付宝订单状态
 *
 */
@Repository
public class OrderPayInfoDao extends SpringBaseDao implements IOrderPayInfoDao{

	@Override
	@Resource(name="paymentSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	/**
	 * @param orderPayInfo 保存支付宝订单状态
	 */
	@Override
	public void saveOrderPayInfoDao(OrderPayInfo orderPayInfo) {
		this.getSqlMapClientTemplate().insert("saveOrderPayInfoDao", orderPayInfo);
	}
	

}
