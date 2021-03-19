package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Aluno;
import br.com.fiap.tds.bean.Pessoa;
import br.com.fiap.tds.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um Aluno e uma Pessoa
		Aluno aluno = new Aluno();
		Pessoa pessoa = new Pessoa();
		
		//Instanciar um orm
		Orm orm = new Orm();
		
		//Chamar o método gerarPesquisa do orm
		System.out.println(orm.gerarPesquisa(aluno));
		System.out.println(orm.gerarPesquisa(pessoa));
	}
}
