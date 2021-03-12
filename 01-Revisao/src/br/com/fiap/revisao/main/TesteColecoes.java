package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Chocolate;

public class TesteColecoes {

	public static void main(String[] args) {
		
		//Instanciar uma lista de Chocolate
		List<Chocolate> lista = new ArrayList<>();
		
		//Adicionar dois chocolates na lista
		lista.add(new Chocolate(1, "Garoto", true, 50));
		
		Chocolate chocolate = new Chocolate(2, "70%", false, 80);
		lista.add(chocolate);
		
		//Exibir os chocolates da lista
		for (int i =0; i < lista.size() ; i++) {
			System.out.println(lista.get(i).getNome() + " "
					+ lista.get(i).getPeso());
		}
		
		//foreach
		for (Chocolate c : lista) {
			System.out.println(c);
		}
		
		//Mapa<Tipo da chave, Tipo Valor>
		Map<String, Chocolate> mapa = new HashMap<String, Chocolate>();
		
		//adicionar dois chocolates no mapa
		mapa.put("choco1", new Chocolate(1, "Cacau Show", true, 80));
		mapa.put("choco2", new Chocolate(2, "KitKat", false, 90));
		
		//recuperar um chocolate através da chave
		chocolate = mapa.get("choco2");
		System.out.println(chocolate.getNome() + " " + chocolate.getPeso());
		
		chocolate.setNome("Lacta");
		
		System.out.println(mapa.get("choco2").getNome()); 
		
	}//main
	
}//classe
