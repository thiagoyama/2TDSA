package br.com.fiap.tds.exercicio.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SERVICO")
@SequenceGenerator(name="servico", sequenceName = "SQ_TB_SERVICO", allocationSize = 1)
public class Servico {
	
	@Id
	@Column(name="cd_servico")
	@GeneratedValue(generator = "servico", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_servico", nullable = false, length = 40)
	private String nome;
	
	@OneToMany(mappedBy = "servico")
	private List<Agendamento> agendamentos;
	
	public Servico() {}

	public Servico(String nome) {
		this.nome = nome;
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

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
}
