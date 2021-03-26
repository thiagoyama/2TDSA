package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.EstadoProduto;
import br.com.fiap.tds.entity.Produto;

//View - Controller - DAO - Banco

public class Atualizacao {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um produto com um código existente no banco (Estado detached)
		Produto produto = new Produto(1, "Arroz Integral 10Kg", 10, 
				new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 
				true, EstadoProduto.NOVO);
		
		//Atualizar o produto
		Produto copiaGerenciada = em.merge(produto);
		
		//copiaGerenciada.setValor(15);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Produto atualizado!");
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
