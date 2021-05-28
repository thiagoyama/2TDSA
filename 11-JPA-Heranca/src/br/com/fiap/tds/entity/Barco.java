package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="TB_BARCO")
@Entity
public class Barco extends Veiculo {

	@Column(name="nr_pes")
	private Float pes;
	
	@Column(name="nr_motores")
	private Integer motores;

	public Barco() {}
	
	public Barco(String modelo, Integer ano, Float pes, Integer motores) {
		super(modelo, ano);
		this.pes = pes;
		this.motores = motores;
	}

	public Float getPes() {
		return pes;
	}

	public void setPes(Float pes) {
		this.pes = pes;
	}

	public Integer getMotores() {
		return motores;
	}

	public void setMotores(Integer motores) {
		this.motores = motores;
	}
	
}
