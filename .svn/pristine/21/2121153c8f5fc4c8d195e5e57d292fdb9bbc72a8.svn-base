package com.etaoguan.wea.client.mobile.action;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ParameterAware;

import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.vo.OwnerAdmin;

public class MOwnerBaseAction extends MBaseAction implements ParameterAware{

	private static final long serialVersionUID = 5536361461768866104L;
	
	protected String ownerNum;
	
	@Override
	public void setParameters(Map<String, String[]> params) {
		
		
		String[] shopNums = params.get(WeaConstant.CLIENTSHOPNUM);
		String relateOwnerNum = "";
		if(shopNums==null||StringUtils.isEmpty(shopNums[0])
				||(relateOwnerNum = WeaDataCache.getCache().getOwnerShopNumMap().get(shopNums[0]))==null){
			throw new WeaException("无效访问请求");
		}

		OwnerAdmin ownerAdmin = getCurrentOwnerAdmin();
		if(ownerAdmin!=null&&!relateOwnerNum.equals(ownerAdmin.getOwnerNum())){
			removeSessionAttribute(WeaConstant.CUROWNERADMIN);
			throw new WeaException("非法访问参数");
		}

		ownerNum = relateOwnerNum;
		
	}


}
