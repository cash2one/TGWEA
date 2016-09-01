package com.etaoguan.wea.dao;

import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.vo.OwnerAdmin;

public interface IOwnerAdminDao {
	/**
	 * @param dataCriteria 检查管理员名字是否有重复
	 */
	public int duplicateCheck(DataCriteria dataCriteria); 
	/**
	 * @param dataCriteria 根据id删除管理员
	 */
	public void deleteOwnerAdmin(DataCriteria dataCriteria);

	public OwnerAdmin getOwnerAdmin(DataCriteria dataCriteria);

	public OwnerAdmin getLoginOwnerAdmin(DataCriteria dataCriteria);

	/**
	 * @param dataCriteria 根据id修改密码
	 */
	public void updateOwnerAdmin(DataCriteria dataCriteria);

	public void addOwnerAdmin(OwnerAdmin ownerAdmin);

	/**
	 * @param dataCriteria
	 * @return 根据ownerNum获取管理员列表
	 */
	public List<OwnerAdmin> getOwnerAdmins(DataCriteria dataCriteria);
}
