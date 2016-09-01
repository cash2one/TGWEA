package com.etaoguan.wea.client.web.service;

import java.util.Map;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WechatKeysSearch;
import com.etaoguan.wea.service.IWechatKeysService;
import com.etaoguan.wea.vo.WechatKeys;

public interface IWWechatKeysService extends IWechatKeysService{

	public WechatKeys wechatKeys(String ownerNum);
	
	@SuppressWarnings("rawtypes")
	public WPage listWechatKeys(WechatKeysSearch wechatKeysSearch,SortParam sortParam,WPagingRequest wpagingRequest);
	
	@SuppressWarnings("rawtypes")
	public Map getEditWechatKeysInitData(String ownerNum);
	
	public void saveOrUpdateWechatKeys(WechatKeys wechatKeys);
}
