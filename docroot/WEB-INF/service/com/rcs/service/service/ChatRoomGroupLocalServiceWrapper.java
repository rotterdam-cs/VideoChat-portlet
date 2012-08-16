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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomGroupLocalService}.
 * </p>
 *
 * @author    flor
 * @see       ChatRoomGroupLocalService
 * @generated
 */
public class ChatRoomGroupLocalServiceWrapper
	implements ChatRoomGroupLocalService,
		ServiceWrapper<ChatRoomGroupLocalService> {
	public ChatRoomGroupLocalServiceWrapper(
		ChatRoomGroupLocalService chatRoomGroupLocalService) {
		_chatRoomGroupLocalService = chatRoomGroupLocalService;
	}

	/**
	* Adds the chat room group to the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroup the chat room group
	* @return the chat room group that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoomGroup addChatRoomGroup(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.addChatRoomGroup(chatRoomGroup);
	}

	/**
	* Creates a new chat room group with the primary key. Does not add the chat room group to the database.
	*
	* @param chatRoomGroupPK the primary key for the new chat room group
	* @return the new chat room group
	*/
	public com.rcs.service.model.ChatRoomGroup createChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK) {
		return _chatRoomGroupLocalService.createChatRoomGroup(chatRoomGroupPK);
	}

	/**
	* Deletes the chat room group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @throws PortalException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_chatRoomGroupLocalService.deleteChatRoomGroup(chatRoomGroupPK);
	}

	/**
	* Deletes the chat room group from the database. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroup the chat room group
	* @throws SystemException if a system exception occurred
	*/
	public void deleteChatRoomGroup(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		_chatRoomGroupLocalService.deleteChatRoomGroup(chatRoomGroup);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.rcs.service.model.ChatRoomGroup fetchChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.fetchChatRoomGroup(chatRoomGroupPK);
	}

	/**
	* Returns the chat room group with the primary key.
	*
	* @param chatRoomGroupPK the primary key of the chat room group
	* @return the chat room group
	* @throws PortalException if a chat room group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoomGroup getChatRoomGroup(
		com.rcs.service.service.persistence.ChatRoomGroupPK chatRoomGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.getChatRoomGroup(chatRoomGroupPK);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the chat room groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chat room groups
	* @param end the upper bound of the range of chat room groups (not inclusive)
	* @return the range of chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.ChatRoomGroup> getChatRoomGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.getChatRoomGroups(start, end);
	}

	/**
	* Returns the number of chat room groups.
	*
	* @return the number of chat room groups
	* @throws SystemException if a system exception occurred
	*/
	public int getChatRoomGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.getChatRoomGroupsCount();
	}

	/**
	* Updates the chat room group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroup the chat room group
	* @return the chat room group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoomGroup updateChatRoomGroup(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.updateChatRoomGroup(chatRoomGroup);
	}

	/**
	* Updates the chat room group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chatRoomGroup the chat room group
	* @param merge whether to merge the chat room group with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the chat room group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.ChatRoomGroup updateChatRoomGroup(
		com.rcs.service.model.ChatRoomGroup chatRoomGroup, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.updateChatRoomGroup(chatRoomGroup,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _chatRoomGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_chatRoomGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.rcs.service.model.ChatRoomGroup addChatRoomGroup(long userId,
		long chatRoomId, long chatRoomGroupId, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.addChatRoomGroup(userId, chatRoomId,
			chatRoomGroupId, type);
	}

	public java.util.List<com.rcs.service.model.ChatRoomGroup> getChatRoomsByChatRoomId(
		long chatRoomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chatRoomGroupLocalService.getChatRoomsByChatRoomId(chatRoomId);
	}

	public java.util.List<com.liferay.portal.model.Group> getGroupsByChatRoomGroups(
		java.util.List<com.rcs.service.model.ChatRoomGroup> chatRoomGroups) {
		return _chatRoomGroupLocalService.getGroupsByChatRoomGroups(chatRoomGroups);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ChatRoomGroupLocalService getWrappedChatRoomGroupLocalService() {
		return _chatRoomGroupLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedChatRoomGroupLocalService(
		ChatRoomGroupLocalService chatRoomGroupLocalService) {
		_chatRoomGroupLocalService = chatRoomGroupLocalService;
	}

	public ChatRoomGroupLocalService getWrappedService() {
		return _chatRoomGroupLocalService;
	}

	public void setWrappedService(
		ChatRoomGroupLocalService chatRoomGroupLocalService) {
		_chatRoomGroupLocalService = chatRoomGroupLocalService;
	}

	private ChatRoomGroupLocalService _chatRoomGroupLocalService;
}