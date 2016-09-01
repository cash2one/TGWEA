package com.etaoguan.wea.client.web.service.impl;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWGenerateProjectService;
import com.etaoguan.wea.service.impl.GenerateProjectService;
import com.etaoguan.wea.vo.OwnerMobileGeneration;

/**
 * @author cunli 记录生成mobile项目的时间和是否生成
 *
 */
@Service("wgenerateProjectService")
public class WGenerateProjectService extends GenerateProjectService implements IWGenerateProjectService{

	/* (non-Javadoc) 记录生成mobile项目的时间
	 * @see com.etaoguan.wea.client.web.service.IWGenerateProjectService#addWGenerateProject(com.etaoguan.wea.vo.GenerateProject)
	 */
	@Override
	public void addWGenerateProject(OwnerMobileGeneration generateProject) {
		addGenerateProject(generateProject);
	}

	/* (non-Javadoc) 再次生成
	 * @see com.etaoguan.wea.client.web.service.IWGenerateProjectService#updateWGenerateProject(com.etaoguan.wea.vo.OwnerMobileGeneration)
	 */
	@Override
	public void updateWGenerateProject(OwnerMobileGeneration generateProject) {
		updateGenerateProject(generateProject);
	}


}
