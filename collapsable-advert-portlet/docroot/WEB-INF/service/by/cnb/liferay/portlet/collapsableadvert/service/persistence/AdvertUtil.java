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

package by.cnb.liferay.portlet.collapsableadvert.service.persistence;

import by.cnb.liferay.portlet.collapsableadvert.model.Advert;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the advert service. This utility wraps {@link AdvertPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdvertPersistence
 * @see AdvertPersistenceImpl
 * @generated
 */
public class AdvertUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Advert advert) {
		getPersistence().clearCache(advert);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Advert> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Advert> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Advert> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Advert update(Advert advert, boolean merge)
		throws SystemException {
		return getPersistence().update(advert, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Advert update(Advert advert, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(advert, merge, serviceContext);
	}

	/**
	* Caches the advert in the entity cache if it is enabled.
	*
	* @param advert the advert
	*/
	public static void cacheResult(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert) {
		getPersistence().cacheResult(advert);
	}

	/**
	* Caches the adverts in the entity cache if it is enabled.
	*
	* @param adverts the adverts
	*/
	public static void cacheResult(
		java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> adverts) {
		getPersistence().cacheResult(adverts);
	}

	/**
	* Creates a new advert with the primary key. Does not add the advert to the database.
	*
	* @param entryId the primary key for the new advert
	* @return the new advert
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the advert with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the advert
	* @return the advert that was removed
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert remove(
		long entryId)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(entryId);
	}

	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert updateImpl(
		by.cnb.liferay.portlet.collapsableadvert.model.Advert advert,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(advert, merge);
	}

	/**
	* Returns the advert with the primary key or throws a {@link by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException} if it could not be found.
	*
	* @param entryId the primary key of the advert
	* @return the advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert findByPrimaryKey(
		long entryId)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the advert with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the advert
	* @return the advert, or <code>null</code> if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the adverts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the adverts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of adverts
	* @param end the upper bound of the range of adverts (not inclusive)
	* @return the range of matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the adverts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of adverts
	* @param end the upper bound of the range of adverts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first advert in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first advert in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advert, or <code>null</code> if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last advert in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last advert in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advert, or <code>null</code> if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the adverts before and after the current advert in the ordered set where uuid = &#63;.
	*
	* @param entryId the primary key of the current advert
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert[] findByUuid_PrevAndNext(
		long entryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(entryId, uuid, orderByComparator);
	}

	/**
	* Returns the advert where uuid = &#63; and groupId = &#63; or throws a {@link by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert findByUUID_G(
		java.lang.String uuid, long groupId)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the advert where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching advert, or <code>null</code> if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the advert where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching advert, or <code>null</code> if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Returns all the adverts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the adverts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adverts
	* @param end the upper bound of the range of adverts (not inclusive)
	* @return the range of matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the adverts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of adverts
	* @param end the upper bound of the range of adverts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first advert in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first advert in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advert, or <code>null</code> if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last advert in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last advert in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advert, or <code>null</code> if a matching advert could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the adverts before and after the current advert in the ordered set where groupId = &#63;.
	*
	* @param entryId the primary key of the current advert
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next advert
	* @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException if a advert with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert[] findByGroupId_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(entryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the adverts.
	*
	* @return the adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the adverts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of adverts
	* @param end the upper bound of the range of adverts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of adverts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<by.cnb.liferay.portlet.collapsableadvert.model.Advert> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the adverts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the advert where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the advert that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static by.cnb.liferay.portlet.collapsableadvert.model.Advert removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes all the adverts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the adverts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of adverts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of adverts where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of adverts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching adverts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of adverts.
	*
	* @return the number of adverts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdvertPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdvertPersistence)PortletBeanLocatorUtil.locate(by.cnb.liferay.portlet.collapsableadvert.service.ClpSerializer.getServletContextName(),
					AdvertPersistence.class.getName());

			ReferenceRegistry.registerReference(AdvertUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AdvertPersistence persistence) {
	}

	private static AdvertPersistence _persistence;
}