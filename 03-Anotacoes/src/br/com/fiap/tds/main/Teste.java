package br.com.fiap.tds.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.bean.Pessoa;

public class Teste {

	public static void main(String[] args) {
		//Instanciar uma classe Pessoa
		Pessoa pessoa = new Pessoa();
		
		//API Refletion -> obter a estrutura da classe
		//Obter o nome da classe
		String nome = pessoa.getClass().getName(); //getSimpleName();
		System.out.println(nome);
		
		//Obter os métodos da classe
		System.out.println("Métodos:");
		Method[] metodos = pessoa.getClass().getDeclaredMethods();
		//Exibir o nome dos métodos
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
		//Obter os atributos
		System.out.println("Atributos:");
		Field[] atributos = pessoa.getClass().getDeclaredFields();
		//Exibir o nome e o tipo dos atributos
		for (Field f : atributos) {
			System.out.println(f.getName() + " " + f.getType().getSimpleName());
			//Recuperar a anotação @Coluna
			Coluna a = f.getAnnotation(Coluna.class);
			//Exibir os parametros da anotação
			System.out.println(a.nome() + " Obrigatório: " + a.obrigatorio() + 
					" Tamanho: " + a.tamanho());
		}
		
	}//main
	
}//classe


