package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Equipe;
import br.com.fiap.tds.entity.Pais;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroEquipe {

	//Cadastrar uma equipe
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma EquipeDao
		GenericDao<Equipe,Integer> dao = new GenericDaoImpl<Equipe,Integer>(em){};
		
		//Instanciar uma equipe
		Equipe equipe = new Equipe("RedBull", Pais.ALEMANHA, "Renato", 5000);
		
		//Cadastrar
		try {
			dao.insert(equipe);
			dao.commit();
			System.out.println("Equipe cadastrada!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
