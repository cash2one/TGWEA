package com.etaoguan.wea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.dao.ILogDao;
import com.etaoguan.wea.service.ILogService;
import com.etaoguan.wea.vo.OperationLogInfo;

@Service("logService")
public class LogService  extends BaseService implements ILogService{

	@Autowired
	private ILogDao ilogdao;
	
	@Override
	public void addOperationLogInfo(OperationLogInfo operationLogInfo) {
		ilogdao.addOperationLogInfo(operationLogInfo);
		
	}

}
