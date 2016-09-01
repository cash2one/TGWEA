package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.dao.IGenerateProjectDao;
import com.etaoguan.wea.service.IGenerateProjectService;
import com.etaoguan.wea.vo.OwnerMobileGeneration;

/**
 * @author cunli 记录生成mobile项目的时间和是否生成
 *
 */
@Service("generateProjectService")
public class GenerateProjectService extends BaseService implements IGenerateProjectService {

	@Autowired
	private IGenerateProjectDao iGenerateProjectDao;

	/* (non-Javadoc)记录生成mobile项目的时间
	 * @see com.etaoguan.wea.service.IGenerateProjectService#addGenerateProject(com.etaoguan.wea.vo.GenerateProject)
	 */
	@Override
	public void addGenerateProject(OwnerMobileGeneration generateProject) {
		iGenerateProjectDao.addGenerateProject(generateProject);
	}

	/* (non-Javadoc) 再次生成
	 * @see com.etaoguan.wea.service.IGenerateProjectService#updateGenerateProject(com.etaoguan.wea.vo.OwnerMobileGeneration)
	 */
	@Override
	public void updateGenerateProject(OwnerMobileGeneration generateProject) {
		iGenerateProjectDao.updateGenerateProject(generateProject);
	}
	

}
