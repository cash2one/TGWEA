package com.etaoguan.wea.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.dao.IProdCatDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IProdCatService;
import com.etaoguan.wea.vo.ProdCat;

@Service("prodCatService")
public class ProdCatService  extends BaseService implements IProdCatService {
	
	@Autowired
	private IProdCatDao iProdCatDao;

	@Resource(name="prodCatKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Override
	public void addProdCat(ProdCat prodCat) {
		String prodCatId = iKeyGenService.saveNGetKey();
		prodCat.setProdCatId(prodCatId);
		iProdCatDao.addProdCat(prodCat);

	}

	@Override
	public void delProdCat(String ownerNum,String prodCatId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("prodCatId",prodCatId);
		iProdCatDao.delProdCat(dataCriteria);
	}

	@Override
	public List<ProdCat> getProdCatsByOwnerNum(String ownerNum){
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iProdCatDao.getProdCats(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List getChildProdCatIds(String parentProdCatId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("parentProdCatId",parentProdCatId);
		return iProdCatDao.getProdCatIds(dataCriteria);
	}

	@Override
	public boolean haveChildProdCat(String parentProdCatId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("parentProdCatId",parentProdCatId);
		if(iProdCatDao.getProdCatCount(dataCriteria)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<ProdCat> listChildProdCat(String parentProdCatId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("parentProdCatId",parentProdCatId);
		return iProdCatDao.getProdCats(dataCriteria);
	}

	@Override
	public List<ProdCat> listTopLevelProdCat(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		dataCriteria.setParam("parentProdCatId",0);
		return iProdCatDao.getProdCats(dataCriteria);
	}

	@Override
	public void updateProdCat(ProdCat prodCat) {
		iProdCatDao.updateProdCat(prodCat);

	}

	@Override
	public ProdCat getProdCatById(String prodCatId) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodCatId",prodCatId);
		return iProdCatDao.getProdCatById(dataCriteria);
	}

}
