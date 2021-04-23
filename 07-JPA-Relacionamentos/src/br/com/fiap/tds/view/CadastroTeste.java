package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.CarroDao;
import br.com.fiap.tds.dao.PilotoDao;
import br.com.fiap.tds.dao.impl.CarroDaoImpl;
import br.com.fiap.tds.dao.impl.PilotoDaoImpl;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.entity.Piloto;
import br.com.fiap.tds.entity.TamanhoUniforme;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	//Cadastrar um carro e piloto relacionados
	public static void main(String[] args) {
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um PilotoDao e CarroDao
		PilotoDao pilotoDao = new PilotoDaoImpl(em);
		CarroDao carroDao = new CarroDaoImpl(em);
		
		//Instanciar um piloto
		Piloto piloto = new Piloto("Rubens", new GregorianCalendar(1980, Calendar.APRIL, 1),
														TamanhoUniforme.M, 60f, "Brasileira");
		
		//Instanciar um carro com o piloto
		Carro carro = new Carro(12, 550d, "Ferrari", 1400, piloto);
		
		//Cadastrar um carro
		carroDao.insert(carro);
		
		//Commit
		try {
			carroDao.commit();
			System.out.println("Carro e piloto cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
