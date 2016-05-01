package br.uefs.ClinicaMeow.model;

public class Veterinário extends Pessoa{
	private String crmv;
	
	public Veterinário() {
		super();
	}
	/**
	 * @return the crmv
	 */
	public String getCrmv() {
		return crmv;
	}
	/**
	 * @param crmv the crmv to set
	 */
	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}
	
}
