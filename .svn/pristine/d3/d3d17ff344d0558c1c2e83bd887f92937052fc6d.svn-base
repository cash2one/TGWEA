package com.etaoguan.wea.client.web.action.common;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.openapi.client.auth.AuthorizationToken;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WCommonBaseAction;
import com.etaoguan.wea.client.web.service.IWAuthorityService;
import com.etaoguan.wea.client.web.service.IWE688Service;
import com.etaoguan.wea.client.web.service.IWOwnerAdminService;
import com.etaoguan.wea.client.web.service.IWOwnerService;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.util.WeaCryptUtil;
import com.etaoguan.wea.vo.Owner;
import com.etaoguan.wea.vo.OwnerAdmin;

@SuppressWarnings("serial")
@WeaModule(mname="1688数据同步管理")
@Service("we688Action") @Scope("prototype")
public class WE688AuthAction extends WCommonBaseAction{
	
	private final static Log logger = LogFactory.getLog(WE688AuthAction.class);
	
	@Autowired
	IWOwnerAdminService iWOwnerAdminService;

	@Autowired
	IWOwnerService iWOwnerService;
			
	@Resource(name="we688Service")
	private IWE688Service iwE688Service;
	
	@Resource(name="wauthorityService")
	private IWAuthorityService iwAuthorityService;

	@Action(value="wE688Login",results = { @Result(name = "error", type = "dispatcher",location="/acterror.jsp")})
	public String e688Login() throws IOException {

		String inviteCode = getRequestParamValue("inviteCode");
		String shopNum = getRequestParamValue(WeaConstant.CLIENTSHOPNUM);
		
		if(StringUtils.isNotEmpty(shopNum)){
			String ownerNum = WeaDataCache.getCache().getOwnerShopNumMap().get(shopNum);
			if(StringUtils.isNotEmpty(ownerNum)){
				String redirectUri = getDomainBaseUrl()+"common/e688CallBack.action";
				String authPageUrl = iwE688Service.getE688AuthorizationPageUrl(redirectUri);
				getResponse().sendRedirect(authPageUrl);
				return null;
			}else{
				
				weaResponse.setFailStatus();
				weaResponse.setMessage("无效访问请求");
				return ERROR;
			}
		}else{
			
			if(WeaCryptUtil.isValidE688InviteCode(inviteCode)){
				String randomShopNum = iWOwnerService.getRandomOwnerShopNum();
				String redirectUri = getDomainBaseUrl().replaceAll("www.", randomShopNum+".")+"common/e688CallBack.action?shopNum="+randomShopNum;
				String authPageUrl = iwE688Service.getE688AuthorizationPageUrl(redirectUri);
				getResponse().sendRedirect(authPageUrl);
				return null;
				
			}else{
				weaResponse.setFailStatus();
				weaResponse.setMessage("无效的邀请码");
				return ERROR;
			}
			
		}
		
		
		
	}


	//@Action(value="wE688Login",results = { @Result(name = "success", type = "redirectAction",params={"actionName","owner/wLogin.action", "adminName","${defaultOwnerAdmin.adminName}","adminPwd","${defaultOwnerAdmin.adminPwd}"})})
	@Action(value="e688CallBack",results = { @Result(name = "success", type = "dispatcher",location="/owner/1688_syncpage.jsp"),@Result(name = "error", type = "dispatcher",location="/acterror.jsp")})
	public String e688CallBack() throws IOException {
		String e688AuthCode = getRequestParamValue("code");
		String shopNum = getRequestParamValue(WeaConstant.CLIENTSHOPNUM);
		logger.info("shopNum="+shopNum+";e688AuthCode="+e688AuthCode);
		AuthorizationToken authToken =iwE688Service.getE688AuthorizationToken(e688AuthCode);
		Owner owner = iwE688Service.saveFirstLoginE688Owner(authToken,shopNum);
		OwnerAdmin defaultOwnerAdmin = iWOwnerAdminService.getReserveOwnerAdminsByOwnerNum(owner.getOwnerNum()).get(0);
		defaultOwnerAdmin.setOwner(owner);//设置用户同步1688数据权限
		boolean activeOwner = iWOwnerService.isActiveOwner(owner.getOwnerNum());
		if(!activeOwner){
			weaResponse.setFailStatus();
			weaResponse.setMessage("企业未经授权");
			return ERROR;
		}else{
		
			iWOwnerAdminService.updateOwnerAdminLoginDate(defaultOwnerAdmin.getAdminId(), new Date());
			
			setSessionAttribute("ownerInSession", owner);
			
			/*获取用户权限*/
			setSessionAttribute("whichAuthority", iwAuthorityService.lookWAuthority(owner.getOwnerNum()));
			
			setLoginSessionAttribute(WeaConstant.CUROWNERADMIN,defaultOwnerAdmin);
			setSessionAttribute("e688AuthToken", authToken);
			String redirectUrl = getDomainBaseUrl().replaceAll(shopNum+".", owner.getShopNum()+".")+"owner/wE688SyncPage.action";
			logger.info("shopNum="+shopNum+";owner.shopNum="+owner.getShopNum()+";redirectUrl="+redirectUrl);
			getResponse().sendRedirect(redirectUrl);
			return null;
		}
	}

}
