package br.com.fiap.tds.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARRO")
@SequenceGenerator(name="carro",sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro {
	
	@Id
	@Column(name="cd_carro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private int codigo;
	
	@Column(name="qtd_pneus", nullable = false)
	private Integer quantidadePneus;
	
	@Column(name="vl_velocidade_maxima")
	private Double velocidadeMaxima;
	
	@Column(name="ds_marca_motor", length = 40)
	private String marcaMotor;
	
	@Column(name="nr_cavalos")
	private Integer numeroCavalos;
	
	//Mapear o relacionamento um-para-um 
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name="cd_piloto", nullable = false)
	private Piloto piloto;
	
	//Mapear o relacionamento muitos-para-um
	@ManyToOne
	@JoinColumn(name="cd_equipe", nullable = false)
	private Equipe equipe;
	
	public Carro() {}
	
	public Carro(Integer quantidadePneus, Double velocidadeMaxima, String marcaMotor,
				Integer numeroCavalos, Piloto piloto) {
		this.setPiloto(piloto);
		this.quantidadePneus = quantidadePneus;
		this.velocidadeMaxima = velocidadeMaxima;
		this.marcaMotor = marcaMotor;
		this.numeroCavalos = numeroCavalos;
	}

	public Carro(int codigo, Integer quantidadePneus, Double velocidadeMaxima, String marcaMotor,
			Integer numeroCavalos) {
		this.codigo = codigo;
		this.quantidadePneus = quantidadePneus;
		this.velocidadeMaxima = velocidadeMaxima;
		this.marcaMotor = marcaMotor;
		this.numeroCavalos = numeroCavalos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidadePneus() {
		return quantidadePneus;
	}

	public void setQuantidadePneus(Integer quantidadePneus) {
		this.quantidadePneus = quantidadePneus;
	}

	public Double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(Double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public String getMarcaMotor() {
		return marcaMotor;
	}

	public void setMarcaMotor(String marcaMotor) {
		this.marcaMotor = marcaMotor;
	}

	public Integer getNumeroCavalos() {
		return numeroCavalos;
	}

	public void setNumeroCavalos(Integer numeroCavalos) {
		this.numeroCavalos = numeroCavalos;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
