package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.dao.IAlipayWapPayResultDao;
import com.etaoguan.wea.vo.AlipayWapPayResult;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli 微信的返回结果
 *
 */
@Repository
public class AlipayWapPayResultDao extends SpringBaseDao implements IAlipayWapPayResultDao{

	@Override
	@Resource(name="paymentSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		super.setSqlMapClient(sqlMapClient);
	}
	
	/**
	 * @param alipayWapPayResult 保存微信的返回结果
	 */
	@Override
	public int saveAlipayWapPayResult(AlipayWapPayResult alipayWapPayResult) {
		return (int) this.getSqlMapClientTemplate().insert("saveAlipayWapPayResult", alipayWapPayResult);
	}

	

}
