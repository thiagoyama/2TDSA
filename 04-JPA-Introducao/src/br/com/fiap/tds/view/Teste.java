package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		//Obter a fabrica de gerenciador de entidades
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		//Obter o gerenciador de entidade (EntityManager)
		EntityManager em = fabrica.createEntityManager();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
