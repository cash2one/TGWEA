package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.vo.OwnerBanner;

public interface IOwnerBannerService {

	public void addOwnerBanner(OwnerBanner ownerBanner);
	
	public OwnerBanner getOwnerBanner(long bannerId);
	
	public List<OwnerBanner> getAllOwnerBanners(String ownerNum);
	
	public void delOwnerBanner(long bannerId);
	
	public void updateOwnerBannerSeqence(long preBannerId,long bannerId);
	
	public void updateOwnerBanner(OwnerBanner ownerBanner);
	
	public int getOwnerBannerMaxSeqence(String ownerNum);
}
