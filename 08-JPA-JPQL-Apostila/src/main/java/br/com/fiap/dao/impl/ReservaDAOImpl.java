package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> buscarPorCpfCliente(String cpf) {
		return em.createNamedQuery("Reserva.porCpfCliente", Reserva.class)
				.setParameter("cpf", cpf)
				.getResultList();
	}

	@Override
	public List<Reserva> buscarPorDescricaoPacote(String descricao) {
		return em.createNamedQuery("Reserva.porDescricaoPacote", Reserva.class)
				.setParameter("desc", "%" + descricao.toLowerCase() + "%")
				.getResultList();
	}

}
