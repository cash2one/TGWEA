package com.etaoguan.wea.service;

import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.FileGenResult;

public interface IFileUploadService {
	
	/**
	 * @param fileDir
	 * @param fileGenRequest
	 * @return 保存图片
	 */
	public FileGenResult save2TargetFile(String fileDir,FileGenRequest fileGenRequest);
	
	/**
	 * @param fileDir
	 * @param fileGenRequest
	 * @return 保存缩略图
	 */
	public FileGenResult save2TmpFile(String fileDir,FileGenRequest fileGenRequest);
	
	/**
	 * @param tmpFileFullPath
	 * @return 更改图片名称
	 */
	public FileGenResult rename2TargetFile(String tmpFileFullPath);
	
	public String getFileSuffix(String fileName);
	
	/**
	 * @param filePath
	 * @return 设置图片上传的路径
	 */
	public String formatFilePath2WebPath(String filePath);
	
	/**
	 * @param webPath
	 * @return 设置图片上传的路径
	 */
	public String formatWebPath2FilePath(String webPath);

	public FileGenResult genThumbFile(String fileFullPath,int thumbWidth);
	
	public FileGenResult genTmpThumbFile(String tmpFileFullPath, int thumbWidth);
	
	/**
	 * @param fileFullPath
	 * @return 更改图片名称
	 */
	public FileGenResult rename2TmpFile(String fileFullPath);

}
