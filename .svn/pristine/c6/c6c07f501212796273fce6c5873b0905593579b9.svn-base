package com.etaoguan.wea.client.web.service;

import java.io.File;
import java.util.List;

import com.etaoguan.wea.service.IWechatPictureTextService;
import com.etaoguan.wea.wechat.util.HelpPictureText;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;

public interface IWWechatPictureTextService extends IWechatPictureTextService{
	public void savePTclientService(List<WechatMassMpnews> wechatMassMpnews,String ownerNum,String wechatSubject);
	public String token(String ownerNum);
	public String accessToken(String ownerNum);
	public HelpPictureText uploadimgPtclientService(File imgFile,String imgFileFileName,String ownerNum);
	public void updatePTclientService(String massMessageId,String ownerNum,List<WechatMassMpnews> wechatMassMpnews);
	
	public void deleteWechatmmnews(long massMessageId);
	public void addWechatPtxt(WechatMassMpnews wechatPictureText);
	public void updateWechatPtxt(WechatMassMpnews wechatPictureText);
	public HelpPictureText wechatPtById(String massMessageId,String accessToken);
	
	/**
	 * @param imgUrl 图片地址
	 * @return 选择产品时，上传产品图片到微信服务器
	 */
	public String uploadImgToWechat(String imgUrl,String ownerNum);
	
}
