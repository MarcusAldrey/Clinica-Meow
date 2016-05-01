package br.uefs.ClinicaMeow.model;

public class Animal {
	private static int idTotal;
	private int id;
	private String nome;
	private String tipo;
	private String cor;
	private Cliente dono;
	
	public Animal() {
		idTotal++;
		this.id = idTotal;
	}
	
	public int getId() {
		return this.id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}
	/**
	 * @param cor the cor to set
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}
	/**
	 * @param idade the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}
	/**
	 * @return the dono
	 */
	public Cliente getDono() {
		return dono;
	}
	/**
	 * @param dono the dono to set
	 */
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
	private int idade;
	
	@Override
	public String toString(){
		return this.getNome();
	}
}
