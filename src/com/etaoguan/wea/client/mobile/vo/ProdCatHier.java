	package com.etaoguan.wea.client.mobile.vo;

import java.util.ArrayList;
import java.util.List;

import com.etaoguan.wea.vo.ProdCat;

public class ProdCatHier {
	
	private ProdCat prodCat;
	
	private List<ProdCatHier> childProdCatHiers = new ArrayList<ProdCatHier>();

	public ProdCat getProdCat() {
		return prodCat;
	}

	public void setProdCat(ProdCat prodCat) {
		this.prodCat = prodCat;
	}

	public void addChildProdCatHier(ProdCatHier prodCatHier){
		childProdCatHiers.add(prodCatHier);
	}
	public List<ProdCatHier> getChildProdCatHiers() {
		return childProdCatHiers;
	}

	public void setChildProdCatHiers(List<ProdCatHier> childProdCatHiers) {
		this.childProdCatHiers = childProdCatHiers;
	}



}
