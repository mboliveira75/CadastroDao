package com.xpto.Dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory;
	
	static{
		
		JpaUtil.factory = Persistence.createEntityManagerFactory("Cadastro");
	}
	
	public EntityManagerFactory getFactory(){
			
		return JpaUtil.factory ;
	}

}
