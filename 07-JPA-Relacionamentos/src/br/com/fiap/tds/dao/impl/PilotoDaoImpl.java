package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.PilotoDao;
import br.com.fiap.tds.entity.Piloto;

public class PilotoDaoImpl 
					extends GenericDaoImpl<Piloto, Integer> implements PilotoDao {

	public PilotoDaoImpl(EntityManager em) {
		super(em);
	}

}
