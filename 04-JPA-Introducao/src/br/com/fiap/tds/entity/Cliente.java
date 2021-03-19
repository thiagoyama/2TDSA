package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TB_CLIENTE"
														, allocationSize = 1)
//name -> nome no java, utilizado nno GeneratedValue
//sequenceName -> nome da sequence no banco de dados
//allocationSize -> incremento
public class Cliente {

	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private int codigo;
	
	@Column(name="nm_cliente", nullable = false, length = 100)
	private String nome;
	
	@Column(name="ds_email", nullable = false, length = 100)
	private String email;
	
	@Column(name="nr_rg", length = 14)
	private String rg;
	
	@Column(name="nr_cpf", nullable = false, length = 16, updatable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE) //Armazena somente a data no banco
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING) //Armazena o texto da constante
	@Column(name="ds_genero")
	private Genero genero;
	
	@Column(name="st_vip")
	private boolean vip;
	
	@Transient // Não é mapeado para uma coluna no banco
	private int idade;
	
	@Lob // BLOB no oracle, armazena arquivos
	@Column(name="fl_foto")
	private byte[] foto;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}