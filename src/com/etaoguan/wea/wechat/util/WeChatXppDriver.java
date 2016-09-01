package com.etaoguan.wea.wechat.util;

import java.io.Writer;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class WeChatXppDriver extends XppDriver{

	protected static String PREFIX_CDATA = "<![CDATA[";
	protected static String SUFFIX_CDATA = "]]>";
	
	@Override
	public HierarchicalStreamWriter createWriter(Writer out) {
		return new PrettyPrintWriter(out) {
			@Override
			protected void writeText(QuickWriter writer, String text) {
					writer.write(PREFIX_CDATA+text+SUFFIX_CDATA);

			}
		};
	};
}
