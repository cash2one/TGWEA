package com.etaoguan.wea.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;

import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.service.IBaseService;
import com.etaoguan.wea.util.AppSessionUtil;

public class BaseService implements IBaseService {

	protected static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	protected static SimpleDateFormat sdt = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@Override
	public String getCurrentOperator() {
		String operator = AppSessionUtil.getAppSession().getOperator();
		return operator == null ? "" : operator;
	}

	public void checkUploadImg(FileGenRequest fileGenRequest, BufferedImage image,int imgWidth,int imgHeight) {
		
		if(WeaDataCache.getCache().getAppSettingAllowImageLimit()){

			String[] suffix = fileGenRequest.getUploadFileName().split("\\.");
			String suf = suffix[suffix.length - 1].toLowerCase();
	
			if ("jpg|jpeg|png".indexOf(suf) == -1) {
				throw new WeaException("请上传jpg或png格式的图片");
			}
	
			File picture = new File(fileGenRequest.getUploadFile().toString());
	
			double length = Double.parseDouble(String.format("%.1f",
					picture.length() / 1024.0));// 图片大小以k计算
	
			if (image.getWidth() != imgWidth || image.getHeight() != imgHeight || length > 500) {
				throw new WeaException("请上传小于500k的宽" + imgWidth + "高"+imgHeight+"的图片");
			}
		}

	}

}
