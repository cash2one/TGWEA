package com.etaoguan.wea.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang.StringUtils;

public class ExceptionUtil {

	public static String getStackTrace(Throwable exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		return sw.toString();
	}
	
	public static String getStackTrace(Throwable exception, int stackLen) {
		
		String stackTrace = getStackTrace(exception);

        if (stackTrace.length()>stackLen){
        	stackTrace = stackTrace.substring(0,stackLen);
        }
        
		return stackTrace;
	}
	
	public static String getExMessage(Throwable ex){
		String message = ex.getMessage();
		if(StringUtils.isEmpty(message)){
			message = ex.toString();
		}
		return message;
	}
}
