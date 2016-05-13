package br.uefs.ClinicaMeow.persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import br.uefs.ClinicaMeow.model.Animal;
import br.uefs.ClinicaMeow.model.Cliente;
import br.uefs.ClinicaMeow.model.Consulta;
import br.uefs.ClinicaMeow.model.Endereco;
import br.uefs.ClinicaMeow.model.Pessoa;
import br.uefs.ClinicaMeow.model.Veterinário;

public class ClinicaMeowPersisteArquivo implements ClinicaMeowPersiste {

	@Override
	public void salvaClientes(List<Cliente> clientes) throws IOException {
		FileWriter arq = new FileWriter("Clientes.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		Iterator<Cliente> itr = clientes.iterator();
		while(itr.hasNext()) { 
			Pessoa pessoa = (Pessoa)itr.next();
			Endereco endereco = pessoa.getEndereco();
			String rua = "Rua " + endereco.getRua();
			String cidade = endereco.getEstado();
			String bairro = endereco.getBairro();
			String numero = "Nº " + endereco.getNumero();
			String estado = endereco.getEstado();
			gravarArq.printf(pessoa.getNome()+ ";\r\n"
					+pessoa.getCPF()+ ";\r\n"
					+pessoa.getDataDeNascimento()+ ";\r\n"
					+pessoa.getTelefone()+ ";\r\n"
					+ "Endereço: \r\n"
					+cidade+","
					+bairro+","
					+rua+";"
					+numero+", "
					+estado+";\n");
		} 
		arq.close();
	}

	@Override
	public void salvaAnimais(List<Animal> animais) throws IOException {
		FileWriter arq = new FileWriter("Animais.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		Iterator<Animal> itr = animais.iterator();
		while(itr.hasNext()) { 
			Animal animal = (Animal)itr.next();
			gravarArq.printf(animal.getNome() + "\n"
					+animal.getTipo()+ "\n"
					+animal.getCor()+ "\n"
					+animal.getIdade() + "anos" + "\n"
					+"Dono: " + animal.getNome() + ";\n");
		}
		arq.close();
	}

	@Override
	public void salvaConsultas(List<Consulta> consultas) throws IOException {
		FileWriter arq = new FileWriter("Consultas.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		Iterator<Consulta> itr = consultas.iterator();
		while(itr.hasNext()) { 
			Consulta consulta = (Consulta)itr.next();
			gravarArq.printf("Número da consulta: " + consulta.getId() + "\n"
					+ "Horário: " + consulta.getData()+ "\n"
					+ "Veterinario: " + consulta.getVeterinario()+ "\n"
					+ "Cliente: " + consulta.getCliente()+ "\n"
					+ "Animal atendido: " + consulta.getAnimal()+ "\n"
					+ "Valor da consulta: " + consulta.getPreco() + "\n");
		}
		arq.close();
	}

	@Override
	public void salvaVeterinarios(List<Veterinário> veterinarios) throws IOException {
		FileWriter arq = new FileWriter("veterinarios.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		Iterator<Veterinário> itr = veterinarios.iterator();
		while(itr.hasNext()) { 
			Veterinário pessoa = itr.next();
			Endereco endereco = pessoa.getEndereco();
			String rua = "Rua: " + endereco.getRua();
			String cidade = "Cidade: " + endereco.getEstado();
			String bairro = endereco.getBairro();
			String numero = "Nº " + endereco.getNumero();
			String estado = endereco.getEstado();
			gravarArq.printf(pessoa.getNome()+ "\n"
					+pessoa.getCPF()+ "\n"
					+pessoa.getDataDeNascimento()+ "\n"
					+pessoa.getTelefone()+ "\n"
					+ "Endereço: "
					+cidade+","
					+bairro+","
					+"Rua "+ rua+";"
					+"Nº " + numero+", "
					+estado+";"
					+ "CRMV: " + pessoa.getCrmv() + ";\n");
		}
		arq.close();
	} 
	
}
