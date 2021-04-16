package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PILOTO")
@SequenceGenerator(name="piloto", sequenceName = "SQ_TB_PILOTO", allocationSize = 1)
public class Piloto {

	@Id
	@Column(name="cd_piloto")
	@GeneratedValue(generator = "cd_piloto", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_piloto", length = 100, nullable = false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tamanho_uniforme", length = 20)
	private TamanhoUniforme tamanhoUniforme;
	
	@Column(name="vl_peso", scale = 3, precision = 6)
	private Float peso;
	
	@Column(name="ds_nacionalidade", length = 50)
	private String nacionalidade;
	
	//Mapear o relacionamento 1:1 bidirecional
	//mappedBy -> sempre utilizado no bidirecional
	//mappedBy -> nome do atributo que mapeia a FK
	@OneToOne(mappedBy = "piloto", cascade = CascadeType.PERSIST)
	private Carro carro;
	
	public Piloto() {}

	public Piloto(String nome, Calendar dataNascimento, TamanhoUniforme tamanhoUniforme, 
			Float peso, String nacionalidade) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tamanhoUniforme = tamanhoUniforme;
		this.peso = peso;
		this.nacionalidade = nacionalidade;
	}
	
	public Piloto(int codigo, String nome, Calendar dataNascimento, TamanhoUniforme tamanhoUniforme, Float peso,
			String nacionalidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tamanhoUniforme = tamanhoUniforme;
		this.peso = peso;
		this.nacionalidade = nacionalidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TamanhoUniforme getTamanhoUniforme() {
		return tamanhoUniforme;
	}

	public void setTamanhoUniforme(TamanhoUniforme tamanhoUniforme) {
		this.tamanhoUniforme = tamanhoUniforme;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
