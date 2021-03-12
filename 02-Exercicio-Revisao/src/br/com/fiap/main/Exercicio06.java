package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Exercicio06 {

	public static void main(String[] args) {
		//Instanciar uma conta corrente
		ContaCorrente cc = new ContaCorrente(
				10, 123, Calendar.getInstance(), 100, TipoConta.COMUM);
		
		//Instanciar um conta poupança
		ContaPoupanca cp = new ContaPoupanca(
				10, 3221, new GregorianCalendar(2019, Calendar.JANUARY, 4), 200, 1);
		
		//RuntimeException (unchecked) x Exception (checked)
		
		try {
			//Chamar o método retirar de umas contas
			cc.retirar(101);
			System.out.println("Retirada efetuada!");
		}catch(SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
}//classe
