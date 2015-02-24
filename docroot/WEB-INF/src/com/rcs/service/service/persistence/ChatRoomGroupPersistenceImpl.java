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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.service.NoSuchChatRoomGroupException;
import com.rcs.service.model.ChatRoomGroup;
import com.rcs.service.model.impl.ChatRoomGroupImpl;
import com.rcs.service.model.impl.ChatRoomGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the chat room group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Flor|Ale
 * @see ChatRoomGroupPersistence
 * @see ChatRoomGroupUtil
 * @generated
 */
public class ChatRoomGroupPersistenceImpl extends BasePersistenceImpl<ChatRoomGroup>
	implements ChatRoomGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChatRoomGroupUtil} to access the chat room group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChatRoomGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED,
			ChatRoomGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED,
			ChatRoomGroupImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BY_CHATROOMID =
		new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED,
			ChatRoomGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBY_chatRoomId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMID =
		new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED,
			ChatRoomGroupImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBY_chatRoomId", new String[] { Long.class.getName() },
			ChatRoomGroupModelImpl.CHATROOMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BY_CHATROOMID = new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBY_chatRoomId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the chat room groups where chatRoomId = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @return the matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findByBY_chatRoomId(long chatRoomId)
		throws SystemException {
		return findByBY_chatRoomId(chatRoomId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat room groups where chatRoomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chatRoomId the chat room ID
	 * @param start the lower bound of the range of chat room groups
	 * @param end the upper bound of the range of chat room groups (not inclusive)
	 * @return the range of matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findByBY_chatRoomId(long chatRoomId, int start,
		int end) throws SystemException {
		return findByBY_chatRoomId(chatRoomId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat room groups where chatRoomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chatRoomId the chat room ID
	 * @param start the lower bound of the range of chat room groups
	 * @param end the upper bound of the range of chat room groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findByBY_chatRoomId(long chatRoomId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMID;
			finderArgs = new Object[] { chatRoomId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BY_CHATROOMID;
			finderArgs = new Object[] { chatRoomId, start, end, orderByComparator };
		}

		List<ChatRoomGroup> list = (List<ChatRoomGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChatRoomGroup chatRoomGroup : list) {
				if ((chatRoomId != chatRoomGroup.getChatRoomId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CHATROOMGROUP_WHERE);

			query.append(_FINDER_COLUMN_BY_CHATROOMID_CHATROOMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChatRoomGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chatRoomId);

				if (!pagination) {
					list = (List<ChatRoomGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChatRoomGroup>(list);
				}
				else {
					list = (List<ChatRoomGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chat room group in the ordered set where chatRoomId = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup findByBY_chatRoomId_First(long chatRoomId,
		OrderByComparator orderByComparator)
		throws NoSuchChatRoomGroupException, SystemException {
		ChatRoomGroup chatRoomGroup = fetchByBY_chatRoomId_First(chatRoomId,
				orderByComparator);

		if (chatRoomGroup != null) {
			return chatRoomGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chatRoomId=");
		msg.append(chatRoomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChatRoomGroupException(msg.toString());
	}

	/**
	 * Returns the first chat room group in the ordered set where chatRoomId = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat room group, or <code>null</code> if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup fetchByBY_chatRoomId_First(long chatRoomId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ChatRoomGroup> list = findByBY_chatRoomId(chatRoomId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chat room group in the ordered set where chatRoomId = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup findByBY_chatRoomId_Last(long chatRoomId,
		OrderByComparator orderByComparator)
		throws NoSuchChatRoomGroupException, SystemException {
		ChatRoomGroup chatRoomGroup = fetchByBY_chatRoomId_Last(chatRoomId,
				orderByComparator);

		if (chatRoomGroup != null) {
			return chatRoomGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chatRoomId=");
		msg.append(chatRoomId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChatRoomGroupException(msg.toString());
	}

	/**
	 * Returns the last chat room group in the ordered set where chatRoomId = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat room group, or <code>null</code> if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup fetchByBY_chatRoomId_Last(long chatRoomId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBY_chatRoomId(chatRoomId);

		if (count == 0) {
			return null;
		}

		List<ChatRoomGroup> list = findByBY_chatRoomId(chatRoomId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chat room groups before and after the current chat room group in the ordered set where chatRoomId = &#63;.
	 *
	 * @param chatRoomGroupPK the primary key of the current chat room group
	 * @param chatRoomId the chat room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup[] findByBY_chatRoomId_PrevAndNext(
		ChatRoomGroupPK chatRoomGroupPK, long chatRoomId,
		OrderByComparator orderByComparator)
		throws NoSuchChatRoomGroupException, SystemException {
		ChatRoomGroup chatRoomGroup = findByPrimaryKey(chatRoomGroupPK);

		Session session = null;

		try {
			session = openSession();

			ChatRoomGroup[] array = new ChatRoomGroupImpl[3];

			array[0] = getByBY_chatRoomId_PrevAndNext(session, chatRoomGroup,
					chatRoomId, orderByComparator, true);

			array[1] = chatRoomGroup;

			array[2] = getByBY_chatRoomId_PrevAndNext(session, chatRoomGroup,
					chatRoomId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChatRoomGroup getByBY_chatRoomId_PrevAndNext(Session session,
		ChatRoomGroup chatRoomGroup, long chatRoomId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHATROOMGROUP_WHERE);

		query.append(_FINDER_COLUMN_BY_CHATROOMID_CHATROOMID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ChatRoomGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chatRoomId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chatRoomGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChatRoomGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chat room groups where chatRoomId = &#63; from the database.
	 *
	 * @param chatRoomId the chat room ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBY_chatRoomId(long chatRoomId)
		throws SystemException {
		for (ChatRoomGroup chatRoomGroup : findByBY_chatRoomId(chatRoomId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chatRoomGroup);
		}
	}

	/**
	 * Returns the number of chat room groups where chatRoomId = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @return the number of matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBY_chatRoomId(long chatRoomId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BY_CHATROOMID;

		Object[] finderArgs = new Object[] { chatRoomId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHATROOMGROUP_WHERE);

			query.append(_FINDER_COLUMN_BY_CHATROOMID_CHATROOMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chatRoomId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BY_CHATROOMID_CHATROOMID_2 = "chatRoomGroup.id.chatRoomId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BY_CHATROOMIDANDTYPE =
		new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED,
			ChatRoomGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBY_chatRoomIdAndType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMIDANDTYPE =
		new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED,
			ChatRoomGroupImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBY_chatRoomIdAndType",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ChatRoomGroupModelImpl.CHATROOMID_COLUMN_BITMASK |
			ChatRoomGroupModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BY_CHATROOMIDANDTYPE = new FinderPath(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBY_chatRoomIdAndType",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the chat room groups where chatRoomId = &#63; and type = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @return the matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findByBY_chatRoomIdAndType(long chatRoomId,
		int type) throws SystemException {
		return findByBY_chatRoomIdAndType(chatRoomId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat room groups where chatRoomId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @param start the lower bound of the range of chat room groups
	 * @param end the upper bound of the range of chat room groups (not inclusive)
	 * @return the range of matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findByBY_chatRoomIdAndType(long chatRoomId,
		int type, int start, int end) throws SystemException {
		return findByBY_chatRoomIdAndType(chatRoomId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat room groups where chatRoomId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @param start the lower bound of the range of chat room groups
	 * @param end the upper bound of the range of chat room groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findByBY_chatRoomIdAndType(long chatRoomId,
		int type, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMIDANDTYPE;
			finderArgs = new Object[] { chatRoomId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BY_CHATROOMIDANDTYPE;
			finderArgs = new Object[] {
					chatRoomId, type,
					
					start, end, orderByComparator
				};
		}

		List<ChatRoomGroup> list = (List<ChatRoomGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChatRoomGroup chatRoomGroup : list) {
				if ((chatRoomId != chatRoomGroup.getChatRoomId()) ||
						(type != chatRoomGroup.getType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CHATROOMGROUP_WHERE);

			query.append(_FINDER_COLUMN_BY_CHATROOMIDANDTYPE_CHATROOMID_2);

			query.append(_FINDER_COLUMN_BY_CHATROOMIDANDTYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChatRoomGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chatRoomId);

				qPos.add(type);

				if (!pagination) {
					list = (List<ChatRoomGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChatRoomGroup>(list);
				}
				else {
					list = (List<ChatRoomGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup findByBY_chatRoomIdAndType_First(long chatRoomId,
		int type, OrderByComparator orderByComparator)
		throws NoSuchChatRoomGroupException, SystemException {
		ChatRoomGroup chatRoomGroup = fetchByBY_chatRoomIdAndType_First(chatRoomId,
				type, orderByComparator);

		if (chatRoomGroup != null) {
			return chatRoomGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chatRoomId=");
		msg.append(chatRoomId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChatRoomGroupException(msg.toString());
	}

	/**
	 * Returns the first chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat room group, or <code>null</code> if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup fetchByBY_chatRoomIdAndType_First(long chatRoomId,
		int type, OrderByComparator orderByComparator)
		throws SystemException {
		List<ChatRoomGroup> list = findByBY_chatRoomIdAndType(chatRoomId, type,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup findByBY_chatRoomIdAndType_Last(long chatRoomId,
		int type, OrderByComparator orderByComparator)
		throws NoSuchChatRoomGroupException, SystemException {
		ChatRoomGroup chatRoomGroup = fetchByBY_chatRoomIdAndType_Last(chatRoomId,
				type, orderByComparator);

		if (chatRoomGroup != null) {
			return chatRoomGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chatRoomId=");
		msg.append(chatRoomId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChatRoomGroupException(msg.toString());
	}

	/**
	 * Returns the last chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat room group, or <code>null</code> if a matching chat room group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup fetchByBY_chatRoomIdAndType_Last(long chatRoomId,
		int type, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBY_chatRoomIdAndType(chatRoomId, type);

		if (count == 0) {
			return null;
		}

		List<ChatRoomGroup> list = findByBY_chatRoomIdAndType(chatRoomId, type,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chat room groups before and after the current chat room group in the ordered set where chatRoomId = &#63; and type = &#63;.
	 *
	 * @param chatRoomGroupPK the primary key of the current chat room group
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup[] findByBY_chatRoomIdAndType_PrevAndNext(
		ChatRoomGroupPK chatRoomGroupPK, long chatRoomId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchChatRoomGroupException, SystemException {
		ChatRoomGroup chatRoomGroup = findByPrimaryKey(chatRoomGroupPK);

		Session session = null;

		try {
			session = openSession();

			ChatRoomGroup[] array = new ChatRoomGroupImpl[3];

			array[0] = getByBY_chatRoomIdAndType_PrevAndNext(session,
					chatRoomGroup, chatRoomId, type, orderByComparator, true);

			array[1] = chatRoomGroup;

			array[2] = getByBY_chatRoomIdAndType_PrevAndNext(session,
					chatRoomGroup, chatRoomId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChatRoomGroup getByBY_chatRoomIdAndType_PrevAndNext(
		Session session, ChatRoomGroup chatRoomGroup, long chatRoomId,
		int type, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHATROOMGROUP_WHERE);

		query.append(_FINDER_COLUMN_BY_CHATROOMIDANDTYPE_CHATROOMID_2);

		query.append(_FINDER_COLUMN_BY_CHATROOMIDANDTYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ChatRoomGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chatRoomId);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chatRoomGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChatRoomGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chat room groups where chatRoomId = &#63; and type = &#63; from the database.
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBY_chatRoomIdAndType(long chatRoomId, int type)
		throws SystemException {
		for (ChatRoomGroup chatRoomGroup : findByBY_chatRoomIdAndType(
				chatRoomId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chatRoomGroup);
		}
	}

	/**
	 * Returns the number of chat room groups where chatRoomId = &#63; and type = &#63;.
	 *
	 * @param chatRoomId the chat room ID
	 * @param type the type
	 * @return the number of matching chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBY_chatRoomIdAndType(long chatRoomId, int type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BY_CHATROOMIDANDTYPE;

		Object[] finderArgs = new Object[] { chatRoomId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHATROOMGROUP_WHERE);

			query.append(_FINDER_COLUMN_BY_CHATROOMIDANDTYPE_CHATROOMID_2);

			query.append(_FINDER_COLUMN_BY_CHATROOMIDANDTYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chatRoomId);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BY_CHATROOMIDANDTYPE_CHATROOMID_2 =
		"chatRoomGroup.id.chatRoomId = ? AND ";
	private static final String _FINDER_COLUMN_BY_CHATROOMIDANDTYPE_TYPE_2 = "chatRoomGroup.type = ?";

	public ChatRoomGroupPersistenceImpl() {
		setModelClass(ChatRoomGroup.class);
	}

	/**
	 * Caches the chat room group in the entity cache if it is enabled.
	 *
	 * @param chatRoomGroup the chat room group
	 */
	@Override
	public void cacheResult(ChatRoomGroup chatRoomGroup) {
		EntityCacheUtil.putResult(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupImpl.class, chatRoomGroup.getPrimaryKey(),
			chatRoomGroup);

		chatRoomGroup.resetOriginalValues();
	}

	/**
	 * Caches the chat room groups in the entity cache if it is enabled.
	 *
	 * @param chatRoomGroups the chat room groups
	 */
	@Override
	public void cacheResult(List<ChatRoomGroup> chatRoomGroups) {
		for (ChatRoomGroup chatRoomGroup : chatRoomGroups) {
			if (EntityCacheUtil.getResult(
						ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
						ChatRoomGroupImpl.class, chatRoomGroup.getPrimaryKey()) == null) {
				cacheResult(chatRoomGroup);
			}
			else {
				chatRoomGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chat room groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChatRoomGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChatRoomGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chat room group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChatRoomGroup chatRoomGroup) {
		EntityCacheUtil.removeResult(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupImpl.class, chatRoomGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ChatRoomGroup> chatRoomGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChatRoomGroup chatRoomGroup : chatRoomGroups) {
			EntityCacheUtil.removeResult(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
				ChatRoomGroupImpl.class, chatRoomGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chat room group with the primary key. Does not add the chat room group to the database.
	 *
	 * @param chatRoomGroupPK the primary key for the new chat room group
	 * @return the new chat room group
	 */
	@Override
	public ChatRoomGroup create(ChatRoomGroupPK chatRoomGroupPK) {
		ChatRoomGroup chatRoomGroup = new ChatRoomGroupImpl();

		chatRoomGroup.setNew(true);
		chatRoomGroup.setPrimaryKey(chatRoomGroupPK);

		return chatRoomGroup;
	}

	/**
	 * Removes the chat room group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chatRoomGroupPK the primary key of the chat room group
	 * @return the chat room group that was removed
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup remove(ChatRoomGroupPK chatRoomGroupPK)
		throws NoSuchChatRoomGroupException, SystemException {
		return remove((Serializable)chatRoomGroupPK);
	}

	/**
	 * Removes the chat room group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chat room group
	 * @return the chat room group that was removed
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup remove(Serializable primaryKey)
		throws NoSuchChatRoomGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChatRoomGroup chatRoomGroup = (ChatRoomGroup)session.get(ChatRoomGroupImpl.class,
					primaryKey);

			if (chatRoomGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChatRoomGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chatRoomGroup);
		}
		catch (NoSuchChatRoomGroupException nsee) {
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
	protected ChatRoomGroup removeImpl(ChatRoomGroup chatRoomGroup)
		throws SystemException {
		chatRoomGroup = toUnwrappedModel(chatRoomGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chatRoomGroup)) {
				chatRoomGroup = (ChatRoomGroup)session.get(ChatRoomGroupImpl.class,
						chatRoomGroup.getPrimaryKeyObj());
			}

			if (chatRoomGroup != null) {
				session.delete(chatRoomGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chatRoomGroup != null) {
			clearCache(chatRoomGroup);
		}

		return chatRoomGroup;
	}

	@Override
	public ChatRoomGroup updateImpl(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup)
		throws SystemException {
		chatRoomGroup = toUnwrappedModel(chatRoomGroup);

		boolean isNew = chatRoomGroup.isNew();

		ChatRoomGroupModelImpl chatRoomGroupModelImpl = (ChatRoomGroupModelImpl)chatRoomGroup;

		Session session = null;

		try {
			session = openSession();

			if (chatRoomGroup.isNew()) {
				session.save(chatRoomGroup);

				chatRoomGroup.setNew(false);
			}
			else {
				session.merge(chatRoomGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChatRoomGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chatRoomGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chatRoomGroupModelImpl.getOriginalChatRoomId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BY_CHATROOMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMID,
					args);

				args = new Object[] { chatRoomGroupModelImpl.getChatRoomId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BY_CHATROOMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMID,
					args);
			}

			if ((chatRoomGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMIDANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chatRoomGroupModelImpl.getOriginalChatRoomId(),
						chatRoomGroupModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BY_CHATROOMIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMIDANDTYPE,
					args);

				args = new Object[] {
						chatRoomGroupModelImpl.getChatRoomId(),
						chatRoomGroupModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BY_CHATROOMIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BY_CHATROOMIDANDTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
			ChatRoomGroupImpl.class, chatRoomGroup.getPrimaryKey(),
			chatRoomGroup);

		return chatRoomGroup;
	}

	protected ChatRoomGroup toUnwrappedModel(ChatRoomGroup chatRoomGroup) {
		if (chatRoomGroup instanceof ChatRoomGroupImpl) {
			return chatRoomGroup;
		}

		ChatRoomGroupImpl chatRoomGroupImpl = new ChatRoomGroupImpl();

		chatRoomGroupImpl.setNew(chatRoomGroup.isNew());
		chatRoomGroupImpl.setPrimaryKey(chatRoomGroup.getPrimaryKey());

		chatRoomGroupImpl.setChatRoomId(chatRoomGroup.getChatRoomId());
		chatRoomGroupImpl.setChatRoomGroupId(chatRoomGroup.getChatRoomGroupId());
		chatRoomGroupImpl.setGroupId(chatRoomGroup.getGroupId());
		chatRoomGroupImpl.setCompanyId(chatRoomGroup.getCompanyId());
		chatRoomGroupImpl.setUserId(chatRoomGroup.getUserId());
		chatRoomGroupImpl.setUserName(chatRoomGroup.getUserName());
		chatRoomGroupImpl.setCreateDate(chatRoomGroup.getCreateDate());
		chatRoomGroupImpl.setModifiedDate(chatRoomGroup.getModifiedDate());
		chatRoomGroupImpl.setType(chatRoomGroup.getType());

		return chatRoomGroupImpl;
	}

	/**
	 * Returns the chat room group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat room group
	 * @return the chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChatRoomGroupException, SystemException {
		ChatRoomGroup chatRoomGroup = fetchByPrimaryKey(primaryKey);

		if (chatRoomGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChatRoomGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chatRoomGroup;
	}

	/**
	 * Returns the chat room group with the primary key or throws a {@link com.rcs.service.NoSuchChatRoomGroupException} if it could not be found.
	 *
	 * @param chatRoomGroupPK the primary key of the chat room group
	 * @return the chat room group
	 * @throws com.rcs.service.NoSuchChatRoomGroupException if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup findByPrimaryKey(ChatRoomGroupPK chatRoomGroupPK)
		throws NoSuchChatRoomGroupException, SystemException {
		return findByPrimaryKey((Serializable)chatRoomGroupPK);
	}

	/**
	 * Returns the chat room group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat room group
	 * @return the chat room group, or <code>null</code> if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChatRoomGroup chatRoomGroup = (ChatRoomGroup)EntityCacheUtil.getResult(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
				ChatRoomGroupImpl.class, primaryKey);

		if (chatRoomGroup == _nullChatRoomGroup) {
			return null;
		}

		if (chatRoomGroup == null) {
			Session session = null;

			try {
				session = openSession();

				chatRoomGroup = (ChatRoomGroup)session.get(ChatRoomGroupImpl.class,
						primaryKey);

				if (chatRoomGroup != null) {
					cacheResult(chatRoomGroup);
				}
				else {
					EntityCacheUtil.putResult(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
						ChatRoomGroupImpl.class, primaryKey, _nullChatRoomGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChatRoomGroupModelImpl.ENTITY_CACHE_ENABLED,
					ChatRoomGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chatRoomGroup;
	}

	/**
	 * Returns the chat room group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chatRoomGroupPK the primary key of the chat room group
	 * @return the chat room group, or <code>null</code> if a chat room group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChatRoomGroup fetchByPrimaryKey(ChatRoomGroupPK chatRoomGroupPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)chatRoomGroupPK);
	}

	/**
	 * Returns all the chat room groups.
	 *
	 * @return the chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat room groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat room groups
	 * @param end the upper bound of the range of chat room groups (not inclusive)
	 * @return the range of chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat room groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat room groups
	 * @param end the upper bound of the range of chat room groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chat room groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChatRoomGroup> findAll(int start, int end,
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

		List<ChatRoomGroup> list = (List<ChatRoomGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHATROOMGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHATROOMGROUP;

				if (pagination) {
					sql = sql.concat(ChatRoomGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChatRoomGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChatRoomGroup>(list);
				}
				else {
					list = (List<ChatRoomGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the chat room groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChatRoomGroup chatRoomGroup : findAll()) {
			remove(chatRoomGroup);
		}
	}

	/**
	 * Returns the number of chat room groups.
	 *
	 * @return the number of chat room groups
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

				Query q = session.createQuery(_SQL_COUNT_CHATROOMGROUP);

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
	 * Initializes the chat room group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.service.model.ChatRoomGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChatRoomGroup>> listenersList = new ArrayList<ModelListener<ChatRoomGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChatRoomGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChatRoomGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHATROOMGROUP = "SELECT chatRoomGroup FROM ChatRoomGroup chatRoomGroup";
	private static final String _SQL_SELECT_CHATROOMGROUP_WHERE = "SELECT chatRoomGroup FROM ChatRoomGroup chatRoomGroup WHERE ";
	private static final String _SQL_COUNT_CHATROOMGROUP = "SELECT COUNT(chatRoomGroup) FROM ChatRoomGroup chatRoomGroup";
	private static final String _SQL_COUNT_CHATROOMGROUP_WHERE = "SELECT COUNT(chatRoomGroup) FROM ChatRoomGroup chatRoomGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chatRoomGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatRoomGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChatRoomGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChatRoomGroupPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static ChatRoomGroup _nullChatRoomGroup = new ChatRoomGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChatRoomGroup> toCacheModel() {
				return _nullChatRoomGroupCacheModel;
			}
		};

	private static CacheModel<ChatRoomGroup> _nullChatRoomGroupCacheModel = new CacheModel<ChatRoomGroup>() {
			@Override
			public ChatRoomGroup toEntityModel() {
				return _nullChatRoomGroup;
			}
		};
}