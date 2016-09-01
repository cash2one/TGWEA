package com.etaoguan.wea.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.etaoguan.wea.common.DataCriteria;
import com.etaoguan.wea.common.DataSet;
import com.etaoguan.wea.common.OffsetRequest;
import com.etaoguan.wea.dao.IGuestBookDao;
import com.etaoguan.wea.vo.GuestBook;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class GuestBookDao extends SpringBaseDao implements IGuestBookDao{

	@Override
	@Resource(name="guestBookSqlMapClient")
	public void setSbiSqlMapClient(SqlMapClient sqlMapClient){
		
		super.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addGuestBook(GuestBook guestBook) {
		this.getSqlMapClientTemplate().insert("createGuestBook", guestBook);
		
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataSet getGuestBooks(DataCriteria dataCriteria,
			OffsetRequest offsetRequest) {
		Map params = dataCriteria.getParams();
		
		Integer count=(Integer) this.getSqlMapClientTemplate().queryForObject("getGuestBookCount", params);
		
		params.put("limit", offsetRequest.getPerUnitNum());
		params.put("offset", offsetRequest.getOffset());
		List<GuestBook> guestBookList = this.getSqlMapClientTemplate().queryForList("getGuestBookDatSet", params);
		
		DataSet<GuestBook> dataSet = new DataSet<GuestBook>();
		dataSet.setTotalRecNum(count);
		dataSet.setDataList(guestBookList);
		return dataSet;
	}

	@Override
	public void delGuestBook(DataCriteria dataCriteria) {
		this.getSqlMapClientTemplate().delete("deleteGuestBook", dataCriteria.getParams());
		
	}

}
