package com.etaoguan.wea.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.KeyRequest;
import com.etaoguan.wea.constant.WeaConstant;

@Service("stkAllocKeyGenService")
public class StkAllocKeyGenService extends AKeyGenService {

	@Override
	public String constructKey(String maxKey) {
		return WeaConstant.STKALLOCKEYPREFIX+maxKey;
	}

	@Override
	public KeyRequest getKeyRequest() {
		return new KeyRequest(WeaConstant.STKALLOCKEYNAME,WeaConstant.WEACOMMONKEYLEN);
	}

}
