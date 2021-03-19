package br.com.fiap.tds.bean;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.annotation.Tabela;

@Tabela(nome="TB_PESSOA")
public class Pessoa {

	@Coluna(nome="nm_pessoa", tamanho = 80, obrigatorio = true)
	private String nome;
	
	@Coluna(nome="ds_email",tamanho = 50)
	private String email;
	
	@Coluna(nome="nr_cpf", tamanho = 14)
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}