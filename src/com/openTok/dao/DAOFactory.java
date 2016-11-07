package com.openTok.dao;

import com.openTok.daoImpl.DAOImpl;

public class DAOFactory {

	public static DAO daoImplInstance() {
		return new DAOImpl();
	}

}
