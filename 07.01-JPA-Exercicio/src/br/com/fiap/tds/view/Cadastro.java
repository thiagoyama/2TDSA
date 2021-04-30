package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	
	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		//Instanciar um sistema com o nome
		Sistema sistema = new Sistema("Portal FIAP");
		
		//Instanciar 2 casos de teste com o nome e descrição
		CasoTeste caso1 = new CasoTeste("Challenge", "Módulo de entrega da challenge");
		CasoTeste caso2 = new CasoTeste("Boletim", "Módulo de notas dos alunos");
		
		//Adicionar os casos de teste no sistema
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);
		
		//Instanciar 3 itens de teste com a descrição
		ItemTeste item1 = new ItemTeste("Upload de arquivo com 100mb com sucesso");
		ItemTeste item2 = new ItemTeste("Não permitir o upload de arquivo com 0kb");
		
		ItemTeste item3 = new ItemTeste("Exibir a nota após o lançamento e a confirmação do token");
		
		//Adicionar 2 itens no primeiro caso de teste e 1 item no segundo caso
		caso1.addItemTeste(item1);
		caso1.addItemTeste(item2);
		
		caso2.addItemTeste(item3);
		
		//Instanciar 2 usuários com o nome
		Usuario usuario1 = new Usuario("Danilo");
		Usuario usuario2 = new Usuario("Marcela");
		
		//Criar uma lista de usuário e adicioná-los
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		//Setar a lista de usuário em alguns dos itens
		item1.setUsuarios(usuarios);
		item3.setUsuarios(usuarios);
		
		//Cadastrar o sistema
		//Obter o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um Sistema Dao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Cadastrar
			dao.insert(sistema);
			dao.commit();
			System.out.println("Sucesso!");
		
		} catch (CommitException e) {
			System.out.println("Deu ruim..");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main

}//classe