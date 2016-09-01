package com.etaoguan.wea.client.web.service;

import java.util.List;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WechatMassMessageSearch;
import com.etaoguan.wea.service.IWechatMassMessageService;
import com.etaoguan.wea.wechat.vo.WechatMassMessage;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;

public interface IWWechatMassMessageService extends IWechatMassMessageService{
	public void updateWmMsg(int massMessageId,List<WechatMassMpnews> wechatMassMpnews,String ownerNum);
	public int addWechatmmsg(String ownerNum,List<WechatMassMpnews> wechatMassMpnews,String wechatSubject);
	public WechatMassMessage massMessageById(long massMessageId);
	public void delWechatmMsg(long massMessageId);
	/**
	 * @param wechatMassMessageSearch
	 * @param sortParam
	 * @param wpagingRequest
	 * @return 图文消息列表
	 */
	@SuppressWarnings("rawtypes")
	public WPage listWechatMassMessage(WechatMassMessageSearch wechatMassMessageSearch,
			SortParam sortParam, WPagingRequest wpagingRequest);
	
}
