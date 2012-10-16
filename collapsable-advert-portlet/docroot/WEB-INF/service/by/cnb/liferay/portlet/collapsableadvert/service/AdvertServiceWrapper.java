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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AdvertService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       AdvertService
 * @generated
 */
public class AdvertServiceWrapper implements AdvertService,
	ServiceWrapper<AdvertService> {
	public AdvertServiceWrapper(AdvertService advertService) {
		_advertService = advertService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _advertService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_advertService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _advertService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AdvertService getWrappedAdvertService() {
		return _advertService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAdvertService(AdvertService advertService) {
		_advertService = advertService;
	}

	public AdvertService getWrappedService() {
		return _advertService;
	}

	public void setWrappedService(AdvertService advertService) {
		_advertService = advertService;
	}

	private AdvertService _advertService;
}