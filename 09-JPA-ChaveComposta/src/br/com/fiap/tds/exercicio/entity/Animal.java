package br.com.fiap.tds.exercicio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ANIMAL")
@SequenceGenerator(name="animal", sequenceName = "SQ_TB_ANIMAL", allocationSize = 1)
public class Animal {

	@Id
	@Column(name="cd_animal")
	@GeneratedValue(generator="cd_animal", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_animal", nullable = false, length = 30)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_porte", length = 20)
	private Porte porte;
	
	@OneToMany(mappedBy = "animal")
	private List<Agendamento> agendamentos;
	
	public Animal() {}
	
	public Animal(String nome, Porte porte) {
		this.nome = nome;
		this.porte = porte;
	}
	
	public void addAgendamento(Agendamento agenda) {
		if (agendamentos == null)
			agendamentos = new ArrayList<Agendamento>();
		agenda.setAnimal(this);
		agendamentos.add(agenda);
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

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
}
