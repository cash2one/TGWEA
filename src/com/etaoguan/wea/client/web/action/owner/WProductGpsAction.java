package com.etaoguan.wea.client.web.action.owner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.annotation.WeaFunction;
import com.etaoguan.wea.annotation.WeaModule;
import com.etaoguan.wea.client.web.action.WOwnerBaseAction;
import com.etaoguan.wea.client.web.service.IWProductGpsService;
import com.etaoguan.wea.client.web.vo.ProductGpsSearch;
import com.etaoguan.wea.util.Help;
import com.etaoguan.wea.vo.ProductGps;

/**
 * @author cunli 产品管理 ————> 产品定位
 */
@SuppressWarnings("serial")
@WeaModule(mname = "产品定位")
@Service("productGpsAction")
@Scope("prototype")
public class WProductGpsAction extends WOwnerBaseAction {

	private ProductGpsSearch productGpsSearch = new ProductGpsSearch();

	@Resource(name = "wproductGpsService")
	private IWProductGpsService iwProductGpsService;
	
	public ProductGpsSearch getProductGpsSearch() {
		return productGpsSearch;
	}

	public void setProductGpsSearch(ProductGpsSearch productGpsSearch) {
		this.productGpsSearch = productGpsSearch;
	}

	/**
	 * @return 显示选择客户的产品
	 * @throws IOException
	 */
	@WeaFunction(fname = "显示选择客户的产品", oname = WeaFunction.Operation.READ)
	@Action(value = "WChooseCustproducts")
	public String chooseCustproducts() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		String custNum = getRequestParamValue("custNum");
		if (!StringUtils.isBlank(custNum)) {
			
			ProductGps productGps=new ProductGps();
			productGps.setOwnerNum(ownerNum);
			productGps.setCustNum(custNum);
			List<ProductGps> lGps=iwProductGpsService.productGpsService(productGps);
			List<Help> list = new ArrayList<Help>();
			for (ProductGps productGps2 : lGps) {
				Help help=new Help();
				help.setAttribute1(productGps2.getProdNum());
				help.setAttribute2(productGps2.getProdName());
				list.add(help);
			}
			setSessionAttribute("prodcp",list);
			
			weaResponse.setRows(lGps);
			weaResponse.setTotal(lGps.size());
			weaResponse.setRespData(null);
		}
		return JSONRESPONSE;
	}
	
	@SuppressWarnings("unchecked")
	@WeaFunction(fname = "执行添加 产品定位", oname = WeaFunction.Operation.CREATE)
	@Action(value = "wAddGps")
	public String addproductGps() throws IOException {
		String ownerNum = getCurrentOwnerAdmin().getOwnerNum();
		String custNum = getRequestParamValue("custNum");
		String chanpin=	getRequestParamValue("chanpin");
		
		List<Help> lHelps=(List<Help>) getSessionAttribute("prodcp");
		try {
			if (lHelps.size() > 0) {
				String gval="";
				for (Help help : lHelps) {
					gval+=help.getAttribute1()+","+help.getAttribute2()+"---";
				}
				chanpin+=gval;
			}
		} catch (Exception e) {
		}
		
		String[] cps = chanpin.split("---");
		ProductGps productGps3 = new ProductGps();
			productGps3.setOwnerNum(ownerNum);

				for (String cp : cps) {
					String[] truecp = cp.split(",");

					ProductGps productGps = new ProductGps();
					productGps.setOwnerNum(ownerNum);

					productGps.setCustNum(custNum);
					productGps.setCreateBy(custNum);
					if (!StringUtils.isBlank(truecp[0]) && !StringUtils.isBlank(truecp[1])) {
						productGps.setProdNum(truecp[0]);
						productGps.setProdName(truecp[1]);
						iwProductGpsService.addProductgps(productGps);
					}
				}
		

		return JSONRESPONSE;
	}

	@WeaFunction(fname = "查看产品定位", oname = WeaFunction.Operation.READ)
	@Action(value = "wAddProdsGps", results = { @Result(name = "success", type = "dispatcher", location = "/owner/addproductgps.jsp") })
	public String addProdsgps() throws IOException {

		return SUCCESS;
	}

	/**
	 * @return 到 产品定位列表页面
	 * @throws IOException
	 */
	@WeaFunction(fname = "查看产品定位", oname = WeaFunction.Operation.READ)
	@Action(value = "wListProdsgps", results = { @Result(name = "success", type = "dispatcher", location = "/owner/list_prodsgps.jsp") })
	public String listProdsgps() throws IOException {

		return SUCCESS;
	}

	@WeaFunction(fname = "删除产品定位", oname = WeaFunction.Operation.DELETE)
	@Action(value = "wDelproductGps")
	public String delproductGps() throws IOException {
		String custNum = getRequestParamValue("custNum");
		String prodNum = getRequestParamValue("prodNum");
		ProductGps productGps = new ProductGps();
		productGps.setCustNum(custNum);
		productGps.setProdNum(prodNum);
		iwProductGpsService.delProductGps(productGps);

		return JSONRESPONSE;
	}

}
