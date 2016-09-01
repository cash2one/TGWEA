package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.vo.AndroidSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IAndroidVersionDao;
import com.etaoguan.wea.service.IAddAndroidversionService;
import com.etaoguan.wea.vo.AppAndroidVersion;

/**
 * @author cunli
 * 安卓版本 业务接口实现类
 */
@Service("addAndroidversionService")
public class AddAndroidversionService extends BaseService implements IAddAndroidversionService{

	@Autowired
	private IAndroidVersionDao iAndroidVersionDao;

	/* (non-Javadoc)添加安卓版本信息
	 * @see com.etaoguan.wea.service.IAddAndroidversionService#addandroidversion(com.etaoguan.wea.vo.AppAndroidVersion)
	 */
	@Override
	public void addandroidversion(AppAndroidVersion appAndroidVersion) {
		appAndroidVersion.setCreateBy(getCurrentOperator());
		iAndroidVersionDao.addandroidversion(appAndroidVersion);
		
	}

	/* (non-Javadoc)删除安卓版本信息
	 * @see com.etaoguan.wea.service.IAddAndroidversionService#delandroidversoin(com.etaoguan.wea.vo.AppAndroidVersion)
	 */
	@Override
	public void delandroidversoin(int versionId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("versionId",versionId);
		iAndroidVersionDao.delandroidversoin(dataCriteria);
		
	}

	/* (non-Javadoc)修改安卓版本信息
	 * @see com.etaoguan.wea.service.IAddAndroidversionService#updateandroidversoin(com.etaoguan.wea.vo.AppAndroidVersion)
	 */
	@Override
	public void updateandroidversoin(AppAndroidVersion appAndroidVersion) {
		appAndroidVersion.setUpdateBy(getCurrentOperator());
		iAndroidVersionDao.updateandroidversoin(appAndroidVersion);
		
	}

	/* (non-Javadoc)查看所有安卓版本信息
	 * @see com.etaoguan.wea.service.IAddAndroidversionService#getAndroidvs()
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public WPage getAndroidvs(AndroidSearch androidSearch,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("companyName", androidSearch.getCompanyName());

		DataSet dataSet = iAndroidVersionDao.getAndroidvs(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
		
	}

	/* (non-Javadoc) 更新版本信息之前的初始化信息
	 * @see com.etaoguan.wea.service.IAddAndroidversionService#getAndrodivsbyId(int)
	 */
	@Override
	public AppAndroidVersion getAndrodivsbyId(AppAndroidVersion androidVersion) {
			DataCriteria dataCriteria = new DataCriteria();
			dataCriteria.setParam("versionId",androidVersion.getVersionId());
			dataCriteria.setParam("ownerNum", androidVersion.getOwnerNum());
			return iAndroidVersionDao.getAndroidvsbyId(dataCriteria);
	}

	/* (non-Javadoc)获得最大的安卓版本号
	 * @see com.etaoguan.wea.service.IAddAndroidversionService#getMaxVersionNumService()
	 */
	@Override
	public int getMaxVersionNumService(AppAndroidVersion androidVersion) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", androidVersion.getOwnerNum());
		return iAndroidVersionDao.getMaxVersionNum(dataCriteria);
	}

	/* (non-Javadoc)获取同一个公司的最大版本号，确定是否更新
	 * @see com.etaoguan.wea.service.IAddAndroidversionService#getMaxvstoUpdate(int, int)
	 */
	@Override
	public boolean getMaxvstoUpdate(String ownerNum, int versionNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		int maxVersionNum =	iAndroidVersionDao.getMaxVersionNum(dataCriteria);
		if (maxVersionNum > versionNum) {
			return true;
		}
		return false;
	}
	
}
