package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Corrida;
import br.com.fiap.tds.entity.Equipe;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadatroAssociativa {

	//Associar uma corrida e uma equipe que existem no banco
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma CorridaDao e EquipeDao
		GenericDao<Corrida,Integer> corridaDao = new GenericDaoImpl<Corrida,Integer>(em) {};
		GenericDao<Equipe,Integer> equipeDao = new GenericDaoImpl<Equipe,Integer>(em) {};
		
		try {
			//Pesquisar uma corrida
			Corrida corrida = corridaDao.select(1);
			
			//Pesquisar uma equipe
			Equipe equipe = equipeDao.select(1);
			
			//Setar a corrida na lista da corrida da equipe
			equipe.getCorridas().add(corrida);
			
			//Atualizar a equipe
			equipeDao.update(equipe);
			equipeDao.commit();
			System.out.println("Corrida e equipe associadas");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
