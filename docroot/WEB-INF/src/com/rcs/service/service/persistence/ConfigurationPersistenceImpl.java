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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.service.NoSuchConfigurationException;
import com.rcs.service.model.Configuration;
import com.rcs.service.model.impl.ConfigurationImpl;
import com.rcs.service.model.impl.ConfigurationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see ConfigurationPersistence
 * @see ConfigurationUtil
 * @generated
 */
public class ConfigurationPersistenceImpl extends BasePersistenceImpl<Configuration>
	implements ConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConfigurationUtil} to access the configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the configuration in the entity cache if it is enabled.
	 *
	 * @param configuration the configuration
	 */
	public void cacheResult(Configuration configuration) {
		EntityCacheUtil.putResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationImpl.class, configuration.getPrimaryKey(),
			configuration);

		configuration.resetOriginalValues();
	}

	/**
	 * Caches the configurations in the entity cache if it is enabled.
	 *
	 * @param configurations the configurations
	 */
	public void cacheResult(List<Configuration> configurations) {
		for (Configuration configuration : configurations) {
			if (EntityCacheUtil.getResult(
						ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ConfigurationImpl.class, configuration.getPrimaryKey()) == null) {
				cacheResult(configuration);
			}
			else {
				configuration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Configuration configuration) {
		EntityCacheUtil.removeResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationImpl.class, configuration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Configuration> configurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Configuration configuration : configurations) {
			EntityCacheUtil.removeResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ConfigurationImpl.class, configuration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new configuration with the primary key. Does not add the configuration to the database.
	 *
	 * @param apiKey the primary key for the new configuration
	 * @return the new configuration
	 */
	public Configuration create(String apiKey) {
		Configuration configuration = new ConfigurationImpl();

		configuration.setNew(true);
		configuration.setPrimaryKey(apiKey);

		return configuration;
	}

	/**
	 * Removes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param apiKey the primary key of the configuration
	 * @return the configuration that was removed
	 * @throws com.rcs.service.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Configuration remove(String apiKey)
		throws NoSuchConfigurationException, SystemException {
		return remove((Serializable)apiKey);
	}

	/**
	 * Removes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the configuration
	 * @return the configuration that was removed
	 * @throws com.rcs.service.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration remove(Serializable primaryKey)
		throws NoSuchConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Configuration configuration = (Configuration)session.get(ConfigurationImpl.class,
					primaryKey);

			if (configuration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(configuration);
		}
		catch (NoSuchConfigurationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Configuration removeImpl(Configuration configuration)
		throws SystemException {
		configuration = toUnwrappedModel(configuration);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, configuration);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(configuration);

		return configuration;
	}

	@Override
	public Configuration updateImpl(
		com.rcs.service.model.Configuration configuration, boolean merge)
		throws SystemException {
		configuration = toUnwrappedModel(configuration);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, configuration, merge);

			configuration.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationImpl.class, configuration.getPrimaryKey(),
			configuration);

		return configuration;
	}

	protected Configuration toUnwrappedModel(Configuration configuration) {
		if (configuration instanceof ConfigurationImpl) {
			return configuration;
		}

		ConfigurationImpl configurationImpl = new ConfigurationImpl();

		configurationImpl.setNew(configuration.isNew());
		configurationImpl.setPrimaryKey(configuration.getPrimaryKey());

		configurationImpl.setApiKey(configuration.getApiKey());
		configurationImpl.setGroupId(configuration.getGroupId());
		configurationImpl.setCompanyId(configuration.getCompanyId());
		configurationImpl.setUserId(configuration.getUserId());
		configurationImpl.setUserName(configuration.getUserName());
		configurationImpl.setCreateDate(configuration.getCreateDate());
		configurationImpl.setModifiedDate(configuration.getModifiedDate());
		configurationImpl.setApiSecret(configuration.getApiSecret());
		configurationImpl.setType(configuration.getType());

		return configurationImpl;
	}

	/**
	 * Returns the configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuration
	 * @return the configuration
	 * @throws com.liferay.portal.NoSuchModelException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the configuration with the primary key or throws a {@link com.rcs.service.NoSuchConfigurationException} if it could not be found.
	 *
	 * @param apiKey the primary key of the configuration
	 * @return the configuration
	 * @throws com.rcs.service.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Configuration findByPrimaryKey(String apiKey)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByPrimaryKey(apiKey);

		if (configuration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + apiKey);
			}

			throw new NoSuchConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				apiKey);
		}

		return configuration;
	}

	/**
	 * Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuration
	 * @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param apiKey the primary key of the configuration
	 * @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Configuration fetchByPrimaryKey(String apiKey)
		throws SystemException {
		Configuration configuration = (Configuration)EntityCacheUtil.getResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ConfigurationImpl.class, apiKey);

		if (configuration == _nullConfiguration) {
			return null;
		}

		if (configuration == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				configuration = (Configuration)session.get(ConfigurationImpl.class,
						apiKey);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (configuration != null) {
					cacheResult(configuration);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ConfigurationImpl.class, apiKey, _nullConfiguration);
				}

				closeSession(session);
			}
		}

		return configuration;
	}

	/**
	 * Returns all the configurations.
	 *
	 * @return the configurations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Configuration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Configuration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Configuration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Configuration> list = (List<Configuration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONFIGURATION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Configuration configuration : findAll()) {
			remove(configuration);
		}
	}

	/**
	 * Returns the number of configurations.
	 *
	 * @return the number of configurations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONFIGURATION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.service.model.Configuration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Configuration>> listenersList = new ArrayList<ModelListener<Configuration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Configuration>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ChatRoomPersistence.class)
	protected ChatRoomPersistence chatRoomPersistence;
	@BeanReference(type = ChatRoomGroupPersistence.class)
	protected ChatRoomGroupPersistence chatRoomGroupPersistence;
	@BeanReference(type = ConfigurationPersistence.class)
	protected ConfigurationPersistence configurationPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CONFIGURATION = "SELECT configuration FROM Configuration configuration";
	private static final String _SQL_COUNT_CONFIGURATION = "SELECT COUNT(configuration) FROM Configuration configuration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "configuration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Configuration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConfigurationPersistenceImpl.class);
	private static Configuration _nullConfiguration = new ConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Configuration> toCacheModel() {
				return _nullConfigurationCacheModel;
			}
		};

	private static CacheModel<Configuration> _nullConfigurationCacheModel = new CacheModel<Configuration>() {
			public Configuration toEntityModel() {
				return _nullConfiguration;
			}
		};
}