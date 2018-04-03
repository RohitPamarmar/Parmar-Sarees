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

package demoService.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link demoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see demoLocalService
 * @generated
 */
@ProviderType
public class demoLocalServiceWrapper implements demoLocalService,
	ServiceWrapper<demoLocalService> {
	public demoLocalServiceWrapper(demoLocalService demoLocalService) {
		_demoLocalService = demoLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _demoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _demoLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _demoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _demoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _demoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the demo to the database. Also notifies the appropriate model listeners.
	*
	* @param demo the demo
	* @return the demo that was added
	*/
	@Override
	public demoService.model.demo adddemo(demoService.model.demo demo) {
		return _demoLocalService.adddemo(demo);
	}

	/**
	* Creates a new demo with the primary key. Does not add the demo to the database.
	*
	* @param demoId the primary key for the new demo
	* @return the new demo
	*/
	@Override
	public demoService.model.demo createdemo(int demoId) {
		return _demoLocalService.createdemo(demoId);
	}

	/**
	* Deletes the demo from the database. Also notifies the appropriate model listeners.
	*
	* @param demo the demo
	* @return the demo that was removed
	*/
	@Override
	public demoService.model.demo deletedemo(demoService.model.demo demo) {
		return _demoLocalService.deletedemo(demo);
	}

	/**
	* Deletes the demo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param demoId the primary key of the demo
	* @return the demo that was removed
	* @throws PortalException if a demo with the primary key could not be found
	*/
	@Override
	public demoService.model.demo deletedemo(int demoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _demoLocalService.deletedemo(demoId);
	}

	@Override
	public demoService.model.demo fetchdemo(int demoId) {
		return _demoLocalService.fetchdemo(demoId);
	}

	/**
	* Returns the demo with the primary key.
	*
	* @param demoId the primary key of the demo
	* @return the demo
	* @throws PortalException if a demo with the primary key could not be found
	*/
	@Override
	public demoService.model.demo getdemo(int demoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _demoLocalService.getdemo(demoId);
	}

	/**
	* Updates the demo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param demo the demo
	* @return the demo that was updated
	*/
	@Override
	public demoService.model.demo updatedemo(demoService.model.demo demo) {
		return _demoLocalService.updatedemo(demo);
	}

	/**
	* Returns the number of demos.
	*
	* @return the number of demos
	*/
	@Override
	public int getdemosCount() {
		return _demoLocalService.getdemosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _demoLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _demoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoService.model.impl.demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _demoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoService.model.impl.demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _demoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the demos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link demoService.model.impl.demoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of demos
	* @param end the upper bound of the range of demos (not inclusive)
	* @return the range of demos
	*/
	@Override
	public java.util.List<demoService.model.demo> getdemos(int start, int end) {
		return _demoLocalService.getdemos(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _demoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _demoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public demoLocalService getWrappedService() {
		return _demoLocalService;
	}

	@Override
	public void setWrappedService(demoLocalService demoLocalService) {
		_demoLocalService = demoLocalService;
	}

	private demoLocalService _demoLocalService;
}