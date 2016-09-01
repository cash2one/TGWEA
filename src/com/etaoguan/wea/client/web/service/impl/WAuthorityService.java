package com.etaoguan.wea.client.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWAuthorityService;
import com.etaoguan.wea.service.impl.AuthorityService;
import com.etaoguan.wea.vo.Authority;

@Service("wauthorityService")
public class WAuthorityService extends AuthorityService implements IWAuthorityService{

	
	@Override
	public void saveWAuthority(Authority authority) {
		saveAuthority(authority);
	}

	@Override
	public void removeWAuthority(String ownerNum) {
		removeAuthority(ownerNum);
		
	}

	@Override
	public List<Integer> lookWAuthority(String ownerNum) {
		List<Integer> list=null;
		Authority authority = lookAuthority(ownerNum);
		String wau="";
		if (authority == null) {
			wau = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30";
		}else {
			wau=authority.getWhichAuthority();//
			
		}

		String[] aut=wau.split(",");
		list=new ArrayList<Integer>();
		for (int i = 0; i < aut.length; i++) {
			list.add(Integer.parseInt(aut[i].trim()));
		}
		
		return list;
	}
}
