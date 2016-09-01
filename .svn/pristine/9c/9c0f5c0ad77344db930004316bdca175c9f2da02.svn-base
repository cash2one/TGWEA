package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IPushMessageDao;
import com.etaoguan.wea.vo.JpushKeys;
import com.etaoguan.wea.vo.PushGroup;
import com.etaoguan.wea.vo.PushGroupCustRef;
import com.etaoguan.wea.vo.PushMessage;
import com.etaoguan.wea.vo.PushMessageExtra;
import com.etaoguan.wea.vo.PushMessageResult;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class PushMessageDao extends SpringBaseDao implements IPushMessageDao{

	@Override
	@Resource(name="pushMessageSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}

	@Override
	public void addJpushKeys(JpushKeys jpushKeys) {
		this.getSqlMapClientTemplate().insert("createJpushKeys", jpushKeys);
		
	}

	@Override
	public void addPushGroup(PushGroup pushGroup) {
		this.getSqlMapClientTemplate().insert("createPushGroup", pushGroup);
		
	}
	
	@Override
	public void addPushMessageResult(PushMessageResult pushMessageResult) {
		this.getSqlMapClientTemplate().insert("createPushMessageResult", pushMessageResult);
		
	}

	@Override
	public void addPushGroupCustRef(PushGroupCustRef pushGroupCustRef) {
		this.getSqlMapClientTemplate().insert("createPushGroupCustRef", pushGroupCustRef);
		
	}

	@Override
	public long addPushMessage(PushMessage pushMessage) {
		return (Long)this.getSqlMapClientTemplate().insert("createPushMessage", pushMessage);
		
	}

	@Override
	public void addPushMessageExtra(PushMessageExtra pushMessageExtra) {
		this.getSqlMapClientTemplate().insert("createPushMessageExtra", pushMessageExtra);
		
	}

	@Override
	public void delJpushKeys(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteJpushKeys", dataCriteria.getParams());
		
	}

	@Override
	public void delPushGroup(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deletePushGroup", dataCriteria.getParams());
		
	}

	@Override
	public void delPushGroupCustRef(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deletePushGroupCustRef", dataCriteria.getParams());
		
	}

	@Override
	public void delPushMessage(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deletePushMessage", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getJpushKeysDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getJpushKeysCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<JpushKeys> jpushKeysList = this.getSqlMapClientTemplate().queryForList("getJpushKeysDataSet", params);
		DataSet<JpushKeys> dataSet = new DataSet<JpushKeys>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(jpushKeysList);
		return dataSet;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PushGroup> getPushGroups(DataCriteria dataCriteria) {

		return this.getSqlMapClientTemplate().queryForList("getPushGroups", dataCriteria.getParams());
	}

	@Override
	public PushMessage getPushMessage(DataCriteria dataCriteria) {
		
		return (PushMessage)this.getSqlMapClientTemplate().queryForObject("getPushMessage", dataCriteria.getParams());
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataSet getPushMessageDataSet(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getPushMessageCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<PushMessage> pushMessageList = this.getSqlMapClientTemplate().queryForList("getPushMessageDataSet", params);
		DataSet<PushMessage> dataSet = new DataSet<PushMessage>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(pushMessageList);
		return dataSet;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PushMessageResult> getPushMessageResults(
			DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getPushMessageResults", dataCriteria.getParams());
	}

	@Override
	public void updateJpushKeys(JpushKeys jpushKeys) {
		this.getSqlMapClientTemplate().update("updateJpushKeys", jpushKeys);
		
	}

	@Override
	public void updateJpushKeysByMap(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updateJpushKeysByMap", dataCriteria.getParams());
		
	}

	@Override
	public void updatePushGroup(PushGroup pushGroup) {
		this.getSqlMapClientTemplate().update("updatePushGroup", pushGroup);
		
	}

	@Override
	public void updatePushMessage(PushMessage pushMessage) {
		this.getSqlMapClientTemplate().update("updatePushMessage", pushMessage);
		
	}

	@Override
	public void updatePushMessage(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updatePushMessageByMap", dataCriteria.getParams());
		
	}

	@Override
	public JpushKeys getJpushKeys(DataCriteria dataCriteria) {
		
		return (JpushKeys)this.getSqlMapClientTemplate().queryForObject("getJpushKeys", dataCriteria.getParams());
		
	}

	@Override
	public PushGroup getPushGroup(DataCriteria dataCriteria) {
		return (PushGroup)this.getSqlMapClientTemplate().queryForObject("getPushGroup", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PushGroupCustRef> getPushGroupCustRefs(DataCriteria dataCriteria) {
		return this.getSqlMapClientTemplate().queryForList("getPushGroupCustRefs", dataCriteria.getParams());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PushMessage> getPushMessages(DataCriteria dataCriteria) {
		
		return this.getSqlMapClientTemplate().queryForList("getPushMessages", dataCriteria.getParams());
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PushMessage> getPreSendPushMessages(DataCriteria dataCriteria) {
		
		return this.getSqlMapClientTemplate().queryForList("getPreSendPushMessages", dataCriteria.getParams());
	}
	
	@Override
	public void updatePushMessageProcessStatus(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().update("updatePushMessageProcessStatus", dataCriteria.getParams());
		
	}

	@Override
	public int getPushMessageDateRangeCount(DataCriteria dataCriteria) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getPushMessageDateRangeCount", dataCriteria.getParams());
		
	}
}
