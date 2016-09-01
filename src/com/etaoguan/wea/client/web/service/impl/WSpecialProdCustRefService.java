package com.etaoguan.wea.client.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.vo.SortParam;
import com.etaoguan.wea.client.web.service.IWGroupOfCustService;
import com.etaoguan.wea.client.web.service.IWSpecialProdCustRefService;
import com.etaoguan.wea.client.web.vo.SpecialProdCustRefSearch;
import com.etaoguan.wea.client.web.vo.WPage;
import com.etaoguan.wea.client.web.vo.WPagingRequest;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.service.impl.SpecialProdCustRefService;
import com.etaoguan.wea.vo.GroupOfCust;

/**
 * @author cunli
 * 特供产品表
 */
@Service("wspecialProdCustRefService")
public class WSpecialProdCustRefService extends SpecialProdCustRefService implements IWSpecialProdCustRefService{

	@Resource(name="wGroupOfCustService")
	private  IWGroupOfCustService iwGroupOfCustService;
	
	/* (non-Javadoc)根据组名查询特供产品，获得属于某个人的特供产品列表
	 * @see com.etaoguan.wea.client.web.service.IWSpecialProdCustRefService#specialprods(java.lang.String)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public WPage specialprods(SpecialProdCustRefSearch search,
			SortParam sortParam, WPagingRequest wpagingRequest) {
		OffsetRequest offsetRequest = wpagingRequest.format2OffsetRequest();
		DataCriteria dataCriteria = new DataCriteria();
		
		String custId = search.getGroupName();
		GroupOfCust groupOfCust = iwGroupOfCustService.nameOfGroup(custId);
		String groupName = "";
		if (!custId.trim().equals("")) {//不等于空，此时是在安客户id查询属于这个客户的商品
			if (groupOfCust != null) {
				groupName = groupOfCust.getGroupName();//不等于空，此时查询到这个客户所属的组了（得到的是组名）
			}else {
				groupName = "noResut";//查询不到组名，说明这个客户还没有分配组，所以这个客户也就没有商品，前台显示为空
			}
		}
		
		dataCriteria.setParam("prodName", search.getProdName());
		dataCriteria.setParam("custNum", groupName);
		dataCriteria.setParam("ownerNum", search.getOwnerNum());
		DataSet dataSet = specialprods(dataCriteria, offsetRequest);
		
		return new WPage(wpagingRequest,dataSet);
	}

}
