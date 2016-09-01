package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IWechatKeysDao;
import com.etaoguan.wea.service.IWechatKeysService;
import com.etaoguan.wea.vo.WechatKeys;

@Service("wechatKeysService")
public class WechatKeysService extends BaseService implements IWechatKeysService{

	@Autowired
	IWechatKeysDao iWechatKeysDao;

	@Override
	public void addWechatKeys(WechatKeys wechatKeys) {
		wechatKeys.setCreateBy(getCurrentOperator());
		wechatKeys.setUpdateBy(getCurrentOperator());
		iWechatKeysDao.addWechatKeys(wechatKeys);
		
	}

	@Override
	public void delWechatKeys(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		iWechatKeysDao.delWechatKeys(dataCriteria);
		
	}

	@Override
	public WechatKeys getWechatKeys(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iWechatKeysDao.getWechatKeys(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listWechatKeys(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		
		return iWechatKeysDao.getWechatKeysDataSet(dataCriteria, offsetRequest);
	}

	@Override
	public void updateWechatKeys(WechatKeys wechatKeys) {
		wechatKeys.setUpdateBy(getCurrentOperator());
		iWechatKeysDao.updateWechatKeys(wechatKeys);
		
	}


}
