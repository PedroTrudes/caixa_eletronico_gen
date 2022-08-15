package caixa_eletronico.banco_dados;

import java.util.List;

import caixa_eletronico.conta.Conta;
import caixa_eletronico.conta.ContaCorrente;
import caixa_eletronico.conta.ContaPoupanca;

public class BancoDeDados {
	
	private static List<Conta> contas = List.of(
			new ContaCorrente("Veronica", "Itau", 1, "123456", 500.00),
			new ContaPoupanca("Veronica", "Itau", 2, "654321", 1500.00),
			new ContaCorrente("José", "Banco do Brasil", 2, "121212", 50.00));

	public static boolean validarConta(String numeroConta) {
		return contas.stream().map(conta -> conta.getNumeroConta()).anyMatch(conta -> conta.equals(numeroConta));
	}

	public static Conta retornarConta(String numeroConta) {
		for (Conta conta : contas) {
			if (conta.getNumeroConta().equals(numeroConta)) {
				return conta;
			}
		}
		throw new RuntimeException("caixa_eletronico.Conta Não Encontrada!");
	}
}

