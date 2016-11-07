package com.openTok.forms;

import javax.ws.rs.FormParam;

import org.springframework.validation.Errors;

public class MobileForm extends RestBaseForm {
	@FormParam("deviceType")
	String deviceType;
	@FormParam("osVersion")
	String osVersion;
	@FormParam("appVersion")
	String appVersion;
	@FormParam("deviceToken")
	String deviceToken;
	@FormParam("osType")
	String osType;

	public enum OSTYPE {
		IOS, ANDROID
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return MobileForm.class.isAssignableFrom(clazz);
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
	}
}
