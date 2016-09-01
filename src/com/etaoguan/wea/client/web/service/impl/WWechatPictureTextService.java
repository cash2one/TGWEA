package com.etaoguan.wea.client.web.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.action.owner.WWechatCallbackAction;
import com.etaoguan.wea.client.web.service.IWWechatKeysService;
import com.etaoguan.wea.client.web.service.IWWechatMassMessageService;
import com.etaoguan.wea.client.web.service.IWWechatPictureTextService;
import com.etaoguan.wea.common.FileGenRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.service.impl.WechatPictureTextService;
import com.etaoguan.wea.util.JsonUtil;
import com.etaoguan.wea.vo.WechatKeys;
import com.etaoguan.wea.wechat.util.HelpPictureText;
import com.etaoguan.wea.wechat.util.WechatPictureTextUtil;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;


/**
 * @author cunli
 * 图文消息详情
 */
@Service("wWechatPictureTextService")
public class WWechatPictureTextService extends WechatPictureTextService implements IWWechatPictureTextService{
	
	@Resource(name = "wwechatMassMessageService")
	private IWWechatMassMessageService iwWechatMassMessageService;
	
	@Resource(name = "wwechatKeysService")
	private IWWechatKeysService iWWechatKeysService;
	
	private final static Log logger = LogFactory.getLog(WWechatCallbackAction.class);
	
	@Override
	public void savePTclientService(List<WechatMassMpnews> wechatMassMpnews,String ownerNum,String wechatSubject) {
		int massMessageId = iwWechatMassMessageService.addWechatmmsg(ownerNum,wechatMassMpnews,wechatSubject);

		iwWechatMassMessageService.updateWmMsg(massMessageId,wechatMassMpnews,ownerNum);// save mediaId to database  上传图文

		/* 保存图文到数据库 */

		for (int i = 0; i < wechatMassMpnews.size(); i++) {

			WechatMassMpnews pText = new WechatMassMpnews();
			pText.setMassMessageId(massMessageId);
			pText.setThumbMediaId(wechatMassMpnews.get(i).getThumbMediaId());
			pText.setTitle(wechatMassMpnews.get(i).getTitle());
			pText.setContent(wechatMassMpnews.get(i).getContent());
          String author=wechatMassMpnews.get(i).getAuthor();
			if (!StringUtils.isBlank(author)) {
				pText.setAuthor(author);
			}
			String contentSourceUrl=wechatMassMpnews.get(i).getContentSourceUrl();
			if (!StringUtils.isBlank(contentSourceUrl)) {
				pText.setContentSourceUrl(contentSourceUrl);
			}
			String digest=wechatMassMpnews.get(i).getDigest();
			if (!StringUtils.isBlank(digest)) {
				pText.setDigest(digest);
			}

			if (i == 0) {
				pText.setShowCoverPic(1);
			} else {
				pText.setShowCoverPic(0);
			}

			addWechatPtxt(pText);
		}
		
	}
	
	/**
	 * @return 获取token
	 */
	@Override
	public String accessToken(String ownerNum) {
		String accessToken = "";
		
		 accessToken = WeaDataCache.getCache().getWechatTokenMap().get(ownerNum); 
		 if(StringUtils.isBlank(accessToken)) { 
			 WechatKeys wechatKeys = iWWechatKeysService.wechatKeys(ownerNum);//根据ownerNum获取到当前用户的微信的AppId和AppSecret
			 accessToken =  WechatPictureTextUtil.accessToken(wechatKeys.getAppId(),wechatKeys.getAppSecret());//用AppId和AppSecret得到accessToken.
		  WeaDataCache.getCache().getWechatTokenMap().put(ownerNum,accessToken); 
		  }
		return accessToken;
	}
	
	@Override
	public String token(String ownerNum) {
		WechatKeys wechatKeys = iWWechatKeysService.wechatKeys(ownerNum);
		 String accessToken =  WechatPictureTextUtil.accessToken(wechatKeys.getAppId(),wechatKeys.getAppSecret());
	  WeaDataCache.getCache().getWechatTokenMap().put(ownerNum,accessToken);
		return accessToken;
	}
	
	@Override
	@SuppressWarnings({"unused" })
	public HelpPictureText uploadimgPtclientService(File imgFile, String imgFileFileName,String ownerNum) {
		FileGenRequest fileGenRequest = new FileGenRequest(imgFile,imgFileFileName);

		String filepath = fileGenRequest.getUploadFile().getPath();

		String accessToken = accessToken(ownerNum);
		String urlStr = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+ accessToken + "&type=image";

		Map<String, String> fileMap = new HashMap<String, String>();

		fileMap.put("userfile", filepath);

		String ret = WechatPictureTextUtil.formUpload(urlStr, fileMap);

		JsonUtil jsonUtil = new JsonUtil();
		String mediaId ="";
			
			Object objectRet=JsonUtil.parseMapFromJsonString(ret).get("errcode");
		if(objectRet != null && objectRet.toString().equals("40001")){
				System.out.println("**********************token 无效**********************");
				token(ownerNum);
				uploadimgPtclientService(imgFile,imgFileFileName,ownerNum);
		}else {
			logger.info("错误信息：----"+ret);
		}
		mediaId = JsonUtil.parseMapFromJsonString(ret).get("media_id").toString();//if token is invalid
			
		HelpPictureText helpPictureText = new HelpPictureText();
		String imgUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+ accessToken + "&media_id=" + mediaId;
		helpPictureText.setImgUrl(imgUrl);
		helpPictureText.setMediaId(mediaId);
		
		return helpPictureText;
	}
	
	@Override
	public void updatePTclientService(String MMId,String ownerNum,List<WechatMassMpnews> wechatMassMpnews){
		int massMessageId = Integer .parseInt(MMId);

		iwWechatMassMessageService.updateWmMsg(massMessageId,wechatMassMpnews,ownerNum);
		
		for (int i = 0; i < wechatMassMpnews.size(); i++) {
			WechatMassMpnews wechatPictureText = new WechatMassMpnews();
			wechatPictureText.setMpnewsId(Long.parseLong(wechatMassMpnews.get(i).getIds()));
			wechatPictureText.setTitle(wechatMassMpnews.get(i).getTitle());
			wechatPictureText.setThumbMediaId(wechatMassMpnews.get(i).getThumbMediaId());
			wechatPictureText.setContent(wechatMassMpnews.get(i).getContent());
			String author=wechatMassMpnews.get(i).getAuthor();
			if (!StringUtils.isBlank(author)) {
			wechatPictureText.setAuthor(author);
			}
			String contentSourceUrl = wechatMassMpnews.get(i).getContentSourceUrl();
			if (!StringUtils.isBlank(contentSourceUrl)) {
			wechatPictureText.setContentSourceUrl(contentSourceUrl);
			}
			String digest = wechatMassMpnews.get(i).getDigest();
			if (!StringUtils.isBlank(digest)) {
			wechatPictureText.setDigest(digest);
			}
			updateWechatPtxt(wechatPictureText);
		}
	}

	@Override
	public HelpPictureText wechatPtById(String massMessageId,String accessToken) {
		long massMessageId2 = Long.parseLong(massMessageId);
		List<WechatMassMpnews> wechatPictureTexts = wechatPictureTexts(massMessageId2);
		for (WechatMassMpnews wechatMassMpnews : wechatPictureTexts) {
			if (StringUtils.isBlank(wechatMassMpnews.getAuthor())) {
				wechatMassMpnews.setAuthor("");
			}
			if (StringUtils.isBlank(wechatMassMpnews.getDigest())) {
				wechatMassMpnews.setDigest("");
			}
			if (StringUtils.isBlank(wechatMassMpnews.getContentSourceUrl())) {
				wechatMassMpnews.setContentSourceUrl("");
			}
		}
		HelpPictureText helpPictureText = new HelpPictureText();
		helpPictureText.setAccessToken(accessToken);
		helpPictureText.setWechatPictureTexts(wechatPictureTexts);
		return helpPictureText;
	}

	@Override
	public void updateWechatPtxt(WechatMassMpnews wechatPictureText) {
		updateWechatPictureText(wechatPictureText);
		
	}

	@Override
	public void addWechatPtxt(WechatMassMpnews wechatPictureText) {
		addWechatPictureText(wechatPictureText);
		
	}

	@Override
	public void deleteWechatmmnews(long massMessageId) {
	deleteWechatMassMpnews(massMessageId);
		
	}

	

	/* (non-Javadoc)选择产品时，上传产品图片到微信服务器
	 * @see com.etaoguan.wea.client.web.service.IWWechatPictureTextService#uploadImgToWechat(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unused")
	public String uploadImgToWechat(String imgUrl,String ownerNum) {
		String accessToken = accessToken(ownerNum);
		
		String urlStr = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="+ accessToken + "&type=image";
		
		 String res = "";
		 HttpURLConnection conn = null;  
	        String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容
	        
	        
		try {
			
			URL url = new URL(imgUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); // 获取连接
			ByteArrayOutputStream imageByteArrayOS = new ByteArrayOutputStream();
			con.setRequestMethod("GET");
            con.setConnectTimeout(6 * 1000);
            if(con.getResponseCode()==200){
                    //con.connect();
                    InputStream is = con.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);
                    int bytes = 0;  
                    byte[] bufferOut = new byte[1024];  
                    while ((bytes = bis.read(bufferOut)) != -1) {  
                    	imageByteArrayOS.write(bufferOut, 0, bytes);  
                    }  
                    is.close();

            }

			
            url = new URL(urlStr);  
            conn = (HttpURLConnection) url.openConnection();  
            conn.setConnectTimeout(5000);  
            conn.setReadTimeout(30000);  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            conn.setRequestMethod("POST");  
            conn.setRequestProperty("Connection", "Keep-Alive");  
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");  
            conn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + BOUNDARY);  
 
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
            
                String contentType = "application/octet-stream";  
   
            StringBuffer strBuf = new StringBuffer();  
            strBuf.append("\r\n").append("--").append(BOUNDARY).append(  
                    "\r\n");  
            strBuf.append("Content-Disposition: form-data; name=\""  
                    + "ok" + "\"; filename=\"" + "okf"  
                    + ".jpg\"\r\n");  
            strBuf.append("Content-Type:" + contentType + "\r\n\r\n");  

            out.write(strBuf.toString().getBytes());  
            
            out.write(imageByteArrayOS.toByteArray());
			
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();  
            out.write(endData);  
            out.flush();  
            out.close();  
  
            // 读取返回数据  
           strBuf = new StringBuffer();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream()));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                strBuf.append(line).append("\n");  
            }  
            res = strBuf.toString();  
            
            System.out.println("*********************res= "+res);
            
            reader.close();  
            reader = null;  
        } catch (Exception e) {  
            System.out.println("发送POST请求出错。" + urlStr);  
            e.printStackTrace();  
        } finally {  
            if (conn != null) {  
                conn.disconnect();  
                conn = null;  
            }  
        }  
			
		
		
		JsonUtil jsonUtil = new JsonUtil();
		String mediaId ="";
			
			Object objectRet=JsonUtil.parseMapFromJsonString(res).get("errcode");
		if(objectRet != null && objectRet.toString().equals("40001") && objectRet.toString().equals("42001")){
				System.out.println("********************** 微信 获取token出现问题 **********************");
				token(ownerNum);
				uploadImgToWechat(imgUrl,ownerNum);
		}else {
			logger.info("mediaId 信息：----"+res);
		}
		

		
		mediaId = JsonUtil.parseMapFromJsonString(res).get("media_id").toString();//if token is invalid
		
			
			
		return mediaId;
	}

}
