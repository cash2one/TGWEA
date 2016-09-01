package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.dao.IAlipayWapRequestDao;
import com.etaoguan.wea.vo.AlipayWapRequest;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli 发送到支付宝的数据
 *
 */
@Repository
public class AlipayWapRequestDao extends SpringBaseDao implements IAlipayWapRequestDao{

	@Override
	@Resource(name="paymentSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	/* (non-Javadoc)保存 发送到支付宝的数据
	 * @see com.etaoguan.wea.dao.IAlipayWapRequestDao#saveAlipayWapRequest(com.etaoguan.wea.vo.AlipayWapRequest)
	 */
	@Override
	public void saveAlipayWapRequest(AlipayWapRequest alipayWapRequest) {
		this.getSqlMapClientTemplate().insert("saveAlipayWapRequest", alipayWapRequest);
	}


}
