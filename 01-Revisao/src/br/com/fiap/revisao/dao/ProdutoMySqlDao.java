package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.bean.Produto;

public class ProdutoMySqlDao implements ProdutoDao {

	@Override
	public void cadastrar(Produto produto) {
		System.out.println("Cadastrando no MySql");
	}

	@Override
	public List<Produto> listar() {
		System.out.println("Listando do MySql");
		return null;
	}

}
