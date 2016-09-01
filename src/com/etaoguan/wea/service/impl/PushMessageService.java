package com.etaoguan.wea.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IPushMessageDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IPushMessageService;
import com.etaoguan.wea.vo.JpushKeys;
import com.etaoguan.wea.vo.PushGroup;
import com.etaoguan.wea.vo.PushGroupCustRef;
import com.etaoguan.wea.vo.PushMessage;
import com.etaoguan.wea.vo.PushMessageExtra;
import com.etaoguan.wea.vo.PushMessageResult;

@Service("pushMessageService")
public class PushMessageService extends BaseService implements IPushMessageService{

	@Resource(name="pushGroupKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Autowired
	IPushMessageDao iPushMessageDao;
	
	@Override
	public void addJpushKeys(JpushKeys jpushKeys) {
		jpushKeys.setCreateBy(getCurrentOperator());
		jpushKeys.setUpdateBy(getCurrentOperator());
		iPushMessageDao.addJpushKeys(jpushKeys);
	}

	@Override
	public String addPushGroup(PushGroup pushGroup) {
		String groupNum = iKeyGenService.saveNGetKey();
		pushGroup.setGroupNum(groupNum);
		pushGroup.setCreateBy(getCurrentOperator());
		pushGroup.setUpdateBy(getCurrentOperator());
		iPushMessageDao.addPushGroup(pushGroup);
		return groupNum;
	}

	@Override
	public long addPushMessage(PushMessage pushMessage) {
		pushMessage.setCreateBy(getCurrentOperator());
		pushMessage.setUpdateBy(getCurrentOperator());
		long messageId = iPushMessageDao.addPushMessage(pushMessage);
		if(pushMessage.getPushMessageExtras()!=null&&pushMessage.getPushMessageExtras().size()>0){
			for(PushMessageExtra pushMessageExtra:pushMessage.getPushMessageExtras()){
				pushMessageExtra.setMessageId(messageId);
				iPushMessageDao.addPushMessageExtra(pushMessageExtra);
			}
		}
		return messageId;
	}

	@Override
	public void updatePushGroupCustRefs(String groupNum,String[] custNums) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupNum",groupNum);
		iPushMessageDao.delPushGroupCustRef(dataCriteria);
		for(String custNum:custNums){
			PushGroupCustRef pushGroupCustRef = new PushGroupCustRef();
			pushGroupCustRef.setGroupNum(groupNum);
			pushGroupCustRef.setCustNum(custNum);
			pushGroupCustRef.setCreateBy(getCurrentOperator());
			pushGroupCustRef.setUpdateBy(getCurrentOperator());
			iPushMessageDao.addPushGroupCustRef(pushGroupCustRef);
		}
		
	}
	
	@Override
	public void addPushMessageExtra(PushMessageExtra pushMessageExtra) {
		iPushMessageDao.addPushMessageExtra(pushMessageExtra);
		
	}

	@Override
	public void delJpushKeys(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		iPushMessageDao.delJpushKeys(dataCriteria);
	}

	@Override
	public void delPushGroup(String groupNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupNum",groupNum);
		iPushMessageDao.delPushGroup(dataCriteria);
		
	}

	@Override
	public void delPushMessage(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		iPushMessageDao.delPushMessage(dataCriteria);
		
	}

	@Override
	public List<PushGroup> getAllPushGroups(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iPushMessageDao.getPushGroups(dataCriteria);
	}

	@Override
	public List<PushGroup> getCustPushGroups(String custNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum",custNum);
		return iPushMessageDao.getPushGroups(dataCriteria);
	}

	@Override
	public PushMessage getPushMessage(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		return iPushMessageDao.getPushMessage(dataCriteria);
	}

	@Override
	public List<PushMessageResult> getPushMessageResults(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		return iPushMessageDao.getPushMessageResults(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listJpushKeys(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iPushMessageDao.getJpushKeysDataSet(dataCriteria, offsetRequest);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listPushMessages(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iPushMessageDao.getPushMessageDataSet(dataCriteria, offsetRequest);
	}

	@Override
	public void updateJpushKeys(JpushKeys jpushKeys) {
		jpushKeys.setUpdateBy(getCurrentOperator());
		iPushMessageDao.updateJpushKeys(jpushKeys);
	}

	@Override
	public void updatePushGroup(PushGroup pushGroup) {
		pushGroup.setUpdateBy(getCurrentOperator());
		iPushMessageDao.updatePushGroup(pushGroup);
		
	}

	@Override
	public void updatePushMessage(PushMessage pushMessage) {
		pushMessage.setUpdateBy(getCurrentOperator());
		iPushMessageDao.updatePushMessage(pushMessage);
		
	}

	@Override
	public void updatePushMessageProcessStatus2New(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		dataCriteria.setParam("processStatus",0);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iPushMessageDao.updatePushMessage(dataCriteria);
	}

	@Override
	public void updatePushMessageSendTime(long messageId, Date sendTime) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		dataCriteria.setParam("sendTime",sendTime);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iPushMessageDao.updatePushMessage(dataCriteria);
		
	}

	@Override
	public JpushKeys getJpushKeys(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iPushMessageDao.getJpushKeys(dataCriteria);
		
	}

	@Override
	public PushGroup getPushGroup(String groupNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupNum",groupNum);
		return iPushMessageDao.getPushGroup(dataCriteria);
	}

	@Override
	public List<PushGroupCustRef> getPushGroupCustRefs(String groupNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupNum",groupNum);
		return iPushMessageDao.getPushGroupCustRefs(dataCriteria);
	}

	@Override
	public List<PushMessage> getAllPreSendPushMessages() {
		DataCriteria dataCriteria = new DataCriteria();
		return iPushMessageDao.getPreSendPushMessages(dataCriteria);
	}

	@Override
	public void updatePushMessageProcessStatus2Failed(long messageId,
			String remark) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId", messageId);
		dataCriteria.setParam("processStatus", 3);
		dataCriteria.setParam("remark", remark);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iPushMessageDao.updatePushMessageProcessStatus(dataCriteria);
		
	}

	@Override
	public void updatePushMessageProcessStatus2Submit(List<Long> messageIds) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageIds", messageIds);
		dataCriteria.setParam("processStatus", 1);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iPushMessageDao.updatePushMessageProcessStatus(dataCriteria);
	}

	@Override
	public void updatePushMessageProcessStatus2Success(long messageId,
			String remark) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId", messageId);
		dataCriteria.setParam("processStatus", 2);
		dataCriteria.setParam("remark", remark);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iPushMessageDao.updatePushMessageProcessStatus(dataCriteria);
	}

	@Override
	public void addPushMessageResult(PushMessageResult pushMessageResult) {
		pushMessageResult.setCreateBy(getCurrentOperator());
		pushMessageResult.setUpdateBy(getCurrentOperator());
		iPushMessageDao.addPushMessageResult(pushMessageResult);
		
	}

	@Override
	public int getPushMessageDateRangeCount(String ownerNum,Date createDateFrom,
			Date createDateTo) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		dataCriteria.setParam("createDateFrom", createDateFrom);
		dataCriteria.setParam("createDateTo", createDateTo);
		return iPushMessageDao.getPushMessageDateRangeCount(dataCriteria);
	}

	@Override
	public int getPushMessageTodayCount(String ownerNum) {
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
        
	    Calendar tomorrow = Calendar.getInstance(); 
	    tomorrow.setTime(today.getTime()); 
	    tomorrow.add(Calendar.DATE,1);
		return getPushMessageDateRangeCount(ownerNum,today.getTime(),tomorrow.getTime());
	}

}
