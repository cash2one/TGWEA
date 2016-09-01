package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.dao.IWechatpayRequestDao;
import com.etaoguan.wea.wechat.vo.WechatpayRequest;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli 发送微信的信息
 *
 */
@Repository
public class WechatpayRequestDao extends SpringBaseDao implements IWechatpayRequestDao{

	@Override
	@Resource(name="wechatpaySqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}


	/* (non-Javadoc) 保存发送微信的信息
	 * @see com.etaoguan.wea.dao.IWechatpayRequestDao#saveWechatpayRequest(com.etaoguan.wea.wechat.vo.WechatpayRequest)
	 */
	@Override
	public void saveWechatpayRequest(WechatpayRequest wechatpayRequest) {
		this.getSqlMapClientTemplate().insert("saveWechatpayRequest", wechatpayRequest);
	}
	

}
