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

import by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException;
import by.cnb.liferay.portlet.collapsableadvert.model.Advert;
import by.cnb.liferay.portlet.collapsableadvert.model.impl.AdvertImpl;
import by.cnb.liferay.portlet.collapsableadvert.model.impl.AdvertModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the advert service.
 * 
 * <p>
 * Caching information and settings can be found in
 * <code>portal.properties</code>
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see AdvertPersistence
 * @see AdvertUtil
 * @generated
 */
public class AdvertPersistenceImpl extends BasePersistenceImpl<Advert>
		implements AdvertPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never modify or reference this class directly. Always use {@link
	 * AdvertUtil} to access the advert persistence. Modify
	 * <code>service.xml</code> and rerun ServiceBuilder to regenerate this
	 * class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdvertImpl.class
			.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY
			+ ".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY
			+ ".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, AdvertImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid", new String[] {
					String.class.getName(),

					"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, AdvertImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AdvertModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, AdvertImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G", new String[] {
					String.class.getName(), Long.class.getName() },
			AdvertModelImpl.UUID_COLUMN_BITMASK
					| AdvertModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, AdvertImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName(),

			"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, AdvertImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			AdvertModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, AdvertImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, AdvertImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(
			AdvertModelImpl.ENTITY_CACHE_ENABLED,
			AdvertModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the advert in the entity cache if it is enabled.
	 * 
	 * @param advert
	 *            the advert
	 */
	public void cacheResult(Advert advert) {
		EntityCacheUtil.putResult(AdvertModelImpl.ENTITY_CACHE_ENABLED,
				AdvertImpl.class, advert.getPrimaryKey(), advert);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, new Object[] {
				advert.getUuid(), Long.valueOf(advert.getGroupId()) }, advert);

		advert.resetOriginalValues();
	}

	/**
	 * Caches the adverts in the entity cache if it is enabled.
	 * 
	 * @param adverts
	 *            the adverts
	 */
	public void cacheResult(List<Advert> adverts) {
		for (Advert advert : adverts) {
			if (EntityCacheUtil.getResult(AdvertModelImpl.ENTITY_CACHE_ENABLED,
					AdvertImpl.class, advert.getPrimaryKey()) == null) {
				cacheResult(advert);
			} else {
				advert.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all adverts.
	 * 
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and
	 * {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by
	 * this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdvertImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdvertImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the advert.
	 * 
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and
	 * {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by
	 * this method.
	 * </p>
	 */
	@Override
	public void clearCache(Advert advert) {
		EntityCacheUtil.removeResult(AdvertModelImpl.ENTITY_CACHE_ENABLED,
				AdvertImpl.class, advert.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(advert);
	}

	@Override
	public void clearCache(List<Advert> adverts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Advert advert : adverts) {
			EntityCacheUtil.removeResult(AdvertModelImpl.ENTITY_CACHE_ENABLED,
					AdvertImpl.class, advert.getPrimaryKey());

			clearUniqueFindersCache(advert);
		}
	}

	protected void clearUniqueFindersCache(Advert advert) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, new Object[] {
				advert.getUuid(), Long.valueOf(advert.getGroupId()) });
	}

	/**
	 * Creates a new advert with the primary key. Does not add the advert to the
	 * database.
	 * 
	 * @param entryId
	 *            the primary key for the new advert
	 * @return the new advert
	 */
	public Advert create(long entryId) {
		Advert advert = new AdvertImpl();

		advert.setNew(true);
		advert.setPrimaryKey(entryId);

		String uuid = PortalUUIDUtil.generate();

		advert.setUuid(uuid);

		return advert;
	}

	/**
	 * Removes the advert with the primary key from the database. Also notifies
	 * the appropriate model listeners.
	 * 
	 * @param entryId
	 *            the primary key of the advert
	 * @return the advert that was removed
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a advert with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert remove(long entryId) throws NoSuchAdvertException,
			SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the advert with the primary key from the database. Also notifies
	 * the appropriate model listeners.
	 * 
	 * @param primaryKey
	 *            the primary key of the advert
	 * @return the advert that was removed
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a advert with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	@Override
	public Advert remove(Serializable primaryKey) throws NoSuchAdvertException,
			SystemException {
		Session session = null;

		try {
			session = openSession();

			Advert advert = (Advert) session.get(AdvertImpl.class, primaryKey);

			if (advert == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdvertException(
						_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(advert);
		} catch (NoSuchAdvertException nsee) {
			throw nsee;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	@Override
	protected Advert removeImpl(Advert advert) throws SystemException {
		advert = toUnwrappedModel(advert);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, advert);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}

		clearCache(advert);

		return advert;
	}

	@Override
	public Advert updateImpl(
			by.cnb.liferay.portlet.collapsableadvert.model.Advert advert,
			boolean merge) throws SystemException {
		advert = toUnwrappedModel(advert);

		boolean isNew = advert.isNew();

		AdvertModelImpl advertModelImpl = (AdvertModelImpl) advert;

		if (Validator.isNull(advert.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			advert.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, advert, merge);

			advert.setNew(false);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdvertModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil
					.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((advertModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { advertModelImpl
						.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID, args);

				args = new Object[] { advertModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID, args);
			}

			if ((advertModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { Long.valueOf(advertModelImpl
						.getOriginalGroupId()) };

				FinderCacheUtil
						.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID, args);

				args = new Object[] { Long
						.valueOf(advertModelImpl.getGroupId()) };

				FinderCacheUtil
						.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID, args);
			}
		}

		EntityCacheUtil.putResult(AdvertModelImpl.ENTITY_CACHE_ENABLED,
				AdvertImpl.class, advert.getPrimaryKey(), advert);

		if (isNew) {
			FinderCacheUtil.putResult(
					FINDER_PATH_FETCH_BY_UUID_G,
					new Object[] { advert.getUuid(),
							Long.valueOf(advert.getGroupId()) }, advert);
		} else {
			if ((advertModelImpl.getColumnBitmask() & FINDER_PATH_FETCH_BY_UUID_G
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advertModelImpl.getOriginalUuid(),
						Long.valueOf(advertModelImpl.getOriginalGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(
						FINDER_PATH_FETCH_BY_UUID_G,
						new Object[] { advert.getUuid(),
								Long.valueOf(advert.getGroupId()) }, advert);
			}
		}

		return advert;
	}

	protected Advert toUnwrappedModel(Advert advert) {
		if (advert instanceof AdvertImpl) {
			return advert;
		}

		AdvertImpl advertImpl = new AdvertImpl();

		advertImpl.setNew(advert.isNew());
		advertImpl.setPrimaryKey(advert.getPrimaryKey());

		advertImpl.setUuid(advert.getUuid());
		advertImpl.setEntryId(advert.getEntryId());
		advertImpl.setGroupId(advert.getGroupId());
		advertImpl.setCompanyId(advert.getCompanyId());
		advertImpl.setCreateDate(advert.getCreateDate());
		advertImpl.setModifiedDate(advert.getModifiedDate());
		advertImpl.setName(advert.getName());

		return advertImpl;
	}

	/**
	 * Returns the advert with the primary key or throws a
	 * {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 * 
	 * @param primaryKey
	 *            the primary key of the advert
	 * @return the advert
	 * @throws com.liferay.portal.NoSuchModelException
	 *             if a advert with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	@Override
	public Advert findByPrimaryKey(Serializable primaryKey)
			throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long) primaryKey).longValue());
	}

	/**
	 * Returns the advert with the primary key or throws a
	 * {@link by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException} if
	 * it could not be found.
	 * 
	 * @param entryId
	 *            the primary key of the advert
	 * @return the advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a advert with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert findByPrimaryKey(long entryId) throws NoSuchAdvertException,
			SystemException {
		Advert advert = fetchByPrimaryKey(entryId);

		if (advert == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchAdvertException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY
					+ entryId);
		}

		return advert;
	}

	/**
	 * Returns the advert with the primary key or returns <code>null</code> if
	 * it could not be found.
	 * 
	 * @param primaryKey
	 *            the primary key of the advert
	 * @return the advert, or <code>null</code> if a advert with the primary key
	 *         could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	@Override
	public Advert fetchByPrimaryKey(Serializable primaryKey)
			throws SystemException {
		return fetchByPrimaryKey(((Long) primaryKey).longValue());
	}

	/**
	 * Returns the advert with the primary key or returns <code>null</code> if
	 * it could not be found.
	 * 
	 * @param entryId
	 *            the primary key of the advert
	 * @return the advert, or <code>null</code> if a advert with the primary key
	 *         could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert fetchByPrimaryKey(long entryId) throws SystemException {
		Advert advert = (Advert) EntityCacheUtil
				.getResult(AdvertModelImpl.ENTITY_CACHE_ENABLED,
						AdvertImpl.class, entryId);

		if (advert == _nullAdvert) {
			return null;
		}

		if (advert == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				advert = (Advert) session.get(AdvertImpl.class,
						Long.valueOf(entryId));
			} catch (Exception e) {
				hasException = true;

				throw processException(e);
			} finally {
				if (advert != null) {
					cacheResult(advert);
				} else if (!hasException) {
					EntityCacheUtil.putResult(
							AdvertModelImpl.ENTITY_CACHE_ENABLED,
							AdvertImpl.class, entryId, _nullAdvert);
				}

				closeSession(session);
			}
		}

		return advert;
	}

	/**
	 * Returns all the adverts where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @return the matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the adverts where uuid = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param uuid
	 *            the uuid
	 * @param start
	 *            the lower bound of the range of adverts
	 * @param end
	 *            the upper bound of the range of adverts (not inclusive)
	 * @return the range of matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findByUuid(String uuid, int start, int end)
			throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the adverts where uuid = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param uuid
	 *            the uuid
	 * @param start
	 *            the lower bound of the range of adverts
	 * @param end
	 *            the upper bound of the range of adverts (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findByUuid(String uuid, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Advert> list = (List<Advert>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Advert advert : list) {
				if (!Validator.equals(uuid, advert.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						3 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ADVERT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Advert>) QueryUtil.list(q, getDialect(), start,
						end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first advert in the ordered set where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a matching advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert findByUuid_First(String uuid,
			OrderByComparator orderByComparator) throws NoSuchAdvertException,
			SystemException {
		Advert advert = fetchByUuid_First(uuid, orderByComparator);

		if (advert != null) {
			return advert;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvertException(msg.toString());
	}

	/**
	 * Returns the first advert in the ordered set where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching advert, or <code>null</code> if a matching
	 *         advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert fetchByUuid_First(String uuid,
			OrderByComparator orderByComparator) throws SystemException {
		List<Advert> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last advert in the ordered set where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a matching advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert findByUuid_Last(String uuid,
			OrderByComparator orderByComparator) throws NoSuchAdvertException,
			SystemException {
		Advert advert = fetchByUuid_Last(uuid, orderByComparator);

		if (advert != null) {
			return advert;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvertException(msg.toString());
	}

	/**
	 * Returns the last advert in the ordered set where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching advert, or <code>null</code> if a matching
	 *         advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert fetchByUuid_Last(String uuid,
			OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		List<Advert> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the adverts before and after the current advert in the ordered
	 * set where uuid = &#63;.
	 * 
	 * @param entryId
	 *            the primary key of the current advert
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a advert with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert[] findByUuid_PrevAndNext(long entryId, String uuid,
			OrderByComparator orderByComparator) throws NoSuchAdvertException,
			SystemException {
		Advert advert = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			Advert[] array = new AdvertImpl[3];

			array[0] = getByUuid_PrevAndNext(session, advert, uuid,
					orderByComparator, true);

			array[1] = advert;

			array[2] = getByUuid_PrevAndNext(session, advert, uuid,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected Advert getByUuid_PrevAndNext(Session session, Advert advert,
			String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVERT_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		} else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			} else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(advert);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Advert> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns the advert where uuid = &#63; and groupId = &#63; or throws a
	 * {@link by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException} if
	 * it could not be found.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @return the matching advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a matching advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert findByUUID_G(String uuid, long groupId)
			throws NoSuchAdvertException, SystemException {
		Advert advert = fetchByUUID_G(uuid, groupId);

		if (advert == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAdvertException(msg.toString());
		}

		return advert;
	}

	/**
	 * Returns the advert where uuid = &#63; and groupId = &#63; or returns
	 * <code>null</code> if it could not be found. Uses the finder cache.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @return the matching advert, or <code>null</code> if a matching advert
	 *         could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert fetchByUUID_G(String uuid, long groupId)
			throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the advert where uuid = &#63; and groupId = &#63; or returns
	 * <code>null</code> if it could not be found, optionally using the finder
	 * cache.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @param retrieveFromCache
	 *            whether to use the finder cache
	 * @return the matching advert, or <code>null</code> if a matching advert
	 *         could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert fetchByUUID_G(String uuid, long groupId,
			boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Advert) {
			Advert advert = (Advert) result;

			if (!Validator.equals(uuid, advert.getUuid())
					|| (groupId != advert.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ADVERT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Advert> list = q.list();

				result = list;

				Advert advert = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, list);
				} else {
					advert = list.get(0);

					cacheResult(advert);

					if ((advert.getUuid() == null)
							|| !advert.getUuid().equals(uuid)
							|| (advert.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
								finderArgs, advert);
					}
				}

				return advert;
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs);
				}

				closeSession(session);
			}
		} else {
			if (result instanceof List<?>) {
				return null;
			} else {
				return (Advert) result;
			}
		}
	}

	/**
	 * Returns all the adverts where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @return the matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
	}

	/**
	 * Returns a range of all the adverts where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param start
	 *            the lower bound of the range of adverts
	 * @param end
	 *            the upper bound of the range of adverts (not inclusive)
	 * @return the range of matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findByGroupId(long groupId, int start, int end)
			throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the adverts where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param start
	 *            the lower bound of the range of adverts
	 * @param end
	 *            the upper bound of the range of adverts (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findByGroupId(long groupId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Advert> list = (List<Advert>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Advert advert : list) {
				if ((groupId != advert.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						3 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ADVERT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Advert>) QueryUtil.list(q, getDialect(), start,
						end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first advert in the ordered set where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a matching advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert findByGroupId_First(long groupId,
			OrderByComparator orderByComparator) throws NoSuchAdvertException,
			SystemException {
		Advert advert = fetchByGroupId_First(groupId, orderByComparator);

		if (advert != null) {
			return advert;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvertException(msg.toString());
	}

	/**
	 * Returns the first advert in the ordered set where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching advert, or <code>null</code> if a matching
	 *         advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert fetchByGroupId_First(long groupId,
			OrderByComparator orderByComparator) throws SystemException {
		List<Advert> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last advert in the ordered set where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a matching advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert findByGroupId_Last(long groupId,
			OrderByComparator orderByComparator) throws NoSuchAdvertException,
			SystemException {
		Advert advert = fetchByGroupId_Last(groupId, orderByComparator);

		if (advert != null) {
			return advert;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvertException(msg.toString());
	}

	/**
	 * Returns the last advert in the ordered set where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching advert, or <code>null</code> if a matching
	 *         advert could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert fetchByGroupId_Last(long groupId,
			OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<Advert> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the adverts before and after the current advert in the ordered
	 * set where groupId = &#63;.
	 * 
	 * @param entryId
	 *            the primary key of the current advert
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next advert
	 * @throws by.cnb.liferay.portlet.collapsableadvert.NoSuchAdvertException
	 *             if a advert with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert[] findByGroupId_PrevAndNext(long entryId, long groupId,
			OrderByComparator orderByComparator) throws NoSuchAdvertException,
			SystemException {
		Advert advert = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			Advert[] array = new AdvertImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, advert, groupId,
					orderByComparator, true);

			array[1] = advert;

			array[2] = getByGroupId_PrevAndNext(session, advert, groupId,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected Advert getByGroupId_PrevAndNext(Session session, Advert advert,
			long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVERT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(advert);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Advert> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns all the adverts.
	 * 
	 * @return the adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the adverts.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param start
	 *            the lower bound of the range of adverts
	 * @param end
	 *            the upper bound of the range of adverts (not inclusive)
	 * @return the range of adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the adverts.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param start
	 *            the lower bound of the range of adverts
	 * @param end
	 *            the upper bound of the range of adverts (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Advert> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Advert> list = (List<Advert>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						2 + (orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADVERT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

				sql = query.toString();
			} else {
				sql = _SQL_SELECT_ADVERT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Advert>) QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				} else {
					list = (List<Advert>) QueryUtil.list(q, getDialect(),
							start, end);
				}
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the adverts where uuid = &#63; from the database.
	 * 
	 * @param uuid
	 *            the uuid
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Advert advert : findByUuid(uuid)) {
			remove(advert);
		}
	}

	/**
	 * Removes the advert where uuid = &#63; and groupId = &#63; from the
	 * database.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @return the advert that was removed
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public Advert removeByUUID_G(String uuid, long groupId)
			throws NoSuchAdvertException, SystemException {
		Advert advert = findByUUID_G(uuid, groupId);

		return remove(advert);
	}

	/**
	 * Removes all the adverts where groupId = &#63; from the database.
	 * 
	 * @param groupId
	 *            the group ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Advert advert : findByGroupId(groupId)) {
			remove(advert);
		}
	}

	/**
	 * Removes all the adverts from the database.
	 * 
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Advert advert : findAll()) {
			remove(advert);
		}
	}

	/**
	 * Returns the number of adverts where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @return the number of matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_UUID, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVERT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of adverts where uuid = &#63; and groupId = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @return the number of matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_UUID_G, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADVERT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of adverts where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @return the number of matching adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_GROUPID, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADVERT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of adverts.
	 * 
	 * @return the number of adverts
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADVERT);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
						FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the advert persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil
				.split(GetterUtil.getString(com.liferay.util.service.ServiceProps
						.get("value.object.listener.by.cnb.liferay.portlet.collapsableadvert.model.Advert")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Advert>> listenersList = new ArrayList<ModelListener<Advert>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Advert>) InstanceFactory
							.newInstance(listenerClassName));
				}

				listeners = listenersList
						.toArray(new ModelListener[listenersList.size()]);
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AdvertImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AdvertPersistence.class)
	protected AdvertPersistence advertPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ADVERT = "SELECT advert FROM Advert advert";
	private static final String _SQL_SELECT_ADVERT_WHERE = "SELECT advert FROM Advert advert WHERE ";
	private static final String _SQL_COUNT_ADVERT = "SELECT COUNT(advert) FROM Advert advert";
	private static final String _SQL_COUNT_ADVERT_WHERE = "SELECT COUNT(advert) FROM Advert advert WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "advert.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "advert.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(advert.uuid IS NULL OR advert.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "advert.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "advert.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(advert.uuid IS NULL OR advert.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "advert.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "advert.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "advert.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Advert exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Advert exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil
			.getBoolean(PropsUtil
					.get(PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil
			.getLog(AdvertPersistenceImpl.class);
	private static Advert _nullAdvert = new AdvertImpl() {
		@Override
		public Object clone() {
			return this;
		}

		@Override
		public CacheModel<Advert> toCacheModel() {
			return _nullAdvertCacheModel;
		}
	};

	private static CacheModel<Advert> _nullAdvertCacheModel = new CacheModel<Advert>() {
		public Advert toEntityModel() {
			return _nullAdvert;
		}
	};
}