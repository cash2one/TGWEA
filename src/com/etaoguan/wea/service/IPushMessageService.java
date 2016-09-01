package com.etaoguan.wea.service;

import java.util.Date;
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

public interface IPushMessageService {

	@SuppressWarnings("rawtypes")
	public DataSet listPushMessages(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public PushMessage getPushMessage(long messageId);
	
	public List<PushMessageResult> getPushMessageResults(long messageId);
	
	public long addPushMessage(PushMessage pushMessage);
	
	public void addPushMessageResult(PushMessageResult pushMessageResult);
	
	public void addPushMessageExtra(PushMessageExtra pushMessageExtra);
	
	public void delPushMessage(long messageId);
	
	public void updatePushMessage(PushMessage pushMessage);
	
	public void updatePushMessageProcessStatus2New(long messageId);
	
	public void updatePushMessageSendTime(long messageId,Date sendTime);
	
	public List<PushGroup> getAllPushGroups(String ownerNum);
	
	public String addPushGroup(PushGroup pushGroup);
	
	public PushGroup getPushGroup(String groupNum);
	
	public List<PushGroupCustRef> getPushGroupCustRefs(String groupNum);
	
	public void delPushGroup(String groupNum);
	
	public void updatePushGroup(PushGroup pushGroup);
	
	public List<PushGroup> getCustPushGroups(String custNum);
	
	@SuppressWarnings("rawtypes")
	public DataSet listJpushKeys(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addJpushKeys(JpushKeys jpushKeys);
	
	public void delJpushKeys(String ownerNum);
	
	public void updateJpushKeys(JpushKeys jpushKeys);
	
	public JpushKeys getJpushKeys(String ownerNum);
	
	public void updatePushGroupCustRefs(String groupNum,String[] custNums);
	
	public List<PushMessage> getAllPreSendPushMessages();
	
	public void updatePushMessageProcessStatus2Submit(List<Long> messageIds);
	
	public void updatePushMessageProcessStatus2Success(long messageId,String remark);
	
	public void updatePushMessageProcessStatus2Failed(long messageId,String remark);
	
	public int getPushMessageDateRangeCount(String ownerNum,Date createDateFrom,Date createDateTo);
	
	public int getPushMessageTodayCount(String ownerNum);
	
}
