package com.etaoguan.wea.client.web.service;

import com.alibaba.openapi.client.auth.AuthorizationToken;
import com.etaoguan.wea.service.IE688Service;
import com.etaoguan.wea.vo.Owner;

public interface IWE688Service extends IE688Service{
	
	public String getE688AuthorizationPageUrl(String redirectUri);
	
	public Owner saveFirstLoginE688Owner(AuthorizationToken authorizationToken,String shopNum);
	
	public void syncE688Data(AuthorizationToken authorizationToken);
	
	public AuthorizationToken getE688AuthorizationToken(String e688AuthCode);

}
