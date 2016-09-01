package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.KeyRequest;
import com.etaoguan.wea.dao.IBasicDataDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.vo.MaxKeyValue;

public abstract class AKeyGenService extends BaseService implements IKeyGenService {
	
	private String STRINGPADDING = "0000000000";
	
	@Autowired
	private IBasicDataDao iBasicDataDao;

	private long getMaxKeyValue(KeyRequest keyRequest){
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("keyName", keyRequest.getKeyName());
		MaxKeyValue maxKeyValue= iBasicDataDao.getMaxKeyValue(dataCriteria);
		if(maxKeyValue!=null){
			return maxKeyValue.getMaxKeyValue();
		}
		return 0l;
	}
	
	private void saveNewMaxKeyValue(String keyName,long maxKey){
		MaxKeyValue maxKeyValue = new MaxKeyValue();
		maxKeyValue.setKeyName(keyName);
		maxKeyValue.setMaxKeyValue( maxKey);
		if(maxKey == 1l){
			iBasicDataDao.saveMaxKeyValue(maxKeyValue);
		}else{
			iBasicDataDao.updateMaxKeyValue(maxKeyValue);
		}
	}
	
	public abstract String constructKey(String maxKey);
	
	public abstract KeyRequest getKeyRequest();
	
	@Override
	public synchronized String saveNGetKey(){
		
		KeyRequest keyRequest = getKeyRequest();
		long  maxKey = getMaxKeyValue(keyRequest);
		long newMaxKey = maxKey+1;
		saveNewMaxKeyValue(keyRequest.getKeyName(),newMaxKey);
		return constructKey(leftPad(newMaxKey,keyRequest.getKeyLen()));
	}
	
	private String leftPad(long maxKey,int keyLen){
		String maxKeyText = String.valueOf(maxKey);
		String padText = STRINGPADDING.substring(0, keyLen - maxKeyText.length());
		return padText+maxKeyText;
	}
	
	@Override
	public String getRootKey(){
		
		KeyRequest keyRequest = getKeyRequest();
		return constructKey(leftPad(0,keyRequest.getKeyLen()));
	}
}

