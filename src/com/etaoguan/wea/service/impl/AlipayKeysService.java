package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IAlipayKeysDao;
import com.etaoguan.wea.service.IAlipayKeysService;
import com.etaoguan.wea.vo.AlipayKeys;

/**
 * @author cunli 客户支付宝的key
 *
 */
@Service("alipayKeysService")
public class AlipayKeysService extends BaseService implements IAlipayKeysService{

	@Autowired
	private IAlipayKeysDao iAlipayKeysDao;
	
	/* (non-Javadoc)添加客户支付宝的key
	 * @see com.etaoguan.wea.service.IAlipayKeysService#addAlipayKeys(com.etaoguan.wea.vo.AlipayKeys)
	 */
	@Override
	public void addAlipayKeys(AlipayKeys alipayKeys) {
		iAlipayKeysDao.addAlipayKeys(alipayKeys);
	}

	/* (non-Javadoc)删除客户支付宝的key
	 * @see com.etaoguan.wea.service.IAlipayKeysService#deleteAlipayKeys(int)
	 */
	@Override
	public void deleteAlipayKeys(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		iAlipayKeysDao.deleteAlipayKeys(dataCriteria);
	}

	/* (non-Javadoc)修改客户支付宝的key
	 * @see com.etaoguan.wea.service.IAlipayKeysService#updateAlipaykeys(com.etaoguan.wea.vo.AlipayKeys)
	 */
	@Override
	public void updateAlipaykeys(AlipayKeys alipayKeys) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",alipayKeys.getOwnerNum());
		dataCriteria.setParam("ownerKey",alipayKeys.getOwnerKey());
		dataCriteria.setParam("ownerPartner",alipayKeys.getOwnerPartner());
		dataCriteria.setParam("ownerAccountName",alipayKeys.getOwnerAccountName());
		
		iAlipayKeysDao.updateAlipaykeys(dataCriteria);
		
	}

	/* (non-Javadoc)客户支付宝的key的列表
	 * @see com.etaoguan.wea.service.IAlipayKeysService#alipayKeysDataSet(com.etaoguan.wea.common.DataCriteria, com.etaoguan.wea.common.OffsetRequest)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DataSet alipayKeysDataSet(DataCriteria dataCriteria, OffsetRequest offsetRequest) {
		return iAlipayKeysDao.alipayKeysDataSet(dataCriteria, offsetRequest);
	}

	/* (non-Javadoc) 根据owenrNum 获取用户的partner
	 * @see com.etaoguan.wea.service.IAlipayKeysService#alipayKeysInformation(java.lang.String)
	 */
	@Override
	public AlipayKeys alipayKeysInformation(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iAlipayKeysDao.alipayKeysInformation(dataCriteria);
	}



}
