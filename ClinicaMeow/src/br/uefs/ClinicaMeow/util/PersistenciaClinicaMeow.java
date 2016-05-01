package br.uefs.ClinicaMeow.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface PersistenciaClinicaMeow {

	public void salvaremTexto(List<?> lista);
	public String lerTexto(File arquivo) throws IOException;

}
