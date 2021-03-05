package br.com.fiap.revisao.bean;

public class Chocolate extends Produto {

	//Construtor é herdado? Não
	//Construtor "cheio" e o vazio
	public Chocolate(int codigo, String nome, boolean disponivel, float peso) {
		super(codigo, nome, disponivel);
		this.setPeso(peso);
	}
	
	public Chocolate() {}

	private float peso;
	
	//Sobrescrita -> o mesmo método do pai na classe filha
	@Override
	public void calcularDesconto() {
		System.out.println("Calculando desconto do chocolate...");
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
}