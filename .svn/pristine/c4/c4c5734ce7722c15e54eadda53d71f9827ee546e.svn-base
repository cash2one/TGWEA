package com.etaoguan.wea.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

public class CglibBean {
	/**
	 * 实体Object
	 */
	public Object object = null;

	/**
	 * 属�?map
	 */
	public BeanMap beanMap = null;

	public CglibBean() {
		super();
	}

	@SuppressWarnings("rawtypes")
	public CglibBean(Map propertyMap) {
		this.object = generateBean(propertyMap);
		this.beanMap = BeanMap.create(this.object);
	}

	/**
	 * 给bean属�?赋�?
	 * 
	 * @param property
	 *            属�?�?
	 * @param value
	 *            �?
	 */
	public void setValue(String property, Object value) {
		beanMap.put(property, value);
	}

	/**
	 * 通过属�?名得到属性�?
	 * 
	 * @param property
	 *            属�?�?
	 * @return �?
	 */
	public Object getValue(String property) {
		return beanMap.get(property);
	}

	/**
	 * 得到该实体bean对象
	 * 
	 * @return
	 */
	public Object getObject() {
		return this.object;
	}

	@SuppressWarnings({"rawtypes" })
	private Object generateBean(Map propertyMap) {
		BeanGenerator generator = new BeanGenerator();
		Set keySet = propertyMap.keySet();
		for (Iterator i = keySet.iterator(); i.hasNext();) {
			String key = (String) i.next();
			generator.addProperty(key, (Class) propertyMap.get(key));
		}
		return generator.create();
	}
}