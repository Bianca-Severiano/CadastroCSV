package model;

public class Cliente {
	public String CPF;
	public String Nome;
	public int Idade;
	public double LimiteCredito;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String cPF, String nome, int idade, double limiteCredito) {
		CPF = cPF;
		Nome = nome;
		Idade = idade;
		LimiteCredito = limiteCredito;
	}

	@Override
	public String toString() {
		return "Cliente [CPF=" + CPF + ", Nome=" + Nome + ", Idade=" + Idade + ", LimiteCredito=" + LimiteCredito + "]";
	}
	
	
	
	
}
