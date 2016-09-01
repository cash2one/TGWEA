package com.etaoguan.wea.client.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWWechatMassMessageService;
import com.etaoguan.wea.client.web.service.IWWechatPictureTextService;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WechatMassMessageSearch;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.WechatMassMessageService;
import com.etaoguan.wea.wechat.util.WechatPictureTextUtil;
import com.etaoguan.wea.wechat.vo.WechatMassMessage;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;


/**
 * @author cunli
 * 图文消息列表
 */
@Service("wwechatMassMessageService")
public class WWechatMassMessageService extends WechatMassMessageService implements IWWechatMassMessageService{
	
	@Resource(name = "wWechatPictureTextService")
	private IWWechatPictureTextService iWWechatPictureTextService;
	
	@Override
	public void delWechatmMsg(long massMessageId){
		deleteWechatMassMessage(massMessageId);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public WPage listWechatMassMessage(
			WechatMassMessageSearch wechatPictureTextSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", wechatPictureTextSearch.getOwnerNum());
		DataSet dataSet = listWechatMassMessage(dataCriteria, offsetRequest);

		return new WPage(wpagingRequest,dataSet);
	}

	@Override
	public WechatMassMessage massMessageById(long massMessageId) {
		return getMassMessageById(massMessageId);
	}

	@Override
	public int addWechatmmsg(String ownerNum,List<WechatMassMpnews> wechatMassMpnews,String wechatSubject) {
		WechatMassMessage wechatMassMessage = new WechatMassMessage();
		wechatMassMessage.setOwnerNum(ownerNum);
		wechatMassMessage.setWechatSubject(wechatSubject);
		wechatMassMessage.setMsgType(0);
		wechatMassMessage.setFilterType(1);
		wechatMassMessage.setFilterText("1");
		wechatMassMessage.setCreateDate(new Date());
		wechatMassMessage.setCreateBy(ownerNum);
		wechatMassMessage.setUpdateDate(new Date());
		wechatMassMessage.setUpdateBy(ownerNum);
		return addWechatMassMessage(wechatMassMessage);
	}

	/* (non-Javadoc)上传图文
	 * @see com.etaoguan.wea.client.web.service.IWWechatMassMessageService#updateWmMsg(int, java.util.List, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unused")
	public void updateWmMsg(int massMessageId,List<WechatMassMpnews> wechatMassMpnews,String ownerNum) {
		
				/*上传图文*/
				List<WechatMassMpnews> wechatPictureTexts = new ArrayList<WechatMassMpnews>();
				for (int i = 0; i < wechatMassMpnews.size(); i++) {
					WechatMassMpnews wechatPictureText=new WechatMassMpnews();
					wechatPictureText.setThumbMediaId(wechatMassMpnews.get(i).getThumbMediaId());
					wechatPictureText.setTitle(wechatMassMpnews.get(i).getTitle());
					String digest=wechatMassMpnews.get(i).getDigest();
					if (StringUtils.isBlank(digest)) {
						wechatPictureText.setDigest("");
					}else {
						wechatPictureText.setDigest(digest);
					}
					wechatPictureText.setContent(wechatMassMpnews.get(i).getContent());
					wechatPictureText.setContentSourceUrl(wechatMassMpnews.get(i).getContentSourceUrl());
					String linkUrl=wechatPictureText.getContentSourceUrl();
					if (StringUtils.isBlank(linkUrl)) {
						wechatPictureText.setContentSourceUrl("");
					}
					String gauthor=wechatPictureText.getAuthor();
					if (StringUtils.isBlank(gauthor)) {
						wechatPictureText.setAuthor("");
					}
					if (i==0) {
						wechatPictureText.setShowCoverPic(1);
					}else {
						wechatPictureText.setShowCoverPic(0);
					}
					wechatPictureTexts.add(wechatPictureText);
				}
				
				WechatPictureTextUtil wechatMessagesUtil=new WechatPictureTextUtil();
				
				String accessToken=iWWechatPictureTextService.accessToken(ownerNum);
				String mediaId = WechatPictureTextUtil.uploadImgText(wechatPictureTexts,accessToken);
		updateWechatMassMessage(massMessageId, mediaId);
		
	}

	
}
