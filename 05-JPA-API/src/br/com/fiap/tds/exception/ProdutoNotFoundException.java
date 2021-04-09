package br.com.fiap.tds.exception;

public class ProdutoNotFoundException extends Exception {

	public ProdutoNotFoundException() {
		super("Produto não encontrado");
	}
	
	public ProdutoNotFoundException(String msg) {
		super(msg);
	}
	
}
