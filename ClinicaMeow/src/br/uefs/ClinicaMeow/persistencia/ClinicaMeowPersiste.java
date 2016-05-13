package br.uefs.ClinicaMeow.persistencia;

import java.io.IOException;
import java.util.List;

import br.uefs.ClinicaMeow.model.*;

public interface ClinicaMeowPersiste {

	public void salvaClientes(List<Cliente> clientes) throws IOException;
	public void salvaVeterinarios(List<Veterinário> veterinarios) throws IOException;
	public void salvaAnimais(List<Cliente> clientes) throws IOException;
	public void salvaConsultas(List<Consulta> consultas) throws IOException;
	
}
