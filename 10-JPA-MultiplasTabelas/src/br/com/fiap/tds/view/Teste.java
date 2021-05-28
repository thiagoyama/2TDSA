package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Obter o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um FuncionarioDao
		FuncionarioDao dao = new FuncionarioDaoImpl(em);
		
		//Instanciar um Funcionario
		Funcionario func = new Funcionario("Allen", 
				new GregorianCalendar(2010, Calendar.JANUARY, 1), 10000.00, 123, 12312);
		
		//Cadastrar
		try {
			dao.insert(func);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar por código
			Funcionario busca = dao.select(1);
			System.out.println(busca.getNome() + " " + busca.getSalario());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}
