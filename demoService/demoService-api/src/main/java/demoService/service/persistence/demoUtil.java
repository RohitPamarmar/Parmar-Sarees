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

package demoService.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import demoService.model.demo;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the demo service. This utility wraps {@link demoService.service.persistence.impl.demoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see demoPersistence
 * @see demoService.service.persistence.impl.demoPersistenceImpl
 * @generated
 */
@ProviderType
public class demoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(demo demo) {
		getPersistence().clearCache(demo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<demo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<demo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<demo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<demo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static demo update(demo demo) {
		return getPersistence().update(demo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static demo update(demo demo, ServiceContext serviceContext) {
		return getPersistence().update(demo, serviceContext);
	}

	/**
	* Returns all the demos where demoName = &#63;.
	*
	* @param demoName the demo name
	* @return the matching demos
	*/
	public static List<demo> findByfindByDemo(java.lang.String demoName) {
		return getPersistence().findByfindByDemo(demoName);
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
	public static List<demo> findByfindByDemo(java.lang.String demoName,
		int start, int end) {
		return getPersistence().findByfindByDemo(demoName, start, end);
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
	public static List<demo> findByfindByDemo(java.lang.String demoName,
		int start, int end, OrderByComparator<demo> orderByComparator) {
		return getPersistence()
				   .findByfindByDemo(demoName, start, end, orderByComparator);
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
	public static List<demo> findByfindByDemo(java.lang.String demoName,
		int start, int end, OrderByComparator<demo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByfindByDemo(demoName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching demo
	* @throws NoSuchdemoException if a matching demo could not be found
	*/
	public static demo findByfindByDemo_First(java.lang.String demoName,
		OrderByComparator<demo> orderByComparator)
		throws demoService.exception.NoSuchdemoException {
		return getPersistence()
				   .findByfindByDemo_First(demoName, orderByComparator);
	}

	/**
	* Returns the first demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching demo, or <code>null</code> if a matching demo could not be found
	*/
	public static demo fetchByfindByDemo_First(java.lang.String demoName,
		OrderByComparator<demo> orderByComparator) {
		return getPersistence()
				   .fetchByfindByDemo_First(demoName, orderByComparator);
	}

	/**
	* Returns the last demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching demo
	* @throws NoSuchdemoException if a matching demo could not be found
	*/
	public static demo findByfindByDemo_Last(java.lang.String demoName,
		OrderByComparator<demo> orderByComparator)
		throws demoService.exception.NoSuchdemoException {
		return getPersistence()
				   .findByfindByDemo_Last(demoName, orderByComparator);
	}

	/**
	* Returns the last demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching demo, or <code>null</code> if a matching demo could not be found
	*/
	public static demo fetchByfindByDemo_Last(java.lang.String demoName,
		OrderByComparator<demo> orderByComparator) {
		return getPersistence()
				   .fetchByfindByDemo_Last(demoName, orderByComparator);
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
	public static demo[] findByfindByDemo_PrevAndNext(int demoId,
		java.lang.String demoName, OrderByComparator<demo> orderByComparator)
		throws demoService.exception.NoSuchdemoException {
		return getPersistence()
				   .findByfindByDemo_PrevAndNext(demoId, demoName,
			orderByComparator);
	}

	/**
	* Removes all the demos where demoName = &#63; from the database.
	*
	* @param demoName the demo name
	*/
	public static void removeByfindByDemo(java.lang.String demoName) {
		getPersistence().removeByfindByDemo(demoName);
	}

	/**
	* Returns the number of demos where demoName = &#63;.
	*
	* @param demoName the demo name
	* @return the number of matching demos
	*/
	public static int countByfindByDemo(java.lang.String demoName) {
		return getPersistence().countByfindByDemo(demoName);
	}

	/**
	* Caches the demo in the entity cache if it is enabled.
	*
	* @param demo the demo
	*/
	public static void cacheResult(demo demo) {
		getPersistence().cacheResult(demo);
	}

	/**
	* Caches the demos in the entity cache if it is enabled.
	*
	* @param demos the demos
	*/
	public static void cacheResult(List<demo> demos) {
		getPersistence().cacheResult(demos);
	}

	/**
	* Creates a new demo with the primary key. Does not add the demo to the database.
	*
	* @param demoId the primary key for the new demo
	* @return the new demo
	*/
	public static demo create(int demoId) {
		return getPersistence().create(demoId);
	}

	/**
	* Removes the demo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param demoId the primary key of the demo
	* @return the demo that was removed
	* @throws NoSuchdemoException if a demo with the primary key could not be found
	*/
	public static demo remove(int demoId)
		throws demoService.exception.NoSuchdemoException {
		return getPersistence().remove(demoId);
	}

	public static demo updateImpl(demo demo) {
		return getPersistence().updateImpl(demo);
	}

	/**
	* Returns the demo with the primary key or throws a {@link NoSuchdemoException} if it could not be found.
	*
	* @param demoId the primary key of the demo
	* @return the demo
	* @throws NoSuchdemoException if a demo with the primary key could not be found
	*/
	public static demo findByPrimaryKey(int demoId)
		throws demoService.exception.NoSuchdemoException {
		return getPersistence().findByPrimaryKey(demoId);
	}

	/**
	* Returns the demo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param demoId the primary key of the demo
	* @return the demo, or <code>null</code> if a demo with the primary key could not be found
	*/
	public static demo fetchByPrimaryKey(int demoId) {
		return getPersistence().fetchByPrimaryKey(demoId);
	}

	public static java.util.Map<java.io.Serializable, demo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the demos.
	*
	* @return the demos
	*/
	public static List<demo> findAll() {
		return getPersistence().findAll();
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
	public static List<demo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<demo> findAll(int start, int end,
		OrderByComparator<demo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<demo> findAll(int start, int end,
		OrderByComparator<demo> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the demos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of demos.
	*
	* @return the number of demos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static demoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<demoPersistence, demoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(demoPersistence.class);
}