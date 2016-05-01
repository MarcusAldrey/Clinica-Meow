package br.uefs.ClinicaMeow.model;

import java.util.Date;

public class Consulta {
	private static int TotalDeConsultas = 0;
	private int Id;
	private Date data;
	private Veterinário veterinario;
	private Cliente cliente;
	private Animal animal;
	private float preco;
	
	public Consulta() {
		TotalDeConsultas++;
		this.Id = TotalDeConsultas; 
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the veterinario
	 */
	public Veterinário getVeterinario() {
		return veterinario;
	}
	/**
	 * @param veterinario the veterinario to set
	 */
	public void setVeterinario(Veterinário veterinario) {
		this.veterinario = veterinario;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}
	/**
	 * @param animal the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	/**
	 * @return the preco
	 */
	public float getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(float preco) {
		this.preco = preco;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
}
