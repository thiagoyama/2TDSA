package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)

//SINGLE_TABLE
//Configura o nome da coluna que armazena o tipo de objeto gravado
//@DiscriminatorColumn(name = "ds_tipo")
//Define o valor que será gravado
//@DiscriminatorValue("V")

@Entity
@Table(name="TB_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName = "SQ_TB_VEICULO", allocationSize = 1)
public class Veiculo {

	@Id
	@Column(name="cd_veiculo")
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="ds_modelo", nullable = false, length = 100)
	private String modelo;
	
	@Column(name="nr_ano")
	private Integer ano;
	
	public Veiculo() {}
	
	public Veiculo(String modelo, Integer ano) {
		this.modelo = modelo;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}