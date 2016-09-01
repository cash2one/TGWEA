package com.etaoguan.wea.common;

public class KeyRequest {

	private String keyName;
	
	private int keyLen=10;
	
	public KeyRequest(String keyName,int keyLen){
		this.keyName = keyName;
		this.keyLen = keyLen;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public int getKeyLen() {
		return keyLen;
	}

	public void setKeyLen(int keyLen) {
		this.keyLen = keyLen;
	}
}
