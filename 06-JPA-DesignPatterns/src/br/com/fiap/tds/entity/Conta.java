package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CONTA")
@SequenceGenerator(name="conta", sequenceName = "SQ_TB_CONTA", allocationSize = 1)
public class Conta {
	
	@Id
	@Column(name="cd_conta")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta")
	private int codigo;

	@Column(name="vl_saldo", nullable = false)
	private double saldo;
	
	@Column(name="dt_abertura")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAbertura;
	
	public Conta() {}
	
	public Conta(double saldo, Calendar dataAbertura) {
		super();
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
	}

	public Conta(int codigo, double saldo, Calendar dataAbertura) {
		super();
		this.codigo = codigo;
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
}
