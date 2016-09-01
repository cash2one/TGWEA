package com.etaoguan.wea.client.web.action.owner;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWOwnerAdminService;
import com.etaoguan.wea.client.web.service.IWOwnerService;
import com.etaoguan.wea.client.web.vo.ImgNode;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.vo.Owner;

@SuppressWarnings("serial")
@WeaModule(mname="企业主管理")
@Service("ownerWOwnerAction") @Scope("prototype")
public class WOwnerAction extends WOwnerBaseAction{
	
	private Owner owner;
	
	private ImgNode imgNode;
	
	private File imgFile; 
	
	private String imgFileFileContentType;  
	
    private String imgFileFileName;  

	@Resource(name="wownerService")
	private IWOwnerService iwOwnerService;
	
	@Resource(name="wownerAdminService")
	private IWOwnerAdminService iwOwnerAdminService;

	@WeaFunction(fname="更新企业主信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wEditOwner",results = { @Result(name = "success", type = "dispatcher",location="/owner/edit_owner.jsp")})
	public String editOwner() throws IOException {
		return SUCCESS;
	}
	@WeaFunction(fname="更新企业主信息",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wSaveEditOwner")
	public String saveEditOwner() throws IOException {
		owner.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		iwOwnerService.saveOrUpdateOwner(owner,imgNode);
		return JSONRESPONSE;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="获取企业主信息",oname=WeaFunction.Operation.READ)
	@Action(value="wGetEditOwnerInitData")
	public String getEditOwnerInitData() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		Map initOwnerDataMap = iwOwnerService.getEditOwnerInitData(ownerNum);
		weaResponse.setRespData(initOwnerDataMap);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="上传企业图片",oname=WeaFunction.Operation.UPDATE)
	@Action(value="wUploadOwnerImg")
	public String uploadOwnerImg() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		FileGenRequest fileGenRequest =  new FileGenRequest(imgFile,imgFileFileName);// 接收图片和图片相关信息
		ImgNode imgNode = iwOwnerService.genOwnerTmpImgFile(fileGenRequest, ownerNum);
		weaResponse.setRespData(imgNode);
		return JSONRESPONSE;
	}
	
	
	@Action(value="wGetOwnerMobileIndexUrl")
	public String getOwnerMobileIndexUrl() throws IOException {
		//采用客户端js获取主机地址，暂无调用
		StringBuilder mobileIndexUrl = new StringBuilder();
		mobileIndexUrl.append(getDomainBaseUrl());	
		mobileIndexUrl.append("mobile/index.html");	
		weaResponse.setRespData(mobileIndexUrl.toString());
	
		return JSONRESPONSE;
	}
	
	
	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileFileContentType() {
		return imgFileFileContentType;
	}

	public void setImgFileFileContentType(String imgFileFileContentType) {
		this.imgFileFileContentType = imgFileFileContentType;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public ImgNode getImgNode() {
		return imgNode;
	}

	public void setImgNode(ImgNode imgNode) {
		this.imgNode = imgNode;
	}


}
