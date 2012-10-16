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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the advert local service. This utility wraps {@link by.cnb.liferay.portlet.collapsableadvert.service.impl.AdvertLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdvertLocalService
 * @see by.cnb.liferay.portlet.collapsableadvert.service.base.AdvertLocalServiceBaseImpl
 * @see by.cnb.liferay.portlet.collapsableadvert.service.impl.AdvertLocalServiceImpl
 * @generated
 */
public class AdvertLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link by.cnb.liferay.portlet.collapsableadvert.service.impl.AdvertLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the advert to the database. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @return the advert that was added
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert addAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAdvert(advert);
	}

	/**
	* Creates a new advert with the primary key. Does not add the advert to the database.
	*
	* @param entryId the primary key for the new advert
	* @return the new advert
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert createAdvert(
		long entryId) {
		return getService().createAdvert(entryId);
	}

	/**
	* Deletes the advert with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the advert
	* @return the advert that was removed
	* @throws PortalException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert deleteAdvert(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdvert(entryId);
	}

	/**
	* Deletes the advert from the database. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @return the advert that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert deleteAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdvert(advert);
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

	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchAdvert(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAdvert(entryId);
	}

	/**
	* Returns the advert with the primary key.
	*
	* @param entryId the primary key of the advert
	* @return the advert
	* @throws PortalException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert getAdvert(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdvert(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert getAdvertByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdvertByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> getAdverts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdverts(start, end);
	}

	/**
	* Returns the number of adverts.
	*
	* @return the number of adverts
	* @throws SystemException if a system exception occurred
	*/
	public static int getAdvertsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdvertsCount();
	}

	/**
	* Updates the advert in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @return the advert that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert updateAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAdvert(advert);
	}

	/**
	* Updates the advert in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advert the advert
	* @param merge whether to merge the advert with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the advert that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert updateAdvert(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAdvert(advert, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static AdvertLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdvertLocalService.class.getName());

			if (invokableLocalService instanceof AdvertLocalService) {
				_service = (AdvertLocalService)invokableLocalService;
			}
			else {
				_service = new AdvertLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AdvertLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AdvertLocalService service) {
	}

	private static AdvertLocalService _service;
}