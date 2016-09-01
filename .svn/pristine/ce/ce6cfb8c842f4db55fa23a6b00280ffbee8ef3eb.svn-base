package com.etaoguan.wea.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.ICustDao;
import com.etaoguan.wea.service.IAccessAuthService;
import com.etaoguan.wea.service.ICustService;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IOrderService;
import com.etaoguan.wea.vo.Customer;

@Service("custService")
public class CustService extends BaseService implements ICustService {

	@Autowired
	private ICustDao iCustDao;
	
	@Resource(name="orderService") 
	private IOrderService  iOrderService;
	
	@Resource(name="custKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	
	@Resource(name="accessAuthService") 
	private IAccessAuthService iAccessAuthService;
	
	@Override
	public void addCust(Customer cust) {
		cust.setCreateBy(getCurrentOperator());
		cust.setUpdateBy(getCurrentOperator());
		String custNum = iKeyGenService.saveNGetKey();
		cust.setCustNum(custNum);
		iCustDao.addCust(cust);
	}

	@Override
	public boolean isActiveCust(String custNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("delFlag", 1);
		dataCriteria.setParam("custNum", custNum);
		Customer cust = iCustDao.geCust(dataCriteria);
		if(cust==null)
			return true;
		else
			return false;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listCusts(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		dataCriteria.setParam("delFlag", 0);
		return iCustDao.getCustDataSet(dataCriteria, offsetRequest);
	}

	@Override
	public void updateCust(Customer cust) {
		cust.setUpdateBy(getCurrentOperator());
		iCustDao.updateCust(cust);
	}

	@Override
	public void updateCust2delStatus(String custNum) {
	
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum", custNum);
		dataCriteria.setParam("delFlag", 1);
		iCustDao.updateCust(dataCriteria);
	}

	@Override
	public void updateCustKeyLevel(String custNum, int keyLevel) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum", custNum);
		dataCriteria.setParam("keyLevel", keyLevel);
		iCustDao.updateCust(dataCriteria);

	}

	@Override
	public void updateCustLoginDate(String custNum, Date loginDate) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum", custNum);
		dataCriteria.setParam("loginDate", loginDate);
		dataCriteria.setParam("updateBy", getCurrentOperator());
		iCustDao.updateCust(dataCriteria);
	}

	@Override
	public void updateCustPwd(String custNum,String custNewPwd) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum", custNum);
		dataCriteria.setParam("password", custNewPwd);
		dataCriteria.setParam("updateBy", getCurrentOperator());
		iCustDao.updateCust(dataCriteria);

	}

	@Override
	public Customer getLoginCust(String ownerNum,String custName, String password) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("password", password);
		dataCriteria.setParam("custName", custName);
		dataCriteria.setParam("ownerNum", ownerNum);
		Customer customer = iCustDao.geLoginCust(dataCriteria);
		if(customer!=null){
			customer.setAccessOperationList(iAccessAuthService.getCustAccessOperationsByRole());
		}
		return customer;
	}

	@Override
	public Customer getCust(String custNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNum", custNum);
		return iCustDao.geCust(dataCriteria);
	}

	@Override
	public Customer getCustByCustName(String ownerNum,String custName) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custName", custName);
		dataCriteria.setParam("ownerNum", ownerNum);
		return iCustDao.geCust(dataCriteria);
	}

	@Override
	public List<Customer> getCusts(String[] custNums) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custNums", custNums);
		return iCustDao.getCusts(dataCriteria);
	}

}
