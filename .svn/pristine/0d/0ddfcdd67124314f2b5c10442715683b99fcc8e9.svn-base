package com.etaoguan.wea.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.FileGenResult;
import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.service.IFileUploadService;
import com.etaoguan.wea.util.FileOperation;
import com.etaoguan.wea.util.IM4Editor;

/**
 * @author cunli
 * 图片上传
 */
@Service("fileUploadService")
public class FileUploadService  extends BaseService implements IFileUploadService{
	
	/* (non-Javadoc)获取图片后缀
	 * @see com.etaoguan.wea.service.IFileUploadService#getFileSuffix(java.lang.String)
	 */
	@Override
	public String getFileSuffix(String fileName) {
		int formerName = fileName.lastIndexOf(".");
		return fileName.substring(formerName + 1);
	}
	
	private String getThumbFileFullPath(String fileFullPath,int thumbWidth) {
		File file = new File(fileFullPath);
		String fileName = file.getName();
		StringBuffer thumbFileFullPathSB =new StringBuffer();
		thumbFileFullPathSB.append(file.getParent());
		thumbFileFullPathSB.append(File.separator);
		thumbFileFullPathSB.append(fileName.substring(0,fileName.lastIndexOf(".")));
		thumbFileFullPathSB.append(".");
		thumbFileFullPathSB.append(thumbWidth);
		thumbFileFullPathSB.append(".");
		thumbFileFullPathSB.append(getFileSuffix(fileName));
		return thumbFileFullPathSB.toString();
	}
	
	private String getTmpThumbFileFullPath(String tmpFileFullPath,int thumbWidth) {
		File file = new File(tmpFileFullPath);
		String fileName = file.getName().replace(".tmp", "");
		StringBuffer tmpThumbFileFullPathSB =new StringBuffer();
		tmpThumbFileFullPathSB.append(file.getParent());
		tmpThumbFileFullPathSB.append(File.separator);
		tmpThumbFileFullPathSB.append(fileName.substring(0,fileName.lastIndexOf(".")));
		tmpThumbFileFullPathSB.append(".");
		tmpThumbFileFullPathSB.append(thumbWidth);
		tmpThumbFileFullPathSB.append(".");
		tmpThumbFileFullPathSB.append(getFileSuffix(fileName));
		tmpThumbFileFullPathSB.append(".tmp");
		return tmpThumbFileFullPathSB.toString();
	}
	

	/* (non-Javadoc)设置图片上传的路径
	 * @see com.etaoguan.wea.service.IFileUploadService#formatFilePath2WebPath(java.lang.String)
	 */
	@Override
	public String formatFilePath2WebPath(String filePath) {
		String whatsAddress = WeaApplication.getInstance().getImgSaveAddr().replace("\\", "/");
		return filePath.replace(whatsAddress, "").replace(File.separator, "/");
		
//		return filePath.replace(WeaApplication.getInstance().getAppRealPath(), "").replace(File.separator, "/");
	}

	/* (non-Javadoc)设置图片上传的路径
	 * @see com.etaoguan.wea.service.IFileUploadService#formatWebPath2FilePath(java.lang.String)
	 */
	@Override
	public String formatWebPath2FilePath(String webPath) {
		String whatsAddress = WeaApplication.getInstance().getImgSaveAddr().replace("\\", "/");
		
		return whatsAddress+webPath.replace("/", File.separator);
		
//		return WeaApplication.getInstance().getAppRealPath()+webPath.replace("/", File.separator);
	}
	
	/* (non-Javadoc)更改图片名称
	 * @see com.etaoguan.wea.service.IFileUploadService#rename2TargetFile(java.lang.String)
	 */
	@Override
	public FileGenResult rename2TargetFile(String tmpFileFullPath) {
		FileGenResult fileResult = new FileGenResult();
		String descFilePath = tmpFileFullPath.replace(".tmp", "");
		FileOperation.rename(tmpFileFullPath, descFilePath);
		fileResult.setFileFullPath(descFilePath);
		return fileResult;
	}
	
	@Override
	public FileGenResult save2TargetFile(String fileDir,FileGenRequest fileGenRequest) {
		FileGenResult fileResult = new FileGenResult();
		if (fileGenRequest.getUploadFile()!= null) {

			String fileSuffix = getFileSuffix(fileGenRequest.getUploadFileName());
			Long time=	new Date().getTime();
			StringBuffer destpathsb = new StringBuffer();
			destpathsb.append(fileDir);
			destpathsb.append(File.separator);
			StringBuffer destTmpName = new StringBuffer();
			destTmpName.append(time);
			destTmpName.append(".");
			destTmpName.append(fileSuffix);
			FileOperation.move(fileGenRequest.getUploadFile(), WeaApplication.getInstance().getAppRealPath()+destpathsb.toString(), destTmpName.toString());
			fileResult.setFileFullPath(WeaApplication.getInstance().getAppRealPath()+destpathsb.toString()+destTmpName.toString());
		}
		return fileResult;
	}
	
	/* (non-Javadoc)保存图片为.tmp格式
	 * @see com.etaoguan.wea.service.IFileUploadService#save2TmpFile(java.lang.String, com.etaoguan.wea.common.FileGenRequest)
	 */
	@Override
	public FileGenResult save2TmpFile(String fileDir,FileGenRequest fileGenRequest) {
		FileGenResult fileResult = new FileGenResult();
		if (fileGenRequest.getUploadFile()!= null) {

			String fileSuffix = getFileSuffix(fileGenRequest.getUploadFileName());
			Long time=	new Date().getTime();
			StringBuffer destpathsb = new StringBuffer();//组合图片信息
			destpathsb.append(fileDir);
			destpathsb.append(File.separator);
			StringBuffer destTmpName = new StringBuffer();//组合图片名
			destTmpName.append(time);
			destTmpName.append(".");
			destTmpName.append(fileSuffix);
			destTmpName.append(".tmp");
			
			String whatsAddress = "D:/TGImg/img.zhizhangtong.com/";//图片服务器实际地址（目录）
//			String whatsAddress = WeaApplication.getInstance().getAppRealPath();//项目地址（目录）
			
			FileOperation.move(fileGenRequest.getUploadFile(), whatsAddress + destpathsb.toString(), destTmpName.toString());//保存图片
			fileResult.setFileFullPath(whatsAddress+destpathsb.toString()+destTmpName.toString());//设置（获取）图片路径
		}
		return fileResult;
	}
	
	/* (non-Javadoc)更改图片名称
	 * @see com.etaoguan.wea.service.IFileUploadService#rename2TmpFile(java.lang.String)
	 */
	@Override
	public FileGenResult rename2TmpFile(String fileFullPath) {
		FileGenResult fileResult = new FileGenResult();
		String tmpFileFullPath = fileFullPath +".tmp";
		FileOperation.rename(fileFullPath, tmpFileFullPath);
		fileResult.setFileFullPath(tmpFileFullPath);
		return fileResult;
	}

	@Override
	public FileGenResult genThumbFile(String fileFullPath, int thumbWidth) {
		FileGenResult fileGenResult = new FileGenResult();
		String thumbFileFullPath = getThumbFileFullPath(fileFullPath,thumbWidth);
		IM4Editor.thumb(fileFullPath, thumbWidth,0, thumbFileFullPath);
		fileGenResult.setFileFullPath(thumbFileFullPath);
		return fileGenResult;
	}
	
	@Override
	public FileGenResult genTmpThumbFile(String tmpFileFullPath, int thumbWidth) {
		FileGenResult fileGenResult = new FileGenResult();
		String tmpThumbFileFullPath = getTmpThumbFileFullPath(tmpFileFullPath,thumbWidth);
		IM4Editor.thumb(tmpFileFullPath, thumbWidth,0, tmpThumbFileFullPath);
		fileGenResult.setFileFullPath(tmpThumbFileFullPath);
		return fileGenResult;
	}

}
