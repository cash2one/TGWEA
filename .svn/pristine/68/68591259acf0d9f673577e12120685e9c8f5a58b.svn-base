package com.etaoguan.wea.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IOwnerAdminDao;
import com.etaoguan.wea.service.IAccessAuthService;
import com.etaoguan.wea.service.IOwnerAdminService;
import com.etaoguan.wea.service.IOwnerService;
import com.etaoguan.wea.vo.Owner;
import com.etaoguan.wea.vo.OwnerAdmin;

@Service("ownerAdminService")
public class OwnerAdminService  extends BaseService implements IOwnerAdminService {

	@Autowired
	private IOwnerAdminDao iOwnerAdminDao;
	
	@Resource(name="ownerService") 
	private IOwnerService iOwnerService;
	
	@Resource(name="accessAuthService") 
	private IAccessAuthService iAccessAuthService;
	
	@Override
	public void addOwnerAdmin(OwnerAdmin ownerAdmin) {
		ownerAdmin.setCreateBy(getCurrentOperator());
		ownerAdmin.setUpdateBy(getCurrentOperator());
		iOwnerAdminDao.addOwnerAdmin(ownerAdmin);
	}

	@Override
	public void delOwnerAdmin(int ownerAdminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId", ownerAdminId);


	}

	@Override
	public OwnerAdmin getLoginOwnerAdmin(String ownerAdminName,
			String ownerAdminPwd,
			String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminName", ownerAdminName);
		dataCriteria.setParam("adminPwd", ownerAdminPwd);
		dataCriteria.setParam("ownerNum", ownerNum);
		OwnerAdmin ownerAdmin = iOwnerAdminDao.getLoginOwnerAdmin(dataCriteria);
		if(ownerAdmin!=null){
			ownerAdmin.setAccessOperationList(iAccessAuthService.getOwnerAccessOperationsByRole());
			Owner owner = iOwnerService.getOwner(ownerAdmin.getOwnerNum());
			ownerAdmin.setOwner(owner);
		}
		return ownerAdmin;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listOwnerAdmins(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return null;
	}

	@Override
	public void updateOwnerAdminLoginDate(int ownerAdminId, Date loginDate) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId", ownerAdminId);
		dataCriteria.setParam("loginDate", loginDate);
		dataCriteria.setParam("updateBy", getCurrentOperator());
		iOwnerAdminDao.updateOwnerAdmin(dataCriteria);

	}

	/* (non-Javadoc)根据id修改密码
	 * @see com.etaoguan.wea.service.IOwnerAdminService#updateOwnerAdminPwd(int, java.lang.String)
	 */
	@Override
	public void updateOwnerAdminPwd(int ownerAdminId,
			String ownerAdminNewPwd) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId", ownerAdminId);
		dataCriteria.setParam("adminPwd", ownerAdminNewPwd);
		dataCriteria.setParam("updateBy", getCurrentOperator());
		iOwnerAdminDao.updateOwnerAdmin(dataCriteria);
	}

	@Override
	public OwnerAdmin getOwnerAdmin(int ownerAdminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId", ownerAdminId);
		return iOwnerAdminDao.getOwnerAdmin(dataCriteria);
	}

	/* (non-Javadoc)根据ownerNum获取管理员列表
	 * @see com.etaoguan.wea.service.IOwnerAdminService#getOwnerAdminsByOwnerNum(java.lang.String)
	 */
	@Override
	public List<OwnerAdmin> getOwnerAdminsByOwnerNum(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		return iOwnerAdminDao.getOwnerAdmins(dataCriteria);
	}

	@Override
	public List<OwnerAdmin> getReserveOwnerAdminsByOwnerNum(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		dataCriteria.setParam("reserveFlag", 1);
		return iOwnerAdminDao.getOwnerAdmins(dataCriteria);
	}

	/* (non-Javadoc)根据id删除管理员
	 * @see com.etaoguan.wea.service.IOwnerAdminService#deleteOwnerAdminService(com.etaoguan.wea.vo.OwnerAdmin)
	 */
	@Override
	public void deleteOwnerAdminService(int adminId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("adminId", adminId);
		iOwnerAdminDao.deleteOwnerAdmin(dataCriteria);
		
	}

	/* (non-Javadoc)检查管理员名字是否有重复
	 * @see com.etaoguan.wea.service.IOwnerAdminService#duplicateCheck(com.etaoguan.wea.common.DataCriteria)
	 */
	@Override
	public int duplicateCheck(DataCriteria dataCriteria) {
		return iOwnerAdminDao.duplicateCheck(dataCriteria);
	}

}
