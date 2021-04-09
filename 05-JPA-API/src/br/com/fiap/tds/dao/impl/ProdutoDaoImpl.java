package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.ProdutoDao;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.ProdutoNotFoundException;

public class ProdutoDaoImpl implements ProdutoDao {

	private EntityManager em;
	
	public ProdutoDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void insert(Produto produto) {
		em.persist(produto);
	}

	@Override
	public Produto select(int id) throws ProdutoNotFoundException {
		Produto produto = em.find(Produto.class, id);
		if (produto == null)
			throw new ProdutoNotFoundException();
		return produto;
	}

	@Override
	public void update(Produto produto) {
		em.merge(produto);
	}

	@Override
	public void delete(int id) throws ProdutoNotFoundException {
		Produto produto = select(id);
		em.remove(produto);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}

