package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWGuestBookService;
import com.etaoguan.wea.client.web.vo.GuestBookSearch;
import com.etaoguan.wea.client.web.vo.WPage;

@SuppressWarnings("serial")
@WeaModule(mname="留言板管理")
@Service("ownerWGuestBookAction") @Scope("prototype")
public class WGuestBookAction extends WOwnerBaseAction{

	private GuestBookSearch guestBookSearch = new GuestBookSearch();
	
	@Resource(name="wguestBookService")
	private IWGuestBookService iwGuestBookService;
	
	@WeaFunction(fname="查看留言列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListGuestBooks",results = { @Result(name = "success", type = "dispatcher",location="/owner/list_guestbooks.jsp")})
	public String listGuestBooks() throws IOException {

		return SUCCESS;
	}
	@SuppressWarnings("rawtypes")
	@WeaFunction(fname="查看留言列表",oname=WeaFunction.Operation.READ)
	@Action(value="wListGuestBooksData")
	public String listGuestBooksData() throws IOException {
		guestBookSearch.setOwnerNum(getCurrentOwnerAdmin().getOwnerNum());
		WPage wpage = iwGuestBookService.listGuestBooks(guestBookSearch, sortParam, wpagingRequest);
		weaResponse.setRows(wpage.getDataList());
		weaResponse.setTotal(wpage.getWpagingNavInfo().getTotalRecNum());
		weaResponse.setRespData(null);
		return JSONRESPONSE;
	}
	@WeaFunction(fname="删除留言",oname=WeaFunction.Operation.DELETE)
	@Action(value="wDelGuestBook")
	public String delGuestBook() throws IOException {
		String messageId = getRequestParamValue("messageId");
		iwGuestBookService.delGuestBook(Long.parseLong(messageId));
		return JSONRESPONSE;
	}

	public GuestBookSearch getGuestBookSearch() {
		return guestBookSearch;
	}

	public void setGuestBookSearch(GuestBookSearch guestBookSearch) {
		this.guestBookSearch = guestBookSearch;
	}


}
