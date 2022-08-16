package caixa_eletronico.conta;

public class ContaCorrente extends Conta {

	private double limite;

	public ContaCorrente(String nomeCliente, String banco, String numeroConta, double limite, double saldoInicial) {
		super(nomeCliente, banco, numeroConta, saldoInicial);
		this.limite = limite;

	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public void saque(double valorSaque) {
		double saldoTotal = saldoComLimite();

		if (valorSaque <= getSaldo()) {
			setSaldo(getSaldo() - valorSaque);
			System.out.println("===Saque Aprovado===");

		} else if (valorSaque <= saldoTotal) {
			setSaldo(getSaldo() - valorSaque);
			limite -= getSaldo();
			System.out.println("===Saque Aprovado===");

		} else {
			System.out.println("===Saque Recusado===");
		}

	}

	public double saldoComLimite() {
		double saldoTotal = getSaldo() + limite;
		System.out.println("Saldo + Limite : " + saldoTotal);
		return saldoTotal;
	}
}

/*
 * herda todas informações da conta, so colocar aqui o especifico dessa
 * conta.ContaCorrente. ex limite.
 */