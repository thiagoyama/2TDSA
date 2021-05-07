package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma CidadeDem
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Pesquisar por todas as cidades
		List<Cidade> cidades = cidadeDao.listar();
		
		//Exibir todas as cidades
		System.out.println("Listar todas as cidades");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}
		
		//Pesquisar cidades por estado (PR, SP, BA)
		cidades = cidadeDao.buscarPorEstado("SP");
		System.out.println("Buscar cidades por estado:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		//Instanciar o ClienteDAO
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		//1 - Listar todos os clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar os clientes");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//2 - Pesquisar clientes por parte do nome
		clientes = clienteDao.buscarPorNome("Pa");
		System.out.println("Buscar cliente por parte do nome");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Instanciar um PacoteDAO e TransporteDAO
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		
		//Pesquisar um transporte por código
		Transporte transporte = transporteDao.pesquisar(2);
		
		//3 - Pesquisar pacote por transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		System.out.println("Buscar pacotes por transporte");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa()));
		
		//4 - Pesquisar clientes por estado
		clientes = clienteDao.buscarPorEstado("BA");
		System.out.println("Buscar clientes por estado");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//5 - Pesquisar clientes por número de dias de reserva
		clientes = clienteDao.buscarPorDiasReserva(10);
		System.out.println("Buscar clientes por dias de reserva");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
}//classe