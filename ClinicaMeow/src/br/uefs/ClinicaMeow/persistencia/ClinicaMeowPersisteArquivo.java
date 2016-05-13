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
			String cidade = endereco.getCidade();
			String bairro = endereco.getBairro();
			String numero = "Nº " + endereco.getNumero();
			String estado = endereco.getEstado();
			gravarArq.printf("\n" + pessoa.getNome()+ ";\r\n"
					+"CPF: " + pessoa.getCPF()+ ";\r\n"
					+"Data de Nascimento: " + pessoa.getDataDeNascimento()+ ";\r\n"
					+"Tel: " + pessoa.getTelefone()+ ";\r\n"
					+ "Endereço: "
					+cidade+","
					+bairro+","
					+rua+","
					+numero+", "
					+estado+";\r\n"
					+"/////////////////////////////////////////////\r\n");
		} 
		arq.close();
	}

	@Override
	public void salvaAnimais(List<Cliente> clientes) throws IOException {
		FileWriter arq = new FileWriter("Animais.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		for(Cliente c : clientes) {
			Iterator<Animal> itr = c.getAnimais().iterator();
			gravarArq.printf("Animais de " + c.getNome() + "\r\n");
			while(itr.hasNext()) { 
				Animal animal = (Animal)itr.next();
				gravarArq.printf("\r\nNome: " + animal.getNome() + "\r\n"
						+"Espécie: " + animal.getTipo()+ "\r\n"
						+"Cor: " + animal.getCor()+ "\r\n"
						+"Idade: " + animal.getIdade() + " anos" + "\r\n");
			}
			gravarArq.printf("////////////////////////////////////////\r\n");
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
			gravarArq.printf("Número da consulta: " + consulta.getId() + "\r\n"
					+ "Horário: " + consulta.getData()+ "\r\n"
					+ "Veterinario: " + consulta.getVeterinario()+ "\r\n"
					+ "Cliente: " + consulta.getCliente()+ "\r\n"
					+ "Animal atendido: " + consulta.getAnimal()+ "\r\n"
					+ "Valor da consulta (R$): " + consulta.getPreco() + "\r\n"
					+"/////////////////////////////////////////////\r\n");
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
			String rua = "Rua " + endereco.getRua();
			String cidade = endereco.getCidade();
			String bairro = endereco.getBairro();
			String numero = "Nº " + endereco.getNumero();
			String estado = endereco.getEstado();
			gravarArq.printf("\n" + pessoa.getNome()+ ";\r\n"
					+"CPF: " + pessoa.getCPF()+ ";\r\n"
					+"Data de Nascimento: " + pessoa.getDataDeNascimento()+ ";\r\n"
					+"Tel: " + pessoa.getTelefone()+ ";\r\n"
					+ "Endereço: "
					+cidade+","
					+bairro+","
					+rua+";"
					+numero+", "
					+estado+";\r\n"
					+ "CRMV: " + pessoa.getCrmv() + ";\r\n"
					+"/////////////////////////////////////////////\r\n");
		}
		arq.close();
	} 

}
