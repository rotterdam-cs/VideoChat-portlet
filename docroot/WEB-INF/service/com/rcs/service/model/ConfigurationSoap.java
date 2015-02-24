/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rcs.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Flor|Ale
 * @generated
 */
public class ConfigurationSoap implements Serializable {
	public static ConfigurationSoap toSoapModel(Configuration model) {
		ConfigurationSoap soapModel = new ConfigurationSoap();

		soapModel.setApiKey(model.getApiKey());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApiSecret(model.getApiSecret());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static ConfigurationSoap[] toSoapModels(Configuration[] models) {
		ConfigurationSoap[] soapModels = new ConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConfigurationSoap[][] toSoapModels(Configuration[][] models) {
		ConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConfigurationSoap[] toSoapModels(List<Configuration> models) {
		List<ConfigurationSoap> soapModels = new ArrayList<ConfigurationSoap>(models.size());

		for (Configuration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConfigurationSoap[soapModels.size()]);
	}

	public ConfigurationSoap() {
	}

	public String getPrimaryKey() {
		return _apiKey;
	}

	public void setPrimaryKey(String pk) {
		setApiKey(pk);
	}

	public String getApiKey() {
		return _apiKey;
	}

	public void setApiKey(String apiKey) {
		_apiKey = apiKey;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getApiSecret() {
		return _apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		_apiSecret = apiSecret;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private String _apiKey;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _apiSecret;
	private int _type;
}