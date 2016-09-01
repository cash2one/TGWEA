package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.JpushKeys;
import com.etaoguan.wea.vo.PushGroup;
import com.etaoguan.wea.vo.PushGroupCustRef;
import com.etaoguan.wea.vo.PushMessage;
import com.etaoguan.wea.vo.PushMessageExtra;
import com.etaoguan.wea.vo.PushMessageResult;

public interface IPushMessageDao {
	
	@SuppressWarnings("rawtypes")
	public DataSet getPushMessageDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public List<PushMessageResult> getPushMessageResults(DataCriteria dataCriteria);
	
	public void updatePushMessage(PushMessage pushMessage);
	
	public void updatePushMessage(DataCriteria dataCriteria);
	
	public void delPushMessage(DataCriteria dataCriteria);
	
	public long addPushMessage(PushMessage pushMessage);
	
	public void addPushMessageExtra(PushMessageExtra pushMessageExtra);
	
	public PushMessage getPushMessage(DataCriteria dataCriteria);
	
	public List<PushMessage> getPushMessages(DataCriteria dataCriteria);
	
	@SuppressWarnings("rawtypes")
	public DataSet getJpushKeysDataSet(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void updateJpushKeys(JpushKeys jpushKeys);
	
	public void updateJpushKeysByMap(DataCriteria dataCriteria);
	
	public void delJpushKeys(DataCriteria dataCriteria);
	
	public void addJpushKeys(JpushKeys jpushKeys);
	
	public JpushKeys getJpushKeys(DataCriteria dataCriteria);
	
	public List<PushGroup> getPushGroups(DataCriteria dataCriteria);
	
	public void addPushGroup(PushGroup pushGroup);
	
	public void addPushMessageResult(PushMessageResult pushMessageResult);
	
	public void updatePushGroup(PushGroup pushGroup);
	
	public void delPushGroup(DataCriteria dataCriteria);
	
	public PushGroup getPushGroup(DataCriteria dataCriteria);
	
	public void addPushGroupCustRef(PushGroupCustRef pushGroupCustRef);
	
	public void delPushGroupCustRef(DataCriteria dataCriteria);
	
	public List<PushGroupCustRef> getPushGroupCustRefs(DataCriteria dataCriteria);

	public List<PushMessage> getPreSendPushMessages(DataCriteria dataCriteria);
	
	public void updatePushMessageProcessStatus(DataCriteria dataCriteria);
	
	public int getPushMessageDateRangeCount(DataCriteria dataCriteria);
}
