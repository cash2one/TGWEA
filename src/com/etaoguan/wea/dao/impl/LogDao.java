package com.etaoguan.wea.dao.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.etaoguan.wea.dao.ILogDao;
import com.etaoguan.wea.vo.OperationLogInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class LogDao  extends SpringBaseDao implements ILogDao{

	@Override
	@Resource(name="logSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addOperationLogInfo(OperationLogInfo operationLogInfo) {
		
		this.getSqlMapClientTemplate().insert("createOperationLogInfo", operationLogInfo);
	}

}
