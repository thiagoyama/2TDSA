package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EQUIPE")
@SequenceGenerator(name="equipe", sequenceName = "SQ_TB_EQUIPE", allocationSize = 1)
public class Equipe {
	
	@Id
	@Column(name="cd_equipe")
	@GeneratedValue(generator = "equipe", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_equipe", nullable = false, length = 60)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_pais", nullable = false, length = 60)
	private Pais pais;
	
	@Column(name="nm_tecnico", length = 100)
	private String tecnico;
	
	@Column(name="nr_funcionario")
	private Integer numeroFuncionarios;

	public Equipe() {}
	
	public Equipe(String nome, Pais pais, String tecnico, Integer numeroFuncionarios) {
		this.nome = nome;
		this.pais = pais;
		this.tecnico = tecnico;
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Equipe(int codigo, String nome, Pais pais, String tecnico, Integer numeroFuncionarios) {
		this.codigo = codigo;
		this.nome = nome;
		this.pais = pais;
		this.tecnico = tecnico;
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
