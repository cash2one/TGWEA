package com.etaoguan.wea.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.dao.IFileCacheDeltaDao;
import com.etaoguan.wea.service.IFileCacheService;
import com.etaoguan.wea.service.IProductService;
import com.etaoguan.wea.util.JsonUtil;
import com.etaoguan.wea.vo.FileCacheDelta;
import com.etaoguan.wea.vo.Product;

@Service("fileCacheService")
public class FileCacheService extends BaseService implements IFileCacheService {

	@Autowired
	private IFileCacheDeltaDao iFileCacheDeltaDao;
	
	@Resource(name="productService") 
	private IProductService productService;
	
	private final static Log logger = LogFactory.getLog(FileCacheService.class);
	
	private static String PRODDETAILDIR = WeaApplication.getInstance().getFileSaveAddr()+"product";
	
	private static String PRODDETAILFILECACHETYPE = "prod_detail";
	
	@Override
	public void addFileCacheDelta(FileCacheDelta fileCacheDelta) {
		iFileCacheDeltaDao.addFileCacheDelta(fileCacheDelta);
	}

	@Override
	public void updateFileCacheDeltaDate(String fileCacheType) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("fileCacheType",fileCacheType);
		iFileCacheDeltaDao.updateFileCacheDeltaDate(dataCriteria);
		
	}

	@Override
	public FileCacheDelta getFileCacheDelta(String fileCacheType) {
		DataCriteria dataCriteria = new DataCriteria();
		dataCriteria.setParam("fileCacheType",fileCacheType);
		return iFileCacheDeltaDao.getFileCacheDelta(dataCriteria);
	}

	@Override
	public synchronized void saveProdDetailJSONFileCache()  {
		
		FileCacheDelta fileCacheDelta = getFileCacheDelta(PRODDETAILFILECACHETYPE);
		if(fileCacheDelta==null){
			fileCacheDelta = new FileCacheDelta();
			fileCacheDelta.setFileCacheType(PRODDETAILFILECACHETYPE);
			addFileCacheDelta(fileCacheDelta);
		}
		updateFileCacheDeltaDate(PRODDETAILFILECACHETYPE);
		try{
			long startTime = System.currentTimeMillis();
			List<String> prodNums = productService.getUpdatedProdNums(fileCacheDelta.getLastCacheDate());
			Product product;
			logger.info("开始生成产品静态缓存数据，共【" +prodNums.size()+"】条");
			for(String prodNum:prodNums){
				product = productService.getProduct(prodNum);
				genCacheFile(PRODDETAILDIR,prodNum+".json",JsonUtil.getJSONStringDateNoTime(product));
			}
			long endTime = System.currentTimeMillis();
			logger.info("产品静态缓存数据生成完毕，耗时"+(endTime-startTime)/1000+"秒");
			logger.info("***************PRODDETAILDIR= "+PRODDETAILDIR);
		
		}catch(Exception ex){
			ex.printStackTrace();
			throw new WeaException(ex.getMessage());
		}
		
	}
	
	private void genCacheFile(String pathDir,String fileName,String content) throws IOException{
		if (!(new File(pathDir).isDirectory())) {
			new File(pathDir).mkdirs();
		}

		byte[] bytes = content.getBytes("UTF-8");
		String filePath = PRODDETAILDIR +IOUtils.DIR_SEPARATOR +fileName;
		FileOutputStream outf=new FileOutputStream(filePath);
		BufferedOutputStream bufferout= new BufferedOutputStream(outf);
		bufferout.write(bytes);
		bufferout.flush();
  		bufferout.close();


	}

}
