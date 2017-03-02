package model;

public class Loja {

	private int id;
	private String nome;
	private String produto;
	private int valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String toString()
	{
		String dados = "ID: " + id;
		dados += "\nNome da Loja: " + nome;
		dados += "\nValor: " + valor;
		dados += "\nProduto: " + produto;
		
		return dados;
	}
	
}
