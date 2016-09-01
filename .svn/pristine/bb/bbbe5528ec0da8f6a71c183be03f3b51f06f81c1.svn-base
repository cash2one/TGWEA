package com.etaoguan.wea.util;


public class AppSessionUtil {
	  private static ThreadLocal<AppSession> AppSessionHodler = new 

      ThreadLocal<AppSession>();
	  
	  
	  public static void remove( ){
		  AppSessionHodler.remove();
		  
	  }
	  
      public static AppSession getAppSession(){
    	  
    	  AppSession appSession = AppSessionHodler.get();
    	  if(appSession==null){
    		  
    		  appSession = new AppSession();
    		  AppSessionHodler.set(appSession);
    	  }
             return appSession;
      }
      
 
	
public static class AppSession{
    	
    	private String operator;
    	
    	public void setOperator(String operator){
    		this.operator = operator;
    	}
    	
    	public String getOperator(){
    		return this.operator;
    	}
 
      }
	
	

}
