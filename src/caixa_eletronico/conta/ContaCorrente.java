package caixa_eletronico.conta;

public class ContaCorrente extends Conta {
	
    private double limite;

	public ContaCorrente(String nomeCliente, String banco, int tipo, String numeroConta, double limite) {
		super(nomeCliente, banco, tipo, numeroConta);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
 

}


/* herda todas informações da conta, so colocar aqui o especifico dessa conta.ContaCorrente. ex limite.*/