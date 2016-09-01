package com.etaoguan.wea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IWechatPictureTextDao;
import com.etaoguan.wea.service.IWechatPictureTextService;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;

/**
 * @author cunli
 * 图文详情
 */ 
@Service("wechatPictureTextService")
public class WechatPictureTextService extends BaseService implements IWechatPictureTextService{

	@Autowired
	private IWechatPictureTextDao iWechatPictureTextDao;
	

	/* (non-Javadoc)添加图文详情
	 * @see com.etaoguan.wea.service.IWechatPictureTextService#addWechatPictureText(com.etaoguan.wea.wechat.vo.WechatPictureText)
	 */
	@Override
	public void addWechatPictureText(WechatMassMpnews wechatPictureText) {
		iWechatPictureTextDao.addWechatPictureText(wechatPictureText);
	}


	/* (non-Javadoc)根据某次发送图文的id 获取详细信息
	 * @see com.etaoguan.wea.service.IWechatPictureTextService#wechatPictureTexts(long)
	 */
		@Override
		public List<WechatMassMpnews> wechatPictureTexts(long massMessageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("massMessageId", massMessageId);
		return iWechatPictureTextDao.wechatPictureTexts(dataCriteria);
	}


		/* (non-Javadoc) 删除群发消息
		 * @see com.etaoguan.wea.service.IWechatMassMpnewsService#deleteWechatMassMpnews(long)
		 */
		@Override
		public void deleteWechatMassMpnews(long massMessageId) {
			DataCriteria dataCriteria = new DataCriteria();
			dataCriteria.setParam("massMessageId",massMessageId);
			iWechatPictureTextDao.deleteWechatMassMpnews(dataCriteria);
			
		}


		@Override
		public void updateWechatPictureText(WechatMassMpnews wechatPictureText) {
			iWechatPictureTextDao.updateWechatPictureText(wechatPictureText);
			
		}

}
