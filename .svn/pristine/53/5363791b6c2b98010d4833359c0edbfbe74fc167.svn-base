package com.etaoguan.wea.client.web.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWWareHouseService;
import com.etaoguan.wea.service.impl.WareHouseService;
import com.etaoguan.wea.vo.WareHouse;

@Service("wwareHouseService")
public class WWareHouseService extends WareHouseService implements IWWareHouseService{

	@Override
	public void saveOrUpdateProduct(WareHouse wareHouse) {
		if(StringUtils.isEmpty(wareHouse.getWhNum())){
			addWareHouse(wareHouse);
		}else{
			updateWareHouse(wareHouse);
		}	
	}

}
