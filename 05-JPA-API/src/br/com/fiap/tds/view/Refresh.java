package br.com.fiap.tds.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Produto;

public class Refresh {

	//Atualiza o objeto com os valores do banco
	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um produto de código 1
		Produto produto = em.find(Produto.class, 1);
		
		//Exibir os dados do produto
		System.out.println(produto);
		
		//Alterar o nome e o valor do produto (no objeto)
		produto.setNome("Macarrão");
		produto.setValor(5);
		
		//Exibir os dados
		System.out.println(produto);
		
		//Refresh
		em.refresh(produto);
		
		//Exibir os dados
		System.out.println(produto);
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
