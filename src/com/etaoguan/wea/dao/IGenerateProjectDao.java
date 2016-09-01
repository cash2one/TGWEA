package com.etaoguan.wea.dao;

import com.etaoguan.wea.vo.OwnerMobileGeneration;

/**
 * @author cunli
 * 记录生成mobile项目的时间和是否生成
 */
public interface IGenerateProjectDao {
	
	
	/**
	 * @param generateProject 记录生成mobile项目的时间
	 */
	public void addGenerateProject(OwnerMobileGeneration generateProject);
	/**
	 * @param generateProject 再次生成
	 */
	public void updateGenerateProject(OwnerMobileGeneration generateProject);

	
}
