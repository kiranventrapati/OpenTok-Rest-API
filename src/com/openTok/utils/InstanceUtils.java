package com.openTok.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstanceUtils {

	public static SessionFactory factory;

	private InstanceUtils() {

	}

	public static SessionFactory getSessionFactoryInstance() {
		if (factory == null) {
			factory = new Configuration().configure(
					"com/openTok/config/hibernate.cfg.xml")
					.buildSessionFactory();
		}

		return factory;
	}

}
