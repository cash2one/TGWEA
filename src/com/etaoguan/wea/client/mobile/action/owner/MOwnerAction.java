package com.etaoguan.wea.client.mobile.action.owner;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMOwnerBannerService;
import com.etaoguan.wea.client.mobile.service.IMOwnerService;
import com.etaoguan.wea.client.mobile.service.IMPaymentInfoService;
import com.etaoguan.wea.client.mobile.service.IMRecommendOwnerService;
import com.etaoguan.wea.service.IOwnerService;
import com.etaoguan.wea.vo.Owner;
import com.etaoguan.wea.vo.OwnerAdmin;
import com.etaoguan.wea.vo.OwnerBanner;
import com.etaoguan.wea.vo.RecommendOwner;

@SuppressWarnings("serial")
@WeaModule(mname="企业基本信息")
@Service("ownerMOwnerAction") @Scope("prototype")
public class MOwnerAction extends MOwnerBaseAction{
	
	@Resource(name="mownerService")
	private IMOwnerService imOwnerService;
	
	@Resource(name="mrecommendOwnerService")
	private IMRecommendOwnerService imRecommendOwnerService;
	
	@Resource(name="mownerBannerService")
	private IMOwnerBannerService imOwnerBannerService;
	
	@Resource(name="mpaymentInfoService")
	private IMPaymentInfoService imPaymentInfoService;
	
	@Resource(name="ownerService")
	private  IOwnerService iOwnerService;
	
	@WeaFunction(fname="获取企业管理员信息",oname=WeaFunction.Operation.READ)
	@Action(value="mGetOwnerData")
	public String getOwnerData() throws IOException {

		Owner owner=iOwnerService.getOwner(ownerNum);
		OwnerAdmin ownerAdmin = (OwnerAdmin) getSessionAttribute("CURRENT_OWNERADMIN");
		owner.setAdminName(ownerAdmin.getAdminName());
		
		weaResponse.setRespData(owner);
		
		return JSONRESPONSE;
	}
	
	@Action(value="mGetOwnerSupportPayType")
	public String getOwnerSupportPayType() throws IOException {

		weaResponse.setRespData(imPaymentInfoService.getSupportOnlinePayType(ownerNum));
		
		return JSONRESPONSE;
	}
	
	@Action(value="mGetOwnerInfo")
	public String getOwnerInfo() throws IOException {
		Owner owner = imOwnerService.getOwner(ownerNum);
		weaResponse.setRespData(owner);
		return JSONRESPONSE;
	}
	
	@Action(value="mGetRecommendOwners")
	public String getRecommendOwners() throws IOException {
		List<RecommendOwner> recommendOwnerList = imRecommendOwnerService.getAllRecommendOwners();
		weaResponse.setRespData(recommendOwnerList);
		return JSONRESPONSE;
	}

	@Action(value="mGetOwnerBanners")
	public String getOwnerBanners() throws IOException {
		List<OwnerBanner> ownerBannerList = imOwnerBannerService.getAllOwnerBanners(ownerNum);
		weaResponse.setRespData(ownerBannerList);
		return JSONRESPONSE;
	}
}
