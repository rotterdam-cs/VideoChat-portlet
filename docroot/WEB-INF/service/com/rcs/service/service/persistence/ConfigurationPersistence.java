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

package com.rcs.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.service.model.Configuration;

/**
 * The persistence interface for the configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see ConfigurationPersistenceImpl
 * @see ConfigurationUtil
 * @generated
 */
public interface ConfigurationPersistence extends BasePersistence<Configuration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConfigurationUtil} to access the configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the configuration in the entity cache if it is enabled.
	*
	* @param configuration the configuration
	*/
	public void cacheResult(com.rcs.service.model.Configuration configuration);

	/**
	* Caches the configurations in the entity cache if it is enabled.
	*
	* @param configurations the configurations
	*/
	public void cacheResult(
		java.util.List<com.rcs.service.model.Configuration> configurations);

	/**
	* Creates a new configuration with the primary key. Does not add the configuration to the database.
	*
	* @param apiKey the primary key for the new configuration
	* @return the new configuration
	*/
	public com.rcs.service.model.Configuration create(java.lang.String apiKey);

	/**
	* Removes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param apiKey the primary key of the configuration
	* @return the configuration that was removed
	* @throws com.rcs.service.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.Configuration remove(java.lang.String apiKey)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchConfigurationException;

	public com.rcs.service.model.Configuration updateImpl(
		com.rcs.service.model.Configuration configuration, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration with the primary key or throws a {@link com.rcs.service.NoSuchConfigurationException} if it could not be found.
	*
	* @param apiKey the primary key of the configuration
	* @return the configuration
	* @throws com.rcs.service.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.Configuration findByPrimaryKey(
		java.lang.String apiKey)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchConfigurationException;

	/**
	* Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param apiKey the primary key of the configuration
	* @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.Configuration fetchByPrimaryKey(
		java.lang.String apiKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configurations.
	*
	* @return the configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.Configuration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @return the range of configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.Configuration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.Configuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configurations.
	*
	* @return the number of configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}