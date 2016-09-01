package com.etaoguan.wea.client.mobile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jpush.api.utils.StringUtils;

import com.etaoguan.wea.client.mobile.service.IMOrderService;
import com.etaoguan.wea.client.mobile.service.IMOrigOrderService;
import com.etaoguan.wea.client.mobile.service.IMProductService;
import com.etaoguan.wea.client.mobile.service.IMShortMessageService;
import com.etaoguan.wea.client.mobile.vo.MPage;
import com.etaoguan.wea.client.mobile.vo.MPagingRequest;
import com.etaoguan.wea.client.mobile.vo.OrigOrderSearch;
import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.service.impl.OrigOrderService;
import com.etaoguan.wea.util.JsonUtil;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.Order;
import com.etaoguan.wea.vo.OrigOrder;
import com.etaoguan.wea.vo.OrigOrderItem;
import com.etaoguan.wea.vo.ProdQty;
import com.etaoguan.wea.vo.Product;

@Service("morigOrderService")
public class MOrigOrderService extends OrigOrderService  implements IMOrigOrderService{
	
	@Autowired
	IMProductService iMProductService;
	
	@Autowired
	IMOrderService iMOrderService;
	
	@Autowired
	private IMShortMessageService imShortMessageService;
	
	@Override
	@SuppressWarnings("unchecked")
	public void addOrigOrder(String jsonProdQtys, Customer cust,
			String ownerNum,String deliverAddr) {
		List<ProdQty> prodQtyList = JsonUtil.getDTOList(jsonProdQtys, ProdQty.class);
		List<String> prodNums = new ArrayList<String>();
		for(ProdQty prodQty:prodQtyList){
			prodNums.add(prodQty.getProdNum());
		}
		List<Product> prodList = iMProductService.getProducts(prodNums);
		List<OrigOrderItem> origOrderItemList = new ArrayList<OrigOrderItem>();
		for(ProdQty prodQty:prodQtyList){
			for(Product product:prodList){
				if(prodQty.getProdNum().equals(product.getProdNum())){
					OrigOrderItem origOrderItem = new OrigOrderItem();
					origOrderItem.setProdNum(product.getProdNum());
					origOrderItem.setProdName(product.getProdName());
					origOrderItem.setDifferName(StringUtils.isEmpty(prodQty.getDifferName())?WeaConstant.PROD_DEFAULT_DIFFER:prodQty.getDifferName());
					origOrderItem.setUnit(product.getUnit());
					origOrderItem.setCases(prodQty.getCases());
					origOrderItem.setPieces(prodQty.getPieces());
					origOrderItemList.add(origOrderItem);
				}
			}
		}
		
		OrigOrder origOrder = new OrigOrder();
		origOrder.setOrigOrderItemList(origOrderItemList);
		origOrder.setOwnerNum(ownerNum);
		origOrder.setCustNum(cust.getCustNum());
		origOrder.setDeliverAddr(deliverAddr);
		addOrigOrder(origOrder);
		
		Order order = iMOrderService.saveGenOrderFromOrigOrder(origOrder.getOrigOrderNum());
		
		if(WeaDataCache.getCache().getOwnerSettingAllowSMMobileOrder(ownerNum)){
			String custNum = cust.getCustNum();
			String orderNum = order.getOrderNum();
			imShortMessageService.sendMobileOrderShortMessageContent(custNum, orderNum, ownerNum);
			
		}
		
	}

	/* (non-Javadoc)未审核订单列表(移动端)
	 * @see com.etaoguan.wea.client.mobile.service.IMOrigOrderService#getMOrigOrderList(java.lang.String)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public MPage getMOrigOrderList(OrigOrderSearch origOrderSearch,SortParam sortParam,MPagingRequest mpagingRequest) {
		OffsetRequest offsetRequest = mpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", origOrderSearch.getOwnerNum());
		dataCriteria.setParam("custNum", origOrderSearch.getCustNum());
		DataSet dataSet = GetOrigOrders(dataCriteria, offsetRequest);
		
		return new MPage(mpagingRequest,dataSet);
	}
	
}
