package com.etaoguan.wea.client.web.service;
import java.util.List;
import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.JpushKeysSearch;
import com.etaoguan.wea.client.web.vo.PushMessageSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WPushGroup;
import com.etaoguan.wea.service.IPushMessageService;
import com.etaoguan.wea.vo.JpushKeys;
import com.etaoguan.wea.vo.PushMessage;

public interface IWPushMessageService extends IPushMessageService{
	
	@SuppressWarnings("rawtypes")
	public WPage listJpushKeys(JpushKeysSearch jpushKeysSearch,SortParam sortParam,WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getEditJpushKeysInitData(String ownerNum);
	
	public void saveOrUpdateJpushKeys(JpushKeys jpushKeys);
	
	@Override
	public void updatePushGroupCustRefs(String groupNum,String[] custNums);
	
	public void saveOrUpdatePushGroup(WPushGroup wPushGroup);
	
	@SuppressWarnings("rawtypes")
	public Map getEditPushGroupInitData(String groupNum);
	
	@SuppressWarnings("rawtypes")
	public List getPushGroupCusts(String groupNum);
	
	@SuppressWarnings("rawtypes")
	public WPage listPushMessages(PushMessageSearch pushMessageSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);

	@SuppressWarnings("rawtypes")
	public Map getEditPushMessageInitData(String messageId,String ownerNum);
	
	@SuppressWarnings("rawtypes")
	public Map getListPushMessagesSearchInitData(String ownerNum);
	
	public void saveOrUpdatePushMessage(PushMessage pushMessage);
}
