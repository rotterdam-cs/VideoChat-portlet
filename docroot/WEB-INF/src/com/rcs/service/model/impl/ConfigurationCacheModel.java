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

package com.rcs.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.service.model.Configuration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Configuration in entity cache.
 *
 * @author Flor|Ale
 * @see Configuration
 * @generated
 */
public class ConfigurationCacheModel implements CacheModel<Configuration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{apiKey=");
		sb.append(apiKey);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", apiSecret=");
		sb.append(apiSecret);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Configuration toEntityModel() {
		ConfigurationImpl configurationImpl = new ConfigurationImpl();

		if (apiKey == null) {
			configurationImpl.setApiKey(StringPool.BLANK);
		}
		else {
			configurationImpl.setApiKey(apiKey);
		}

		configurationImpl.setGroupId(groupId);
		configurationImpl.setCompanyId(companyId);
		configurationImpl.setUserId(userId);

		if (userName == null) {
			configurationImpl.setUserName(StringPool.BLANK);
		}
		else {
			configurationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			configurationImpl.setCreateDate(null);
		}
		else {
			configurationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			configurationImpl.setModifiedDate(null);
		}
		else {
			configurationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (apiSecret == null) {
			configurationImpl.setApiSecret(StringPool.BLANK);
		}
		else {
			configurationImpl.setApiSecret(apiSecret);
		}

		configurationImpl.setType(type);

		configurationImpl.resetOriginalValues();

		return configurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		apiKey = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		apiSecret = objectInput.readUTF();
		type = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (apiKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(apiKey);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (apiSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(apiSecret);
		}

		objectOutput.writeInt(type);
	}

	public String apiKey;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String apiSecret;
	public int type;
}