package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.dao.IWechatpayResultDao;
import com.etaoguan.wea.wechat.vo.WechatpayResult;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author cunli 微信异步返回的信息
 * 
 */
@Repository
public class WechatpayResultDao extends SpringBaseDao implements IWechatpayResultDao {

	@Override
	@Resource(name = "wechatpaySqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient) {

		super.setSqlMapClient(sqlMapClient);
	}

	/*
	 * (non-Javadoc) 保存微信异步返回的信息
	 * 
	 * @see
	 * com.etaoguan.wea.dao.IWechatpayResultDao#saveWechatpayResult(com.etaoguan
	 * .wea.wechat.vo.WechatpayResult)
	 */
	@Override
	public int saveWechatpayResult(WechatpayResult wechatpayResult) {
		return (int) this.getSqlMapClientTemplate().insert("saveWechatpayResult", wechatpayResult);
	}

}
