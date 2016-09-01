package com.etaoguan.wea.e688.crawl;

import org.apache.http.Header;

public class HttpAliResponse {

	private int StatusCode;
	private String responseHTML;
	private byte[] responeBytes;
	private Header[] responseHeaders;
	
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public String getResponseHTML() {
		return responseHTML;
	}
	public void setResponseHTML(String responseHTML) {
		this.responseHTML = responseHTML;
	}
	public byte[] getResponeBytes() {
		return responeBytes;
	}
	public void setResponeBytes(byte[] responeBytes) {
		this.responeBytes = responeBytes;
	}
	public Header[] getResponseHeaders() {
		return responseHeaders;
	}
	public String getResponseHeader(String headerName) {
		for(Header header:responseHeaders){
			if(header.getName().equalsIgnoreCase(headerName)){
				return header.getValue();
			}
		}
		
		return "";
	}
	public void setResponseHeaders(Header[] responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
}
