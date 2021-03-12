package br.com.fiap.exception;

public class SaldoInsuficienteException extends Exception {

	
	public SaldoInsuficienteException() {
		super("Saldo insuficiente");
	}
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	
	public SaldoInsuficienteException(double saldo) {
		super("Saldo insuficiente, limite máximo de " + saldo);
	}
	
}
