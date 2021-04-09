package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.dao.impl.ProdutoDaoImpl;
import br.com.fiap.tds.entity.EstadoProduto;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.ProdutoNotFoundException;

public class ProdutoDaoTeste {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Obter um ProdutoDao
		ProdutoDao dao = new ProdutoDaoImpl(em);
		
		//Cadastrar um produto
		Produto produto = new Produto("Fone", 50, new GregorianCalendar(2020, Calendar.JULY, 1),
										false, EstadoProduto.NOVO);
		
		try {
			dao.insert(produto);
			dao.commit();
			System.out.println("Produto cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um produto e exibir as informações
		try {
			produto = dao.select(5000);
			System.out.println(produto);
		} catch (ProdutoNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar um produto
		produto = new Produto(5, "TV", 1000, Calendar.getInstance(), false, EstadoProduto.USADO);
		try {
			dao.update(produto);
			dao.commit();
			System.out.println("Produto atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover um produto
		try {
			dao.delete(5);
			dao.commit();
			System.out.println("Produto removido!");
		} catch (CommitException | ProdutoNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
}
