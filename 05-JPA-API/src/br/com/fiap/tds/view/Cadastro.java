package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.EstadoProduto;
import br.com.fiap.tds.entity.Produto;

public class Cadastro {

	public static void main(String[] args) {
		
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();

		//Instanciar um Produto sem o código - Estado novo - não gerenciado
		Produto produto = new Produto("Mouse", 40, 
			new GregorianCalendar(2020, Calendar.FEBRUARY, 10), 
			false, EstadoProduto.NOVO);
		
		//Entity manager coloca o produto no context - gerenciando
		em.persist(produto);
		
		//Começa uma transação e finaliza com commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Produto cadastrado!");
		
//		produto.setNome("Mouse e teclado");
//		produto.setEstado(EstadoProduto.USADO);
//	
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}