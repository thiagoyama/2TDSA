package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AgendamentoDao;
import br.com.fiap.tds.dao.impl.AgendamentoDaoImpl;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exercicio.entity.Agendamento;
import br.com.fiap.tds.exercicio.entity.Animal;
import br.com.fiap.tds.exercicio.entity.Porte;
import br.com.fiap.tds.exercicio.entity.Servico;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Exercicio {
	
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um AgendamentoDao
		AgendamentoDao dao = new AgendamentoDaoImpl(em);
		
		//Instanciar um animal
		Animal animal = new Animal("Duke", Porte.MEDIO);
		
		//Instanciar um serviço
		Servico servico = new Servico("Banho");
		
		//Instanciar um agendamento
		Agendamento agenda = new Agendamento(servico, animal, 
									//ano, mes, dia, horas, minutos
				new GregorianCalendar(2021, Calendar.JUNE, 10, 11, 20), 70.0);
		
		try {
			//Cadastrar o agendamento
			dao.insert(agenda);
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