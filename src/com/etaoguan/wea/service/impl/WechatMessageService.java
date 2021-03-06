package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IWechatMessageDao;
import com.etaoguan.wea.service.IWechatMessageService;
import com.etaoguan.wea.vo.WechatMessage;
import com.etaoguan.wea.vo.WechatMessageData;
@Service("wechatMessageService")
public class WechatMessageService extends BaseService implements IWechatMessageService{

	@Autowired
	private IWechatMessageDao iWechatMessageDao;

	@Override
	public void addWechatMessage(WechatMessage wechatMessage) {

		wechatMessage.setUpdateBy(getCurrentOperator());
		wechatMessage.setCreateBy(getCurrentOperator());
		long messageId = iWechatMessageDao.addWechatMessage(wechatMessage);
		if(wechatMessage.getWechatMessageDatas()!=null&&wechatMessage.getWechatMessageDatas().size()>0){
			for(WechatMessageData wechatMessageData:wechatMessage.getWechatMessageDatas()){
				wechatMessageData.setMessageId(messageId);
				iWechatMessageDao.addWechatMessageData(wechatMessageData);
			}
		}
		
	}

	@Override
	public void delWechatMessage(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		iWechatMessageDao.delWechatMessage(dataCriteria);
	}

	@Override
	public int getMaxWechatMessageDataItemNum(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		return iWechatMessageDao.getMaxWechatMessageDataItemNum(dataCriteria);
	}

	@Override
	public WechatMessage getWechatMessage(long messageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		return iWechatMessageDao.getWechatMessage(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listWechatMessages(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		
		return iWechatMessageDao.getWechatMessages(dataCriteria, offsetRequest);
	}

	@Override
	public void updateWechatMessage(WechatMessage wechatMessage) {
		wechatMessage.setUpdateBy(getCurrentOperator());
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",wechatMessage.getMessageId());
		iWechatMessageDao.delWechatMessageData(dataCriteria);

		if(wechatMessage.getWechatMessageDatas()!=null&&wechatMessage.getWechatMessageDatas().size()>0){
			for(WechatMessageData wechatMessageData:wechatMessage.getWechatMessageDatas()){
				wechatMessageData.setMessageId(wechatMessage.getMessageId());
				iWechatMessageDao.addWechatMessageData(wechatMessageData);
			}
		}
		
		iWechatMessageDao.updateWechatMessage(wechatMessage);
	}

	@Override
	public void updateWechatMessageSubjectNReplyKey(long messageId,
			String subject, String replyKey) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("messageId",messageId);
		dataCriteria.setParam("subject",subject);
		dataCriteria.setParam("replyKey",replyKey);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iWechatMessageDao.updateWechatMessage(dataCriteria);
		
	}

	@Override
	public WechatMessage getWechatMessage(String ownerNum,String replyKey) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("replyKey",replyKey);
		return iWechatMessageDao.getWechatMessage(dataCriteria);

	}

	/* (non-Javadoc)检查消息要不要转发给多客服
	 * @see com.etaoguan.wea.service.IWechatMessageService#checkManyCustomerMsgService(com.etaoguan.wea.vo.WechatMessage)
	 */
	@Override
	public boolean isManyCustomerMsg(String ownerNum,String replyKey) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("replyKey",replyKey);
		int count = iWechatMessageDao.getWechatMsgCount(dataCriteria);
		if(count>0){
			return false; 
		}
		return true;
	}
}
