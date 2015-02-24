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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Configuration}.
 * </p>
 *
 * @author Flor|Ale
 * @see Configuration
 * @generated
 */
public class ConfigurationWrapper implements Configuration,
	ModelWrapper<Configuration> {
	public ConfigurationWrapper(Configuration configuration) {
		_configuration = configuration;
	}

	@Override
	public Class<?> getModelClass() {
		return Configuration.class;
	}

	@Override
	public String getModelClassName() {
		return Configuration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("apiKey", getApiKey());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("apiSecret", getApiSecret());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String apiKey = (String)attributes.get("apiKey");

		if (apiKey != null) {
			setApiKey(apiKey);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String apiSecret = (String)attributes.get("apiSecret");

		if (apiSecret != null) {
			setApiSecret(apiSecret);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	* Returns the primary key of this configuration.
	*
	* @return the primary key of this configuration
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _configuration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this configuration.
	*
	* @param primaryKey the primary key of this configuration
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_configuration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the api key of this configuration.
	*
	* @return the api key of this configuration
	*/
	@Override
	public java.lang.String getApiKey() {
		return _configuration.getApiKey();
	}

	/**
	* Sets the api key of this configuration.
	*
	* @param apiKey the api key of this configuration
	*/
	@Override
	public void setApiKey(java.lang.String apiKey) {
		_configuration.setApiKey(apiKey);
	}

	/**
	* Returns the group ID of this configuration.
	*
	* @return the group ID of this configuration
	*/
	@Override
	public long getGroupId() {
		return _configuration.getGroupId();
	}

	/**
	* Sets the group ID of this configuration.
	*
	* @param groupId the group ID of this configuration
	*/
	@Override
	public void setGroupId(long groupId) {
		_configuration.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this configuration.
	*
	* @return the company ID of this configuration
	*/
	@Override
	public long getCompanyId() {
		return _configuration.getCompanyId();
	}

	/**
	* Sets the company ID of this configuration.
	*
	* @param companyId the company ID of this configuration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_configuration.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this configuration.
	*
	* @return the user ID of this configuration
	*/
	@Override
	public long getUserId() {
		return _configuration.getUserId();
	}

	/**
	* Sets the user ID of this configuration.
	*
	* @param userId the user ID of this configuration
	*/
	@Override
	public void setUserId(long userId) {
		_configuration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this configuration.
	*
	* @return the user uuid of this configuration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configuration.getUserUuid();
	}

	/**
	* Sets the user uuid of this configuration.
	*
	* @param userUuid the user uuid of this configuration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_configuration.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this configuration.
	*
	* @return the user name of this configuration
	*/
	@Override
	public java.lang.String getUserName() {
		return _configuration.getUserName();
	}

	/**
	* Sets the user name of this configuration.
	*
	* @param userName the user name of this configuration
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_configuration.setUserName(userName);
	}

	/**
	* Returns the create date of this configuration.
	*
	* @return the create date of this configuration
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _configuration.getCreateDate();
	}

	/**
	* Sets the create date of this configuration.
	*
	* @param createDate the create date of this configuration
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_configuration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this configuration.
	*
	* @return the modified date of this configuration
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _configuration.getModifiedDate();
	}

	/**
	* Sets the modified date of this configuration.
	*
	* @param modifiedDate the modified date of this configuration
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_configuration.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the api secret of this configuration.
	*
	* @return the api secret of this configuration
	*/
	@Override
	public java.lang.String getApiSecret() {
		return _configuration.getApiSecret();
	}

	/**
	* Sets the api secret of this configuration.
	*
	* @param apiSecret the api secret of this configuration
	*/
	@Override
	public void setApiSecret(java.lang.String apiSecret) {
		_configuration.setApiSecret(apiSecret);
	}

	/**
	* Returns the type of this configuration.
	*
	* @return the type of this configuration
	*/
	@Override
	public int getType() {
		return _configuration.getType();
	}

	/**
	* Sets the type of this configuration.
	*
	* @param type the type of this configuration
	*/
	@Override
	public void setType(int type) {
		_configuration.setType(type);
	}

	@Override
	public boolean isNew() {
		return _configuration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_configuration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _configuration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_configuration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _configuration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _configuration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_configuration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _configuration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_configuration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_configuration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_configuration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConfigurationWrapper((Configuration)_configuration.clone());
	}

	@Override
	public int compareTo(com.rcs.service.model.Configuration configuration) {
		return _configuration.compareTo(configuration);
	}

	@Override
	public int hashCode() {
		return _configuration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.service.model.Configuration> toCacheModel() {
		return _configuration.toCacheModel();
	}

	@Override
	public com.rcs.service.model.Configuration toEscapedModel() {
		return new ConfigurationWrapper(_configuration.toEscapedModel());
	}

	@Override
	public com.rcs.service.model.Configuration toUnescapedModel() {
		return new ConfigurationWrapper(_configuration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _configuration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _configuration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_configuration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConfigurationWrapper)) {
			return false;
		}

		ConfigurationWrapper configurationWrapper = (ConfigurationWrapper)obj;

		if (Validator.equals(_configuration, configurationWrapper._configuration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Configuration getWrappedConfiguration() {
		return _configuration;
	}

	@Override
	public Configuration getWrappedModel() {
		return _configuration;
	}

	@Override
	public void resetOriginalValues() {
		_configuration.resetOriginalValues();
	}

	private Configuration _configuration;
}