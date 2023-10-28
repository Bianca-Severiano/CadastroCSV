package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import bilbioteca.fila.dinamica.generica.model.Lista;
import model.Cliente;

public class ModificacaoCadastroController {

	private void novoArquivo(Lista l, String nomeArquivo) throws IOException {
		File file = new File("C:\\TEMP\\" + nomeArquivo);
		int tamanho = l.size();
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < tamanho; i++) {
			try {
				buffer.append(l.get(i).toString() + "\r\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		FileWriter AbreArquivo = new FileWriter(file);
		PrintWriter EscreveArquivo = new PrintWriter(AbreArquivo);
		EscreveArquivo.write(buffer.toString());
		EscreveArquivo.flush();
		EscreveArquivo.close();
		AbreArquivo.close();

	}

	public void novoCadastro(int idadeMin, int idadeMax, Double limiteCredito) throws Exception {
		Lista<Cliente> clientes = new Lista();
		File file = new File("C:\\TEMP\\cadastro.csv");

		if (file.exists() && file.isFile()) {

			FileInputStream fluxo = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();;

			while (linha != null) {
				
				linha = linha.replace("\"", "");
				String[] clienteInfos = linha.split(";");
				Cliente cliente = new Cliente();

				cliente.CPF = clienteInfos[0];
				cliente.Nome = clienteInfos[1];
				cliente.Idade = Integer.parseInt(clienteInfos[2]);
				
				double credito = Double.parseDouble(clienteInfos[3].replace(",", "."));
				
				cliente.LimiteCredito = credito;

				if (cliente.Idade > idadeMin && cliente.Idade < idadeMax) {
					if (credito > limiteCredito) {
						if (clientes.isEmpty()) {
							clientes.addFirst(cliente);
							
						} else {
							clientes.addLast(cliente);
						}
						String nomeArquivo = "idade" + idadeMin + " a " + idadeMax + " limite" + limiteCredito + ".csv";
						novoArquivo(clientes, nomeArquivo);
					}
				}
				linha = buffer.readLine();
			} 
			
			fluxo.close();
			reader.close();
			buffer.close();
		} else {
			throw new IOException("Diretório Inválido");

		}
		
	
	}
}
