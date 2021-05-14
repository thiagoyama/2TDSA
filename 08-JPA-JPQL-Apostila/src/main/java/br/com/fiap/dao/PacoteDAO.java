package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	//3 - Buscar pacotes por transporte
	List<Pacote> buscarPorTransporte(Transporte transporte);

	//Buscar pacotes por preço menor, retornando somente a descrição e preco (List<Object[]>)
	List<Object[]> buscarPorPrecoMenor(float preco);
	
	//Buscar pacotes por preço menor, retornando somente a descrição e preço (List<Pacote>)
	List<Pacote> buscarPorPrecoMenor2(float preco);
	
	//Buscar pacotos por preço menor, retornando somente a descrição (List<Strin<>)
	List<String> buscarPorPrecoMenor3(float preco);
	
	// 6 - Buscar por data de saída
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
}
