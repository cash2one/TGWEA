package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IWechatMassMsgRequestDao;
import com.etaoguan.wea.service.IWechatMassMsgRequestService;
import com.etaoguan.wea.wechat.vo.WechatMassMsgRequest;

@Service("wechatMassMsgRequestService")
public class WechatMassMsgRequestService extends BaseService implements IWechatMassMsgRequestService{

	@Autowired
	private IWechatMassMsgRequestDao iWechatMassMsgRequestDao;


	/* (non-Javadoc) 保存群发结果
	 * @see com.etaoguan.wea.service.IWechatMassMsgRequestService#addWechatMassMsgRequest(com.etaoguan.wea.wechat.vo.WechatMassMsgRequest)
	 */
	@Override
	public void addWechatMassMsgRequest(
			WechatMassMsgRequest wechatMassMsgRequest) {
		iWechatMassMsgRequestDao.addWechatMassMsgRequest(wechatMassMsgRequest);
		
	}


	/* (non-Javadoc)保存微信服务器返回的群发结果（第二次）
	 * @see com.etaoguan.wea.service.IWechatMassMsgRequestService#updateWechatMassMsgRequest(com.etaoguan.wea.wechat.vo.WechatMassMsgRequest)
	 */
	@Override
	public void updateWechatMassMsgRequest(
			WechatMassMsgRequest wechatMassMsgRequest) {
		iWechatMassMsgRequestDao.updateWechatMassMsgRequest(wechatMassMsgRequest);
		
	}


	/* (non-Javadoc) 删除群发消息
	 * @see com.etaoguan.wea.service.IWechatMassMsgRequestService#deleteWechatMassMsgRequest(int)
	 */
	@Override
	public void deleteWechatMassMsgRequest(long massMessageId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("massMessageId",massMessageId);
		iWechatMassMsgRequestDao.deleteWechatMassMsgRequest(dataCriteria);
		
	}

}
