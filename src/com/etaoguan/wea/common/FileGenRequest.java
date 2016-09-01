package com.etaoguan.wea.common;

import java.io.File;

public class FileGenRequest {

	private File uploadFile;

	private String uploadFileName;
	
	public FileGenRequest(File uploadFile,String uploadFileName){
		this.uploadFile = uploadFile;
		this.uploadFileName = uploadFileName;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	

}
