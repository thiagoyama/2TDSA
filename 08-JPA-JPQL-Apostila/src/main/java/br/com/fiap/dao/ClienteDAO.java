package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	//2 - Buscar por parte do nome
	List<Cliente> buscarPorNome(String nome);
	
	//4 - Buscar clientes por estado
	List<Cliente> buscarPorEstado(String estado);
	
	//5 - Buscar por número de dias de reserva
	List<Cliente> buscarPorDiasReserva(int dias);
	
}
