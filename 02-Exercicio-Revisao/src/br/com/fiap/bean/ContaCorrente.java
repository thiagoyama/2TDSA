package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//A primeira classe "concreta" da hierarquia é obrigada a implementar
//os métodos abstratos

//CTRL + 1
public class ContaCorrente extends Conta {

	private TipoConta tipo;
	
	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		//Validar se a conta é comum e se o saldo fica negativo dps do saque
		if ( tipo == TipoConta.COMUM && valor > saldo ) {
			throw new SaldoInsuficienteException(saldo);
		} 
		saldo -=valor;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor; //saldo = saldo + valor;
//		//setSaldo(getSaldo() + valor);
//	}
	
	public ContaCorrente() {}
	
	//CTRL + 3 -> gcuf (construtores)
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, 
														double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

}