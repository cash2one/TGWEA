package com.etaoguan.wea.service;

import java.util.List;

import com.etaoguan.wea.vo.ProdCat;

public interface IProdCatService {
	public ProdCat getProdCatById(String prodCatId);
	
	public void addProdCat(ProdCat prodCat);
	
	public void updateProdCat(ProdCat prodCat);
	
	public void delProdCat(String ownerNum,String prodCatId);
	
	public boolean haveChildProdCat(String parentProdCatId);
	
	@SuppressWarnings("rawtypes")
	public List getChildProdCatIds(String parentProdCatId);
	
	public List<ProdCat> listChildProdCat(String parentProdCatId);
	
	public List<ProdCat> listTopLevelProdCat(String ownerNum);
	
	public List<ProdCat> getProdCatsByOwnerNum(String ownerNum);

}
