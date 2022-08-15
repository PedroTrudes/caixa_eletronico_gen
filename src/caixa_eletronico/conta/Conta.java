package caixa_eletronico.conta;

public class Conta {

	private String nomeCliente;
	private String numeroConta;
	private int tipo;
	private String banco;
	private double saldo;

	public Conta(String nomeCliente, String banco, int tipo, String numeroConta) {
		this.nomeCliente = nomeCliente;
		this.tipo = tipo;
		this.numeroConta = numeroConta;
		this.banco = banco;
		
	}

	public Conta(String nomeCliente, String banco, int tipo, String numeroConta, double saldo) {
		this.nomeCliente = nomeCliente;
		this.tipo = tipo;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.banco = banco;
	}

	public Conta() {
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

    
} /*int tipo*/
