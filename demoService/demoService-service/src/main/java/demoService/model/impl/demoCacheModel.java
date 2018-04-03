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

package demoService.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import demoService.model.demo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing demo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see demo
 * @generated
 */
@ProviderType
public class demoCacheModel implements CacheModel<demo>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof demoCacheModel)) {
			return false;
		}

		demoCacheModel demoCacheModel = (demoCacheModel)obj;

		if (demoId == demoCacheModel.demoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, demoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{demoId=");
		sb.append(demoId);
		sb.append(", demoName=");
		sb.append(demoName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public demo toEntityModel() {
		demoImpl demoImpl = new demoImpl();

		demoImpl.setDemoId(demoId);

		if (demoName == null) {
			demoImpl.setDemoName(StringPool.BLANK);
		}
		else {
			demoImpl.setDemoName(demoName);
		}

		demoImpl.resetOriginalValues();

		return demoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		demoId = objectInput.readInt();
		demoName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(demoId);

		if (demoName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(demoName);
		}
	}

	public int demoId;
	public String demoName;
}