package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {
		//Criar uma lista de conta corrente
		List<ContaCorrente> lista = new ArrayList<>();
		
		//Adicionar 3 contas
		lista.add(new ContaCorrente(1,123,Calendar.getInstance(), 100, TipoConta.COMUM));
		lista.add(new ContaCorrente(1,432,Calendar.getInstance(), 1050, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(1,12523,Calendar.getInstance(), 900, TipoConta.ESPECIAL));
		
		//Exibir o saldo das contas
		for (ContaCorrente c : lista) {
			System.out.println(c.getSaldo());
		}
		
	}//main
	
}//classe
