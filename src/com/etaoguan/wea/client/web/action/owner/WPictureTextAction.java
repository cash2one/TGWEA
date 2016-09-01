package com.etaoguan.wea.client.web.action.owner;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWWechatKeysService;
import com.etaoguan.wea.client.web.service.IWWechatMassMessageService;
import com.etaoguan.wea.client.web.service.IWWechatMassMsgRequestService;
import com.etaoguan.wea.client.web.service.IWWechatPictureTextService;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WechatMassMessageSearch;
import com.etaoguan.wea.wechat.util.HelpPictureText;
import com.etaoguan.wea.wechat.vo.WechatMassMessage;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;

@SuppressWarnings("serial")
@WeaModule(mname = "图文消息管理")
@Service("wpictureTextAction")
@Scope("prototype")
public class WPictureTextAction extends WOwnerBaseAction {

	@Resource(name = "wWechatMassMsgRequestService")
	private IWWechatMassMsgRequestService iWWechatMassMsgRequestService;

	@Resource(name = "wWechatPictureTextService")
	private IWWechatPictureTextService iWWechatPictureTextService;

	@Resource(name = "wwechatMassMessageService")
	private IWWechatMassMessageService iwWechatMassMessageService;

	private WechatMassMpnews pictureText;
	

	@Resource(name = "wwechatKeysService")
	private IWWechatKeysService iWWechatKeysService;

	private File imgFile;

	private String imgFileFileName;

	private WechatMassMessageSearch wechatMassMessageSearch = new WechatMassMessageSearch();

	private List<WechatMassMpnews> wechatMassMpnews;
	
	public List<WechatMassMpnews> getWechatMassMpnews() {
		return wechatMassMpnews;
	}

	public void setWechatMassMpnews(List<WechatMassMpnews> wechatMassMpnews) {
		this.wechatMassMpnews = wechatMassMpnews;
	}
	
	@WeaFunction(fname = "选择产品时，上传图片到微信服务器", oname = WeaFunction.Operation.READ)
	@Action(value = "uploadImageToWechat")
	public String uploadImageToWechat() {
		
		String productImgUrl =	getRequestParamValue("productImgUrl");
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		
		String thumId = iWWechatPictureTextService.uploadImgToWechat(productImgUrl,ownerNum);
		
		weaResponse.setRespData(thumId);
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "删除微站消息", oname = WeaFunction.Operation.DELETE)
	@Action(value = "wDelWechatPictureText")
	public String delWechatPictureText() {
		try{
		long massMessageId = Long.parseLong(getRequestParamValue("massMessageId"));
		iWWechatMassMsgRequestService.deleteWmmr(massMessageId);
		iWWechatPictureTextService.deleteWechatmmnews(massMessageId);
		iwWechatMassMessageService.delWechatmMsg(massMessageId);
	} catch (Exception e) {
		weaResponse.setFailStatus();
		weaResponse.setMessage("程序遇到错误，请联系管理员");
	}
		return JSONRESPONSE;
	}

	@SuppressWarnings("rawtypes")
	@WeaFunction(fname = "查看微站消息列表", oname = WeaFunction.Operation.READ)
	@Action(value = "wListWechatMassMessageData")
	public String listWechatMassMessageData() {
		try{
		wechatMassMessageSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwWechatMassMessageService.listWechatMassMessage(wechatMassMessageSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		} catch (Exception e) {
			weaResponse.setFailStatus();
			weaResponse.setMessage("程序遇到错误，请联系管理员");
		}
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "消息详情", oname = WeaFunction.Operation.READ)
	@Action(value = "wGetPictureTextData")
	public String getPictureTextData() {
		try{
		String mpnewid = getRequestParamValue("mpnewId");
		if (!StringUtils.isBlank(mpnewid)) {
			String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
			HelpPictureText helpPictureText = iWWechatPictureTextService.wechatPtById(mpnewid,iWWechatPictureTextService.accessToken(ownerNum));
			weaResponse.setRespData(helpPictureText);
		}
		} catch (Exception e) {
			weaResponse.setFailStatus();
			weaResponse.setMessage("程序遇到错误，请联系管理员");
		}
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "群发图文消息", oname = WeaFunction.Operation.READ)
	@Action(value = "wSendWechatMessages")
	public String sendWechatMessages() throws IOException {
		try{
			long massMessageId = Long.parseLong(getRequestParamValue("massMessageId"));
			WechatMassMessage wechatMassMessage = iwWechatMassMessageService.massMessageById(massMessageId);//获取要发送所需要的mediaId
			String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
			iWWechatMassMsgRequestService.addWechatWMMR(wechatMassMessage,iWWechatPictureTextService.accessToken(ownerNum),ownerNum,massMessageId);
		} catch (Exception e) {
			weaResponse.setFailStatus();
			weaResponse.setMessage("程序遇到错误，请联系管理员");
		}
		return JSONRESPONSE;
		}


	@WeaFunction(fname = "更新图文消息", oname = WeaFunction.Operation.UPDATE)
	@Action(value = "wUpdatePictureText")
	public String updatePictureText() {
		try{
			iWWechatPictureTextService.updatePTclientService(getRequestParamValue("massMessageId"),getCurrentOwnerAdmin().getOwnerNum(),wechatMassMpnews);
		} catch (Exception e) {
			weaResponse.setFailStatus();
			weaResponse.setMessage("程序遇到错误，请联系管理员");
		}
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "保存图文消息", oname = WeaFunction.Operation.CREATE)
	@Action(value = "wSavePictureText")
	public String savePictureText() {
		String wechatSubject =	getRequestParamValue("wechatDescribe");
    try{
		iWWechatPictureTextService.savePTclientService(wechatMassMpnews, getCurrentOwnerAdmin().getOwnerNum(),wechatSubject);
	} catch (Exception e) {
		weaResponse.setFailStatus();
		weaResponse.setMessage("程序遇到错误，请联系管理员");
	}
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "上传微站消息图片", oname = WeaFunction.Operation.UPDATE)
	@Action(value = "wUploadPictureTextImg")
	public String uploadPictureTextImg() {
		
		try {
			String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
			HelpPictureText helpPictureText=iWWechatPictureTextService.uploadimgPtclientService(imgFile, imgFileFileName, ownerNum);
			weaResponse.setRespData(helpPictureText);
		} catch (Exception e) {
			weaResponse.setFailStatus();
			weaResponse.setMessage("程序遇到错误，请联系管理员");
		}
		return JSONRESPONSE;
	}

	/**
	 * @return 图文消息列表页面
	 */
	@WeaFunction(fname="图文消息列表页面",oname=WeaFunction.Operation.READ)
	@Action(value = "wListPictureText", results = { @Result(name = "success", type = "dispatcher", location = "/owner/list_picture_text.jsp") })
	public String listPictureText() {
		return SUCCESS;
	}

	/**
	 * @return 创建图文消息页面
	 */
	@WeaFunction(fname="创建图文消息页面",oname=WeaFunction.Operation.CREATE)
	@Action(value = "wCreatePictureText", results = { @Result(name = "success", type = "dispatcher", location = "/owner/create_picture_text.jsp") })
	public String createPictureText() {
		return SUCCESS;
	}

	public WechatMassMpnews getPictureText() {
		return pictureText;
	}

	public void setPictureText(WechatMassMpnews pictureText) {
		this.pictureText = pictureText;
	}

	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public WechatMassMessageSearch getWechatMassMessageSearch() {
		return wechatMassMessageSearch;
	}

	public void setWechatMassMessageSearch(
			WechatMassMessageSearch wechatMassMessageSearch) {
		this.wechatMassMessageSearch = wechatMassMessageSearch;
	}
}
