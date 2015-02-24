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

package com.rcs.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ChatRoomGroup. This utility wraps
 * {@link com.rcs.service.service.impl.ChatRoomGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Flor|Ale
 * @see ChatRoomGroupLocalService
 * @see com.rcs.service.service.base.ChatRoomGroupLocalServiceBaseImpl
 * @see com.rcs.service.service.impl.ChatRoomGroupLocalServiceImpl
 * @generated
 */
public class ChatRoomGroupLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rcs.service.service.impl.ChatRoomGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the chat room group to the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroup the chat room group
	* @return the chat room group that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup addChatRoomGroup(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addChatRoomGroup(chatRoomGroup);
	}

	/**
	* Creates a new chat room group with the primary key. Does not add the chat room group to the database.
	*
	* @param chatRoomGroupPK the primary key for the new chat room group
	* @return the new chat room group
	*/
	public static com.rcs.service.model.ChatRoomGroup createChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK) {
		return getService().createChatRoomGroup(chatRoomGroupPK);
	}

	/**
	* Deletes the chat room group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group that was removed
	* @throws PortalException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup deleteChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChatRoomGroup(chatRoomGroupPK);
	}

	/**
	* Deletes the chat room group from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroup the chat room group
	* @return the chat room group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup deleteChatRoomGroup(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChatRoomGroup(chatRoomGroup);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.ChatRoomGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rcs.service.model.ChatRoomGroup fetchChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchChatRoomGroup(chatRoomGroupPK);
	}

	/**
	* Returns the chat room group with the primary key.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group
	* @throws PortalException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup getChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRoomGroup(chatRoomGroupPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rcs.service.model.ChatRoomGroup> getChatRoomGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRoomGroups(start, end);
	}

	/**
	* Returns the number of chat room groups.
	*
	* @return the number of chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public static int getChatRoomGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRoomGroupsCount();
	}

	/**
	* Updates the chat room group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroup the chat room group
	* @return the chat room group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.ChatRoomGroup updateChatRoomGroup(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChatRoomGroup(chatRoomGroup);
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

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.rcs.service.model.ChatRoomGroup addChatRoomGroup(
		long userId, long chatRoomId, long chatRoomGroupId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addChatRoomGroup(userId, chatRoomId, chatRoomGroupId, type);
	}

	public static java.util.List<com.rcs.service.model.ChatRoomGroup> getChatRoomsByChatRoomId(
		long chatRoomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChatRoomsByChatRoomId(chatRoomId);
	}

	public static java.util.List<com.liferay.portal.model.Group> getGroupsByChatRoomGroups(
		java.util.List<com.rcs.service.model.ChatRoomGroup> chatRoomGroups) {
		return getService().getGroupsByChatRoomGroups(chatRoomGroups);
	}

	public static void clearService() {
		_service = null;
	}

	public static ChatRoomGroupLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ChatRoomGroupLocalService.class.getName());

			if (invokableLocalService instanceof ChatRoomGroupLocalService) {
				_service = (ChatRoomGroupLocalService)invokableLocalService;
			}
			else {
				_service = new ChatRoomGroupLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ChatRoomGroupLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ChatRoomGroupLocalService service) {
	}

	private static ChatRoomGroupLocalService _service;
}