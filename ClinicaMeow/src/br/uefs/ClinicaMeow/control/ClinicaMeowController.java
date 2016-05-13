package br.uefs.ClinicaMeow.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.uefs.ClinicaMeow.exceptions.AnimalNaoEncontradoException;
import br.uefs.ClinicaMeow.exceptions.ClienteNaoEncontradoException;
import br.uefs.ClinicaMeow.exceptions.VeterinarioNaoEncontradoException;
import br.uefs.ClinicaMeow.model.Animal;
import br.uefs.ClinicaMeow.model.Cliente;
import br.uefs.ClinicaMeow.model.Consulta;
import br.uefs.ClinicaMeow.model.Endereco;
import br.uefs.ClinicaMeow.model.Veterinário;
import br.uefs.ClinicaMeow.persistencia.ClinicaMeowPersiste;
import br.uefs.ClinicaMeow.persistencia.ClinicaMeowPersisteArquivo;

public class ClinicaMeowController {

	private static ClinicaMeowController instance;
	private static ClinicaMeowPersiste persistencia;
	private List<Cliente> clientes;
	private List<Veterinário> veterinarios; 
	private List<Consulta> consultas; 

	private ClinicaMeowController() {
		clientes = new ArrayList<Cliente>();
		veterinarios = new ArrayList<Veterinário>();
		consultas = new ArrayList<Consulta>();
		persistencia = new ClinicaMeowPersisteArquivo();
	}

	public static ClinicaMeowController getInstance() {
		if(instance == null)
			instance = new ClinicaMeowController();
		return instance;
	}

	public void cadastrarCliente(String nome, String cPF,String sexo, String dataDeNascimento, String telefone, String estado, String cidade, String bairro, String rua, int numero) {

		Cliente novoCliente = new Cliente();
		novoCliente.setNome(nome);
		novoCliente.setCPF(cPF);
		novoCliente.setDataDeNascimento(dataDeNascimento);
		novoCliente.setTelefone(telefone);
		novoCliente.setEndereco(criarEndereco(estado, cidade, bairro, rua, numero));
		novoCliente.setSexo(sexo);

		clientes.add(novoCliente);
	}

	public void cadastrarAnimal(String nome, String tipo, String cor, int idade, String cpfDoDono) throws ClienteNaoEncontradoException {
		Animal novoAnimal = new Animal();
		novoAnimal.setNome(nome);
		novoAnimal.setTipo(tipo);
		novoAnimal.setCor(cor);
		novoAnimal.setIdade(idade);

		Cliente atual = null;

		Iterator<Cliente> iterador = clientes.iterator();

		while(iterador.hasNext()) {
			atual = iterador.next();
			if(atual.getCPF().equals(cpfDoDono))
				break;
		}

		if(atual == null)
			throw new ClienteNaoEncontradoException();

		novoAnimal.setDono(atual);
		atual.getAnimais().add(novoAnimal);
	}

	public void cadastrarVeterinario(String nome, String cPF, String sexo, String dataDeNascimento, String telefone, String crmv, String estado, String cidade, String bairro, String rua, int numero) {
		Veterinário novoVeterinario = new Veterinário();
		novoVeterinario.setNome(nome);
		novoVeterinario.setCPF(cPF);
		novoVeterinario.setDataDeNascimento(dataDeNascimento);
		novoVeterinario.setTelefone(telefone);
		novoVeterinario.setCrmv(crmv);
		novoVeterinario.setSexo(sexo);
		novoVeterinario.setEndereco(criarEndereco(estado, cidade, bairro, rua, numero));
		
		veterinarios.add(novoVeterinario);
	}

	public void gerarConsulta(Veterinário veterinario, Cliente dono, Animal animal, float preco) throws ClienteNaoEncontradoException, VeterinarioNaoEncontradoException, AnimalNaoEncontradoException {

		Consulta novaConsulta = new Consulta();
		novaConsulta.setAnimal(animal);
		novaConsulta.setCliente(dono);
		novaConsulta.setVeterinario(veterinario);
		novaConsulta.setData(new Date());
		novaConsulta.setPreco(preco);

		consultas.add(novaConsulta);
	}

	private Endereco criarEndereco(String estado, String cidade, String bairro, String rua, int numero) {
		Endereco novoEndereco = new Endereco();
		novoEndereco.setEstado(estado);
		novoEndereco.setCidade(cidade);
		novoEndereco.setBairro(bairro);
		novoEndereco.setRua(rua);
		novoEndereco.setNumero(numero);
		return novoEndereco;
	}

	public Cliente recuperarCliente(String cpf) throws ClienteNaoEncontradoException {

		Cliente clienteAtual = null;

		Iterator<Cliente> iteradorClientes = clientes.iterator();
		while(iteradorClientes.hasNext()) {
			clienteAtual = iteradorClientes.next();
			if(clienteAtual.getCPF().equals(cpf))
				return clienteAtual;
		}
		throw new ClienteNaoEncontradoException();
	}

	public Veterinário recuperarVeterinario(String cpf) throws VeterinarioNaoEncontradoException {
		Veterinário veterinarioatual = null;


		Iterator<Veterinário> iteradorVeterinarios = veterinarios.iterator();

		while(iteradorVeterinarios.hasNext()) {
			veterinarioatual = iteradorVeterinarios.next();
			if(veterinarioatual.getCPF().equals(cpf))
				return veterinarioatual;
		}
		throw new VeterinarioNaoEncontradoException();
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @return the veterinarios
	 */
	public List<Veterinário> getVeterinarios() {
		return veterinarios;
	}

	/**
	 * @return the consultas
	 */
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void salvarClientes() throws IOException {
		persistencia.salvaClientes(clientes);
	}
	
	public void salvarVeterinarios() throws IOException {
		persistencia.salvaVeterinarios(veterinarios);
	}
	
	public void salvarAnimais(Cliente c) throws IOException {
		persistencia.salvaAnimais(c.getAnimais());		
	}
	
	public void salvarConsultas() throws IOException {
		persistencia.salvaConsultas(consultas);
	}
	
}
