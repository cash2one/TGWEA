package com.etaoguan.wea.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.etaoguan.wea.client.vo.SortParam;

public class DataCriteria {

	public static String LOWERTHAN="&lt;";
	public static String GREATERTHAN="&gt;";
	public static String LOWEREQUALTHAN="&lt;=";
	public static String GREATEREQUALTHAN="&gt;=";
	
	public static String ASC="asc";
	public static String DESC="desc";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<String,Object> paramMap=new HashMap();
	
	public void setParam(String paramName,Object paramValue){
			paramMap.put(paramName, paramValue);

	}
	public void removeParam(String paramName){

		paramMap.remove(paramName);

	}
	
	public void setASCOrderParam(String paramName){
		
		paramMap.put(ASC, paramName);
	}
	
	public void setDESCOrderParam(String paramName){
		
		paramMap.put(DESC, paramName);
	}

	public void setClause(String clause){
		
		paramMap.put("definesql", clause);
	}
	
	public Map<String,Object> getParams(){
		return this.paramMap;
	}
	
	public void clearParams(){
		paramMap.clear();
	}
	
	public void extractSortParam(SortParam sortParam){
		
		if(sortParam!=null&&StringUtils.isNotEmpty(sortParam.getSortBy())){
			if("asc".equalsIgnoreCase(sortParam.getSortType())){
				setASCOrderParam(sortParam.getSortBy());
			}
			
			if("desc".equalsIgnoreCase(sortParam.getSortType())){
				setDESCOrderParam(sortParam.getSortBy());
			}
		}
		
	}
	
	public static DataCriteria parseObjProp2Params(Object object){
		DataCriteria criteria = new DataCriteria();
		String[] fields = getFiledName(object);
		for(String field:fields){
			criteria.setParam(field, getFieldValueByName(field,object));
		}
		return criteria;
	}
	
	/**  
	* 获取对象属性，返回一个字符串数组      
	*   
	* @param  o 对象  
	* @return String[] 字符串数组  
	*/  
	private static String[] getFiledName(Object o)   
	{     
	try    
	{   
	Object[] fields = o.getClass().getDeclaredFields(); 
	if(o.getClass().getSuperclass()!=null){
		fields = ArrayUtils.addAll(fields, o.getClass().getSuperclass().getDeclaredFields());
	}

	String[] fieldNames = new String[fields.length];     
	for (int i=0; i < fields.length; i++)   
	{     
	    fieldNames[i] = ((Field) fields[i]).getName();     
	}     
	return fieldNames;   
	} catch (SecurityException e)    
	{   
	e.printStackTrace();   
	System.out.println(e.toString());   
	}   
	    return null;   
	}     
	  
	/**  
	* 使用反射根据属性名称获取属性值   
	*   
	* @param  fieldName 属性名称  
	* @param  o 操作对象  
	* @return Object 属性值  
	*/  
	  
	private static Object getFieldValueByName(String fieldName, Object o)    
	{       
	   try    
	   {       
	       String firstLetter = fieldName.substring(0, 1).toUpperCase();       
	       String getter = "get" + firstLetter + fieldName.substring(1);       
	       Method method = o.getClass().getMethod(getter, new Class[] {});       
	       Object value = method.invoke(o, new Object[] {});       
	       return value;       
	   } catch (Exception e)    
	   {       
	       System.out.println("属性不存在");       
	       return null;       
	   }       
	}     


}
