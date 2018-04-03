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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import demoService.exception.NoSuchdemoException;

import demoService.model.demo;

/**
 * The persistence interface for the demo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see demoService.service.persistence.impl.demoPersistenceImpl
 * @see demoUtil
 * @generated
 */
@ProviderType
public interface demoPersistence extends BasePersistence<demo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link demoUtil} to access the demo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the demos where demoName = &#63;.
	*
	* @param demoName the demo name
	* @return the matching demos
	*/
	public java.util.List<demo> findByfindByDemo(java.lang.String demoName);

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
	public java.util.List<demo> findByfindByDemo(java.lang.String demoName,
		int start, int end);

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
	public java.util.List<demo> findByfindByDemo(java.lang.String demoName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator);

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
	public java.util.List<demo> findByfindByDemo(java.lang.String demoName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching demo
	* @throws NoSuchdemoException if a matching demo could not be found
	*/
	public demo findByfindByDemo_First(java.lang.String demoName,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator)
		throws NoSuchdemoException;

	/**
	* Returns the first demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching demo, or <code>null</code> if a matching demo could not be found
	*/
	public demo fetchByfindByDemo_First(java.lang.String demoName,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator);

	/**
	* Returns the last demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching demo
	* @throws NoSuchdemoException if a matching demo could not be found
	*/
	public demo findByfindByDemo_Last(java.lang.String demoName,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator)
		throws NoSuchdemoException;

	/**
	* Returns the last demo in the ordered set where demoName = &#63;.
	*
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching demo, or <code>null</code> if a matching demo could not be found
	*/
	public demo fetchByfindByDemo_Last(java.lang.String demoName,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator);

	/**
	* Returns the demos before and after the current demo in the ordered set where demoName = &#63;.
	*
	* @param demoId the primary key of the current demo
	* @param demoName the demo name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next demo
	* @throws NoSuchdemoException if a demo with the primary key could not be found
	*/
	public demo[] findByfindByDemo_PrevAndNext(int demoId,
		java.lang.String demoName,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator)
		throws NoSuchdemoException;

	/**
	* Removes all the demos where demoName = &#63; from the database.
	*
	* @param demoName the demo name
	*/
	public void removeByfindByDemo(java.lang.String demoName);

	/**
	* Returns the number of demos where demoName = &#63;.
	*
	* @param demoName the demo name
	* @return the number of matching demos
	*/
	public int countByfindByDemo(java.lang.String demoName);

	/**
	* Caches the demo in the entity cache if it is enabled.
	*
	* @param demo the demo
	*/
	public void cacheResult(demo demo);

	/**
	* Caches the demos in the entity cache if it is enabled.
	*
	* @param demos the demos
	*/
	public void cacheResult(java.util.List<demo> demos);

	/**
	* Creates a new demo with the primary key. Does not add the demo to the database.
	*
	* @param demoId the primary key for the new demo
	* @return the new demo
	*/
	public demo create(int demoId);

	/**
	* Removes the demo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param demoId the primary key of the demo
	* @return the demo that was removed
	* @throws NoSuchdemoException if a demo with the primary key could not be found
	*/
	public demo remove(int demoId) throws NoSuchdemoException;

	public demo updateImpl(demo demo);

	/**
	* Returns the demo with the primary key or throws a {@link NoSuchdemoException} if it could not be found.
	*
	* @param demoId the primary key of the demo
	* @return the demo
	* @throws NoSuchdemoException if a demo with the primary key could not be found
	*/
	public demo findByPrimaryKey(int demoId) throws NoSuchdemoException;

	/**
	* Returns the demo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param demoId the primary key of the demo
	* @return the demo, or <code>null</code> if a demo with the primary key could not be found
	*/
	public demo fetchByPrimaryKey(int demoId);

	@Override
	public java.util.Map<java.io.Serializable, demo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the demos.
	*
	* @return the demos
	*/
	public java.util.List<demo> findAll();

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
	public java.util.List<demo> findAll(int start, int end);

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
	public java.util.List<demo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator);

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
	public java.util.List<demo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<demo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the demos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of demos.
	*
	* @return the number of demos
	*/
	public int countAll();
}