package com.etaoguan.wea.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.dao.IWareHouseDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IProdStockService;
import com.etaoguan.wea.service.IWareHouseService;
import com.etaoguan.wea.vo.WareHouse;

@Service("wareHouseService")
public class WareHouseService  extends BaseService implements IWareHouseService {

	@Autowired
	private IWareHouseDao iWareHouseDao;
	
	@Resource(name="prodStockService") 
	IProdStockService iProdStockService;
	
	@Resource(name="wareHouseKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Override
	public void addWareHouse(WareHouse wareHouse) {
		String whNum = iKeyGenService.saveNGetKey();
		wareHouse.setWhNum(whNum);
		wareHouse.setCreateBy(getCurrentOperator());
		wareHouse.setUpdateBy(getCurrentOperator());
		iWareHouseDao.addWareHouse(wareHouse);

	}

	@Override
	public void delWareHouse(String whNum,String ownerNum) {
		if(iProdStockService.existsProdStock(whNum, ownerNum)){
			throw new WeaException("仓库存在产品");
		}
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("whNum",whNum);
		dataCriteria.setParam("ownerNum",ownerNum);
		iWareHouseDao.delWareHouse(dataCriteria);
	}

	@Override
	public List<WareHouse> getAllWarehouses(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iWareHouseDao.getAllWarehouses(dataCriteria);
	}


	@Override
	public void updateWareHouse(WareHouse wareHouse) {
		wareHouse.setUpdateBy(getCurrentOperator());
		iWareHouseDao.updateWareHouse(wareHouse);

	}

	@Override
	public WareHouse getWarehouse(String whNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("whNum",whNum);
		return iWareHouseDao.getWarehouse(dataCriteria);
	}

}
