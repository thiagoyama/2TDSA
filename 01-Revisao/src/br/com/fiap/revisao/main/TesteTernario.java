package br.com.fiap.revisao.main;

public class TesteTernario {

	public static void main(String[] args) {
		int x = 7;
		
		if (x > 10) {
			System.out.println("X é maior do que 10");
		} else {
			System.out.println("X é menor ou igual a 10");
		}
		
		//ternário (3 partes) (condição?se verdadeiro:se falso)
		System.out.println( x>10 ? "X é maior do que 10" : "X é menor ou igual a 10");
		
	}
	
}
