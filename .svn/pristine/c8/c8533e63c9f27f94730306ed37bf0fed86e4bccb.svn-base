package com.etaoguan.wea.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.KeyRequest;
import com.etaoguan.wea.constant.WeaConstant;

@Service("orderKeyGenService")
public class OrderKeyGenService extends AKeyGenService {

	@Override
	public String constructKey(String maxKey) {
		return WeaConstant.ORDERKEYPREFIX+maxKey;
	}

	@Override
	public KeyRequest getKeyRequest() {
		return new KeyRequest(WeaConstant.ORDERKEYNAME,WeaConstant.WEACOMMONKEYLEN);
	}

}
