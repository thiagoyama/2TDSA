package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer> {
	
	//Busca por cpf do cliente
	List<Reserva> buscarPorCpfCliente(String cpf);
	
	//Busca por parte da descrição do pacote
	List<Reserva> buscarPorDescricaoPacote(String descricao);

}
