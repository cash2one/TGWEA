package com.etaoguan.wea.service;

import com.alibaba.openapi.client.AlibabaClient;
import com.alibaba.openapi.client.auth.AuthorizationToken;
import com.alibaba.openapi.client.policy.RequestPolicy;
import com.etaoguan.wea.e688.vo.MemberInfo;

public interface IE688Service {
	
	public String getMemberIdByLoginId(AlibabaClient client,RequestPolicy basePolicy,String loginId) throws Exception;
	
	public MemberInfo getMemberInfo(AlibabaClient client,RequestPolicy basePolicy,String memberId)throws Exception;
/*
	public void syncMemberProducts(AlibabaClient client,RequestPolicy basePolicy, String memberId, String accessToken) throws Exception;
	
	public void syncMemberProductCategory(AlibabaClient client,RequestPolicy basePolicy, String memberId,HashMap<String,Integer> orderById) throws Exception;
	
	public void saveMemberInfo(MemberInfo memberInfo);
	public void saveOfferDetailInfo(OfferDetailInfo offerDetailInfo);
	public void saveOfferImageInfo(OfferImageInfo OfferImageInfo);
	public void saveProductFeatureInfo(ProductFeatureInfo productFeatureInfo);
	public void saveProductCategory(ProductCategory productCategory);
	public void saveE688UserDefinedProductCategory(List list,String memberId);
	public void saveE688StandardProductCategory(String catIds,AlibabaClient client,RequestPolicy noAuthPolicy,String memberId,HashMap<String,Integer> orderById)throws Exception;
	public List getCategoryIdByOfferDatailInfo(String memberId);
	public void savePriceRangeInfo(PriceRangeInfo priceRangeInfo);
	public void syncE688Data2Wea(String memberId);
	public void deleteE688Data(String memberId);
*/	
	public void syncE688Data2Wea(AlibabaClient client, RequestPolicy basePolicy, String memberId, AuthorizationToken authorizationToken)  throws Exception;

}
