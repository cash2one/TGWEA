package com.etaoguan.wea.client.web.service;

import java.io.IOException;
import java.util.List;

import com.etaoguan.wea.client.web.vo.ImgNode;
import com.etaoguan.wea.client.web.vo.WOwnerBanner;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.service.IOwnerBannerService;
import com.etaoguan.wea.vo.OwnerBanner;

public interface IWOwnerBannerService extends IOwnerBannerService{

	public ImgNode genOwnerBannerTmpImgFile(FileGenRequest fileGenRequest, String ownerNum) throws IOException;
	
	public void saveOrUpdateOwnerBanner(OwnerBanner ownerBanner,ImgNode imgNode);
	
	public List<WOwnerBanner> getWOwnerBanners(String ownerNum);
}
