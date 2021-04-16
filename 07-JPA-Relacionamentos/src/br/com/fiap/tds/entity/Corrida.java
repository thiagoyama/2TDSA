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
@Table(name="TB_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName = "SQ_TB_CORRIDA", allocationSize = 1)
public class Corrida {

	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(generator = "corrida", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pista", length = 50, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_pais", length = 50)
	private Pais pais;
	
	@Column(name="nr_voltas", nullable = false)
	private Integer numeroVoltas;
	
	@Column(name="vl_extensao_pista", nullable = false)
	private Double extensao;
	
	@Column(name="nr_espectadores")
	private Integer espectadores;
	
	public Corrida() {}

	public Corrida(String nome, Pais pais, Integer numeroVoltas, Double extensao, Integer espectadores) {
		this.nome = nome;
		this.pais = pais;
		this.numeroVoltas = numeroVoltas;
		this.extensao = extensao;
		this.espectadores = espectadores;
	}

	public Corrida(int codigo, String nome, Pais pais, Integer numeroVoltas, Double extensao, Integer espectadores) {
		this.codigo = codigo;
		this.nome = nome;
		this.pais = pais;
		this.numeroVoltas = numeroVoltas;
		this.extensao = extensao;
		this.espectadores = espectadores;
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

	public Integer getNumeroVoltas() {
		return numeroVoltas;
	}

	public void setNumeroVoltas(Integer numeroVoltas) {
		this.numeroVoltas = numeroVoltas;
	}

	public Double getExtensao() {
		return extensao;
	}

	public void setExtensao(Double extensao) {
		this.extensao = extensao;
	}

	public Integer getEspectadores() {
		return espectadores;
	}

	public void setEspectadores(Integer espectadores) {
		this.espectadores = espectadores;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
