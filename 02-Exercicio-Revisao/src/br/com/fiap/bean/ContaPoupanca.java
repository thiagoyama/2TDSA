package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//CTRL + 1
public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	
	//final:
	// atributos -> não permite alterar o valor
	// métodos -> não permite a sobrescrita
	// classe -> não permite a herança
	
	//static -> o elemento fica ligado a classe e não a um objeto
	public static final float RENDIMENTO = 0.04f;
	
	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		//Validar se o saldo é suficiente
		if (saldo < valor + taxa) {
			throw new SaldoInsuficienteException(saldo - taxa);
		}
		saldo -= valor + taxa;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor;
//	}
	
	//CTRL + 3 -> gcuf (Construtores)
	public ContaPoupanca() {}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, 
												double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
