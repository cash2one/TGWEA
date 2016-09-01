package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IWechatMassMessageDao;
import com.etaoguan.wea.wechat.vo.WechatMassMessage;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class WechatMassMessageDao extends SpringBaseDao implements IWechatMassMessageDao{

	@Override
	@Resource(name="wechatMassMessageSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	

	@Override
	public int addWechatMassMessage(WechatMassMessage wechatMassMessage) {
		return (Integer)this.getSqlMapClientTemplate().insert("createWechatMassMessage", wechatMassMessage);
	}


	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getWechatMassMessage(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getWechatMassMessageCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<WechatMassMpnews> wechatPictureTextList = this.getSqlMapClientTemplate().queryForList("getWechatMassMessageDataSet", params);
		
		DataSet<WechatMassMpnews> dataSet = new DataSet<WechatMassMpnews>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(wechatPictureTextList);
		return dataSet;
	}


	/* (non-Javadoc)save massMEssageId to dataBase
	 * @see com.etaoguan.wea.dao.IWechatMassMessageDao#updateWechatMassMessage(int)
	 */
	@Override
	public void updateWechatMassMessage(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateWechatMassMessage", dataCriteria.getParams());
	}


	/* (non-Javadoc)根据Id获取要发送所需要的mediaId
	 * @see com.etaoguan.wea.dao.IWechatMassMessageDao#getMassMessageById(int)
	 */
	@Override
	public WechatMassMessage getMassMessageById(DataCriteria dataCriteria) {
		return (WechatMassMessage)this.getSqlMapClientTemplate().queryForObject("getMassMessageById", dataCriteria.getParams());
	}


	/* (non-Javadoc)删除群发消息
	 * @see com.etaoguan.wea.dao.IWechatMassMessageDao#deleteWechatMassMessage(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public void deleteWechatMassMessage(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteWechatMassMessage", dataCriteria.getParams());
		
	}
}
