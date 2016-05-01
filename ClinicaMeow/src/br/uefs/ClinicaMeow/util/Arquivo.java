package br.uefs.ClinicaMeow.util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.uefs.ClinicaMeow.model.Cliente;

public class Arquivo implements PersistenciaClinicaMeow{

	@Override
	public void salvaremTexto(List<?> lista) {
		Object o = lista.get(0);
		if(o instanceof Cliente) {
			try {
				FileWriter clientes = new FileWriter("clientes.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		}

		@Override
		public String lerTexto(File arquivo) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}




	}
