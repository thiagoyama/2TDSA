package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AgendamentoDao;
import br.com.fiap.tds.exercicio.entity.Agendamento;
import br.com.fiap.tds.exercicio.entity.AgendamentoPK;

public class AgendamentoDaoImpl 
				extends GenericDaoImpl<Agendamento, AgendamentoPK> implements AgendamentoDao {

	public AgendamentoDaoImpl(EntityManager em) {
		super(em);
	}

}
