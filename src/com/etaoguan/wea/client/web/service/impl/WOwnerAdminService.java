package com.etaoguan.wea.client.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWOwnerAdminService;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.service.impl.OwnerAdminService;
import com.etaoguan.wea.vo.OwnerAdmin;

@Service("wownerAdminService")
public class WOwnerAdminService extends OwnerAdminService implements IWOwnerAdminService{

	@Override
	public void saveInitOwnerAdmin(String ownerNum) {
		List<OwnerAdmin> ownerAdmins = getReserveOwnerAdminsByOwnerNum(ownerNum);
		if(ownerAdmins.size()==0){
			OwnerAdmin ownerAdmin = new OwnerAdmin();
			ownerAdmin.setAdminName(ownerNum);
			ownerAdmin.setAdminPwd(WeaConstant.DEFAULT_OWNERADMINPWD);
			ownerAdmin.setOwnerNum(ownerNum);
			ownerAdmin.setReserveFlag(1);
			addOwnerAdmin(ownerAdmin);
		}else{
			for(OwnerAdmin ownerAdmin:ownerAdmins){
				updateOwnerAdminPwd(ownerAdmin.getAdminId(), WeaConstant.DEFAULT_OWNERADMINPWD);
			}
		}
	}

	/* (non-Javadoc)根据 ownerNum 和 adminName 检查管理员名字是否有重复
	 * @see com.etaoguan.wea.client.web.service.IWOwnerAdminService#duplicateCheck(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean duplicateCheck(String ownerNum, String adminName) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		dataCriteria.setParam("adminName", adminName);
		int dcheck = duplicateCheck(dataCriteria);
		if (dcheck > 0) {
			return true;
		}
		return false;
	}


}
