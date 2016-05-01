package br.uefs.ClinicaMeow.model;

public class Pessoa {
	private String nome;
	private String CPF;
	private String dataDeNascimento;
	private Endereco endereco;
	private String telefone;
	private String sexo;
	
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
	 * @return the cPF
	 */
	public String getCPF() {
		return CPF;
	}
	/**
	 * @param cPF the cPF to set
	 */
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	/**
	 * @return the dataDeNascimento
	 */
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	/**
	 * @param dataDeNascimento the dataDeNascimento to set
	 */
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString(){
		return this.getNome();
	}
}
