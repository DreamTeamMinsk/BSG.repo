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

package by.cnb.liferay.portlet.collapsableadvert.model.impl;

import by.cnb.liferay.portlet.collapsableadvert.model.Advert;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Advert in entity cache.
 * 
 * @author Brian Wing Shun Chan
 * @see Advert
 * @generated
 */
public class AdvertCacheModel implements CacheModel<Advert>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Advert toEntityModel() {
		AdvertImpl advertImpl = new AdvertImpl();

		if (uuid == null) {
			advertImpl.setUuid(StringPool.BLANK);
		} else {
			advertImpl.setUuid(uuid);
		}

		advertImpl.setEntryId(entryId);
		advertImpl.setGroupId(groupId);
		advertImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			advertImpl.setCreateDate(null);
		} else {
			advertImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			advertImpl.setModifiedDate(null);
		} else {
			advertImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			advertImpl.setName(StringPool.BLANK);
		} else {
			advertImpl.setName(name);
		}

		advertImpl.resetOriginalValues();

		return advertImpl;
	}

	public String uuid;
	public long entryId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String name;
}