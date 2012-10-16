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

package by.cnb.liferay.portlet.collapsableadvert.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link by.cnb.liferay.portlet.collapsableadvert.service.http.AdvertServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       by.cnb.liferay.portlet.collapsableadvert.service.http.AdvertServiceSoap
 * @generated
 */
public class AdvertSoap implements Serializable {
	public static AdvertSoap toSoapModel(Advert model) {
		AdvertSoap soapModel = new AdvertSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEntryId(model.getEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static AdvertSoap[] toSoapModels(Advert[] models) {
		AdvertSoap[] soapModels = new AdvertSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdvertSoap[][] toSoapModels(Advert[][] models) {
		AdvertSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdvertSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdvertSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdvertSoap[] toSoapModels(List<Advert> models) {
		List<AdvertSoap> soapModels = new ArrayList<AdvertSoap>(models.size());

		for (Advert model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdvertSoap[soapModels.size()]);
	}

	public AdvertSoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _uuid;
	private long _entryId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
}