package com.etaoguan.wea.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.KeyRequest;
import com.etaoguan.wea.constant.WeaConstant;

@Service("origOrderKeyGenService")
public class OrigOrderKeyGenService extends AKeyGenService {

	@Override
	public String constructKey(String maxKey) {
		return WeaConstant.ORIGORDERKEYPREFIX+maxKey;
	}

	@Override
	public KeyRequest getKeyRequest() {
		return new KeyRequest(WeaConstant.ORIGORDERKEYNAME,WeaConstant.WEACOMMONKEYLEN);
	}

}
