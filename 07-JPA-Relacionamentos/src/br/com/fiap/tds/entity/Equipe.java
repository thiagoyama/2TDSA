package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	//Mapeamento bidirecional um-para-muitos
	@OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Carro> carros;
	
	//Mapeamento do relacionamento muitos-para-muitos
	@ManyToMany(cascade = CascadeType.PERSIST)
	//JoinTable -> configura a tabela associativa
	//name -> nome da tabela associativa
	//joinColumns -> configura a coluna que armazena a PK/FK da classe que estamos
	//inverseJoinColumns -> configura a coluna que armazena a PK/FK da classe do outro lado da relação
	@JoinTable(name="TB_EQUIPE_CORRIDA", 
			joinColumns = @JoinColumn(name="cd_equipe"),
			inverseJoinColumns = @JoinColumn(name="cd_corrida"))
	private List<Corrida> corridas;
	
	//Método para relacionamentos um-para-muitos
	//Utilizado para garantir o preenchimento da FK em um cadastro em cascata
	public void addCarro(Carro carro) {
		if (carros == null)
			carros = new ArrayList<>();
		//Adicionar o carro na lista
		carros.add(carro);
		//Setar a equipe do carro
		carro.setEquipe(this); //this -> referencia o próprio objeto
	}

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

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}


	public List<Corrida> getCorridas() {
		return corridas;
	}


	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}
	
}
