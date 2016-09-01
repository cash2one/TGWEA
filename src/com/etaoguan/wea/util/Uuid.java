package com.etaoguan.wea.util;

import java.util.UUID;

/**
 * @author cunli 获取java的uuid 返回32位的字符串
 * 
 */
public class Uuid {
	public static String javaUuid() {
		UUID uuid = UUID.randomUUID();

		// 得到对象产生的ID
		String a = uuid.toString();
		// 转换为大写
		a = a.toUpperCase();
		// 替换 -
		a = a.replaceAll("-", "");

		return a;
	}
}
