package com.etaoguan.wea.e688.crawl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

@SuppressWarnings("deprecation")
public class HttpAliClient {

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(HttpAliClient.class);
			
	private static PoolingClientConnectionManager cm;
	private static DefaultHttpClient httpclient;

	public static synchronized DefaultHttpClient getHttpClient(){
		try{
		if(httpclient==null){
			SchemeRegistry schemeRegistry = new SchemeRegistry();
			schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory
					.getSocketFactory()));
			
			TrustManager easyTrustManager = new X509TrustManager() {
				public void checkClientTrusted(
						java.security.cert.X509Certificate[] x509Certificates,
						String s)
						throws java.security.cert.CertificateException {
					// To change body of implemented methods use File | Settings
					// | File Templates.
				}

				public void checkServerTrusted(
						java.security.cert.X509Certificate[] x509Certificates,
						String s)
						throws java.security.cert.CertificateException {
					// To change body of implemented methods use File | Settings
					// | File Templates.
				}

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return new java.security.cert.X509Certificate[0]; // To
																		// change
																		// body
																		// of
																		// implemented
																		// methods
																		// use
																		// File
																		// |
																		// Settings
																		// |
																		// File
																		// Templates.
				}
			};

			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext
					.init(null, new TrustManager[] { easyTrustManager }, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(sslcontext);

			schemeRegistry.register(new Scheme("https", 443, socketFactory));
			cm = new PoolingClientConnectionManager(
					schemeRegistry);
			// 设置连接最大数
			cm.setMaxTotal(64);
			// 设置每个Route的连接最大数
			cm.setDefaultMaxPerRoute(64);
			// 设置指定域的连接最大数
			// HttpHost localhost = new HttpHost("locahost", 80);
			// cm.setMaxPerRoute(new HttpRoute(localhost), 50);
			httpclient = new DefaultHttpClient(cm);
			httpclient.getParams().setParameter("http.socket.timeout", 30000);
			httpclient.getParams().setParameter("http.connection.timeout", 15000);
			httpclient.getParams().setParameter("http.connection-manager.timeout",
					15000L);
		}
		return httpclient;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}
	
	
	public static synchronized void reloadHttpClient(){
		
		shutdown();
		httpclient =null;
		getHttpClient();
	}

	public static void shutdown(){
		if(httpclient!=null){
			httpclient.getConnectionManager().shutdown();
		}
	}
}
