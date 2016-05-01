package br.uefs.ClinicaMeow.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	private List<Animal> animais;

	public Cliente() {
		super();
		animais = new ArrayList<Animal>();
	}

	/**
	 * @return the animais
	 */
	public List<Animal> getAnimais() {
		return animais;
	}

	/**
	 * @param animais the animais to set
	 */
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
}
