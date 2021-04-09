package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.ProdutoNotFoundException;

// Diminuir o acoplamento (dependência) entre os objetos
// View - Controller (ProdutoDao) - DAO - Banco

public interface ProdutoDao {

	void insert(Produto produto);
	Produto select(int id) throws ProdutoNotFoundException;
	void update(Produto produto);
	void delete(int id) throws ProdutoNotFoundException ;
	void commit() throws CommitException;
	
}