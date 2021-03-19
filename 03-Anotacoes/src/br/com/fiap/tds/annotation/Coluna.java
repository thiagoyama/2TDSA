package br.com.fiap.tds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Target -> definir onde a anotação pode ser utilizada
//FIELD -> atributos
//TYPE -> classe
@Target( { ElementType.FIELD, ElementType.METHOD } )

// Teste.java -compila-> Teste.class (bytecode) -> Interpreta na JVM "Executar"

// Retention -> Determina até quando a anotação estará presente
//SOURCE -> até o .java
//CLASS -> até o .class
//RUNTIME -> até o final (JVM)
@Retention(RetentionPolicy.RUNTIME)

public @interface Coluna {

	String nome();
	boolean obrigatorio() default false;
	int tamanho() default 255;
	
}
