package com.etaoguan.wea.client.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWGroupOfCustService;
import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.ICustDao;
import com.etaoguan.wea.service.impl.GroupOfCustService;
import com.etaoguan.wea.vo.Customer;
import com.etaoguan.wea.vo.GroupOfCust;

@Service("wGroupOfCustService")
public class WGroupOfCustService extends GroupOfCustService implements IWGroupOfCustService{

	@Autowired
	private ICustDao iCustDao;

	@Override
	public List<GroupOfCust> listSearchGroupOfCusts(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum", ownerNum);
		return listGroupOfCust(dataCriteria);
	}

	@Override
	public void delGroupOfCust(int id) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("id", id);
		delGroupOfCust(dataCriteria);
		
	}

	@Override
	public void addGroupOfCust(GroupOfCust groupOfCust) {
		insertGroupOfCust(groupOfCust);
		
	}

	@Override
	public void removeGroup(String groupNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupNum", groupNum);
		delGroup(dataCriteria);
	}

	/*根据groupNum 组的编号查询到客户custid也就是公司id,根据custid查询到companyName公司名*/
	@Override
	@SuppressWarnings("unused")
	public GroupOfCust listGroup(String groupNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("groupNum", groupNum);
		List<GroupOfCust> groupOfCusts = listGroupInfo(dataCriteria);
		String companyName = "";
		String own = "";
		
		GroupOfCust groupOfCust = new GroupOfCust();
		
		groupOfCust.setGroupName(groupOfCusts.get(0).getGroupName());
		groupOfCust.setMemo(groupOfCusts.get(0).getMemo());
		
		for (int i = 0; i < groupOfCusts.size(); i++) {
			String custNum = groupOfCusts.get(i).getCustId();
			
			DataCriteria dataCriteria2 = new DataCriteria();
			dataCriteria2.setParam("custNum", custNum);
			Customer customer = iCustDao.geCust(dataCriteria2);
			
			String cn = customer.getCompanyName();
			companyName+=customer.getCompanyName()+",";
			own+=customer.getCustNum()+",";
		}
		groupOfCust.setCustId(companyName);
		groupOfCust.setOwnerNum(own);
		return groupOfCust;
		
	}

	/* (non-Javadoc)获取组名
	 * @see com.etaoguan.wea.client.web.service.IWGroupOfCustService#nameOfGroup(com.etaoguan.wea.vo.GroupOfCust)
	 */
	@Override
	public GroupOfCust nameOfGroup(String custId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("custId", custId);
		return nameOfGroup(dataCriteria);
	}
	

}
