package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_PRODUTO")
@SequenceGenerator(name="prod", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {
	
	@Id
	@Column(name="cd_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod")
	private int codigo;
	
	@Column(name="nm_produto", length = 100, nullable = false)
	private String nome;
	
	@Column(name="vl_produto")
	private double valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fabricacao")
	private Calendar dataFabricacao;
	
	@Column(name="st_perecivel")
	private boolean perecivel;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_estado", length = 20)
	private EstadoProduto estado;
	
	@CreationTimestamp //Criar a data de cadastro de forma automática
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro" , updatable = false)
	private Calendar dataCadastro;
	
	public Produto() {}
	
	//CTRL + 3 -> gcuf (construtor)
	public Produto(String nome, double valor, Calendar dataFabricacao, boolean perecivel, EstadoProduto estado) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.dataFabricacao = dataFabricacao;
		this.perecivel = perecivel;
		this.estado = estado;
	}
	
	public Produto(int codigo, String nome, double valor, Calendar dataFabricacao, boolean perecivel,
			EstadoProduto estado) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dataFabricacao = dataFabricacao;
		this.perecivel = perecivel;
		this.estado = estado;
	}

	@PrePersist //Antes de cadastrar um produto o método é executado
	public void executar() {
		System.out.println("Produto sendo cadastrado...");
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return "Código: " + codigo + "\nNome: " + nome + "\nValor: "
				+ valor + "\nPerecível: " + perecivel + "\nEstado: "
				+ estado + "\nData Fabricação: " +
				sdf.format(dataFabricacao.getTime()) + "\nData Cadastro: " +
				sdf.format(dataCadastro.getTime());
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public boolean isPerecivel() {
		return perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}

	public EstadoProduto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProduto estado) {
		this.estado = estado;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
