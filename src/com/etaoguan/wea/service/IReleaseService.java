package com.etaoguan.wea.service;

import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.FileGenResult;

/**
 * @author cunli
 * 上传APP
 */
public interface IReleaseService {

	/**
	 * @param fileDir
	 * @param fileGenRequest
	 * @return 设置文件后缀名
	 */
	public FileGenResult setTmpFileService(String fileDir,FileGenRequest fileGenRequest);
	
}
