package br.com.fiap.tds.dao;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Veiculo;

public class VeiculoDaoImpl extends GenericDaoImpl<Veiculo, Integer> implements VeiculoDao {

	public VeiculoDaoImpl(EntityManager em) {
		super(em);
	}

}
