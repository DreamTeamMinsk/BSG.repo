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

package by.cnb.liferay.portlet.collapsableadvert.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AdvertLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AdvertLocalService
 * @generated
 */
public class AdvertLocalServiceWrapper implements AdvertLocalService,
	ServiceWrapper<AdvertLocalService> {
	public AdvertLocalServiceWrapper(AdvertLocalService advertLocalService) {
		_advertLocalService = advertLocalService;
	}

	/**
	* Adds the advert to the database. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @return the advert that was added
	* @throws SystemException if a system exception occurred
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert addAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.addAdvert(advert);
	}

	/**
	* Creates a new advert with the primary key. Does not add the advert to the database.
	*
	* @param entryId the primary key for the new advert
	* @return the new advert
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert createAdvert(
		long entryId) {
		return _advertLocalService.createAdvert(entryId);
	}

	/**
	* Deletes the advert with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the advert
	* @return the advert that was removed
	* @throws PortalException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert deleteAdvert(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.deleteAdvert(entryId);
	}

	/**
	* Deletes the advert from the database. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @return the advert that was removed
	* @throws SystemException if a system exception occurred
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert deleteAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.deleteAdvert(advert);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _advertLocalService.dynamicQuery();
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
		return _advertLocalService.dynamicQuery(dynamicQuery);
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
		return _advertLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _advertLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _advertLocalService.dynamicQueryCount(dynamicQuery);
	}

	public by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchAdvert(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.fetchAdvert(entryId);
	}

	/**
	* Returns the advert with the primary key.
	*
	* @param entryId the primary key of the advert
	* @return the advert
	* @throws PortalException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert getAdvert(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.getAdvert(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the advert with the UUID in the group.
	*
	* @param uuid the UUID of advert
	* @param groupId the group id of the advert
	* @return the advert
	* @throws PortalException if a advert with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert getAdvertByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.getAdvertByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the adverts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of adverts
	* @param end the upper bound of the range of adverts (not inclusive)
	* @return the range of adverts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> getAdverts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.getAdverts(start, end);
	}

	/**
	* Returns the number of adverts.
	*
	* @return the number of adverts
	* @throws SystemException if a system exception occurred
	*/
	public int getAdvertsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.getAdvertsCount();
	}

	/**
	* Updates the advert in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @return the advert that was updated
	* @throws SystemException if a system exception occurred
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert updateAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.updateAdvert(advert);
	}

	/**
	* Updates the advert in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @param merge whether to merge the advert with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the advert that was updated
	* @throws SystemException if a system exception occurred
	*/
	public by.cnb.liferay.portlet.collapsableadvert.model.Advert updateAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advertLocalService.updateAdvert(advert, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _advertLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_advertLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _advertLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AdvertLocalService getWrappedAdvertLocalService() {
		return _advertLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAdvertLocalService(
		AdvertLocalService advertLocalService) {
		_advertLocalService = advertLocalService;
	}

	public AdvertLocalService getWrappedService() {
		return _advertLocalService;
	}

	public void setWrappedService(AdvertLocalService advertLocalService) {
		_advertLocalService = advertLocalService;
	}

	private AdvertLocalService _advertLocalService;
}