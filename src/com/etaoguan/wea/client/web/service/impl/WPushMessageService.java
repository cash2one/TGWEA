package com.etaoguan.wea.client.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWOwnerService;
import com.etaoguan.wea.client.web.service.IWPushMessageService;
import com.etaoguan.wea.client.web.vo.JpushKeysSearch;
import com.etaoguan.wea.client.web.vo.PushMessageSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WPushGroup;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.service.impl.PushMessageService;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.JpushKeys;
import com.etaoguan.wea.vo.PushGroup;
import com.etaoguan.wea.vo.PushGroupCustRef;
import com.etaoguan.wea.vo.PushMessage;

@Service("wpushMessageService")
public class WPushMessageService extends PushMessageService implements IWPushMessageService{

	@Autowired
	IWOwnerService iWOwnerService;
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listJpushKeys(JpushKeysSearch jpushKeysSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", jpushKeysSearch.getOwnerNum());
		DataSet dataSet = listJpushKeys(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getEditJpushKeysInitData(String ownerNum){
		
		Map dataMap = new HashMap();
		dataMap.put("jpushKeys",getJpushKeys(ownerNum));
		dataMap.put("owner",iWOwnerService.getOwner(ownerNum));
		return dataMap;
	}

	@Override
	public void saveOrUpdateJpushKeys(JpushKeys jpushKeys) {
		if(StringUtils.isEmpty(jpushKeys.getOwnerNum())){
			addJpushKeys(jpushKeys);
		}else{
			updateJpushKeys(jpushKeys);
		}
		
	}
	
	@Override
	public void saveOrUpdatePushGroup(WPushGroup wPushGroup) {
		if(wPushGroup.getCustNums()==null||wPushGroup.getCustNums().length==0){
			throw new WeaException("缺少关联客户");
		}
		if(StringUtils.isEmpty(wPushGroup.getPushGroup().getGroupNum())){
			String groupNum = addPushGroup(wPushGroup.getPushGroup());
			updatePushGroupCustRefs(groupNum,wPushGroup.getCustNums());
		}else{
			updatePushGroup(wPushGroup.getPushGroup());
			updatePushGroupCustRefs(wPushGroup.getPushGroup().getGroupNum(),wPushGroup.getCustNums());
		}
		
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getEditPushGroupInitData(String groupNum) {
		Map dataMap = new HashMap();
		if(StringUtils.isNotEmpty(groupNum)){
			PushGroup pushGroup = getPushGroup(groupNum);
			List<PushGroupCustRef> pushGroupCustRefs = getPushGroupCustRefs(groupNum);
			dataMap.put("pushGroup",pushGroup);
			dataMap.put("pushGroupCustRefs",pushGroupCustRefs);
		}
		return dataMap;
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public List getPushGroupCusts(String groupNum) {

		List<PushGroupCustRef> pushGroupCustRefs = getPushGroupCustRefs(groupNum);
		List<Customer> custList = new ArrayList<Customer>();
		for(PushGroupCustRef pushGroupCustRef:pushGroupCustRefs){
			custList.add(pushGroupCustRef.getCust());
		}
		return custList;
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listPushMessages(PushMessageSearch pushMessageSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		Date sendTimeTo = pushMessageSearch.getSendTimeTo();
		if(sendTimeTo!=null){
			String dt = sd.format(sendTimeTo);
			try{
				sendTimeTo = sdt.parse(dt = dt + " 23:59:59");
				pushMessageSearch.setSendTimeTo(sendTimeTo);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		DataCriteria dataCriteria= DataCriteria.parseObjProp2Params(pushMessageSearch);
		if("processStatusName".equalsIgnoreCase(sortParam.getSortBy())){
			sortParam.setSortBy("process_status");
		}else if("targetTypeName".equalsIgnoreCase(sortParam.getSortBy())){
			sortParam.setSortBy("target_type");
		}else if("sendTime".equalsIgnoreCase(sortParam.getSortBy())){
			sortParam.setSortBy("send_time");
		}else if("updateDate".equalsIgnoreCase(sortParam.getSortBy())){
			sortParam.setSortBy("update_date");
		}else{
			
			sortParam.setSortBy("");
		}
		dataCriteria.extractSortParam(sortParam);
		DataSet dataSet = listPushMessages(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}
	
	
	@Override
	public void saveOrUpdatePushMessage(PushMessage pushMessage) {

		if(pushMessage.getMessageId()==0){
			int limit = WeaDataCache.getCache().getOwnerSettingPushMessageCount(pushMessage.getOwnerNum());
			if(getPushMessageTodayCount(pushMessage.getOwnerNum())<limit){
				addPushMessage(pushMessage);
			}else{
				
				throw new WeaException("超出当日推送消息数量限制"+limit);
			}
		}else{
			updatePushMessage(pushMessage);
		}
		
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getListPushMessagesSearchInitData(String ownerNum) {
		Map dataMap = new HashMap();
		dataMap.put("processStatus", WeaDataCache.getCache().getPushMessageProcessStatusNameMap());
		return dataMap;
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getEditPushMessageInitData(String messageId,String ownerNum) {
		Map dataMap = new HashMap();
		if(StringUtils.isNotEmpty(messageId)){
			long longMessageId = Long.parseLong(messageId);
			PushMessage pushMessage = getPushMessage(longMessageId);
			dataMap.put("pushMessage",pushMessage);
		}
		dataMap.put("pushGroups", getAllPushGroups(ownerNum));
		dataMap.put("pushMessageExtraNames", WeaDataCache.getCache().getPushMessageExtraNameMap());
		return dataMap;
	}
}
