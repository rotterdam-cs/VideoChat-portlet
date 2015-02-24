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

package com.rcs.service.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.service.NoSuchConfigurationException;
import com.rcs.service.model.Configuration;
import com.rcs.service.model.impl.ConfigurationImpl;
import com.rcs.service.model.impl.ConfigurationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Flor|Ale
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
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ConfigurationPersistenceImpl() {
		setModelClass(Configuration.class);
	}

	/**
	 * Caches the configuration in the entity cache if it is enabled.
	 *
	 * @param configuration the configuration
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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

			if (!session.contains(configuration)) {
				configuration = (Configuration)session.get(ConfigurationImpl.class,
						configuration.getPrimaryKeyObj());
			}

			if (configuration != null) {
				session.delete(configuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (configuration != null) {
			clearCache(configuration);
		}

		return configuration;
	}

	@Override
	public Configuration updateImpl(
		com.rcs.service.model.Configuration configuration)
		throws SystemException {
		configuration = toUnwrappedModel(configuration);

		boolean isNew = configuration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (configuration.isNew()) {
				session.save(configuration);

				configuration.setNew(false);
			}
			else {
				session.merge(configuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

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
	 * @throws com.rcs.service.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConfigurationException, SystemException {
		Configuration configuration = fetchByPrimaryKey(primaryKey);

		if (configuration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return configuration;
	}

	/**
	 * Returns the configuration with the primary key or throws a {@link com.rcs.service.NoSuchConfigurationException} if it could not be found.
	 *
	 * @param apiKey the primary key of the configuration
	 * @return the configuration
	 * @throws com.rcs.service.NoSuchConfigurationException if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration findByPrimaryKey(String apiKey)
		throws NoSuchConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)apiKey);
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
		Configuration configuration = (Configuration)EntityCacheUtil.getResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ConfigurationImpl.class, primaryKey);

		if (configuration == _nullConfiguration) {
			return null;
		}

		if (configuration == null) {
			Session session = null;

			try {
				session = openSession();

				configuration = (Configuration)session.get(ConfigurationImpl.class,
						primaryKey);

				if (configuration != null) {
					cacheResult(configuration);
				}
				else {
					EntityCacheUtil.putResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ConfigurationImpl.class, primaryKey, _nullConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					ConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return configuration;
	}

	/**
	 * Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param apiKey the primary key of the configuration
	 * @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Configuration fetchByPrimaryKey(String apiKey)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)apiKey);
	}

	/**
	 * Returns all the configurations.
	 *
	 * @return the configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @return the range of configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of configurations
	 * @param end the upper bound of the range of configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Configuration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
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

				if (pagination) {
					sql = sql.concat(ConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Configuration>(list);
				}
				else {
					list = (List<Configuration>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
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
	@Override
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
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONFIGURATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
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
							getClassLoader(), listenerClassName));
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
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONFIGURATION = "SELECT configuration FROM Configuration configuration";
	private static final String _SQL_COUNT_CONFIGURATION = "SELECT COUNT(configuration) FROM Configuration configuration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "configuration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Configuration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConfigurationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
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
			@Override
			public Configuration toEntityModel() {
				return _nullConfiguration;
			}
		};
}