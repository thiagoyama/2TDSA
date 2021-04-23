package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Carro;
import br.com.fiap.tds.entity.Corrida;
import br.com.fiap.tds.entity.Equipe;
import br.com.fiap.tds.entity.Pais;
import br.com.fiap.tds.entity.Piloto;
import br.com.fiap.tds.entity.TamanhoUniforme;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {

	//Cadastar uma equipe com 2 carros e 2 pilotos
	public static void main(String[] args) {
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma EquipeDao
		GenericDao<Equipe,Integer> equipeDao = new GenericDaoImpl<Equipe, Integer>(em) {};
		
		//Instanciar uma equipe
		Equipe equipe = new Equipe("FiapBull", Pais.BRASIL, "Allen", 500);
		
		//Instanciar dois pilotos e dois carros
		Piloto piloto1 = new Piloto("Sálvio", new GregorianCalendar(1980, Calendar.AUGUST, 9), 
				TamanhoUniforme.M, 67f, "Brasileiro");
		
		Piloto piloto2 = new Piloto("Rita", new GregorianCalendar(1983, Calendar.APRIL, 14),
				TamanhoUniforme.P, 60f, "Italiana");
		
		Carro carro1 = new Carro(10, 450.6, "Ferrari", 540, piloto1);
		
		Carro carro2 = new Carro(12, 500d, "Renault", 550, piloto2);
		
		//Adicionar o carro na equipe
		equipe.addCarro(carro1);
		equipe.addCarro(carro2);
		
		//Adicionar 3 corridas para a equipe
		//Instanciar 3 corridas
		Corrida corrida1 = new Corrida("Interlagos", Pais.BRASIL, 54, 4309.0, 60000);
		Corrida corrida2 = new Corrida("La Playa", Pais.ARGENTINA, 60, 4593.2, 30000);
		Corrida corrida3 = new Corrida("London", Pais.INGLATERRA, 50, 4670.2, 50000);
		
		//Criar uma lista de corridas e adiciona-las
		List<Corrida> corridas = new ArrayList<Corrida>();
		corridas.add(corrida1);
		corridas.add(corrida2);
		corridas.add(corrida3);
		
		//Setar a lista de corridas na equipe
		equipe.setCorridas(corridas);
		
		//Cadastrar a equipe
		try {
			equipeDao.insert(equipe);
			equipeDao.commit();
			System.out.println("Tudo cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
