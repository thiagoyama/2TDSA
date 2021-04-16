package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ClienteDao;
import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class ClienteDaoTeste {
	
	public static void main(String[] args) {
		//Obter o Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter o Cliente Dao
		//ClienteDao dao = new ClienteDaoImpl(em);

		//Definir e instanciar uma classe anônima (sem nome) que herda de GenericDaoImpl
		
		GenericDao<Cliente,Integer> dao = new GenericDaoImpl<Cliente,Integer>(em) {};
		
		//Cadastrar
		Cliente cliente = new Cliente("Maria", "12312312", Genero.FEMININO);
		
		try {
			dao.insert(cliente);
			dao.commit();
			System.out.println("Cliente registrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar
		try {
			cliente = dao.select(1);
			System.out.println(cliente.getNome() +  " " + cliente.getCpf());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar
		cliente = new Cliente(1, "Joao", "984939394", Genero.MASCULINO);
		try {
			dao.update(cliente);
			dao.commit();
			System.out.println("Cliente atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Cliente removido!");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}

}
