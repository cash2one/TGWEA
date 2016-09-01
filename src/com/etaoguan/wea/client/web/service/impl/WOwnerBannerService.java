package com.etaoguan.wea.client.web.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWFileUploadService;
import com.etaoguan.wea.client.web.service.IWOwnerBannerService;
import com.etaoguan.wea.client.web.vo.ImgNode;
import com.etaoguan.wea.client.web.vo.WOwnerBanner;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.FileGenResult;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.service.impl.OwnerBannerService;
import com.etaoguan.wea.vo.OwnerBanner;


@Service("wownerBannerService")
public class WOwnerBannerService extends OwnerBannerService implements IWOwnerBannerService{

	@Autowired
	IWFileUploadService iWFileUploadService;
	
	@Override
	@SuppressWarnings("unused")
	public ImgNode genOwnerBannerTmpImgFile(FileGenRequest fileGenRequest,
			String ownerNum) throws IOException {
		BufferedImage image=ImageIO.read(fileGenRequest.getUploadFile());
		
		checkUploadImg(fileGenRequest, image,WeaConstant.BANNER_WIDTH,WeaConstant.BANNER_HEIGHT);
		
		int w=image.getWidth();
		StringBuffer relativefileDir = new StringBuffer();
		relativefileDir.append(WeaConstant.OWNER_RES);
		relativefileDir.append(File.separator);
		relativefileDir.append(ownerNum);
		FileGenResult tmpFileGenResult = iWFileUploadService.save2TmpFile(relativefileDir.toString(),fileGenRequest);
		ImgNode imgNode = new ImgNode();
		imgNode.setImgUrl(iWFileUploadService.formatFilePath2WebPath(tmpFileGenResult.getFileFullPath()));
		return imgNode;
	}

	@Override
	public void saveOrUpdateOwnerBanner(OwnerBanner ownerBanner, ImgNode imgNode) {
		if(imgNode.isAddImg()&&StringUtils.isNotEmpty(imgNode.getImgUrl())){
			FileGenResult targetImgFileGenResult = iWFileUploadService.rename2TargetFile(iWFileUploadService.formatWebPath2FilePath(imgNode.getImgUrl()));
			ownerBanner.setImgUrl(iWFileUploadService.formatFilePath2WebPath(targetImgFileGenResult.getFileFullPath()));
		}else{
			
			ownerBanner.setImgUrl(imgNode.getImgUrl());
		}
		if(ownerBanner.getBannerId()==0l){
			addOwnerBanner(ownerBanner);
		}else{
			updateOwnerBanner(ownerBanner);
		}
		
	}

	@Override
	public List<WOwnerBanner> getWOwnerBanners(String ownerNum) {
		List<OwnerBanner> ownerBannerList = getAllOwnerBanners(ownerNum);
		List<WOwnerBanner> wownerBannerList = new ArrayList<WOwnerBanner>();
		WOwnerBanner preWownerBanner=null;
		for(OwnerBanner ownerBanner:ownerBannerList){
			WOwnerBanner wOwnerBanner = new WOwnerBanner();
			wOwnerBanner.setOwnerBanner(ownerBanner);
			if(preWownerBanner!=null){
				wOwnerBanner.setPreBannerId(preWownerBanner.getOwnerBanner().getBannerId());
				preWownerBanner.setNextBannerId(wOwnerBanner.getOwnerBanner().getBannerId());
			}
			preWownerBanner = wOwnerBanner;
			wownerBannerList.add(wOwnerBanner);
		}
		return wownerBannerList;
	}

}
