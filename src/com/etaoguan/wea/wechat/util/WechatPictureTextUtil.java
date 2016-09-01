package com.etaoguan.wea.wechat.util;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

import com.etaoguan.wea.util.JsonUtil;
import com.etaoguan.wea.wechat.vo.WechatMassMpnews;


/**
 * @author cunli
 * 微信群发功能
 */
public class WechatPictureTextUtil {

	private String urlStr;

	 private static URL url;
	 private static HttpURLConnection httpURLConnection;
	 private static String response;
	 
	 public String getUrlStr() {
		return urlStr;
	}

	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}

	public static URL getUrl() {
		return url;
	}

	public static void setUrl(URL url) {
		WechatPictureTextUtil.url = url;
	}

	public static HttpURLConnection getHttpURLConnection() {
		return httpURLConnection;
	}

	public static void setHttpURLConnection(HttpURLConnection httpURLConnection) {
		WechatPictureTextUtil.httpURLConnection = httpURLConnection;
	}

	public static String getResponse() {
		return response;
	}

	public static void setResponse(String response) {
		WechatPictureTextUtil.response = response;
	}

	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		WechatPictureTextUtil.accessToken = accessToken;
	}




	private static String accessToken = "NsjRopVPS2n91Lc-g5t0srVuJMWEN7fUT_rWtzkaNIx_ArNNY_jRUvNHLPAo8DLiFF-XH7cU5Nbt7537ptjZ8Y-yLNggiTMKoSuKUZETwlg";
	 
	 /**
		 * 获取关注者列表
		 */
		@SuppressWarnings("unused")
		public static String customers(String accessToken){
			WechatPictureTextUtil test=new WechatPictureTextUtil();
			
		String urlStr ="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken+"&next_openid=";
		String context="";
		
		Map<String, Object> map=	WechatPictureTextUtil.SendURLPost(context,urlStr);
			String data=map.get("data").toString();
			
			JsonUtil jsonUtil=new JsonUtil();
			Map<String, Object> map2=  JsonUtil.parseMapFromJsonString(data);
			String openid=map2.get("openid").toString();
			 String openid1=openid.substring(1);
			 String openid2=openid1.substring(0,openid1.length()-1);
			 
			 String[] ids = openid2.split(",");
			 
			 String lastIds = "";
				for (int i = 0; i < ids.length; i++) {
					lastIds+=ids[i].trim()+"\",\"";
				}
				String lastOpenIds = lastIds.substring(0,lastIds.length()-3);
			return lastOpenIds;
		}
		
		public static void main(String[] args) {
			
//			whoareyou("oI3PGt6tW328DGa8sK_gJPsrr8Pw");
			
//			String appid ="wx741d407de98701d8";
//			String secret="c21e454b6c5a3f8f1c6196b8a1cf0e19";
//			System.out.println("************accessToken= "+accessToken(appid,secret));
			
//			
//			System.out.println(customers(accessToken));
//			
//			String[] ids = customers(accessToken).split(",");
//			String lastIds = "";
//			for (int i = 0; i < ids.length; i++) {
//				lastIds+=ids[i].trim()+"\",\"";
//			}
//			
//			System.out.println(lastIds);
			
//			String openid = "oI3PGt5GXN1Hrt5C5nM33AXRCVew";
//			whoareyou(openid);
			
//			String mediaId = "I5EAtAGd2ge-aq5OWlsRR0zhWEeNhJwmNKtwNNl_cEBZwfe01tFyVED3-bbCaUFu";
//			String openIds = "oI3PGt6VbRrYsvGqAD-8t2qJzS0Y,oI3PGtx_NcIucQpJNw0qO5gT-An4";
//			String[] ids = openIds.split(",");
//			String lastIds = "";
//			for (int i = 0; i < ids.length; i++) {
//				lastIds+=ids[i].trim()+"\",\"";
//			}
//			String lastOpenIds = lastIds.substring(0,lastIds.length()-3);
//			
//			System.out.println(lastOpenIds);
//			
//			sendImgText(mediaId,lastIds,accessToken);
		}
		
		/*群发图文消息*/
		/*public static void sendImgTexttt(String mediaId,String openIds,String accessToken){
			
			WechatPictureTextUtil test=new WechatPictureTextUtil();   
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append("{\"touser\":[\"");
			stringBuffer.append(openIds);
			stringBuffer.append("\"],\"mpnews\":{\"media_id\":\"");
			stringBuffer.append(mediaId);
			stringBuffer.append("\"}, \"msgtype\":\"mpnews\"}");
			
			String urlStr="https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token="+accessToken;
		Map<String, Object> map=test.SendURLPost(stringBuffer.toString(),urlStr);
		String errcode = map.get("errcode").toString();
		String errmsg = map.get("errmsg").toString();
		String msgId = map.get("msg_id").toString();
		
		System.out.println("errcode "+errcode);
		System.out.println("errmsg "+errmsg);
		System.out.println("msgId "+msgId);
		System.out.println("*****************     halelujah         ********************");
		
		}*/

	 /**
		 * 群发(图文消息)
		 */
		public static HelpPictureText sendImgText(String mediaId,String openIds,String accessToken){
			
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append("{\"touser\":[\"");
			stringBuffer.append(openIds);
			stringBuffer.append("\"],\"mpnews\":{\"media_id\":\"");
			stringBuffer.append(mediaId);
			stringBuffer.append("\"}, \"msgtype\":\"mpnews\"}");
			
			String urlStr="https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token="+accessToken;
		Map<String, Object> map=SendURLPost(stringBuffer.toString(),urlStr);
		String errcode = map.get("errcode").toString();
//		String errmsg = map.get("errmsg").toString();
		String msgId = map.get("msg_id").toString();
		
		System.out.println();
		
		HelpPictureText helpPictureText=new HelpPictureText();
		helpPictureText.setMsgId(msgId);
		helpPictureText.setErrcode(errcode);
		
			return helpPictureText;
		}
		
	 /**
	 * 上传图文信息
	 */
	public static String uploadImgText(List<WechatMassMpnews> wechatPictureTexts,String accessToken){
		
		StringBuffer stringBuffer=new StringBuffer();
		
		for (WechatMassMpnews wechatPictureText2 : wechatPictureTexts) {
		
		stringBuffer.append("{\"thumb_media_id\":\"");
		stringBuffer.append(wechatPictureText2.getThumbMediaId());
		stringBuffer.append("\",\"author\":\"");
		stringBuffer.append(wechatPictureText2.getAuthor());
		stringBuffer.append("\",\"title\":\"");
		stringBuffer.append(wechatPictureText2.getTitle());
		stringBuffer.append("\",\"content_source_url\":\"");
		stringBuffer.append(wechatPictureText2.getContentSourceUrl());
		stringBuffer.append("\",\"content\":\"");
		stringBuffer.append(wechatPictureText2.getContent().replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\\\""));
		stringBuffer.append("\",\"digest\":\"");
		stringBuffer.append(wechatPictureText2.getDigest());
		stringBuffer.append("\",\"show_cover_pic\":\"");
		stringBuffer.append(wechatPictureText2.getShowCoverPic());
		stringBuffer.append("\"}"+",");
		
		
		}
		
		String wpt2=stringBuffer.substring(0,stringBuffer.length()-1);
		String context ="{\"articles\": ["+wpt2+"]}";
		
		String urlStr="https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token="+accessToken;
	Map<String, Object> map=SendURLPost(context,urlStr);
	String mediaId = map.get("media_id").toString();
	return mediaId;
	}
	
	
	 /** 
     * 上传图片 
     *  
     * @param urlStr 
     * @param textMap 
     * @param fileMap 
     * @return 
     */  
    @SuppressWarnings("rawtypes")
	public static String formUpload(String urlStr,Map<String, String> fileMap) {  
        String res = "";  
        HttpURLConnection conn = null;  
        String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符  
        try {  
            URL url = new URL(urlStr);  
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
  
            // file  
            if (fileMap != null) {  
                Iterator iter = fileMap.entrySet().iterator();  
                while (iter.hasNext()) {  
                    Map.Entry entry = (Map.Entry) iter.next();  
                    String inputName = (String) entry.getKey();  
                    String inputValue = (String) entry.getValue();  
                    if (inputValue == null) {  
                        continue;  
                    }  
                    File file = new File(inputValue);  
                    String filename = file.getName();  
                    String contentType = new MimetypesFileTypeMap()  
                            .getContentType(file);  
                    if (filename.endsWith(".tmp")) {  
                        contentType = "image/tmp";  
                    }  
                    if (contentType == null || contentType.equals("")) {  
                        contentType = "application/octet-stream";  
                    }  
  
                    StringBuffer strBuf = new StringBuffer();  
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append(  
                            "\r\n");  
                    strBuf.append("Content-Disposition: form-data; name=\""  
                            + inputName + "\"; filename=\"" + filename  
                            + ".png\"\r\n");  
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");  
  
                    out.write(strBuf.toString().getBytes());  
  
                    DataInputStream in = new DataInputStream(  
                            new FileInputStream(file));  
                    int bytes = 0;  
                    byte[] bufferOut = new byte[1024];  
                    while ((bytes = in.read(bufferOut)) != -1) {  
                        out.write(bufferOut, 0, bytes);  
                    }  
                    in.close();  
                }  
            }  
  
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();  
            out.write(endData);  
            out.flush();  
            out.close();  
  
            // 读取返回数据  
            StringBuffer strBuf = new StringBuffer();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream()));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                strBuf.append(line).append("\n");  
            }  
            res = strBuf.toString();  
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
        return res;  
    }  
  
	
	/**
	 * 下载
	 */
	public static void download(){
			        
	String mediaId="qppSqxO1FlBG2Ll3je-Od-aVdUkW7OZ0gHQ5mXoSbwkHT2HYIW59HhnGWlcl3BS8";
	String urlStr="http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+accessToken+"&media_id="+mediaId;
	SendURLPost("",urlStr);
	
	System.out.println("***********下载*************");
	}
	
	
	
	/**
	 * 获取用户信息
	 */
	public static void whoareyou(String openid){
		
			String urlStr ="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken+"&openid="+openid+"&lang=zh_CN";
			String context="";
		Map<String, Object> map = SendURLPost(context,urlStr);
		System.out.println(map.get("openid"));
		System.out.println(map.get("nickname"));
			
	}
	
	
	/**
	 * 获取accessToken
	 */
	public static String accessToken(String appid,String secret){
		
		String urlStr="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;	

	Map<String, Object> map = SendURLPost(appid,urlStr);
			
		String token=map.get("access_token").toString();
		String expiresIn=map.get("expires_in").toString();
		System.out.println("expires_in= "+expiresIn);
		return token;

	}
	
	
	/**
	 * 群发(文本消息)
	 */
	public static void sendText(){
		
		String context =  "{\"touser\": [\"oI3PGtx_NcIucQpJNw0qO5gT-An4\"], \"msgtype\": \"text\", \"text\": { \"content\": \"哈利路亚 halelujah\"}}";

		String urlStr="https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token="+accessToken;
		SendURLPost(context,urlStr);
		
		System.out.println("***********群发(文本消息)*******已发送******");
	}
	
	
	
	
	/**
	 * @param articleId
	 * 发送信息
	 */
	@SuppressWarnings({"unused" })
	public static Map<String, Object> SendURLPost(String context,String urlStr)  {
		 StringBuilder sb = null;
	  try {
		url = new URL(urlStr);
		 httpURLConnection = (HttpURLConnection) url.openConnection(); // 获取连接
		  httpURLConnection.setRequestMethod("POST"); // 设置请求方法为POST, 也可以为GET
		  httpURLConnection.setDoOutput(true);

		  OutputStream os = httpURLConnection.getOutputStream();
		  os.write(context.toString().getBytes("UTF-8"));
		  os.flush();
		  os.close();

		  InputStream is = httpURLConnection.getInputStream();
		  BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		   sb = new StringBuilder();
		  int b;
		  while ((b=br.read()) != -1) {
		   sb.append((char)b);
		  }

		  //content = new String(sb.toString().getBytes("ISO8859-1"), "utf-8");
//		  System.out.println(sb.toString());
		  br.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	  JsonUtil jsonUtil=new JsonUtil();
	  return JsonUtil.parseMapFromJsonString(sb.toString());
	 	 }


	@SuppressWarnings({"unused" })
	public static Map<String, Object> SendURLPost(byte[] contextBytes,String urlStr)  {
		 StringBuilder sb = null;
	  try {
		url = new URL(urlStr);
		 httpURLConnection = (HttpURLConnection) url.openConnection(); // 获取连接
		  httpURLConnection.setRequestMethod("POST"); // 设置请求方法为POST, 也可以为GET
		  httpURLConnection.setDoOutput(true);

		  OutputStream os = httpURLConnection.getOutputStream();
		  os.write(contextBytes);
		  os.flush();
		  os.close();

		  InputStream is = httpURLConnection.getInputStream();
		  BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		   sb = new StringBuilder();
		  int b;
		  while ((b=br.read()) != -1) {
		   sb.append((char)b);
		  }

		  //content = new String(sb.toString().getBytes("ISO8859-1"), "utf-8");
//		  System.out.println(sb.toString());
		  br.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	  JsonUtil jsonUtil=new JsonUtil();
	  return JsonUtil.parseMapFromJsonString(sb.toString());
	 	 }

}
