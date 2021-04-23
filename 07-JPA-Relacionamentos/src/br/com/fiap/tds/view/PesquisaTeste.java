package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CarroDao;
import br.com.fiap.tds.dao.impl.CarroDaoImpl;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {

	
	public static void main(String[] args) {
	
		//Obter um Entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um CarroDao
		CarroDao dao = new CarroDaoImpl(em);
		
		try {
			//Pesquisar um carro de código 1
			Carro carro = dao.select(1);

			//Exibir a marca do motor
			System.out.println(carro.getMarcaMotor());
			
			//Exibir o nome do piloto
			System.out.println(carro.getPiloto().getNome());
			
			//Exibir o nome da equipe
			System.out.println(carro.getEquipe().getNome());
		
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
