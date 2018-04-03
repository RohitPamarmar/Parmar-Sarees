/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package demoService.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import demoService.exception.NoSuchdemoException;

import demoService.model.demo;

import demoService.model.impl.demoImpl;
import demoService.model.impl.demoModelImpl;

import demoService.service.persistence.demoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the demo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see demoPersistence
 * @see demoService.service.persistence.demoUtil
 * @generated
 */
@ProviderType
public class demoPersistenceImpl extends BasePersistenceImpl<demo>
	implements demoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link demoUtil} to access the demo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = demoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoModelImpl.FINDER_CACHE_ENABLED, demoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoModelImpl.FINDER_CACHE_ENABLED, demoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYDEMO =
		new FinderPath(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoModelImpl.FINDER_CACHE_ENABLED, demoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByDemo",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYDEMO =
		new FinderPath(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoModelImpl.FINDER_CACHE_ENABLED, demoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByDemo",
			new String[] { String.class.getName() },
			demoModelImpl.DEMONAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYDEMO = new FinderPath(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByDemo",
			new String[] { String.class.getName() });

	/**
	 * Returns all the demos where demoName = &#63;.
	 *
	 * @param demoName the demo name
	 * @return the matching demos
	 */
	@Override
	public List<demo> findByfindByDemo(String demoName) {
		return findByfindByDemo(demoName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the demos where demoName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param demoName the demo name
	 * @param start the lower bound of the range of demos
	 * @param end the upper bound of the range of demos (not inclusive)
	 * @return the range of matching demos
	 */
	@Override
	public List<demo> findByfindByDemo(String demoName, int start, int end) {
		return findByfindByDemo(demoName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the demos where demoName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param demoName the demo name
	 * @param start the lower bound of the range of demos
	 * @param end the upper bound of the range of demos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching demos
	 */
	@Override
	public List<demo> findByfindByDemo(String demoName, int start, int end,
		OrderByComparator<demo> orderByComparator) {
		return findByfindByDemo(demoName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the demos where demoName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param demoName the demo name
	 * @param start the lower bound of the range of demos
	 * @param end the upper bound of the range of demos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching demos
	 */
	@Override
	public List<demo> findByfindByDemo(String demoName, int start, int end,
		OrderByComparator<demo> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYDEMO;
			finderArgs = new Object[] { demoName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FINDBYDEMO;
			finderArgs = new Object[] { demoName, start, end, orderByComparator };
		}

		List<demo> list = null;

		if (retrieveFromCache) {
			list = (List<demo>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (demo demo : list) {
					if (!Objects.equals(demoName, demo.getDemoName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DEMO_WHERE);

			boolean bindDemoName = false;

			if (demoName == null) {
				query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_1);
			}
			else if (demoName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_3);
			}
			else {
				bindDemoName = true;

				query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(demoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDemoName) {
					qPos.add(demoName);
				}

				if (!pagination) {
					list = (List<demo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<demo>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first demo in the ordered set where demoName = &#63;.
	 *
	 * @param demoName the demo name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demo
	 * @throws NoSuchdemoException if a matching demo could not be found
	 */
	@Override
	public demo findByfindByDemo_First(String demoName,
		OrderByComparator<demo> orderByComparator) throws NoSuchdemoException {
		demo demo = fetchByfindByDemo_First(demoName, orderByComparator);

		if (demo != null) {
			return demo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("demoName=");
		msg.append(demoName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchdemoException(msg.toString());
	}

	/**
	 * Returns the first demo in the ordered set where demoName = &#63;.
	 *
	 * @param demoName the demo name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching demo, or <code>null</code> if a matching demo could not be found
	 */
	@Override
	public demo fetchByfindByDemo_First(String demoName,
		OrderByComparator<demo> orderByComparator) {
		List<demo> list = findByfindByDemo(demoName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last demo in the ordered set where demoName = &#63;.
	 *
	 * @param demoName the demo name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demo
	 * @throws NoSuchdemoException if a matching demo could not be found
	 */
	@Override
	public demo findByfindByDemo_Last(String demoName,
		OrderByComparator<demo> orderByComparator) throws NoSuchdemoException {
		demo demo = fetchByfindByDemo_Last(demoName, orderByComparator);

		if (demo != null) {
			return demo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("demoName=");
		msg.append(demoName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchdemoException(msg.toString());
	}

	/**
	 * Returns the last demo in the ordered set where demoName = &#63;.
	 *
	 * @param demoName the demo name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching demo, or <code>null</code> if a matching demo could not be found
	 */
	@Override
	public demo fetchByfindByDemo_Last(String demoName,
		OrderByComparator<demo> orderByComparator) {
		int count = countByfindByDemo(demoName);

		if (count == 0) {
			return null;
		}

		List<demo> list = findByfindByDemo(demoName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the demos before and after the current demo in the ordered set where demoName = &#63;.
	 *
	 * @param demoId the primary key of the current demo
	 * @param demoName the demo name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next demo
	 * @throws NoSuchdemoException if a demo with the primary key could not be found
	 */
	@Override
	public demo[] findByfindByDemo_PrevAndNext(int demoId, String demoName,
		OrderByComparator<demo> orderByComparator) throws NoSuchdemoException {
		demo demo = findByPrimaryKey(demoId);

		Session session = null;

		try {
			session = openSession();

			demo[] array = new demoImpl[3];

			array[0] = getByfindByDemo_PrevAndNext(session, demo, demoName,
					orderByComparator, true);

			array[1] = demo;

			array[2] = getByfindByDemo_PrevAndNext(session, demo, demoName,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected demo getByfindByDemo_PrevAndNext(Session session, demo demo,
		String demoName, OrderByComparator<demo> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEMO_WHERE);

		boolean bindDemoName = false;

		if (demoName == null) {
			query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_1);
		}
		else if (demoName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_3);
		}
		else {
			bindDemoName = true;

			query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
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
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(demoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDemoName) {
			qPos.add(demoName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(demo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<demo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the demos where demoName = &#63; from the database.
	 *
	 * @param demoName the demo name
	 */
	@Override
	public void removeByfindByDemo(String demoName) {
		for (demo demo : findByfindByDemo(demoName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(demo);
		}
	}

	/**
	 * Returns the number of demos where demoName = &#63;.
	 *
	 * @param demoName the demo name
	 * @return the number of matching demos
	 */
	@Override
	public int countByfindByDemo(String demoName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYDEMO;

		Object[] finderArgs = new Object[] { demoName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEMO_WHERE);

			boolean bindDemoName = false;

			if (demoName == null) {
				query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_1);
			}
			else if (demoName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_3);
			}
			else {
				bindDemoName = true;

				query.append(_FINDER_COLUMN_FINDBYDEMO_DEMONAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDemoName) {
					qPos.add(demoName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYDEMO_DEMONAME_1 = "demo.demoName IS NULL";
	private static final String _FINDER_COLUMN_FINDBYDEMO_DEMONAME_2 = "demo.demoName = ?";
	private static final String _FINDER_COLUMN_FINDBYDEMO_DEMONAME_3 = "(demo.demoName IS NULL OR demo.demoName = '')";

	public demoPersistenceImpl() {
		setModelClass(demo.class);
	}

	/**
	 * Caches the demo in the entity cache if it is enabled.
	 *
	 * @param demo the demo
	 */
	@Override
	public void cacheResult(demo demo) {
		entityCache.putResult(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoImpl.class, demo.getPrimaryKey(), demo);

		demo.resetOriginalValues();
	}

	/**
	 * Caches the demos in the entity cache if it is enabled.
	 *
	 * @param demos the demos
	 */
	@Override
	public void cacheResult(List<demo> demos) {
		for (demo demo : demos) {
			if (entityCache.getResult(demoModelImpl.ENTITY_CACHE_ENABLED,
						demoImpl.class, demo.getPrimaryKey()) == null) {
				cacheResult(demo);
			}
			else {
				demo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all demos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(demoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the demo.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(demo demo) {
		entityCache.removeResult(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoImpl.class, demo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<demo> demos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (demo demo : demos) {
			entityCache.removeResult(demoModelImpl.ENTITY_CACHE_ENABLED,
				demoImpl.class, demo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new demo with the primary key. Does not add the demo to the database.
	 *
	 * @param demoId the primary key for the new demo
	 * @return the new demo
	 */
	@Override
	public demo create(int demoId) {
		demo demo = new demoImpl();

		demo.setNew(true);
		demo.setPrimaryKey(demoId);

		return demo;
	}

	/**
	 * Removes the demo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param demoId the primary key of the demo
	 * @return the demo that was removed
	 * @throws NoSuchdemoException if a demo with the primary key could not be found
	 */
	@Override
	public demo remove(int demoId) throws NoSuchdemoException {
		return remove((Serializable)demoId);
	}

	/**
	 * Removes the demo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the demo
	 * @return the demo that was removed
	 * @throws NoSuchdemoException if a demo with the primary key could not be found
	 */
	@Override
	public demo remove(Serializable primaryKey) throws NoSuchdemoException {
		Session session = null;

		try {
			session = openSession();

			demo demo = (demo)session.get(demoImpl.class, primaryKey);

			if (demo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdemoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(demo);
		}
		catch (NoSuchdemoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected demo removeImpl(demo demo) {
		demo = toUnwrappedModel(demo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(demo)) {
				demo = (demo)session.get(demoImpl.class, demo.getPrimaryKeyObj());
			}

			if (demo != null) {
				session.delete(demo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (demo != null) {
			clearCache(demo);
		}

		return demo;
	}

	@Override
	public demo updateImpl(demo demo) {
		demo = toUnwrappedModel(demo);

		boolean isNew = demo.isNew();

		demoModelImpl demoModelImpl = (demoModelImpl)demo;

		Session session = null;

		try {
			session = openSession();

			if (demo.isNew()) {
				session.save(demo);

				demo.setNew(false);
			}
			else {
				demo = (demo)session.merge(demo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!demoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { demoModelImpl.getDemoName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYDEMO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYDEMO,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((demoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYDEMO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { demoModelImpl.getOriginalDemoName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYDEMO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYDEMO,
					args);

				args = new Object[] { demoModelImpl.getDemoName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FINDBYDEMO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FINDBYDEMO,
					args);
			}
		}

		entityCache.putResult(demoModelImpl.ENTITY_CACHE_ENABLED,
			demoImpl.class, demo.getPrimaryKey(), demo, false);

		demo.resetOriginalValues();

		return demo;
	}

	protected demo toUnwrappedModel(demo demo) {
		if (demo instanceof demoImpl) {
			return demo;
		}

		demoImpl demoImpl = new demoImpl();

		demoImpl.setNew(demo.isNew());
		demoImpl.setPrimaryKey(demo.getPrimaryKey());

		demoImpl.setDemoId(demo.getDemoId());
		demoImpl.setDemoName(demo.getDemoName());

		return demoImpl;
	}

	/**
	 * Returns the demo with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the demo
	 * @return the demo
	 * @throws NoSuchdemoException if a demo with the primary key could not be found
	 */
	@Override
	public demo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchdemoException {
		demo demo = fetchByPrimaryKey(primaryKey);

		if (demo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdemoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return demo;
	}

	/**
	 * Returns the demo with the primary key or throws a {@link NoSuchdemoException} if it could not be found.
	 *
	 * @param demoId the primary key of the demo
	 * @return the demo
	 * @throws NoSuchdemoException if a demo with the primary key could not be found
	 */
	@Override
	public demo findByPrimaryKey(int demoId) throws NoSuchdemoException {
		return findByPrimaryKey((Serializable)demoId);
	}

	/**
	 * Returns the demo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the demo
	 * @return the demo, or <code>null</code> if a demo with the primary key could not be found
	 */
	@Override
	public demo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(demoModelImpl.ENTITY_CACHE_ENABLED,
				demoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		demo demo = (demo)serializable;

		if (demo == null) {
			Session session = null;

			try {
				session = openSession();

				demo = (demo)session.get(demoImpl.class, primaryKey);

				if (demo != null) {
					cacheResult(demo);
				}
				else {
					entityCache.putResult(demoModelImpl.ENTITY_CACHE_ENABLED,
						demoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(demoModelImpl.ENTITY_CACHE_ENABLED,
					demoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return demo;
	}

	/**
	 * Returns the demo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param demoId the primary key of the demo
	 * @return the demo, or <code>null</code> if a demo with the primary key could not be found
	 */
	@Override
	public demo fetchByPrimaryKey(int demoId) {
		return fetchByPrimaryKey((Serializable)demoId);
	}

	@Override
	public Map<Serializable, demo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, demo> map = new HashMap<Serializable, demo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			demo demo = fetchByPrimaryKey(primaryKey);

			if (demo != null) {
				map.put(primaryKey, demo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(demoModelImpl.ENTITY_CACHE_ENABLED,
					demoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (demo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DEMO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((int)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (demo demo : (List<demo>)q.list()) {
				map.put(demo.getPrimaryKeyObj(), demo);

				cacheResult(demo);

				uncachedPrimaryKeys.remove(demo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(demoModelImpl.ENTITY_CACHE_ENABLED,
					demoImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the demos.
	 *
	 * @return the demos
	 */
	@Override
	public List<demo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the demos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demos
	 * @param end the upper bound of the range of demos (not inclusive)
	 * @return the range of demos
	 */
	@Override
	public List<demo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the demos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demos
	 * @param end the upper bound of the range of demos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of demos
	 */
	@Override
	public List<demo> findAll(int start, int end,
		OrderByComparator<demo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the demos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of demos
	 * @param end the upper bound of the range of demos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of demos
	 */
	@Override
	public List<demo> findAll(int start, int end,
		OrderByComparator<demo> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<demo> list = null;

		if (retrieveFromCache) {
			list = (List<demo>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DEMO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEMO;

				if (pagination) {
					sql = sql.concat(demoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<demo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<demo>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the demos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (demo demo : findAll()) {
			remove(demo);
		}
	}

	/**
	 * Returns the number of demos.
	 *
	 * @return the number of demos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DEMO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return demoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the demo persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(demoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DEMO = "SELECT demo FROM demo demo";
	private static final String _SQL_SELECT_DEMO_WHERE_PKS_IN = "SELECT demo FROM demo demo WHERE demoId IN (";
	private static final String _SQL_SELECT_DEMO_WHERE = "SELECT demo FROM demo demo WHERE ";
	private static final String _SQL_COUNT_DEMO = "SELECT COUNT(demo) FROM demo demo";
	private static final String _SQL_COUNT_DEMO_WHERE = "SELECT COUNT(demo) FROM demo demo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "demo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No demo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No demo exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(demoPersistenceImpl.class);
}