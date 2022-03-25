package br.com.mercado.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
	private static final EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Mercado");
	
	public static  EntityManager RetornaEntityManager() {
		
		return fabrica.createEntityManager();
	}

}
