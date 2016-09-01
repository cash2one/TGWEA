package com.etaoguan.wea.common;

import java.io.PrintWriter;
import java.io.StringWriter;

@SuppressWarnings("serial")
public class WeaException extends RuntimeException{

	public WeaException() {
        super();
    }
    
    public WeaException(String msg) {
        super(msg);
    }
    
    public WeaException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public WeaException(Throwable cause) {
        super(cause);
    }
    
    public String getStackTraceString(){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        this.printStackTrace(pw);
        return sw.toString();
    }
}
