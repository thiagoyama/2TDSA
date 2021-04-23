package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CarroDao;
import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.CarroDaoImpl;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.entity.Equipe;
import br.com.fiap.tds.entity.Piloto;
import br.com.fiap.tds.entity.TamanhoUniforme;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroCarro {

	//Cadastrar um carro com um novo piloto e uma equipe que existe no banco
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter da EquipeDao e CarroDao
		GenericDao<Equipe,Integer> equipeDao = new GenericDaoImpl<Equipe,Integer>(em) {};
		CarroDao carroDao = new CarroDaoImpl(em);
		
		try {
			//Pesquisar uma equipe
			Equipe equipe = equipeDao.select(1);
			
			//Instanciar um piloto
			Piloto piloto = new Piloto("Cabral", new GregorianCalendar(2000, Calendar.JANUARY, 1),
																		TamanhoUniforme.G, 60.0f, "Brasil");
			
			//Instanciar um carro com a equipe e piloto
			Carro carro = new Carro(12, 400.0, "Fiap Motors", 500, piloto);
			carro.setEquipe(equipe);
			
			//Cadastro do carro
			carroDao.insert(carro);
			carroDao.commit();
			System.out.println("Carro e piloto registrados!"); 
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
