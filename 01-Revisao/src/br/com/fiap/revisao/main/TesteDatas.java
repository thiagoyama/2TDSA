package br.com.fiap.revisao.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteDatas {

	public static void main(String[] args) {
		//Instanciar um objeto de data com a data atual
		Calendar hoje = Calendar.getInstance();
		
		//Instanciar uma data específica, objeto com a data de entrega da challenge
												//ano, mês, dia
		Calendar challenge = new GregorianCalendar(2021, Calendar.APRIL, 4);
		
						// MONTH, DAY_OF_MONTH
		int ano = hoje.get(Calendar.YEAR); //recupera o ano
		
		//Objeto que formata a data
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		//Exibir a data atual
		System.out.println( formatador.format(hoje.getTime()) );
		
		//Exibir a data de entrega da challenge
		System.out.println( formatador.format(challenge.getTime()) );
		
	}
	
}
