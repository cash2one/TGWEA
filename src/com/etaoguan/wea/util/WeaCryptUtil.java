package com.etaoguan.wea.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.jpush.api.utils.StringUtils;

public class WeaCryptUtil {
	
	private static SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyyMMdd");
	
	public static String genE688InviteCode(String expireDateText){
		int randomNum= new java.util.Random().nextInt(900)+100;
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(randomNum));
		sb.append("tg");
		sb.append(expireDateText);
		return AESCrypt.encrypt(sb.toString());
	}
	
	public static boolean isValidE688InviteCode(String inviteCode){
		try{
			if(StringUtils.isEmpty(inviteCode)){
				return false;
			}
			String srcCode = AESCrypt.decrypt(inviteCode);
			if(StringUtils.isEmpty(srcCode)||srcCode.length()!=13||srcCode.indexOf("tg")!=3){
				return false;
			}else{
				
				Date expireDate = DATEFORMAT.parse(srcCode.substring(5));
				Date currentDate = new Date();
				if(currentDate.getTime()>expireDate.getTime()){
					return false;
				}
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}
	

}
