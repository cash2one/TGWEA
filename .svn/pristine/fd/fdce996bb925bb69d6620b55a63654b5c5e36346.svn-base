package com.etaoguan.wea.client.action;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class JspToHtml {

	/**
	 * @param filePath
	 * @param HtmlFile
	 * @param name
	 * @param version
	 * @param date
	 * @param android
	 * @param apple
	 * @param bundleId
	 * @return 苹果下载
	 */
	public static void xmlFile(String filePath, String XmlFile,String applepkgurl,String applepkgimgurl,String applepkgid,String appleversion,String storename) {
		String str = "";
		try {
			
			String tempStr = "";
			FileInputStream is = new FileInputStream(filePath);// 读取模块文件
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			while ((tempStr = br.readLine()) != null)
				str = str + tempStr;
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			/*替换掉模块中相应的地方 */
			  str = str.replaceAll("@applepkgurl", applepkgurl); 
		      str = str.replaceAll("@applepkgimgurl", applepkgimgurl);
		      str = str.replaceAll("@applepkgid", applepkgid);
		      str = str.replaceAll("@appleversion", appleversion);
		      str = str.replaceAll("@storename", storename);

		      try {
					outputFile(XmlFile,str);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	/**
	 * 根据本地模板生成静态页面
	 * 
	 * @param JspFile
	 *            jsp路经
	 * @param HtmlFile
	 *            html路经
	 * @return
	 * @throws Exception 
	 */
	public static void JspToHtmlFile(String filePath, String HtmlFile,String androidVersion,String appleVersion,String androidDate,String appleDate,String android,String apple,String bundleId) {
		String str = "";
		try {
			
			
			String tempStr = "";
			FileInputStream is = new FileInputStream(filePath);// 读取模块文件
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			while ((tempStr = br.readLine()) != null)
				str = str + tempStr;
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

			/*替换掉模块中相应的地方 */
		      str = str.replaceAll("###appleVersion###", appleVersion); 
		      str = str.replaceAll("###androidVersion###", androidVersion); 
		      str = str.replaceAll("###appleDate###", appleDate);
		      str = str.replaceAll("###androidDate###", androidDate);
		      str = str.replaceAll("###android###", android);
		      str = str.replaceAll("###apple###", apple);
		      str = str.replaceAll("###bundleId###", bundleId);

		      try {
				outputFile(HtmlFile,str);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * 根据url生成静态页面
	 * 
	 * @param u
	 *            动态文件路经 如：http://www.163.com/x.jsp
	 * @param path
	 *            文件存放路经如：x:\\abc\bbb.html
	 * @return
	 */
	public static boolean JspToHtmlByURL(String u, String path) {
		// 从utl中读取html存为str
		String str = "";
		try {
			URL url = new URL(u);
			URLConnection uc = url.openConnection();
			InputStream is = uc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while (br.ready()) {
				str += br.readLine() + "\n";

			}
			is.close();
			// 写入文件
			File f = new File(path);
			BufferedWriter o = new BufferedWriter(new FileWriter(f));
			o.write(str);
			o.close();
			str = "";
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void outputFile(String targetFilePath,String content) throws Exception{
		File targetfile = new File(targetFilePath);
		BufferedOutputStream outputStream = null;
		try{
			outputStream = new 
			BufferedOutputStream(FileUtils.openOutputStream(targetfile));
			outputStream.write(content.getBytes("UTF-8"));
			outputStream.flush();
		}
		finally{
			IOUtils.closeQuietly(outputStream);
		}
	}

	/**
	 * 根据url生成静态页面
	 * 
	 * @param url
	 *            动态文件路经 如：http://www.163.com/x.jsp
	 * @return d
	 */
	public static StringBuffer getHtmlTextByURL(String url) {
		// 从utl中读取html存为str
		StringBuffer sb = new StringBuffer();
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			InputStream is = uc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while (br.ready()) {
				sb.append(br.readLine() + "\n");
			}
			is.close();
			return sb;
		} catch (Exception e) {
			e.printStackTrace();
			return sb;
		}
	}

	/**
	 * 测试main 函数
	 * 
	 * @param arg
	 */
	public static void main(String[] arg) {
		long begin = System.currentTimeMillis();
		
		String bb="bbbbbbbb";
		String cc="cccccccc";
		String dd="dddddddd";
		String ee="eeeeeeee";
		String ff="ffffffff";
		String gg="gggggggg";
		String hh="hhhhhhhh";
		
		
		String url = "d:\\formwork.htm";// 模板文件地址
		String savepath = "d:\\360WiFi\\111\\222\\7.html";// 生成文件地址
//		String filePath = "D:\\online\\appleolinstall.xml";// 模板文件地址
//		String savepath = "D:\\online\\appleo.xml";// 生成文件地址
		
		 File   file = new File(savepath);  
		    // 路径为文件且不为空则进行删除  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		    }  
		
//		xmlFile(filePath, savepath,aa,bb,cc,dd,ee);
			JspToHtmlFile(url, savepath,bb,cc,dd,ee,ff,gg,hh);
		System.out.println("用时:" + (System.currentTimeMillis() - begin) + "ms");
	}

}
