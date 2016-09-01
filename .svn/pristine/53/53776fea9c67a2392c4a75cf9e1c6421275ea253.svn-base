package com.etaoguan.wea.wechat.util;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.wechat.vo.EventReceivedMsg;
import com.etaoguan.wea.wechat.vo.InboundRequest;
import com.etaoguan.wea.wechat.vo.MsgMetaData;
import com.etaoguan.wea.wechat.vo.MusicSendMsg;
import com.etaoguan.wea.wechat.vo.NewsSendMsg;
import com.etaoguan.wea.wechat.vo.ReceivedMsg;
import com.etaoguan.wea.wechat.vo.SendMsg;
import com.etaoguan.wea.wechat.vo.TextReceivedMsg;
import com.etaoguan.wea.wechat.vo.TextSendMsg;
import com.etaoguan.wea.wechat.vo.TransCustSvrSendMsg;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class WeChatUtil {

	private final static Log logger = LogFactory.getLog(WeChatUtil.class);
	
	public static boolean isWeChatRequest(InboundRequest inboundRequest) {
		boolean isValid = false;
		try {
			String[] inputArray = new String[3];
			inputArray[0] = inboundRequest.getToken();
			logger.info(inboundRequest.getToken());
			inputArray[1] = inboundRequest.getTimestamp();
			logger.info(inboundRequest.getTimestamp());
			inputArray[2] = inboundRequest.getNonce();
			Arrays.sort(inputArray);
			String inputCode = "";
			for (int i = 0; i < inputArray.length; i++) {
				inputCode = inputCode + inputArray[i];
			}
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] bt = inputCode.getBytes("UTF-8");
			md.update(bt);
			String encryptCode = bytes2HexString(md.digest());
			if (inboundRequest.getSignature().equalsIgnoreCase(encryptCode)) {
				isValid = true;
			}
			logger.info("signature = " + inboundRequest.getSignature());
			logger.info("encryptcode = " + encryptCode);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isValid;
	}

	@SuppressWarnings("rawtypes")
	private static String[] getFieldName(Class clazz) {
		try {
			Field[] fields = clazz.getDeclaredFields();
			if (clazz.getSuperclass() != null) {
				fields = ArrayUtils.addAll(fields, clazz
						.getSuperclass().getDeclaredFields());
			}

			String[] fieldNames = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				fieldNames[i] = fields[i].getName();
			}
			return fieldNames;
		} catch (SecurityException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return null;
	}
	
	public static MsgMetaData getReceivedMsgType(String xml){
		
		return parseMsgType(xml);

	}

	@SuppressWarnings("rawtypes")
	public static EventReceivedMsg parseWeChatEventReceivedMsg(String xml) {
		Class clazz = EventReceivedMsg.class;
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", clazz);
		String[] fields = getFieldName(clazz);
		for (String field : fields) {
			String alias = field.substring(0, 1).toUpperCase()
			+ field.substring(1);
			xstream.aliasField(alias, clazz, field);
		}
		return (EventReceivedMsg) xstream.fromXML(xml);
		
	}
	@SuppressWarnings("rawtypes")
	public static ReceivedMsg parseWeChatReceivedMsg(String xml) {
		Class clazz = TextReceivedMsg.class;
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", clazz);
		String[] fields = getFieldName(clazz);
		for (String field : fields) {
			String alias = field.substring(0, 1).toUpperCase()
					+ field.substring(1);
			xstream.aliasField(alias, clazz, field);
		}
		return (ReceivedMsg) xstream.fromXML(xml);

	}

	@SuppressWarnings("rawtypes")
	public static String buildWeChatSendMsg(SendMsg sendMsg) {
		
		String sendMsgStr = "";
		Class clazz = TextSendMsg.class;
		XStream xstream = new XStream(new WeChatXppDriver());
		if (WeaConstant.WECHAT_MSGTYPE_TEXT.equalsIgnoreCase(sendMsg.getMsgType())) {
			clazz = TextSendMsg.class;
		}else if (WeaConstant.WECHAT_MSGTYPE_MUSIC.equalsIgnoreCase(sendMsg.getMsgType())) {
			clazz = MusicSendMsg.class;
			Class musicClazz = MusicSendMsg.Music.class;
			xstream.alias("Music", musicClazz);
			String[] musicFields = getFieldName(musicClazz);
			for (String field : musicFields) {
				String alias = field.substring(0, 1).toUpperCase()
						+ field.substring(1);
				xstream.aliasField(alias, musicClazz, field);
			}
		}else if (WeaConstant.WECHAT_MSGTYPE_NEWS.equalsIgnoreCase(sendMsg.getMsgType())) {
			clazz = NewsSendMsg.class;
			Class itemClazz = NewsSendMsg.Item.class;
			xstream.alias("item", itemClazz);
			String[] itemFields = getFieldName(itemClazz);
			for (String field : itemFields) {
				String alias = field.substring(0, 1).toUpperCase()
						+ field.substring(1);
				xstream.aliasField(alias, itemClazz, field);
			}
		}else if (WeaConstant.WECHAT_MSGTYPE_TRANSFER_CUSTOMER_SERVICE.equalsIgnoreCase(sendMsg.getMsgType())) {
			clazz = TransCustSvrSendMsg.class;
		}
		xstream.alias("xml", clazz);
		String[] fields = getFieldName(clazz);
		for (String field : fields) {
			String alias = field.substring(0, 1).toUpperCase()
					+ field.substring(1);
			xstream.aliasField(alias, clazz, field);
		}
		sendMsgStr = xstream.toXML(sendMsg);
		return sendMsgStr;
	}

	/**
	 * @param xmlStr
	 * @return 解析微信接受到的xml
	 */
	@SuppressWarnings("unused")
	public static MsgMetaData parseMsgType(String xmlStr) {
		MsgMetaData msgMetaData = new MsgMetaData();
		// 字符串转XML
		String msgType = "",fromUserName="",msgId="",content="";
		try {
			xmlStr = new String(xmlStr.getBytes(), "gb2312");
			StringReader sr = new StringReader(xmlStr);
			InputSource is = new InputSource(sr);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			XPathFactory xfactory = XPathFactory.newInstance();
			XPath xpath = xfactory.newXPath();

			XPathExpression msgPath = xpath.compile("//xml/MsgType");
			msgType = (String) msgPath.evaluate(doc, XPathConstants.STRING);
			
			msgPath = xpath.compile("//xml/FromUserName");
			fromUserName = (String) msgPath.evaluate(doc, XPathConstants.STRING);
			
			msgPath = xpath.compile("//xml/MsgId");
			msgId = (String) msgPath.evaluate(doc, XPathConstants.STRING);
			
			msgMetaData.setMsgType(msgType);
			msgMetaData.setMsgId(msgId);
			msgMetaData.setFromUserName(fromUserName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msgMetaData;
	}

	public static String bytes2HexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex;
		}
		return ret;
	}
}
