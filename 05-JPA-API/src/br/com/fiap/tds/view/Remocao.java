package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Produto;

public class Remocao {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o produto
		Produto produto = em.find(Produto.class, 3);
		
		//Remover o produto
		em.remove(produto);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();

		System.out.println("Produto removido!");
		
		//System.out.println(produto);
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
