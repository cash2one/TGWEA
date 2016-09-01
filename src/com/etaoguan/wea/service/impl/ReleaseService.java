package com.etaoguan.wea.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.FileGenResult;
import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.service.IReleaseService;
import com.etaoguan.wea.util.FileOperation;

/**
 * @author cunli
 * APP上传
 */
@Service("releaseService")
public class ReleaseService extends BaseService implements IReleaseService{

	

	/* (non-Javadoc) 操作文件后缀名
	 * @see com.etaoguan.wea.service.IReleaseService#setTmpFileService(java.lang.String, com.etaoguan.wea.common.FileGenRequest)
	 */
	@Override
	public FileGenResult setTmpFileService(String fileDir,FileGenRequest fileGenRequest) {
		FileGenResult fileResult = new FileGenResult();
		if (fileGenRequest.getUploadFile()!= null) {

			StringBuffer destpathsb = new StringBuffer();
			destpathsb.append(fileDir);
			destpathsb.append(File.separator);
			StringBuffer destTmpName = new StringBuffer();
			destTmpName.append(fileGenRequest.getUploadFileName());
			destTmpName.append(".tmp");
			
			String filePaht=WeaApplication.getInstance().getAppRealPath()+destpathsb.toString();
			String filePaht2=filePaht+fileGenRequest.getUploadFileName();
			File file = new File(filePaht2); 
			   if (file.isFile() && file.exists()) { 
			       file.delete(); 
			   } 
			
			FileOperation.move(fileGenRequest.getUploadFile(), filePaht, destTmpName.toString());
			fileResult.setFileFullPath(WeaApplication.getInstance().getAppRealPath()+destpathsb.toString()+destTmpName.toString());
		}
		return fileResult;
	}


}
