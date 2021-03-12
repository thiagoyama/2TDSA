package br.com.fiap.revisao.bean;

public class Produto {

	//Modificadores de acesso:
	//private -> somente a própria classe;
	//public -> todos;
	//protected -> própria classe, no mesmo pacote e classe filhas;
	//default (package) -> própria classe e no mesmo pacote;
	
	//Tipos primitivos: byte, short, int, long, char, boolean, float, double
	//Valores padrões: números = 0; boolean = false;
	
	//Tipos de referência: String, Produto, Chocolate....
	//Valores padrões: null;
	
	private int codigo;
	
	private String nome;
	
	private boolean disponivel;
	
	private Estado estado; //gets e sets CTRL + 1
	
	//Construtores
	public Produto(int codigo, String nome, boolean disponivel) {
		this.codigo = codigo;
		this.nome = nome;
		this.disponivel = disponivel;
	}
	
	public Produto() {}
	
	//Sobrecarga -> mesmo método com parâmetros diferentes
	public void calcularDesconto() {
		System.out.println("Calculando desconto do produto..");
	}
	
	public void calcularDesconto(float desconto) {
		System.out.println("Desconto de " + desconto);
	}
	
	public void calcularDesconto(float valor, float imposto) {
		System.out.println("Desconto de " + (valor - imposto));
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	//CTRL + 3 -> ggas
	
}