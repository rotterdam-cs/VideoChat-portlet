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

package com.rcs.service.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Configuration}.
 * </p>
 *
 * @author    flor
 * @see       Configuration
 * @generated
 */
public class ConfigurationWrapper implements Configuration,
	ModelWrapper<Configuration> {
	public ConfigurationWrapper(Configuration configuration) {
		_configuration = configuration;
	}

	public Class<?> getModelClass() {
		return Configuration.class;
	}

	public String getModelClassName() {
		return Configuration.class.getName();
	}

	/**
	* Returns the primary key of this configuration.
	*
	* @return the primary key of this configuration
	*/
	public java.lang.String getPrimaryKey() {
		return _configuration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this configuration.
	*
	* @param primaryKey the primary key of this configuration
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_configuration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the api key of this configuration.
	*
	* @return the api key of this configuration
	*/
	public java.lang.String getApiKey() {
		return _configuration.getApiKey();
	}

	/**
	* Sets the api key of this configuration.
	*
	* @param apiKey the api key of this configuration
	*/
	public void setApiKey(java.lang.String apiKey) {
		_configuration.setApiKey(apiKey);
	}

	/**
	* Returns the group ID of this configuration.
	*
	* @return the group ID of this configuration
	*/
	public long getGroupId() {
		return _configuration.getGroupId();
	}

	/**
	* Sets the group ID of this configuration.
	*
	* @param groupId the group ID of this configuration
	*/
	public void setGroupId(long groupId) {
		_configuration.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this configuration.
	*
	* @return the company ID of this configuration
	*/
	public long getCompanyId() {
		return _configuration.getCompanyId();
	}

	/**
	* Sets the company ID of this configuration.
	*
	* @param companyId the company ID of this configuration
	*/
	public void setCompanyId(long companyId) {
		_configuration.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this configuration.
	*
	* @return the user ID of this configuration
	*/
	public long getUserId() {
		return _configuration.getUserId();
	}

	/**
	* Sets the user ID of this configuration.
	*
	* @param userId the user ID of this configuration
	*/
	public void setUserId(long userId) {
		_configuration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this configuration.
	*
	* @return the user uuid of this configuration
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configuration.getUserUuid();
	}

	/**
	* Sets the user uuid of this configuration.
	*
	* @param userUuid the user uuid of this configuration
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_configuration.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this configuration.
	*
	* @return the user name of this configuration
	*/
	public java.lang.String getUserName() {
		return _configuration.getUserName();
	}

	/**
	* Sets the user name of this configuration.
	*
	* @param userName the user name of this configuration
	*/
	public void setUserName(java.lang.String userName) {
		_configuration.setUserName(userName);
	}

	/**
	* Returns the create date of this configuration.
	*
	* @return the create date of this configuration
	*/
	public java.util.Date getCreateDate() {
		return _configuration.getCreateDate();
	}

	/**
	* Sets the create date of this configuration.
	*
	* @param createDate the create date of this configuration
	*/
	public void setCreateDate(java.util.Date createDate) {
		_configuration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this configuration.
	*
	* @return the modified date of this configuration
	*/
	public java.util.Date getModifiedDate() {
		return _configuration.getModifiedDate();
	}

	/**
	* Sets the modified date of this configuration.
	*
	* @param modifiedDate the modified date of this configuration
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_configuration.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the api secret of this configuration.
	*
	* @return the api secret of this configuration
	*/
	public java.lang.String getApiSecret() {
		return _configuration.getApiSecret();
	}

	/**
	* Sets the api secret of this configuration.
	*
	* @param apiSecret the api secret of this configuration
	*/
	public void setApiSecret(java.lang.String apiSecret) {
		_configuration.setApiSecret(apiSecret);
	}

	/**
	* Returns the type of this configuration.
	*
	* @return the type of this configuration
	*/
	public int getType() {
		return _configuration.getType();
	}

	/**
	* Sets the type of this configuration.
	*
	* @param type the type of this configuration
	*/
	public void setType(int type) {
		_configuration.setType(type);
	}

	public boolean isNew() {
		return _configuration.isNew();
	}

	public void setNew(boolean n) {
		_configuration.setNew(n);
	}

	public boolean isCachedModel() {
		return _configuration.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_configuration.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _configuration.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _configuration.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_configuration.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _configuration.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_configuration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConfigurationWrapper((Configuration)_configuration.clone());
	}

	public int compareTo(com.rcs.service.model.Configuration configuration) {
		return _configuration.compareTo(configuration);
	}

	@Override
	public int hashCode() {
		return _configuration.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.rcs.service.model.Configuration> toCacheModel() {
		return _configuration.toCacheModel();
	}

	public com.rcs.service.model.Configuration toEscapedModel() {
		return new ConfigurationWrapper(_configuration.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _configuration.toString();
	}

	public java.lang.String toXmlString() {
		return _configuration.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_configuration.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Configuration getWrappedConfiguration() {
		return _configuration;
	}

	public Configuration getWrappedModel() {
		return _configuration;
	}

	public void resetOriginalValues() {
		_configuration.resetOriginalValues();
	}

	private Configuration _configuration;
}