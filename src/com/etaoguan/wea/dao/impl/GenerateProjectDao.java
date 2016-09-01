package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.etaoguan.wea.dao.IGenerateProjectDao;
import com.etaoguan.wea.vo.OwnerMobileGeneration;
import com.ibatis.sqlmap.client.SqlMapClient;


/**
 * @author cunli 记录生成mobile项目的时间和是否生成
 *
 */
@Repository
public class GenerateProjectDao extends SpringBaseDao implements IGenerateProjectDao{

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory.getLog(GenerateProjectDao.class);
			
	@Override
	@Resource(name="generateProjectSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	/* (non-Javadoc) 记录生成mobile项目的时间
	 * @see com.etaoguan.wea.dao.IGenerateProjectDao#addGenerateProject(com.etaoguan.wea.vo.GenerateProject)
	 */
	@Override
	public void addGenerateProject(OwnerMobileGeneration generateProject) {
		this.getSqlMapClientTemplate().insert("addGenerateProject", generateProject);
	}

	/* (non-Javadoc) 再次生成
	 * @see com.etaoguan.wea.dao.IGenerateProjectDao#updateGenerateProject(com.etaoguan.wea.vo.OwnerMobileGeneration)
	 */
	@Override
	public void updateGenerateProject(OwnerMobileGeneration generateProject) {
		this.getSqlMapClientTemplate().update("updateGenerateProject", generateProject);
		
	}

}
