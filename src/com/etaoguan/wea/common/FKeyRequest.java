package com.etaoguan.wea.common;

public class FKeyRequest extends KeyRequest{
	
	public FKeyRequest(String keyName, int keyLen) {
		super(keyName, keyLen);
	}

	private int dataLen;

	public int getDataLen() {
		return dataLen;
	}

	public void setDataLen(int dataLen) {
		this.dataLen = dataLen;
	}

}
