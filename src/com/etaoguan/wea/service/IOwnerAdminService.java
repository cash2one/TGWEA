package com.etaoguan.wea.service;

import java.util.Date;
import java.util.List;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.vo.OwnerAdmin;

public interface IOwnerAdminService {
	
	/**
	 * @param dataCriteria
	 * @return 检查管理员名字是否有重复
	 */
	public int duplicateCheck(DataCriteria dataCriteria);
	
	/**
	 * @param ownerAdmin 根据id删除管理员
	 */
	public void deleteOwnerAdminService(int adminId);

	@SuppressWarnings("rawtypes")
	public DataSet listOwnerAdmins(DataCriteria dataCriteria,OffsetRequest offsetRequest);
	
	public void addOwnerAdmin(OwnerAdmin ownerAdmin);
	
	public void delOwnerAdmin(int ownerAdminId);
	
	/**
	 * 根据id修改密码
	 * @param ownerAdminId
	 * @param ownerAdminNewPwd
	 */
	public void updateOwnerAdminPwd(int ownerAdminId,String ownerAdminNewPwd);
	
	public void updateOwnerAdminLoginDate(int ownerAdminId,Date loginDate);
	
	public OwnerAdmin getLoginOwnerAdmin(String ownerAdminName, String ownerAdminPwd,String ownerNum);
	
	public OwnerAdmin getOwnerAdmin(int ownerAdminId);
	
	/**
	 * @param ownerNum
	 * @return 根据ownerNum获取管理员列表
	 */
	public List<OwnerAdmin> getOwnerAdminsByOwnerNum(String ownerNum);
	
	public List<OwnerAdmin> getReserveOwnerAdminsByOwnerNum(String ownerNum);
	

}
