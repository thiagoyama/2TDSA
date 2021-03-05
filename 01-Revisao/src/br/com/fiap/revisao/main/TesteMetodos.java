package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Chocolate;
import br.com.fiap.revisao.bean.Produto;

public class TesteMetodos {

	//main -> CTRL + espaço
	public static void main(String args[]) {
		//Instanciar um Produto
		Produto produto = new Produto(1, "Caneta", true);
		
		//Chamar o método calcularDesconto()
		produto.calcularDesconto(); //Produto
		
		//Instanciar um Chocolate
		Chocolate chocolate = new Chocolate(1, "Ao Leite", true, 150);
		
		//Chamar o método calcularDesconto()
		chocolate.calcularDesconto(); //Chocolate
		
		Produto p = new Chocolate();
		p.calcularDesconto(); //Chocolate
		
		//Chocolate c = new Produto(); //Não compila
		
	}
	
}
