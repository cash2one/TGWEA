package com.etaoguan.wea.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.KeyRequest;
import com.etaoguan.wea.constant.WeaConstant;

@Service("prodCatKeyGenService")
public class ProdCatKeyGenService extends AKeyGenService {

	@Override
	public String constructKey(String maxKey) {
		return WeaConstant.PRODCATKEYPREFIX+maxKey;
	}

	@Override
	public KeyRequest getKeyRequest() {
		return new KeyRequest(WeaConstant.PRODCATKEYNAME,WeaConstant.WEACOMMONKEYLEN);
	}

}
