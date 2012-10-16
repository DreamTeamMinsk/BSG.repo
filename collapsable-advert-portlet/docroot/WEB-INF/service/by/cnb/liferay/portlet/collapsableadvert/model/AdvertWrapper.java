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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Advert}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Advert
 * @generated
 */
public class AdvertWrapper implements Advert, ModelWrapper<Advert> {
	public AdvertWrapper(Advert advert) {
		_advert = advert;
	}

	public Class<?> getModelClass() {
		return Advert.class;
	}

	public String getModelClassName() {
		return Advert.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entryId", getEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this advert.
	*
	* @return the primary key of this advert
	*/
	public long getPrimaryKey() {
		return _advert.getPrimaryKey();
	}

	/**
	* Sets the primary key of this advert.
	*
	* @param primaryKey the primary key of this advert
	*/
	public void setPrimaryKey(long primaryKey) {
		_advert.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this advert.
	*
	* @return the uuid of this advert
	*/
	public java.lang.String getUuid() {
		return _advert.getUuid();
	}

	/**
	* Sets the uuid of this advert.
	*
	* @param uuid the uuid of this advert
	*/
	public void setUuid(java.lang.String uuid) {
		_advert.setUuid(uuid);
	}

	/**
	* Returns the entry ID of this advert.
	*
	* @return the entry ID of this advert
	*/
	public long getEntryId() {
		return _advert.getEntryId();
	}

	/**
	* Sets the entry ID of this advert.
	*
	* @param entryId the entry ID of this advert
	*/
	public void setEntryId(long entryId) {
		_advert.setEntryId(entryId);
	}

	/**
	* Returns the group ID of this advert.
	*
	* @return the group ID of this advert
	*/
	public long getGroupId() {
		return _advert.getGroupId();
	}

	/**
	* Sets the group ID of this advert.
	*
	* @param groupId the group ID of this advert
	*/
	public void setGroupId(long groupId) {
		_advert.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this advert.
	*
	* @return the company ID of this advert
	*/
	public long getCompanyId() {
		return _advert.getCompanyId();
	}

	/**
	* Sets the company ID of this advert.
	*
	* @param companyId the company ID of this advert
	*/
	public void setCompanyId(long companyId) {
		_advert.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this advert.
	*
	* @return the create date of this advert
	*/
	public java.util.Date getCreateDate() {
		return _advert.getCreateDate();
	}

	/**
	* Sets the create date of this advert.
	*
	* @param createDate the create date of this advert
	*/
	public void setCreateDate(java.util.Date createDate) {
		_advert.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this advert.
	*
	* @return the modified date of this advert
	*/
	public java.util.Date getModifiedDate() {
		return _advert.getModifiedDate();
	}

	/**
	* Sets the modified date of this advert.
	*
	* @param modifiedDate the modified date of this advert
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_advert.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this advert.
	*
	* @return the name of this advert
	*/
	public java.lang.String getName() {
		return _advert.getName();
	}

	/**
	* Sets the name of this advert.
	*
	* @param name the name of this advert
	*/
	public void setName(java.lang.String name) {
		_advert.setName(name);
	}

	public boolean isNew() {
		return _advert.isNew();
	}

	public void setNew(boolean n) {
		_advert.setNew(n);
	}

	public boolean isCachedModel() {
		return _advert.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_advert.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _advert.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _advert.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_advert.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _advert.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_advert.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdvertWrapper((Advert)_advert.clone());
	}

	public int compareTo(Advert advert) {
		return _advert.compareTo(advert);
	}

	@Override
	public int hashCode() {
		return _advert.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Advert> toCacheModel() {
		return _advert.toCacheModel();
	}

	public Advert toEscapedModel() {
		return new AdvertWrapper(_advert.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _advert.toString();
	}

	public java.lang.String toXmlString() {
		return _advert.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_advert.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Advert getWrappedAdvert() {
		return _advert;
	}

	public Advert getWrappedModel() {
		return _advert;
	}

	public void resetOriginalValues() {
		_advert.resetOriginalValues();
	}

	private Advert _advert;
}