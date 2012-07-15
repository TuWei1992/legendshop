/*
 * 
 * LegendShop 多用户商城系统
 * 
 *  版权所有,并保留所有权利。
 * 
 */
package com.legendshop.business.service.locator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendshop.business.service.CommonPageService;
import com.legendshop.business.service.ShopDetailService;
import com.legendshop.core.helper.ThreadLocalContext;
import com.legendshop.spi.constants.TemplateEnum;

/**
 * The Class CommonPageServiceLocator.
 */
public class CommonPageServiceLocator {
	
	private ShopDetailService shopDetailService;
	
	/** The servicemap. */
	private Map<String,CommonPageService> serviceMap;
	/**
	 * Gets the common page service.
	 * 
	 * @param template
	 *            the template
	 * @return the common page service
	 */
	public CommonPageService getCommonPageService(String shopName, HttpServletRequest request, HttpServletResponse response){
		String template = ThreadLocalContext.getFrontType(shopName, null,request,response);
		CommonPageService service = serviceMap.get(template);
		if(service == null){
			service = serviceMap.get(TemplateEnum.DEFAULT);
		}
		return service;
	}
	
	/**
	 * Sets the service map.
	 * 
	 * @param serviceMap
	 *            the service map
	 */
	public void setServiceMap(Map<String, CommonPageService> serviceMap) {
		this.serviceMap = serviceMap;
	}

	public void setShopDetailService(ShopDetailService shopDetailService) {
		this.shopDetailService = shopDetailService;
	}
	

}