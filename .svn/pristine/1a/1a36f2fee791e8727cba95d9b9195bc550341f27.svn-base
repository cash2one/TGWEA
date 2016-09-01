package com.etaoguan.wea.client.mobile.action;


import com.etaoguan.wea.client.action.WeaBaseAction;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.mobile.vo.MWeaResponse;
import com.etaoguan.wea.client.vo.WeaResponse;
import com.etaoguan.wea.constant.WeaConstant;

public class MBaseAction extends WeaBaseAction{

	private static final long serialVersionUID = 7817071812096412211L;
	protected MPagingRequest mpagingRequest;
	
	protected MWeaResponse weaResponse = new MWeaResponse();
	
	protected String JSONRESPONSE = WeaConstant.JSONRESPONSE;

	public MPagingRequest getMpagingRequest() {
		return mpagingRequest;
	}

	public void setMpagingRequest(MPagingRequest mpagingRequest) {
		this.mpagingRequest = mpagingRequest;
	}

	
	public void setMResponseError(Throwable ex){
		weaResponse.setStatus(WeaResponse.FAIL);
		weaResponse.setMessage(ex.getMessage());
	}


	public MWeaResponse getWeaResponse() {
		return weaResponse;
	}

	public void setWeaResponse(MWeaResponse weaResponse) {
		this.weaResponse = weaResponse;
	}

}
