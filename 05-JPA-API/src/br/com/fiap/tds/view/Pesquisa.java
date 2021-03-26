package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Produto;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um produto de código 1
		Produto produto = em.find(Produto.class, 1);
		
		//Exibir os dados
		System.out.println(produto);
		
//		produto.setPerecivel(true);
//
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}