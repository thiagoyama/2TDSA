package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Corrida;
import br.com.fiap.tds.entity.Pais;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroCorrida {

	//Casdastrar uma corrida
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma CorridaDao
		GenericDao<Corrida,Integer> dao = new GenericDaoImpl<Corrida,Integer>(em) {};
		
		//Instanciar a corrida
		Corrida corrida = new Corrida("Interlagos", Pais.BRASIL, 57, 5630.3, 60000);
		
		try {
			//Cadastrar 
			dao.insert(corrida);
			dao.commit();
			System.out.println("Corrida registrada!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
