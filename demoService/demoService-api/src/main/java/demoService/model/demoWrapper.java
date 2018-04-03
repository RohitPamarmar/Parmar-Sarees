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

package demoService.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link demo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see demo
 * @generated
 */
@ProviderType
public class demoWrapper implements demo, ModelWrapper<demo> {
	public demoWrapper(demo demo) {
		_demo = demo;
	}

	@Override
	public Class<?> getModelClass() {
		return demo.class;
	}

	@Override
	public String getModelClassName() {
		return demo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("demoId", getDemoId());
		attributes.put("demoName", getDemoName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer demoId = (Integer)attributes.get("demoId");

		if (demoId != null) {
			setDemoId(demoId);
		}

		String demoName = (String)attributes.get("demoName");

		if (demoName != null) {
			setDemoName(demoName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _demo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _demo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _demo.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _demo.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<demoService.model.demo> toCacheModel() {
		return _demo.toCacheModel();
	}

	@Override
	public demoService.model.demo toEscapedModel() {
		return new demoWrapper(_demo.toEscapedModel());
	}

	@Override
	public demoService.model.demo toUnescapedModel() {
		return new demoWrapper(_demo.toUnescapedModel());
	}

	@Override
	public int compareTo(demoService.model.demo demo) {
		return _demo.compareTo(demo);
	}

	/**
	* Returns the demo ID of this demo.
	*
	* @return the demo ID of this demo
	*/
	@Override
	public int getDemoId() {
		return _demo.getDemoId();
	}

	/**
	* Returns the primary key of this demo.
	*
	* @return the primary key of this demo
	*/
	@Override
	public int getPrimaryKey() {
		return _demo.getPrimaryKey();
	}

	@Override
	public int hashCode() {
		return _demo.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _demo.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new demoWrapper((demo)_demo.clone());
	}

	/**
	* Returns the demo name of this demo.
	*
	* @return the demo name of this demo
	*/
	@Override
	public java.lang.String getDemoName() {
		return _demo.getDemoName();
	}

	@Override
	public java.lang.String toString() {
		return _demo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _demo.toXmlString();
	}

	@Override
	public void persist() {
		_demo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_demo.setCachedModel(cachedModel);
	}

	/**
	* Sets the demo ID of this demo.
	*
	* @param demoId the demo ID of this demo
	*/
	@Override
	public void setDemoId(int demoId) {
		_demo.setDemoId(demoId);
	}

	/**
	* Sets the demo name of this demo.
	*
	* @param demoName the demo name of this demo
	*/
	@Override
	public void setDemoName(java.lang.String demoName) {
		_demo.setDemoName(demoName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_demo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_demo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_demo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_demo.setNew(n);
	}

	/**
	* Sets the primary key of this demo.
	*
	* @param primaryKey the primary key of this demo
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_demo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_demo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof demoWrapper)) {
			return false;
		}

		demoWrapper demoWrapper = (demoWrapper)obj;

		if (Objects.equals(_demo, demoWrapper._demo)) {
			return true;
		}

		return false;
	}

	@Override
	public demo getWrappedModel() {
		return _demo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _demo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _demo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_demo.resetOriginalValues();
	}

	private final demo _demo;
}