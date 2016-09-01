package com.etaoguan.wea.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.KeyRequest;
import com.etaoguan.wea.constant.WeaConstant;

@Service("custKeyGenService")
public class CustKeyGenService  extends AKeyGenService {

	@Override
	public String constructKey(String maxKey) {
		return WeaConstant.CUSTKEYPREFIX+maxKey;
	}

	@Override
	public KeyRequest getKeyRequest() {
		return new KeyRequest(WeaConstant.CUSTKEYNAME,WeaConstant.WEACOMMONKEYLEN);
	}

}
