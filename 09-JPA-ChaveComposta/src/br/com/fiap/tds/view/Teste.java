package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ItemPedidoDao;
import br.com.fiap.tds.dao.impl.ItemPedidoDaoImpl;
import br.com.fiap.tds.entity.ItemPedido;
import br.com.fiap.tds.entity.ItemPedidoPK;
import br.com.fiap.tds.entity.Pedido;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar todas as entidades relacionadas
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um ItemPedidoDao
		ItemPedidoDao itemDao = new ItemPedidoDaoImpl(em);
		
		//Instanciar um Produto
		Produto produto = new Produto("Pastel de queijo");
		
		//Instanciar um Pedido
		Pedido pedido = new Pedido(Calendar.getInstance());
		
		//Instanciar um Item pedido com o produto e pedido
		ItemPedido itemPedido = new ItemPedido(produto, pedido, 5.0, 2);
		
		//Cadastrar item pedido
		try {
			itemDao.insert(itemPedido);
			itemDao.commit();
			System.out.println("Produto, pedido e item cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar um item pela chave primária PK
			ItemPedidoPK pk = new ItemPedidoPK(1, 1, 1);
			ItemPedido item = itemDao.select(pk);
			//Exibir o nome do produto, preço do item e qtd
			System.out.println(item.getProduto().getNome() + " " + item.getValor() + " " + item.getQuantidade());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
