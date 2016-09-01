package com.etaoguan.wea.client.action;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class StaticHtml {

	private final static String ajaxInterceptJs = "(function(XHR) { "
			+ "var open = XHR.prototype.open;"
			+ "var send = XHR.prototype.send;"
			+ "%s"
			+ "XHR.prototype.open = function(method, url, async, user, pass) {"
			+ "    this._url = url;"
			+ "    open.call(this, method, url, async, user, pass);" 
			+ "};"
			+ "XHR.prototype.send = function(data) {" 
			+ "	if(XHR[this._url]){"
			+ "		this.abort() ;" 
			+ "		delete XHR[this._url] ;" 
			+ "		return  ;"
			+ "	}" + "	send.call(this, data);" + "}" 
			+ "})(XMLHttpRequest);";

	public void process(String dynamicUrl, String staticPath)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {

		final WebClient webClient = new WebClient();
		
		LogAjaxController logAjaxController = new LogAjaxController();

		webClient.setAjaxController(logAjaxController);
		final HtmlPage page = webClient.getPage(dynamicUrl);

		List<String> ajaxRequests = logAjaxController.getAjaxRequests();
		
		String htmlContent = page.asXml();
		
		
		Document document = Jsoup.parse(htmlContent);
		String whitelistStr = document.body().attr("whitelist");
		if (ajaxRequests.size() > 0  && whitelistStr != null) {
			String[] whitelist = whitelistStr.split(",");
			List<String> list = new ArrayList<String>();
			for (String url : ajaxRequests) {
				boolean find = false;
				for (String wlUrl : whitelist) {
					if (url.indexOf(wlUrl) != -1) {
						find = true;
						break;
					}
				}

				if (!find) {
					list.add(url);
				}
			}

			ajaxRequests = list;

		}
		
		if( ajaxRequests.size() > 0 ){
			
			Element script = new Element(Tag.valueOf("script"), "");
			script.attr("type", "text/javascript");
			
			StringBuilder sb  = new StringBuilder() ;
			
			for(String url : ajaxRequests ){
				sb.append("XHR['").append(url).append("']=true;") ;
			}
			
			script.text( String.format(ajaxInterceptJs, sb.toString()) ) ;
			document.head().prependChild(script);
			
		}


		
		FileUtils.writeStringToFile(new File(staticPath), document.html() ,"utf-8");

		webClient.closeAllWindows();

	}

	@SuppressWarnings("serial")
	static class LogAjaxController extends NicelyResynchronizingAjaxController {
		private List<String> ajaxRequests = new ArrayList<String>();

		@Override
		public boolean processSynchron(HtmlPage page, WebRequest settings,
				boolean async) {
			ajaxRequests.add(settings.getUrl().getPath());
			return super.processSynchron(page, settings, async);
		}

		public List<String> getAjaxRequests() {
			return Collections.unmodifiableList(ajaxRequests);
		}
	}

}
