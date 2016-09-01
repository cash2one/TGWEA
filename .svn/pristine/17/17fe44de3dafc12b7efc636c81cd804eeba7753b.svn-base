package com.etaoguan.wea.client.web.action;

import java.util.Map;

import com.etaoguan.wea.client.action.WeaBaseAction;
import com.etaoguan.wea.client.vo.PageTrack;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.client.web.vo.WWeaResponse;
import com.etaoguan.wea.constant.WeaConstant;

public class WBaseAction extends WeaBaseAction{

	protected WWeaResponse weaResponse = new WWeaResponse();
	
	protected String JSONRESPONSE = WeaConstant.JSONRESPONSE;

	private static final long serialVersionUID = 7817071812096412211L;
	
	protected WPagingRequest wpagingRequest;

	public WPagingRequest getWpagingRequest() {
		return wpagingRequest;
	}

	public void setWpagingRequest(WPagingRequest wpagingRequest) {
		this.wpagingRequest = wpagingRequest;
	}

	public WWeaResponse getWeaResponse() {
		return weaResponse;
	}

	public void setWeaResponse(WWeaResponse weaResponse) {
		this.weaResponse = weaResponse;
	}

	
	@SuppressWarnings("rawtypes")
	protected void setPageSearchMap(String pageTrackKey) {
		Map pageTrackMap = (Map)getSessionAttribute(WeaConstant.SESSIONPAGETRACK);
		PageTrack pageTrack = (PageTrack)(pageTrackMap==null?null:pageTrackMap.get(pageTrackKey));
		if(pageTrack!=null&&pageTrack.getLastParamMap()!=null){
			weaResponse.setSearchParams(pageTrack.getLastParamMap());
		}
	}
	

	
}
