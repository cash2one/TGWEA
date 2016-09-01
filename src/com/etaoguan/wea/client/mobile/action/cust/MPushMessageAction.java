package com.etaoguan.wea.client.mobile.action.cust;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMPushMessageService;
import com.etaoguan.wea.client.mobile.vo.JPushAliasNTag;
@Service("custMPushMessageAction") @Scope("prototype")
public class MPushMessageAction extends MOwnerBaseAction{

	private static final long serialVersionUID = -6408795219180308503L;
	@Resource(name="mpushMessageService")
	private IMPushMessageService imPushMessageService;
	
	@Action(value="mGetCustPushMessageTag")
	public String getCustPushMessageTag() throws IOException, ServletException{
		if(getCurrentCust()==null){
			weaResponse.setFailStatus();
			weaResponse.setMessage("无登录客户");
		}else{
			weaResponse.setRespData(imPushMessageService.getCustPushGroupNums(getCurrentCust().getCustNum()));
		}
		return JSONRESPONSE;
	}
	
	@Action(value="mGetCustPushMessageAlias")
	public String getCustPushMessageAlias() throws IOException, ServletException{
		if(getCurrentCust()==null){
			weaResponse.setFailStatus();
			weaResponse.setMessage("无登录客户");
		}else{
			weaResponse.setRespData(getCurrentCust().getCustNum());
		}
		return JSONRESPONSE;
	}
	
	@Action(value="mGetCustPushMessageAliasNTags")
	public String getCustPushMessageAliasNTags() throws IOException, ServletException{
		JPushAliasNTag jPushAliasNTag = new JPushAliasNTag();
		if(getCurrentCust()==null){
			weaResponse.setFailStatus();
			weaResponse.setMessage("无登录客户");
		}else{
			List<String> tags = imPushMessageService.getCustPushGroupNums(getCurrentCust().getCustNum());
			tags.add(getCurrentCust().getOwnerNum().replace("-", "_"));
			jPushAliasNTag.setTags(tags);
			jPushAliasNTag.setAlias(getCurrentCust().getCustNum());
			weaResponse.setRespData(jPushAliasNTag);
		}
		return JSONRESPONSE;
	}	
}
