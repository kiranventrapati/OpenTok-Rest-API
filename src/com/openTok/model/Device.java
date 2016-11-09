package com.openTok.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class Device implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String deviceToken;
	private String deviceType;
	private OsType osType;
	private Date whenCreated;
	private Date tlm;

	public Device(String deviceType, String osType, String deviceToken) {
		this.deviceType = deviceType;
		setDerivedOsType(osType);
		this.deviceToken = deviceToken;
		Date date = new Date();
		this.whenCreated = date;
		this.tlm = date;
	}

	public Device() {
	}

	public static enum OsType {
		IOS, ANDROID;
	}

	public static enum Type {
		iPod("iPod"), iPhone("iPhone"), iPad("iPad");

		private final String name;
		private static final Map<String, Type> map = new HashMap<String, Type>();
		static {
			for (Type type : Type.values()) {
				map.put(type.name, type);
			}
		}

		private Type(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public static Type fromString(String name) {
			if (map.containsKey(name)) {
				return map.get(name);
			}
			return null;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public Date getWhenCreated() {
		return whenCreated;
	}

	public void setWhenCreated(Date whenCreated) {
		this.whenCreated = whenCreated;
	}

	public Date getTlm() {
		return tlm;
	}

	public void setTlm(Date tlm) {
		this.tlm = tlm;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the osType
	 */
	public OsType getOsType() {
		return osType;
	}

	/**
	 * @param osType
	 *            the osType to set
	 */
	public void setOsType(OsType osType) {
		this.osType = osType;
	}

	public void setDerivedOsType(String osType) {
		if (!StringUtils.isEmpty(osType)) {
			OsType osTypeEnum = null;
			try {
				osTypeEnum = OsType.valueOf(osType);
			} catch (IllegalArgumentException ex) {

			}
			setOsType(osTypeEnum);
		}
	}
}
