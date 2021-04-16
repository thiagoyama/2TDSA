package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.ContaDao;
import br.com.fiap.tds.entity.Conta;

public class ContaDaoImpl extends GenericDaoImpl<Conta, Integer> implements ContaDao {

	public ContaDaoImpl(EntityManager em) {
		super(em);
	}

}
