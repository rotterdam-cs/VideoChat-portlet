/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rcs.service.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.opentok.api.API_Config;
import com.rcs.service.model.ChatRoom;
import com.rcs.service.model.Configuration;
import com.rcs.service.service.ConfigurationLocalServiceUtil;
import com.rcs.service.service.base.ConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.service.service.ConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author flor
 * @see com.rcs.service.service.base.ConfigurationLocalServiceBaseImpl
 * @see com.rcs.service.service.ConfigurationLocalServiceUtil
 */
public class ConfigurationLocalServiceImpl
	extends ConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rcs.service.service.ConfigurationLocalServiceUtil} to access the configuration local service.
	 */
	public Configuration updateConfiguration(long userId, String apiKey, String apiSecret, int type) throws PortalException, SystemException {
		User user = UserUtil.findByPrimaryKey(userId);
	    Date now = new Date();
	    
	    configurationPersistence.removeAll();
	    Configuration configuration = configurationPersistence.create(apiKey);
    	    		    	   	    
	    configuration.setApiSecret(apiSecret.trim());
	    configuration.setType(type);
	    
	    configuration.setCreateDate(now);
	    configuration.setUserId(user.getUserId());
	    configuration.setCompanyId(user.getCompanyId());
	    configuration.setUserName(user.getFullName());	    
	    configuration.setModifiedDate(now);
	    
	    configuration = configurationPersistence.update(configuration, false);	    
	    configurationPersistence.clearCache();	    	    
	    return configuration;
	}
	
	public boolean isTestServer() {
		try {
			List<Configuration> configurations = configurationPersistence.findAll();			
			if(configurations.size() > 0) {
	    		Configuration configuration = configurations.get(0);
	    		System.out.println("is test server: " + (configuration.getType() == 0));
	    		return (configuration.getType() == 0);    			
	    	}
		} catch(SystemException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}			
		System.out.println("is test server: derecho al true");
		return true;
	}
	
	public String getApiKey() {
		try {
			List<Configuration> configurations = configurationPersistence.findAll();			
			if(configurations.size() > 0) {
	    		Configuration configuration = configurations.get(0);
	    		return configuration.getApiKey();
	    	}
		} catch(SystemException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}				
		return "";
	}
	
	public String getApiSecret() {
		try {
			List<Configuration> configurations = configurationPersistence.findAll();
			if(configurations.size() > 0) {
	    		Configuration configuration = configurations.get(0);
	    		return configuration.getApiSecret();
	    	}
		} catch(SystemException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}				
		return "";
	}
}