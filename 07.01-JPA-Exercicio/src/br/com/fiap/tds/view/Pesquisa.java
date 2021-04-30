package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Pesquisa {
	
	public static void main(String[] args) {
		//Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um SistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Pesquisar um sistema pelo código
			Sistema sistema = dao.select(1);
			
			//Exibir o nome do sistema
			System.out.println("Sistema: " + sistema.getNome());
			
			//Exibir os casos de teste do sistema
			for (CasoTeste caso : sistema.getCasosTeste()) {
				System.out.println("\nCaso Teste: " + caso.getNome() + " " + caso.getDescricao());
				
				//Exibir os itens de teste dos casos de teste
				for (ItemTeste item : caso.getItensTeste()) {
					System.out.println("\nItem Teste: " + item.getDescricao());
					
					//Exibir os usuários associados aos itens de teste
					System.out.println("\nUsuários:");
					for (Usuario usuario : item.getUsuarios()) {
						System.out.println(usuario.getNome());
					}
				}
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main

}//classe