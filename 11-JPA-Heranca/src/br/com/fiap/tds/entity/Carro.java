package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//Valor quando um carro for gravado
//@DiscriminatorValue("C")

//Configurar o nome da coluna de PK/FK
@PrimaryKeyJoinColumn(name="cd_carro")

@Table(name="TB_CARRO")
@Entity
public class Carro extends Veiculo {

	@Column(name="qt_portas")
	private Integer qtdPortas;
	
	@Column(name="st_direcao_eletrica")
	private boolean direcaoEletrica;
	
	public Carro() {}
	
	public Carro(String modelo, Integer ano, Integer qtdPortas, boolean direcaoEletrica) {
		super(modelo, ano);
		this.qtdPortas = qtdPortas;
		this.direcaoEletrica = direcaoEletrica;
	}

	public Integer getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(Integer qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	public boolean isDirecaoEletrica() {
		return direcaoEletrica;
	}

	public void setDirecaoEletrica(boolean direcaoEletrica) {
		this.direcaoEletrica = direcaoEletrica;
	}
	
}