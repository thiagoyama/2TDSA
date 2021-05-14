package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import br.com.fiap.util.DataUtil;

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
		
		//Listar clientes com paginação
		clientes = clienteDao.listar(10,5);
		System.out.println("Listar clientes com paginação");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Buscar por pacotes por preço menor, retornando um vetor de objetos com a descrição e preço
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(10000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de vetor de objetos");
		listaObjetos.forEach(vetor -> System.out.println(vetor[0] + " " + vetor[1]));
		
		//Buscar pacotes por preço menor, retornando uma lista de pacotes com somente a decrição e preço preenchidos
		pacotes = pacoteDao.buscarPorPrecoMenor2(4000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de pacotes");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getPreco() + " " + p.getDataSaida()));
		
		//Buscar pacotes por preço menor, retornando somente a descrição em uma lista de String
		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(4000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de String");
		listaString.forEach(s -> System.out.println(s));
		
		//Buscar pacotes por data de saída
		Calendar inicio = new GregorianCalendar(2021, Calendar.JANUARY, 1);
		Calendar fim = Calendar.getInstance(); // GregorianCalendar(2021, Calendar.DECEMBER, 30);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		System.out.println("Buscar pacotes por data de saída");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));
		
		//Buscar clientes por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Salvador");
		System.out.println("Buscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		//Buscar clientes por estados
		List<String> estados = new ArrayList<>();
		estados.add("PR");
		estados.add("BA");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar clientes por estados");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Buscar clientes por nome, sem case sensitive, ordenado por nome
		clientes = clienteDao.buscarPorNome2("A");
		System.out.println("Buscar cliente por parte do nome, sem case sensitive e ordenado por nome");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
}//classe