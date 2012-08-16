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

package com.rcs.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the chat room local service. This utility wraps {@link com.rcs.service.service.impl.ChatRoomLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author flor
 * @see ChatRoomLocalService
 * @see com.rcs.service.service.base.ChatRoomLocalServiceBaseImpl
 * @see com.rcs.service.service.impl.ChatRoomLocalServiceImpl
 * @generated
 */
public class ChatRoomLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rcs.service.service.impl.ChatRoomLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the chat room to the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @return the chat room that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoom addChatRoom(
		com.rcs.service.model.ChatRoom chatRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addChatRoom(chatRoom);
	}

	/**
	* Creates a new chat room with the primary key. Does not add the chat room to the database.
	*
	* @param chatRoomId the primary key for the new chat room
	* @return the new chat room
	*/
	public static com.rcs.service.model.ChatRoom createChatRoom(long chatRoomId) {
		return getService().createChatRoom(chatRoomId);
	}

	/**
	* Deletes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomId the primary key of the chat room
	* @throws PortalException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteChatRoom(long chatRoomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteChatRoom(chatRoomId);
	}

	/**
	* Deletes the chat room from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteChatRoom(com.rcs.service.model.ChatRoom chatRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteChatRoom(chatRoom);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.rcs.service.model.ChatRoom fetchChatRoom(long chatRoomId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchChatRoom(chatRoomId);
	}

	/**
	* Returns the chat room with the primary key.
	*
	* @param chatRoomId the primary key of the chat room
	* @return the chat room
	* @throws PortalException if a chat room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoom getChatRoom(long chatRoomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRoom(chatRoomId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the chat rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chat rooms
	* @param end the upper bound of the range of chat rooms (not inclusive)
	* @return the range of chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.ChatRoom> getChatRooms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRooms(start, end);
	}

	/**
	* Returns the number of chat rooms.
	*
	* @return the number of chat rooms
	* @throws SystemException if a system exception occurred
	*/
	public static int getChatRoomsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRoomsCount();
	}

	/**
	* Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @return the chat room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoom updateChatRoom(
		com.rcs.service.model.ChatRoom chatRoom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChatRoom(chatRoom);
	}

	/**
	* Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chatRoom the chat room
	* @param merge whether to merge the chat room with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the chat room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoom updateChatRoom(
		com.rcs.service.model.ChatRoom chatRoom, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChatRoom(chatRoom, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static com.rcs.service.model.ChatRoom addChatRoom(long userId,
		java.lang.String name, java.lang.String description,
		java.lang.String sessionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addChatRoom(userId, name, description, sessionId);
	}

	public static com.rcs.service.model.ChatRoom updateChatRoom(long userId,
		long chatRoomId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChatRoom(userId, chatRoomId, name, description);
	}

	public static java.util.List<com.rcs.service.model.ChatRoom> getChatRoomsForUser(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRoomsForUser(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ChatRoomLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ChatRoomLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ChatRoomLocalService.class.getName(), portletClassLoader);

			_service = new ChatRoomLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ChatRoomLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ChatRoomLocalService.class);
		}

		return _service;
	}

	public void setService(ChatRoomLocalService service) {
		MethodCache.remove(ChatRoomLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ChatRoomLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ChatRoomLocalService.class);
	}

	private static ChatRoomLocalService _service;
}