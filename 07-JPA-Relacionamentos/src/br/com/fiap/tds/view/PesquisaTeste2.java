package br.com.fiap.tds.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.entity.Corrida;
import br.com.fiap.tds.entity.Equipe;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste2 {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		GenericDao<Equipe,Integer> equipeDao = new GenericDaoImpl<Equipe,Integer>(em){};
		
		try {
			//Pesquisar uma equipe
			Equipe equipe = equipeDao.select(2);
			
			//Exibir o nome da equipe e o chefe
			System.out.println(equipe.getNome() + " - " + equipe.getTecnico());
			
			List<Carro> carros = equipe.getCarros();
			for (Carro carro : carros) {
				//Exibir a marcado motor dos carros
				System.out.println(carro.getMarcaMotor());
				//Exibir o nome dos pilotos dos carros
				System.out.println(carro.getPiloto().getNome());
			}
			
			//Exibir as corridas da equipe
			for (Corrida corrida : equipe.getCorridas()) {
				System.out.println(corrida.getNome() + " - " + corrida.getPais());
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
