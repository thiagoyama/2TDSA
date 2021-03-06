package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
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
		
		//Pesquisar um transporte por c??digo
		Transporte transporte = transporteDao.pesquisar(2);
		
		//3 - Pesquisar pacote por transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		System.out.println("Buscar pacotes por transporte");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa()));
		
		//4 - Pesquisar clientes por estado
		clientes = clienteDao.buscarPorEstado("BA");
		System.out.println("Buscar clientes por estado");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//5 - Pesquisar clientes por n??mero de dias de reserva
		clientes = clienteDao.buscarPorDiasReserva(10);
		System.out.println("Buscar clientes por dias de reserva");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Listar clientes com pagina????o
		clientes = clienteDao.listar(10,5);
		System.out.println("Listar clientes com pagina????o");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Buscar por pacotes por pre??o menor, retornando um vetor de objetos com a descri????o e pre??o
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(10000);
		System.out.println("Buscar pacotes por pre??o menor, retornando uma lista de vetor de objetos");
		listaObjetos.forEach(vetor -> System.out.println(vetor[0] + " " + vetor[1]));
		
		//Buscar pacotes por pre??o menor, retornando uma lista de pacotes com somente a decri????o e pre??o preenchidos
		pacotes = pacoteDao.buscarPorPrecoMenor2(4000);
		System.out.println("Buscar pacotes por pre??o menor, retornando uma lista de pacotes");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getPreco() + " " + p.getDataSaida()));
		
		//Buscar pacotes por pre??o menor, retornando somente a descri????o em uma lista de String
		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(4000);
		System.out.println("Buscar pacotes por pre??o menor, retornando uma lista de String");
		listaString.forEach(s -> System.out.println(s));
		
		//Buscar pacotes por data de sa??da
		Calendar inicio = new GregorianCalendar(2021, Calendar.JANUARY, 1);
		Calendar fim = Calendar.getInstance(); // GregorianCalendar(2021, Calendar.DECEMBER, 30);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		System.out.println("Buscar pacotes por data de sa??da");
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
		
		//Contar a quantidade de clientes por estado
		long qtd = clienteDao.contarPorEstado("SP");
		System.out.println("Contar cliente por estado: " + qtd);
		
		//Somar os pre??os dos pacotes por um transporte
		transporte = transporteDao.pesquisar(3);
		double soma = pacoteDao.somarPrecosPorTransporte(transporte);
		System.out.println("A soma dos pre??os dos pacotes: " + soma);
		
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		//Buscar reservas por cpf do client
		List<Reserva> reservas = reservaDao.buscarPorCpfCliente("88892992922");
		System.out.println("Buscar reserva por cpf do cliente");
		reservas.forEach(r -> System.out.println(r.getCliente().getNome() + " " 
					+ r.getPacote().getDescricao() + " " + DataUtil.formatar(r.getDataReserva())));
		
		//Buscar reservas por parte da descri????o do pacote
		reservas = reservaDao.buscarPorDescricaoPacote("a");
		System.out.println("Buscar reserva por parte da descri????o do pacote");
		reservas.forEach(r -> System.out.println(r.getCliente().getNome() + " " + r.getPacote().getDescricao()));
		
		//Buscar pacotes por qtd de dias maior e pre??o menor
		pacotes = pacoteDao.buscarPorQtdDiasMaiorEPrecoMenor(5, 5000);
		System.out.println("Buscar pacotes por qtd de dias maior e pre??o menor");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getPreco()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
}//classe