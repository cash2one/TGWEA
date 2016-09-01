package com.etaoguan.wea.client.mobile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.mobile.service.IMPushMessageService;
import com.etaoguan.wea.service.impl.PushMessageService;
import com.etaoguan.wea.vo.PushGroup;


@Service("mpushMessageService")
public class MPushMessageService extends PushMessageService implements IMPushMessageService{

	@Override
	public List<String> getCustPushGroupNums(String custNum) {
		List<PushGroup> pushGroups = getCustPushGroups(custNum);
		List<String> groupNums = new ArrayList<String>();
		for(PushGroup pushGroup:pushGroups){
			groupNums.add(pushGroup.getGroupNum());
		}
		return groupNums;
	}


}
