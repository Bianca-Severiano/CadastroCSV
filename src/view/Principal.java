package view;

import java.io.IOException;

import bilbioteca.fila.dinamica.generica.model.Lista;
import controller.ModificacaoCadastroController;
import model.Cliente;

public class Principal {

	public static void main(String[] args) throws Exception {
		ModificacaoCadastroController modificacaoCadastro = new ModificacaoCadastroController();

		try {

			modificacaoCadastro.novoCadastro(41, 60, 8000.00);
			modificacaoCadastro.novoCadastro(31, 40, 5000.00);
			modificacaoCadastro.novoCadastro(21, 30, 3000.00);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
