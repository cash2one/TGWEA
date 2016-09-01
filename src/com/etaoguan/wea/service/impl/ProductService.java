package com.etaoguan.wea.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.constant.WeaConstant;
import com.etaoguan.wea.dao.IProductDao;
import com.etaoguan.wea.service.IKeyGenService;
import com.etaoguan.wea.service.IOrderService;
import com.etaoguan.wea.service.IProdPriceService;
import com.etaoguan.wea.service.IProductService;
import com.etaoguan.wea.vo.ProdDiffer;
import com.etaoguan.wea.vo.ProdExternal;
import com.etaoguan.wea.vo.ProdFeature;
import com.etaoguan.wea.vo.ProdImg;
import com.etaoguan.wea.vo.ProdPrice;
import com.etaoguan.wea.vo.Product;

@Service("productService")
public class ProductService  extends BaseService implements IProductService {

	@Autowired
	private IProductDao iProductDao;
	
	@Resource(name="prodKeyGenService") 
	protected IKeyGenService  iKeyGenService;
	
	@Resource(name="orderService") 
	private IOrderService  iOrderService;
	
	@Resource(name="prodPriceService") 
	private IProdPriceService  iProdPriceService;
	
	@Override
	public void addProdImgs(List<ProdImg> prodImgs) {

		for(ProdImg prodImg:prodImgs){
			iProductDao.addProdImg(prodImg);
		}

	}
	

	@Override
	public void addProdImg(ProdImg prodImg) {
		iProductDao.addProdImg(prodImg);
		
	}

	@Override
	public void addProduct(Product product) {
		String prodNum = iKeyGenService.saveNGetKey();
		product.setProdNum(prodNum);
		int posSequence = getProdMaxPosSeqence(product.getOwnerNum());
		product.setPosSeq(posSequence+1);
		product.setUpdateBy(getCurrentOperator());
		product.setCreateBy(getCurrentOperator());
		ProdPrice prodPrice = new ProdPrice();
		prodPrice.setProdNum(product.getProdNum());
		prodPrice.setOwnerNum(product.getOwnerNum());
		prodPrice.setProdPrice(product.getStdPrice());
		if(iProdPriceService.existsProdPrice(product.getProdNum())){
			iProdPriceService.updateProdPrice(product.getProdNum(), product.getStdPrice());
		}else{
			iProdPriceService.saveProdPrice(prodPrice);
		}
		if(product.getProdImgs()!=null&&product.getProdImgs().size()>0){
			product.setFirstProdImg(product.getProdImgs().get(0).getThumbUrl());
			for(ProdImg prodImg:product.getProdImgs()){
				prodImg.setProdNum(prodNum);
				iProductDao.addProdImg(prodImg);
			}
		}
		
		if(product.getProdFeatures()!=null&&product.getProdFeatures().size()>0){
			for(ProdFeature prodFeature:product.getProdFeatures()){
				prodFeature.setProdNum(prodNum);
				iProductDao.addProdFeature(prodFeature);
			}
		}
		/*差异价格功能，暂不使用
		if(product.getProdDiffers()!=null&&product.getProdDiffers().size()>0){
			for(ProdDiffer prodDiffer:product.getProdDiffers()){
				prodDiffer.setProdNum(prodNum);
				iProductDao.addProdDiffer(prodDiffer);
			}
		}
		*/
		iProductDao.addProduct(product);
	}

	@Override
	public void delProdImg(String prodNum, int imgSeq) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("imgSeq",imgSeq);
		iProductDao.delProdImg(dataCriteria);
	}

	@Override
	public void delProduct(String prodNum) {
		if(iOrderService.existsProduct(prodNum)){
			throw new WeaException("存在产品关联的订单");
		}
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		iProductDao.delProduct(dataCriteria);
		iProdPriceService.delProdPrice(prodNum);
		iProdPriceService.delCustProdPrice(prodNum);

	}

	@Override
	public synchronized int getProdMaxImgSequence(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		return iProductDao.getProdMaxImgSequence(dataCriteria);
	}

	@Override
	public synchronized int getProdMaxPosSeqence(String ownerNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("ownerNum",ownerNum);
		return iProductDao.getProdMaxImgSequence(dataCriteria);
	}

	@Override
	public List<ProdImg> listProdImgs(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		return iProductDao.getProdImgs(dataCriteria);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listProducts(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iProductDao.getProducts(dataCriteria, offsetRequest);
	}

	@Override
	public void updateDispStockBalance(String prodNum, int stockBalance) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("dispStockBalance",stockBalance);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);

	}

	@Override
	public void updateHotFlag(String prodNum, int hotFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("hotFlag",hotFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);

	}

	@Override
	public void updateImgSeqence(String prodNum, int preProdImgSeq,
			int prodImgSeq) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("imgSeq",preProdImgSeq);
		ProdImg preProdImg = iProductDao.getProdImg(dataCriteria);
		iProductDao.delProdImg(dataCriteria);
		dataCriteria.clearParams();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("imgSeq",prodImgSeq);
		dataCriteria.setParam("newImgSeq",preProdImgSeq);
		iProductDao.updateProdImg(dataCriteria);
		preProdImg.setImgSeq(prodImgSeq);
		iProductDao.addProdImg(preProdImg);

	}

	@Override
	public void updateNewFlag(String prodNum, int newFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("newFlag",newFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);

	}

	@Override
	public void updatePosSeqence(String preProdNum, String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		Product product = iProductDao.getProduct(dataCriteria);
		dataCriteria.setParam("prodNum",preProdNum);
		Product preProduct = iProductDao.getProduct(dataCriteria);
		dataCriteria.clearParams();
		dataCriteria.setParam("prodNum",preProdNum);
		dataCriteria.setParam("posSeq",product.getPosSeq());
		iProductDao.updateProduct(dataCriteria);
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("posSeq",preProduct.getPosSeq());
		iProductDao.updateProduct(dataCriteria);

	}

	@Override
	public void updateProduct(Product product) {
		product.setUpdateBy(getCurrentOperator());
		ProdPrice prodPrice = new ProdPrice();
		prodPrice.setProdNum(product.getProdNum());
		prodPrice.setOwnerNum(product.getOwnerNum());
		prodPrice.setProdPrice(product.getStdPrice());
		if(iProdPriceService.existsProdPrice(product.getProdNum())){
			iProdPriceService.updateProdPrice(product.getProdNum(), product.getStdPrice());
		}else{
			iProdPriceService.saveProdPrice(prodPrice);
		}
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",product.getProdNum());
		iProductDao.delProdFeature(dataCriteria);
		iProductDao.delProdImg(dataCriteria);
		//产品差异分类
		iProductDao.delProdDiffer(dataCriteria);
		if(product.getProdImgs()!=null&&product.getProdImgs().size()>0){
			product.setFirstProdImg(product.getProdImgs().get(0).getThumbUrl());
			for(ProdImg prodImg:product.getProdImgs()){
				prodImg.setProdNum(product.getProdNum());
				iProductDao.addProdImg(prodImg);
			}
		}
		if(product.getProdFeatures()!=null&&product.getProdFeatures().size()>0){
			for(ProdFeature prodFeature:product.getProdFeatures()){
				prodFeature.setProdNum(product.getProdNum());
				iProductDao.addProdFeature(prodFeature);
			}
		}

		if(product.getProdDiffers()!=null&&product.getProdDiffers().size()>0){
			for(ProdDiffer prodDiffer:product.getProdDiffers()){
				prodDiffer.setProdNum(product.getProdNum());
				iProductDao.addProdDiffer(prodDiffer);
			}
		}

		iProductDao.updateProduct(product);
	}

	@Override
	public void updateShowFlag(String prodNum, int showFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("showFlag",showFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);

	}

	@Override
	public void updateTopFlag(String prodNum, int topFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("topFlag",topFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);

	}


	@Override
	public void addProdFeature(ProdFeature prodFeature) {
		iProductDao.addProdFeature(prodFeature);
		
	}


	@Override
	public void addProdFeatures(List<ProdFeature> prodFeatures) {

		for(ProdFeature prodFeature:prodFeatures){
			iProductDao.addProdFeature(prodFeature);
		}
		
	}


	@Override
	public void delProdFeature(String prodNum, String featureName) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("featureName",featureName);
		iProductDao.delProdFeature(dataCriteria);
		
	}


	@Override
	public List<ProdFeature> listProdFeatures(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		return iProductDao.getProdFeatures(dataCriteria);
	}


	@Override
	public void updateProdFeature(ProdFeature prodFeature) {
		iProductDao.updateProdFeature(prodFeature);
		
	}


	@Override
	public void updateProdStdPrice(String prodNum, double stdPrice) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		dataCriteria.setParam("stdPrice",stdPrice);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);
		
	}


	@Override
	public Product getProduct(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		Product product = iProductDao.getProduct(dataCriteria);
		product.setProdFeatures(iProductDao.getProdFeatures(dataCriteria));
		product.setProdImgs(iProductDao.getProdImgs(dataCriteria));
		product.setProdExternals(iProductDao.getProdExternals(dataCriteria));
		product.setProdDiffers(iProductDao.getProdDiffers(dataCriteria));
		return product;
	}


	@Override
	public List<Product> getProducts(List<String> prodNums) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNums",prodNums);
		return iProductDao.getProducts(dataCriteria);
	}
	
	@Override
	public List<String> getUpdatedProdNums(Date updateDate) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("updateDate",updateDate);
		return iProductDao.getProdNums(dataCriteria);
	}


	@Override
	public void updateHotFlag(String[] prodNums, int hotFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNums",prodNums);
		dataCriteria.setParam("hotFlag",hotFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);
		
	}
	/* (non-Javadoc)公开，隐藏
	 * @see com.etaoguan.wea.service.IProductService#updateIsPublic(java.lang.String[], int)
	 */
	@Override
	public void updateIsPublic(String[] prodNums, int isPublic) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNums",prodNums);
		dataCriteria.setParam("isPublic",isPublic);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);
		
	}


	@Override
	public void updateNewFlag(String[] prodNums, int newFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNums",prodNums);
		dataCriteria.setParam("newFlag",newFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);
		
	}


	@Override
	public void updateShowFlag(String[] prodNums, int showFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNums",prodNums);
		dataCriteria.setParam("showFlag",showFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);
		
	}


	@Override
	public void updateTopFlag(String[] prodNums, int topFlag) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNums",prodNums);
		dataCriteria.setParam("topFlag",topFlag);
		dataCriteria.setParam("updateBy",getCurrentOperator());
		iProductDao.updateProduct(dataCriteria);
		
	}


	@Override
	public List<ProdExternal> listProdExternals(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		return iProductDao.getProdExternals(dataCriteria);
	}


	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listCompProducts(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iProductDao.getCompProducts(dataCriteria, offsetRequest);
	}

	/* (non-Javadoc)根据用户ID获取产品列表信息
	 * @see com.etaoguan.wea.service.IProductService#listProductsbyid(com.etaoguan.wea.common.DataCriteria, com.etaoguan.wea.common.OffsetRequest)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public DataSet listProductsbyid(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		return iProductDao.getProductsBycustNum(dataCriteria, offsetRequest);
	}


	@Override
	public List<ProdDiffer> listProdDiffers(String prodNum) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("prodNum",prodNum);
		List<ProdDiffer> prodDiffers =  iProductDao.getProdDiffers(dataCriteria);
		if(prodDiffers.size()==0){
			ProdDiffer prodDiffer =  new ProdDiffer();
			prodDiffer.setProdNum(prodNum);
			prodDiffer.setDifferId(1);
			prodDiffer.setDifferName(WeaConstant.PROD_DEFAULT_DIFFER);
			prodDiffers.add(prodDiffer);
		}
		return prodDiffers;
	}




}
