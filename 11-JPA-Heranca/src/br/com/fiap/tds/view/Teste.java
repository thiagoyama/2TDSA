package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.dao.VeiculoDaoImpl;
import br.com.fiap.tds.entity.Barco;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um VeiculoDao
		VeiculoDao dao = new VeiculoDaoImpl(em);
		
		//Instanciar um veiculo, carro e barco
		Veiculo veiculo = new Veiculo("Caloi", 2010);
		Carro carro = new Carro("Gol", 2020, 5, false);
		Barco barco = new Barco("Pesca", 1999, 10f, 1);
		
		try {
			//Cadastrar um veiculo, carro e barco
			dao.insert(veiculo);
			dao.insert(carro);
			dao.insert(barco);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}