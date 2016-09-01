package com.etaoguan.wea.client.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etaoguan.wea.client.web.service.IWWechatKeysService;
import com.etaoguan.wea.client.web.service.IWWechatMenuService;
import com.etaoguan.wea.common.WeaDataCache;
import com.etaoguan.wea.common.WeaException;
import com.etaoguan.wea.service.impl.WechatMenuService;
import com.etaoguan.wea.vo.WechatKeys;
import com.etaoguan.wea.vo.WechatMenu;
import com.etaoguan.wea.wechat.util.WeixinMenuUtil;
import com.etaoguan.wea.wechat.vo.AccessToken;
import com.etaoguan.wea.wechat.vo.Button;
import com.etaoguan.wea.wechat.vo.CommonButton;
import com.etaoguan.wea.wechat.vo.ComplexButton;
import com.etaoguan.wea.wechat.vo.LinkButton;
import com.etaoguan.wea.wechat.vo.Menu;
@Service("wwechatMenuService")
public class WWechatMenuService extends WechatMenuService implements IWWechatMenuService{

	private final static Log logger = LogFactory.getLog(WWechatMenuService.class);
			
	@Autowired
	IWWechatKeysService iWWechatKeysService;

	
	@Override
	public void saveOrUpdateWechatMenu(WechatMenu wechatMenu) {
		if(wechatMenu.getMenuId()==0l){
			addWechatMenu(wechatMenu);
		}else{
			updateWechatMenu(wechatMenu);
		}
		
	}

	@Override
	public List<WechatMenu> getWechatMenusIncRootByOwnerNum(String ownerNum) {
		List<WechatMenu> wechatMenuList = getWechatMenusByOwnerNum(ownerNum);
		WechatMenu wechatMenu = new WechatMenu();
		wechatMenu.setMenuName("微站");
		wechatMenu.setMenuId(0);
		wechatMenuList.add(wechatMenu);
		wechatMenu.setParentMenuId(-1);
		return wechatMenuList;
	}

	@Override
	public void delBatchWechatMenu(String ownerNum,long[] menuIds) {
		for(long wechatId:menuIds){
			delWechatMenu(ownerNum,wechatId);
		}
		
	}

	@Override
	public void syncWechatMenu(String ownerNum) {
		
		if(WeaDataCache.getCache().getOwnerSettingAllowWechat(ownerNum)){
			WechatKeys wechatKeys = iWWechatKeysService.getWechatKeys(ownerNum);
			if (wechatKeys == null) {
				throw new WeaException("微站基础信息配置不完整");
			}
			 // 调用接口获取access_token  
	        AccessToken at = WeixinMenuUtil.getAccessToken(wechatKeys.getAppId(), wechatKeys.getAppSecret());  
	        if(at==null){
	        	throw new WeaException("无效的微信授权信息");
	        }
	        logger.debug(at.getAccessToken());
	        logger.debug(at.getExpiresIn());
	        if (null != at) {  
	            // 调用接口创建菜单  
	            int result = WeixinMenuUtil.createMenu(getMenu(ownerNum), at.getAccessToken());  
	  
	            // 判断菜单创建结果  
	            if (0 == result) {
	            	logger.info("菜单创建成功！");  
	            }
	            else {
	            	logger.info("菜单创建失败，错误码：" + result);  
	            	throw new WeaException("菜单创建失败，错误码：" + result);
	            }
	        }
		}else{
			throw new WeaException("您没有授权开通微站，请联系管理员");
			
		}
	}
	
	/**
	 * 组装菜单数据 
	 * @return
	 */
	private Menu getMenu(String ownerNum) {  
		List<WechatMenu> wechatMenus = getWechatMenusByOwnerNum(ownerNum);
		Menu menu = new Menu();
		Map<Long,List<WechatMenu>> childMenuMap = new HashMap<Long,List<WechatMenu>>();
		for(WechatMenu wechatMenu:wechatMenus){
			List<WechatMenu> childMenus = childMenuMap.get(wechatMenu.getParentMenuId());
			if(childMenus==null){
				childMenus = new ArrayList<WechatMenu>();
				childMenuMap.put(wechatMenu.getParentMenuId(), childMenus);
			}
			childMenus.add(wechatMenu);
		}
		ComplexButton rootComplexButton = new ComplexButton();
		genMenuButtons(childMenuMap,rootComplexButton,0);
		menu.setButton(rootComplexButton.getSub_button());
        return menu;  
    }  
	
	private void genMenuButtons(Map<Long,List<WechatMenu>> childMenuMap,ComplexButton parentComplexButton,long parentMenuId){
		List<WechatMenu> childMenus = childMenuMap.get(parentMenuId);
		List<Button> childButtons = new ArrayList<Button>();
		for(WechatMenu wechatMenu:childMenus){
			
			if(childMenuMap.get(wechatMenu.getMenuId())==null){
				if("0".equals(wechatMenu.getMenuType())){
					CommonButton commonButton = new CommonButton();
					commonButton.setName(wechatMenu.getMenuName());
					commonButton.setKey(wechatMenu.getMenuKey());
					commonButton.setType("click");
					childButtons.add(commonButton);
				}else if("1".equals(wechatMenu.getMenuType())){
					LinkButton linkButton = new LinkButton();
					linkButton.setName(wechatMenu.getMenuName());
					linkButton.setUrl(wechatMenu.getContent());
					linkButton.setType("view");
					childButtons.add(linkButton);
				}
				
			}else{
				ComplexButton complexButton = new ComplexButton();
				complexButton.setName(wechatMenu.getMenuName());
				genMenuButtons(childMenuMap,complexButton,wechatMenu.getMenuId());
				childButtons.add(complexButton);
			}
			
		}
		parentComplexButton.setSub_button(childButtons);
	}

}
