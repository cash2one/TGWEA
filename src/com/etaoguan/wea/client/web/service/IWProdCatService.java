package com.etaoguan.wea.client.web.service;

import java.util.List;

import com.etaoguan.wea.service.IProdCatService;
import com.etaoguan.wea.vo.ProdCat;

public interface IWProdCatService extends IProdCatService{

	public void saveOrUpdateProdCat(ProdCat prodCat);
	
	public List<ProdCat> getProdCatsIncRootByOwnerNum(String ownerNum);
	
	public void delBatchProdCat(String ownerNum,String[] prodCatIds);
}
