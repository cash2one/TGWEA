package com.etaoguan.wea.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.KeyRequest;
import com.etaoguan.wea.constant.WeaConstant;

@Service("deliverKeyGenService")
public class DeliverKeyGenService extends AKeyGenService {

	@Override
	public String constructKey(String maxKey) {
		return WeaConstant.DELIVERINVKEYPREFIX+maxKey;
	}

	@Override
	public KeyRequest getKeyRequest() {
		return new KeyRequest(WeaConstant.DELIVERINVKEYNAME,WeaConstant.WEACOMMONKEYLEN);
	}

}
