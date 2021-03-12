package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Estado;
import br.com.fiap.revisao.bean.Produto;

public class TesteEnum {

	public static void main(String[] args) {
		//Instanciar um produto
		Produto produto = new Produto();
		
		//Atribuir um estado para o produto
		produto.setEstado(Estado.NOVO);
		
		//Validar se o produto é novo
		if (produto.getEstado() == Estado.NOVO) {
			System.out.println("Produto é novo!");
		}
		
		//Exibir o estado do produto
		System.out.println(produto.getEstado());
	}
	
}
