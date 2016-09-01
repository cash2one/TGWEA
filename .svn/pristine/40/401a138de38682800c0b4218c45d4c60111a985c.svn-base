package com.etaoguan.wea.client.web.service.impl;

import java.util.HashMap;
import java.util.Map;






import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.openapi.client.AlibabaClient;
import com.alibaba.openapi.client.auth.AuthorizationToken;
import com.alibaba.openapi.client.policy.ClientPolicy;
import com.alibaba.openapi.client.policy.RequestPolicy;
import com.etaoguan.wea.client.web.service.IWAuthorityService;
import com.etaoguan.wea.client.web.service.IWE688Service;
import com.etaoguan.wea.client.web.service.IWOwnerAdminService;
import com.etaoguan.wea.client.web.service.IWOwnerService;
import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.e688.vo.MemberInfo;
import com.etaoguan.wea.service.impl.E688Service;
import com.etaoguan.wea.util.E688Util;
import com.etaoguan.wea.vo.Authority;
import com.etaoguan.wea.vo.Owner;
import com.etaoguan.wea.vo.OwnerAdmin;

@Service("we688Service")
public class WE688Service extends E688Service implements IWE688Service{

	private final static Log logger = LogFactory.getLog(WE688Service.class);
	
	private String clientId = WeaApplication.getInstance().getE688ClientId();
	private String appSecretKey = WeaApplication.getInstance().getE688AppSecretKey();
	
	@Autowired
	IWOwnerAdminService iWOwnerAdminService;

	@Autowired
	IWOwnerService iWOwnerService;
	
	@Resource(name="wauthorityService")
	private IWAuthorityService iwAuthorityService;
	
	@Override
	public String getE688AuthorizationPageUrl(String redirectUri) {
		
		StringBuffer pageUrl = new StringBuffer();
		Map<String,String> parameters=new HashMap<String,String>();
		parameters.put("client_id",clientId);
		parameters.put("redirect_uri",redirectUri);
		parameters.put("site", "china");
		String signature=E688Util.signatureWithParamsOnly(parameters,appSecretKey);
		logger.info("1688 signature="+signature);
		pageUrl.append("http://gw.open.1688.com/auth/authorize.htm?client_id=");
		pageUrl.append(clientId);
		pageUrl.append("&site=china&redirect_uri=");
		pageUrl.append(redirectUri);
		pageUrl.append("&_aop_signature=");
		pageUrl.append(signature);
		return pageUrl.toString();
	}
	
	@Override
	public AuthorizationToken getE688AuthorizationToken(String e688AuthCode){
		/**
		 * 初始化AlibabaClient
		 */
		ClientPolicy policy = ClientPolicy.getDefaultChinaAlibabaPolicy();
		policy = policy.setAppKey(clientId).setSigningKey(appSecretKey);
		AlibabaClient client = new AlibabaClient(policy);
		client.start();
		try{
			
			/**
			 * 调用getToken或者refreshToken方法获取accessToken
			 */
			AuthorizationToken authorizationToken = client.getToken(e688AuthCode);
			return authorizationToken;

		}catch(Throwable ex){
			ex.printStackTrace();
			throw new WeaException(ex);
		}
		finally{
			
			//第四步：释放AlibabaClient
			if (client != null) client.shutdown();
		}
	}

	@Override
	public Owner saveFirstLoginE688Owner(AuthorizationToken authorizationToken,String shopNum){
		/**
		 * 初始化AlibabaClient
		 */
		ClientPolicy policy = ClientPolicy.getDefaultChinaAlibabaPolicy();
		policy = policy.setAppKey(clientId).setSigningKey(appSecretKey);
		AlibabaClient client = new AlibabaClient(policy);
		client.start();
		try{
			

			/**
			 * 调用send方法实现api 的调用
			 */
			RequestPolicy basePolicy = new RequestPolicy().setContentCharset("UTF-8").setTimeout(3000);
			String memberId = getMemberIdByLoginId(client,basePolicy,authorizationToken.getResource_owner());
			MemberInfo memberInfo = getMemberInfo(client,basePolicy,memberId);
			String ownerNum = "1688"+memberInfo.getMemberId();
			Owner owner = iWOwnerService.getOwner(ownerNum);
			if(owner == null){
				owner = new Owner();
				owner.setOwnerNum(ownerNum);
				owner.setCompanyName(memberInfo.getCompanyName());
				owner.setContactPerson(memberInfo.getSellerName());
				owner.setPhoneNum(memberInfo.getTelephone());
				owner.setRegionCode("000000");
				owner.setAddress(memberInfo.getAddressLocation());
				owner.setWebSite(memberInfo.getHomepageUrl());
				owner.setIntroduction(memberInfo.getProduct());
				owner.setShopNum(shopNum);
				owner.setActiveFlag(1);
				owner.setExternalSysCode("1688");
				iWOwnerService.addExtSysOwner(owner);
				owner = iWOwnerService.getOwner(ownerNum);
				
				WeaDataCache.getCache().getOwnerShopNumMap().put(owner.getShopNum(), owner.getOwnerNum());
				OwnerAdmin ownerAdmin = new OwnerAdmin();
				ownerAdmin.setAdminName(owner.getOwnerNum());
				ownerAdmin.setAdminPwd(WeaConstant.DEFAULT_OWNERADMINPWD);
				ownerAdmin.setOwnerNum(ownerNum);
				ownerAdmin.setReserveFlag(1);
				iWOwnerAdminService.addOwnerAdmin(ownerAdmin);
				
				/*创建新用户后立即 添加企业权限*/
				iwAuthorityService.removeWAuthority(ownerNum);
				String which = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33";
				Authority authority = new Authority();
				authority.setWhichAuthority(which);
				authority.setOwnerNum(ownerNum);
				iwAuthorityService.saveAuthority(authority);
				
				
			}
			return owner;
		}catch(Throwable ex){
			ex.printStackTrace();
			throw new WeaException(ex);
		}
		finally{
			
			//释放AlibabaClient
			if (client != null) client.shutdown();
		}
		
	}

	/* (non-Javadoc)同步企业信息
	 * @see com.etaoguan.wea.client.web.service.IWE688Service#syncE688Data(com.alibaba.openapi.client.auth.AuthorizationToken)
	 */
	@Override
	public void syncE688Data(AuthorizationToken authorizationToken) {
		/**
		 * 初始化AlibabaClient
		 */
		ClientPolicy policy = ClientPolicy.getDefaultChinaAlibabaPolicy();
		policy = policy.setAppKey(clientId).setSigningKey(appSecretKey);
		AlibabaClient client = new AlibabaClient(policy);
		try{
			client.start();

			/**
			 * 调用send方法实现api 的调用
			 */
			RequestPolicy basePolicy = new RequestPolicy().setContentCharset("UTF-8").setTimeout(60000);
			String memberId = getMemberIdByLoginId(client,basePolicy,authorizationToken.getResource_owner());//获取会员编号
			syncE688Data2Wea(client, basePolicy, memberId, authorizationToken);
			
		}catch(Exception ex){
			ex.printStackTrace();
			throw new WeaException(ex);
		}
		finally{
			
			//释放AlibabaClient
			if (client != null) client.shutdown();
		}
		
	}



}
