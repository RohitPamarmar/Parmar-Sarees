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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class demoSoap implements Serializable {
	public static demoSoap toSoapModel(demo model) {
		demoSoap soapModel = new demoSoap();

		soapModel.setDemoId(model.getDemoId());
		soapModel.setDemoName(model.getDemoName());

		return soapModel;
	}

	public static demoSoap[] toSoapModels(demo[] models) {
		demoSoap[] soapModels = new demoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static demoSoap[][] toSoapModels(demo[][] models) {
		demoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new demoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new demoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static demoSoap[] toSoapModels(List<demo> models) {
		List<demoSoap> soapModels = new ArrayList<demoSoap>(models.size());

		for (demo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new demoSoap[soapModels.size()]);
	}

	public demoSoap() {
	}

	public int getPrimaryKey() {
		return _demoId;
	}

	public void setPrimaryKey(int pk) {
		setDemoId(pk);
	}

	public int getDemoId() {
		return _demoId;
	}

	public void setDemoId(int demoId) {
		_demoId = demoId;
	}

	public String getDemoName() {
		return _demoName;
	}

	public void setDemoName(String demoName) {
		_demoName = demoName;
	}

	private int _demoId;
	private String _demoName;
}