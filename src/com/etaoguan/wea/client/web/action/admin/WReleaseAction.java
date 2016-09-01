package com.etaoguan.wea.client.web.action.admin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.action.JspToHtml;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.action.common.WQrcodeAction;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.FileGenResult;
import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.service.IAddAndroidversionService;
import com.etaoguan.wea.service.IAppleVersionService;
import com.etaoguan.wea.service.IReleaseService;
import com.etaoguan.wea.util.HelpUploadApp;
import com.etaoguan.wea.vo.AppAndroidVersion;
import com.etaoguan.wea.vo.AppleVersion;

/**
 * @author cunli APP发布管理
 */
@SuppressWarnings("serial")
@WeaModule(mname = "苹果 应用升级信息管理")
@Service("wreleaseAction")
@Scope("prototype")
public class WReleaseAction extends WCommonBaseAction {

	@Resource(name = "appleVersionService")
	private IAppleVersionService iAppleVersionService;
	public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";
	@Resource(name = "addAndroidversionService")
	private IAddAndroidversionService iAddAndroidversionService;

	@Autowired
	IReleaseService iReleaseService;

	private ByteArrayInputStream inputStream;
	private File mobileApp;
	private String mobileAppFileContentType;
	private String mobileAppFileName;

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public File getMobileApp() {
		return mobileApp;
	}

	public void setMobileApp(File mobileApp) {
		this.mobileApp = mobileApp;
	}

	public String getMobileAppFileContentType() {
		return mobileAppFileContentType;
	}

	public void setMobileAppFileContentType(String mobileAppFileContentType) {
		this.mobileAppFileContentType = mobileAppFileContentType;
	}

	public String getMobileAppFileName() {
		return mobileAppFileName;
	}

	public void setMobileAppFileName(String mobileAppFileName) {
		this.mobileAppFileName = mobileAppFileName;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	@WeaFunction(fname = "上传企业图片", oname = WeaFunction.Operation.UPDATE)
	@Action(value = "wUploadAndroidApp")
	public String uploadOwnerImg() throws IOException {
		String ownerNum = getRequestParamValue("ownerNum");
		String appType = getRequestParamValue("appType");

		FileGenRequest fileGenRequest = new FileGenRequest(mobileApp,
				mobileAppFileName);

		String v1 = mobileAppFileName.substring(mobileAppFileName.length() - 4)
				.toLowerCase();
		String fullPath = "";

		if (v1.equals("." + appType)) {
			String fileDir = "download\\" + ownerNum + "\\" + appType;

			FileGenResult tmpFileGenResult = iReleaseService.setTmpFileService(
					fileDir, fileGenRequest);
			if (tmpFileGenResult.getFileFullPath().length() == 0) {
				weaResponse.setFailStatus();
				weaResponse.setMessage("上传失败，请重试一次，或联系管理员");
			}
			fullPath = tmpFileGenResult.getFileFullPath();

		} else {
			weaResponse.setFailStatus();
			weaResponse.setMessage("请选择" + appType + "手机应用安装包！");
		}
		String fileName = mobileAppFileName.substring(0,
				mobileAppFileName.length() - 4);

		HelpUploadApp helpUploadApp = new HelpUploadApp();
		helpUploadApp.setFillName(fileName);
		helpUploadApp.setFullPath(fullPath);
		weaResponse.setRespData(helpUploadApp);// 上传成功返回文件名
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "去上传 APP 页面", oname = WeaFunction.Operation.READ)
	@Action(value = "wReleaseUpload", results = { @Result(name = "success", type = "dispatcher", location = "/admin/upgradeinformation/release_upload.jsp") })
	public String releaseUpload() {
		return SUCCESS;
	}

	@SuppressWarnings("unused")
	@WeaFunction(fname = "生成APP下载 静态页面", oname = WeaFunction.Operation.READ)
	@Action(value = "wReleaseStatic")
	public String staticpage() throws UnsupportedEncodingException {

		JspToHtml jspToHtml = new JspToHtml();

		String versionId = getRequestParamValue("versionId");
		AppAndroidVersion androidVersion1 = new AppAndroidVersion();
		androidVersion1.setVersionId(Long.valueOf(versionId));
		AppAndroidVersion androidVersion = iAddAndroidversionService
				.getAndrodivsbyId(androidVersion1);
		String banben = androidVersion.getVersionCode();
		Date lastChangeTime = androidVersion.getUpdateDate();
		String shijian = DateFormat.getDateInstance().format(lastChangeTime);

		String ownerNum = getRequestParamValue("ownerNum");
		String androidFileName = androidVersion.getFileName();
		String baseUrl = getDomainBaseUrl() + "download/";
		String anzhuo = baseUrl + ownerNum + "/apk/" + androidFileName + ".apk";

		String bundleId = getRequestParamValue("bundleId");

		String appStore = "https://itunes.apple.com/app/id" + bundleId;

		String path = WeaApplication.getInstance().getAppRealPath()
				+ "download/";

		/* 生成苹果xml页 */
		String filePath = path + "templet/appleolinstall.xml";

		String iosId = getRequestParamValue("iosId");
		AppleVersion appleVersion = new AppleVersion();
		appleVersion.setVersionId(Long.parseLong(iosId));
		appleVersion = iAppleVersionService.getAppleVersionById(appleVersion);
		String appleVs = appleVersion.getVersionCode();
		String appleFileName = appleVersion.getFileName();
		String appleAppName = appleVersion.getAppName();
		String applepkgid = appleVersion.getPackageName();

		SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd");
		String appleDate = dateformat1.format(appleVersion.getCreateDate());
		String applepkgurl = baseUrl + ownerNum + "/ipa/" + appleFileName
				+ ".ipa";

		String urlpo = path + ownerNum + "/" + ownerNum;

		String xmlPath = urlpo+ ".xml";

		File fil = new File(xmlPath);
		// 路径为文件且不为空则进行删除
		if (fil.isFile() && fil.exists()) {
			fil.delete();
		}

		String applepkgimgurl = getDomainBaseUrl() + "/download/" + ownerNum
				+ "/ios-install-icon.png";

		JspToHtml.xmlFile(filePath, xmlPath, applepkgurl, applepkgimgurl,
				applepkgid, appleVs, appleAppName);
		String pingugo = "itms-services://?action=download-manifest&url="
				+ baseUrl + ownerNum + "/" + ownerNum + ".xml";
		/* 生成苹果xml页 */

		/* 生成html页 */
		String url = path + "templet/formwork.htm";

		String htmlPath = urlpo + ".html";
		File file = new File(htmlPath);
		if (file.isFile() && file.exists()) {
			file.delete();
		}
		JspToHtml.JspToHtmlFile(url, htmlPath, banben, appleVs, shijian,
				appleDate, anzhuo, pingugo, appStore);
		/* 生成html页 */

		weaResponse.setRespData("s");
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "到 APP发布管理  页面", oname = WeaFunction.Operation.READ)
	@Action(value = "wReleaseDownload", results = { @Result(name = "success", type = "dispatcher", location = "/admin/upgradeinformation/download_app.jsp") })
	public String downloadApppage() {

		return SUCCESS;
	}

	/**
	 * @return 扫描二维码下载 安卓APP
	 * @throws Exception
	 */
	@Action(value = "androidqr", results = { @Result(name = "success", type = "stream", params = {
			"contentType", "applicationnd.jpeg", "inputName", "inputStream" }) })
	public String androidqr() throws Exception {

		String ownerNum = getRequestParamValue("ownerNum");
		String html = getDomainBaseUrl() + "download/" + ownerNum + "/" + ownerNum
				+ ".html";
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);

		StringBuffer destTmpName = new StringBuffer();
		destTmpName.append(WeaApplication.getInstance().getAppRealPath());
		destTmpName.append("download/"+ownerNum+"/");
		destTmpName.append("logo-icon.png");//logo size:40*40

		WQrcodeAction wQrcodeAction = new WQrcodeAction();
		ImageIO.write(
				wQrcodeAction.genBarcode(html, 200, 200,
						destTmpName.toString()), "png", imOut);
		inputStream = new ByteArrayInputStream(bs.toByteArray());

		return SUCCESS;
	}

	@WeaFunction(fname = "安卓版本信息列表", oname = WeaFunction.Operation.READ)
	@Action(value = "wListAppsData")
	public String listAppsData() {
		List<AppleVersion> appleVersions = iAppleVersionService
				.getVersionsService();
		weaResponse.setRows(appleVersions);
		weaResponse.setTotal(appleVersions.size());
		return JSONRESPONSE;
	}

	@WeaFunction(fname = "到 APP发布管理  页面", oname = WeaFunction.Operation.READ)
	@Action(value = "wRelease", results = { @Result(name = "success", type = "dispatcher", location = "/admin/upgradeinformation/release.jsp") })
	public String appreleasepage() {
		return SUCCESS;
	}

}
