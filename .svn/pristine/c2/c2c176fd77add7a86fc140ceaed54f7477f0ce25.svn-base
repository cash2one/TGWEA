package com.etaoguan.wea.wechat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostXml {
	public static String sendXMLDataByPost(String urlStr, String xmlData) throws IOException {  
				String line = "";  
	            URL url = new URL(urlStr);
	            URLConnection con = url.openConnection();
	            con.setDoOutput(true);
	            con.setRequestProperty("Pragma:", "no-cache");
	            con.setRequestProperty("Cache-Control", "no-cache");
	            con.setRequestProperty("Content-Type", "text/xml");

	            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream(),"UTF-8");      
	            out.write(xmlData);  
	            out.flush();  
	            out.close();  
	            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));    
	            
		        char[] buff = new char[1024];
		        int length = 0;
		        while ((length = br.read(buff)) != -1) {
		        	line = new String(buff, 0, length);
		        }
	            
		        		return line;  
	    }  
		
}