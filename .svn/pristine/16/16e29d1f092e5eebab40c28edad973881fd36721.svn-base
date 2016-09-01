package com.etaoguan.wea.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IOrigOrderDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IOrigOrderService;
import com.etaoguan.wea.vo.OrigOrder;
import com.etaoguan.wea.vo.OrigOrderItem;

@Service("origOrderService")
public class OrigOrderService  extends BaseService implements IOrigOrderService {

	@Autowired
	private IOrigOrderDao iOrigOrderDao;
	
	@Resource(name="origOrderKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Override
	public OrigOrder addOrigOrder(OrigOrder origOrder) {
		String origOrderNum = iKeyGenService.saveNGetKey();
		origOrder.setOrigOrderNum(origOrderNum);
		origOrder.setCreateBy(getCurrentOperator());
		origOrder.setUpdateBy(getCurrentOperator());
		iOrigOrderDao.addOrigOrder(origOrder);
		for(OrigOrderItem origOrderItem:origOrder.getOrigOrderItemList()){
			origOrderItem.setOrigOrderNum(origOrderNum);
			iOrigOrderDao.addOrigOrderItem(origOrderItem);
		}
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("origOrderNum",origOrderNum);
		
		/*设置单件和总价*/
		iOrigOrderDao.updateOrigOrderItemUnitPrice(dataCriteria);
		iOrigOrderDao.reCalcOrigOrderPriceTotal(dataCriteria);
		return origOrder;
	}

	@Override
	public void delOrigOrder(String origOrderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("origOrderNum",origOrderNum);
		iOrigOrderDao.delOrigOrder(dataCriteria);

	}

	@Override
	public void saveOrigOrderItem(OrigOrderItem origOrderItem) {
		iOrigOrderDao.addOrigOrderItem(origOrderItem);

	}

	@Override
	public List<OrigOrderItem> getOrigOrderItems(String origOrderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("origOrderNum",origOrderNum);
		return iOrigOrderDao.getOrigOrderItems(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listOrigOrders(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iOrigOrderDao.getOrigOrders(dataCriteria, offsetRequest);
	}

	@Override
	public OrigOrder getOrigOrder(String origOrderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("origOrderNum",origOrderNum);
		OrigOrder origOrder = iOrigOrderDao.getOrigOrder(dataCriteria);
		List<OrigOrderItem> origOrderItemList = iOrigOrderDao.getOrigOrderItems(dataCriteria);
		origOrder.setOrigOrderItemList(origOrderItemList);
		return origOrder;
	}

	@Override
	public void updateReCalcOrigOrderPriceTotal(String origOrderNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("origOrderNum",origOrderNum);
		iOrigOrderDao.reCalcOrigOrderPriceTotal(dataCriteria);
		
	}

	/* (non-Javadoc)未审核订单列表(移动端)
	 * @see com.etaoguan.wea.service.IOrigOrderService#origOrders(java.lang.String)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public DataSet GetOrigOrders(DataCriteria dataCriteria,OffsetRequest offsetRequest) {

		return iOrigOrderDao.getUnauditedOrders(dataCriteria,offsetRequest);
	}
}
