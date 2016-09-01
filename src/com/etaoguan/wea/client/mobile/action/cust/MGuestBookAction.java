package com.etaoguan.wea.client.mobile.action.cust;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.mobile.action.MOwnerBaseAction;
import com.etaoguan.wea.client.mobile.service.IMGuestBookService;
import com.etaoguan.wea.client.mobile.vo.GuestBookSearch;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.vo.GuestBook;

@WeaModule(mname="留言板管理")
@Service("custMGuestBookAction") @Scope("prototype")
public class MGuestBookAction extends MOwnerBaseAction{

	private static final long serialVersionUID = 6708226388912491123L;
	
	private GuestBookSearch guestBookSearch = new GuestBookSearch();
	
	private GuestBook guestBook;
	
	@Resource(name="mguestBookService")
	private IMGuestBookService imGuestBookService;

	@SuppressWarnings("rawtypes")
	@Action(value="mListGuestBooks")
	public String listGuestBooks() throws IOException {
		guestBookSearch.setOwnerNum(ownerNum);
		MPage mpage = imGuestBookService.listGuestBooks(guestBookSearch, sortParam, mpagingRequest);
		weaResponse.setRespData(mpage);
		return JSONRESPONSE;
	}
	
	@Action(value="mAddGuestBook")
	public String addGuestBook() throws IOException {
		guestBook.setOwnerNum(ownerNum);
		imGuestBookService.addGuestBook(guestBook);
		return JSONRESPONSE;
	}

	public GuestBookSearch getGuestBookSearch() {
		return guestBookSearch;
	}

	public void setGuestBookSearch(GuestBookSearch guestBookSearch) {
		this.guestBookSearch = guestBookSearch;
	}

	public GuestBook getGuestBook() {
		return guestBook;
	}

	public void setGuestBook(GuestBook guestBook) {
		this.guestBook = guestBook;
	}
}
