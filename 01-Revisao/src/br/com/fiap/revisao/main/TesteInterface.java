package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Produto;
import br.com.fiap.revisao.dao.ProdutoDao;
import br.com.fiap.revisao.dao.ProdutoMySqlDao;

// View (JSP) <-> Controller (Servlet) ProdutoDao <-> DAO <-> Banco de Dados

public class TesteInterface {

	public static void main(String[] args) {
		//Instanciar um objeto do tipo ProdutoDao
		ProdutoDao dao = new ProdutoMySqlDao();
		
		//Chamar o método cadastrar..
		dao.cadastrar(new Produto(1,"Relógio", true));
	}
	
}