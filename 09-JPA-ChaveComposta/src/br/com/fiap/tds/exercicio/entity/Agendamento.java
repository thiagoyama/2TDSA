package br.com.fiap.tds.exercicio.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@IdClass(AgendamentoPK.class)

@Entity
@Table(name="TB_AGENDAMENTO")
public class Agendamento {

	@Id
	@ManyToOne
	@JoinColumn(name="cd_servico")
	private Servico servico;

	@Id
	@ManyToOne
	@JoinColumn(name="cd_animal")
	private Animal animal;

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_agendada")
	private Calendar data;

	@Column(name="vl_servico")
	private Double valor;

	public Agendamento() {}
	
	public Agendamento(Servico servico, Animal animal, Calendar data, Double valor) {
		this.servico = servico;
		this.animal = animal;
		this.data = data;
		this.valor = valor;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
