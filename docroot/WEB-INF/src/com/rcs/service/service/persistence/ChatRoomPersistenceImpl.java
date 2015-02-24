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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.service.NoSuchChatRoomException;
import com.rcs.service.model.ChatRoom;
import com.rcs.service.model.impl.ChatRoomImpl;
import com.rcs.service.model.impl.ChatRoomModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the chat room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Flor|Ale
 * @see ChatRoomPersistence
 * @see ChatRoomUtil
 * @generated
 */
public class ChatRoomPersistenceImpl extends BasePersistenceImpl<ChatRoom>
	implements ChatRoomPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChatRoomUtil} to access the chat room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChatRoomImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ChatRoomPersistenceImpl() {
		setModelClass(ChatRoom.class);
	}

	/**
	 * Caches the chat room in the entity cache if it is enabled.
	 *
	 * @param chatRoom the chat room
	 */
	@Override
	public void cacheResult(ChatRoom chatRoom) {
		EntityCacheUtil.putResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomImpl.class, chatRoom.getPrimaryKey(), chatRoom);

		chatRoom.resetOriginalValues();
	}

	/**
	 * Caches the chat rooms in the entity cache if it is enabled.
	 *
	 * @param chatRooms the chat rooms
	 */
	@Override
	public void cacheResult(List<ChatRoom> chatRooms) {
		for (ChatRoom chatRoom : chatRooms) {
			if (EntityCacheUtil.getResult(
						ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
						ChatRoomImpl.class, chatRoom.getPrimaryKey()) == null) {
				cacheResult(chatRoom);
			}
			else {
				chatRoom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chat rooms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChatRoomImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChatRoomImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chat room.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChatRoom chatRoom) {
		EntityCacheUtil.removeResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomImpl.class, chatRoom.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ChatRoom> chatRooms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChatRoom chatRoom : chatRooms) {
			EntityCacheUtil.removeResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
				ChatRoomImpl.class, chatRoom.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chat room with the primary key. Does not add the chat room to the database.
	 *
	 * @param chatRoomId the primary key for the new chat room
	 * @return the new chat room
	 */
	@Override
	public ChatRoom create(long chatRoomId) {
		ChatRoom chatRoom = new ChatRoomImpl();

		chatRoom.setNew(true);
		chatRoom.setPrimaryKey(chatRoomId);

		return chatRoom;
	}

	/**
	 * Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chatRoomId the primary key of the chat room
	 * @return the chat room that was removed
	 * @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoom remove(long chatRoomId)
		throws NoSuchChatRoomException, SystemException {
		return remove((Serializable)chatRoomId);
	}

	/**
	 * Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chat room
	 * @return the chat room that was removed
	 * @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoom remove(Serializable primaryKey)
		throws NoSuchChatRoomException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChatRoom chatRoom = (ChatRoom)session.get(ChatRoomImpl.class,
					primaryKey);

			if (chatRoom == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChatRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chatRoom);
		}
		catch (NoSuchChatRoomException nsee) {
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
	protected ChatRoom removeImpl(ChatRoom chatRoom) throws SystemException {
		chatRoom = toUnwrappedModel(chatRoom);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chatRoom)) {
				chatRoom = (ChatRoom)session.get(ChatRoomImpl.class,
						chatRoom.getPrimaryKeyObj());
			}

			if (chatRoom != null) {
				session.delete(chatRoom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chatRoom != null) {
			clearCache(chatRoom);
		}

		return chatRoom;
	}

	@Override
	public ChatRoom updateImpl(com.rcs.service.model.ChatRoom chatRoom)
		throws SystemException {
		chatRoom = toUnwrappedModel(chatRoom);

		boolean isNew = chatRoom.isNew();

		Session session = null;

		try {
			session = openSession();

			if (chatRoom.isNew()) {
				session.save(chatRoom);

				chatRoom.setNew(false);
			}
			else {
				session.merge(chatRoom);
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

		EntityCacheUtil.putResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomImpl.class, chatRoom.getPrimaryKey(), chatRoom);

		return chatRoom;
	}

	protected ChatRoom toUnwrappedModel(ChatRoom chatRoom) {
		if (chatRoom instanceof ChatRoomImpl) {
			return chatRoom;
		}

		ChatRoomImpl chatRoomImpl = new ChatRoomImpl();

		chatRoomImpl.setNew(chatRoom.isNew());
		chatRoomImpl.setPrimaryKey(chatRoom.getPrimaryKey());

		chatRoomImpl.setChatRoomId(chatRoom.getChatRoomId());
		chatRoomImpl.setGroupId(chatRoom.getGroupId());
		chatRoomImpl.setCompanyId(chatRoom.getCompanyId());
		chatRoomImpl.setUserId(chatRoom.getUserId());
		chatRoomImpl.setUserName(chatRoom.getUserName());
		chatRoomImpl.setCreateDate(chatRoom.getCreateDate());
		chatRoomImpl.setModifiedDate(chatRoom.getModifiedDate());
		chatRoomImpl.setSessionId(chatRoom.getSessionId());
		chatRoomImpl.setName(chatRoom.getName());
		chatRoomImpl.setDescription(chatRoom.getDescription());

		return chatRoomImpl;
	}

	/**
	 * Returns the chat room with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat room
	 * @return the chat room
	 * @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChatRoomException, SystemException {
		ChatRoom chatRoom = fetchByPrimaryKey(primaryKey);

		if (chatRoom == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChatRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chatRoom;
	}

	/**
	 * Returns the chat room with the primary key or throws a {@link com.rcs.service.NoSuchChatRoomException} if it could not be found.
	 *
	 * @param chatRoomId the primary key of the chat room
	 * @return the chat room
	 * @throws com.rcs.service.NoSuchChatRoomException if a chat room with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoom findByPrimaryKey(long chatRoomId)
		throws NoSuchChatRoomException, SystemException {
		return findByPrimaryKey((Serializable)chatRoomId);
	}

	/**
	 * Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat room
	 * @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoom fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChatRoom chatRoom = (ChatRoom)EntityCacheUtil.getResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
				ChatRoomImpl.class, primaryKey);

		if (chatRoom == _nullChatRoom) {
			return null;
		}

		if (chatRoom == null) {
			Session session = null;

			try {
				session = openSession();

				chatRoom = (ChatRoom)session.get(ChatRoomImpl.class, primaryKey);

				if (chatRoom != null) {
					cacheResult(chatRoom);
				}
				else {
					EntityCacheUtil.putResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
						ChatRoomImpl.class, primaryKey, _nullChatRoom);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
					ChatRoomImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chatRoom;
	}

	/**
	 * Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chatRoomId the primary key of the chat room
	 * @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoom fetchByPrimaryKey(long chatRoomId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)chatRoomId);
	}

	/**
	 * Returns all the chat rooms.
	 *
	 * @return the chat rooms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoom> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat rooms
	 * @param end the upper bound of the range of chat rooms (not inclusive)
	 * @return the range of chat rooms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoom> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat rooms
	 * @param end the upper bound of the range of chat rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chat rooms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoom> findAll(int start, int end,
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

		List<ChatRoom> list = (List<ChatRoom>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHATROOM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHATROOM;

				if (pagination) {
					sql = sql.concat(ChatRoomModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChatRoom>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChatRoom>(list);
				}
				else {
					list = (List<ChatRoom>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the chat rooms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChatRoom chatRoom : findAll()) {
			remove(chatRoom);
		}
	}

	/**
	 * Returns the number of chat rooms.
	 *
	 * @return the number of chat rooms
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

				Query q = session.createQuery(_SQL_COUNT_CHATROOM);

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

	/**
	 * Initializes the chat room persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.service.model.ChatRoom")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChatRoom>> listenersList = new ArrayList<ModelListener<ChatRoom>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChatRoom>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChatRoomImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHATROOM = "SELECT chatRoom FROM ChatRoom chatRoom";
	private static final String _SQL_COUNT_CHATROOM = "SELECT COUNT(chatRoom) FROM ChatRoom chatRoom";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chatRoom.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatRoom exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChatRoomPersistenceImpl.class);
	private static ChatRoom _nullChatRoom = new ChatRoomImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChatRoom> toCacheModel() {
				return _nullChatRoomCacheModel;
			}
		};

	private static CacheModel<ChatRoom> _nullChatRoomCacheModel = new CacheModel<ChatRoom>() {
			@Override
			public ChatRoom toEntityModel() {
				return _nullChatRoom;
			}
		};
}