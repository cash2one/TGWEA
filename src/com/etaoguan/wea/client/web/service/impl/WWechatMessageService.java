package com.etaoguan.wea.client.web.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWFileUploadService;
import com.etaoguan.wea.client.web.service.IWWechatMessageService;
import com.etaoguan.wea.client.web.vo.ImgNode;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WWechatMessageItem;
import com.etaoguan.wea.client.web.vo.WechatMessageSearch;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.FileGenResult;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.service.impl.WechatMessageService;
import com.etaoguan.wea.vo.WechatMessage;
import com.etaoguan.wea.vo.WechatMessageData;


@Service("wwechatMessageService")
public class WWechatMessageService extends WechatMessageService implements IWWechatMessageService{

	@Autowired
	IWFileUploadService iWFileUploadService;
	
	@Override
	@SuppressWarnings("rawtypes")
	public WPage listWechatMessages(WechatMessageSearch wechatMessageSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", wechatMessageSearch.getOwnerNum());
		dataCriteria.setParam("messageType", wechatMessageSearch.getMessageType());
		DataSet dataSet = listWechatMessages(dataCriteria, offsetRequest);

		return new WPage(wpagingRequest,dataSet);
	}
	
	@Override
	@SuppressWarnings("unused")
	public ImgNode genWechatMessageTmpImgFile(FileGenRequest fileGenRequest,
			String ownerNum) throws IOException {
		BufferedImage image=ImageIO.read(fileGenRequest.getUploadFile());
		
		checkUploadImg(fileGenRequest, image,WeaConstant.IMG_WIDTH,WeaConstant.IMG_HEIGHT);
		
		int w=image.getWidth();
		StringBuffer relativefileDir = new StringBuffer();
		relativefileDir.append(WeaConstant.OWNER_RES);
		relativefileDir.append(File.separator);
		relativefileDir.append(ownerNum);
		FileGenResult tmpFileGenResult = iWFileUploadService.save2TmpFile(relativefileDir.toString(),fileGenRequest);
		ImgNode imgNode = new ImgNode();
		imgNode.setImgUrl(iWFileUploadService.formatFilePath2WebPath(tmpFileGenResult.getFileFullPath()));
		return imgNode;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getListWechatMessagesSearchInitData(String ownerNum) {
		Map dataMap = new HashMap();
		dataMap.put("messageType", WeaDataCache.getCache().getWechatMessageTypeNameMap());
		return dataMap;
	}
	
	@Override
	public void saveOrUpdateWechatMessage(WechatMessage wechatMessage,List<WWechatMessageItem> wWechatMessageItems) {
		int messageType = wechatMessage.getMessageType();
		List<WechatMessageData> wechatMessageDatas = new ArrayList<WechatMessageData>();
		if(wWechatMessageItems!=null&&wWechatMessageItems.size()>0){

			for(WWechatMessageItem wWechatMessageItem:wWechatMessageItems){
				if(messageType==1&&wWechatMessageItem.isAddImg()){
					for(WechatMessageData wechatMessageData:wWechatMessageItem.getWechatMessageDatas()){
						if("imgUrl".equalsIgnoreCase(wechatMessageData.getDataName())){
							FileGenResult targetImgFileGenResult = iWFileUploadService.rename2TargetFile(iWFileUploadService.formatWebPath2FilePath(wechatMessageData.getDataValue()));
							wechatMessageData.setDataValue(iWFileUploadService.formatFilePath2WebPath(targetImgFileGenResult.getFileFullPath()));
						}
					}
				}
				wechatMessageDatas.addAll(wWechatMessageItem.getWechatMessageDatas());
			}
	
		}
		
		wechatMessage.setWechatMessageDatas(wechatMessageDatas);
		if(wechatMessage.getMessageId()==0l){
			addWechatMessage(wechatMessage);
		}else{
			updateWechatMessage(wechatMessage);
		}
		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getWWechatMessageData(String messageId) {
		
		Map dataMap = new HashMap();
		if(StringUtils.isNotEmpty(messageId)){
			WechatMessage wechatMessage = getWechatMessage(Long.parseLong(messageId));
			dataMap.put("wechatMessage",wechatMessage);
			List<WechatMessageData> wechatMessageDatas = wechatMessage.getWechatMessageDatas();
			if(wechatMessageDatas.size()>0){
				if(wechatMessage.getMessageType()==0){
					dataMap.put("messageText", wechatMessageDatas.get(0).getDataValue());
				}
				if(wechatMessage.getMessageType()==1){
					Map<Integer ,Map<String,String>> itemMap = new HashMap<Integer,Map<String,String>>();
					for(WechatMessageData wechatMessageData:wechatMessageDatas){
						Map<String,String> itemDataMap = itemMap.get(wechatMessageData.getItemNum());
						if(itemDataMap==null){
							itemDataMap = new HashMap<String,String>();
							itemMap.put(wechatMessageData.getItemNum(), itemDataMap);
						}
						itemDataMap.put(wechatMessageData.getDataName(), wechatMessageData.getDataValue());
					}
					dataMap.put("messageDatas",new TreeMap(itemMap).values());
				}
				wechatMessageDatas.clear();
			}
		}
		return dataMap;
	}

	@Override
	public void updateWechatMessageSubjectNReplyKey(WechatMessage wechatMessage) {
		updateWechatMessageSubjectNReplyKey(wechatMessage.getMessageId(), wechatMessage.getSubject(), wechatMessage.getReplyKey());
		
	}
}
