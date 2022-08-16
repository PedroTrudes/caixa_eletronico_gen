package caixa_eletronico;

import java.util.Scanner;

import caixa_eletronico.banco_dados.BancoDeDados;
import caixa_eletronico.conta.Conta;
import caixa_eletronico.conta.ContaCorrente;

public class CaixaEletronico {

	private static Conta validarContaNoBancoDados(String numeroConta) {

		try {
			return BancoDeDados.getConta(numeroConta);

		} catch (RuntimeException ex) {
			System.out.println("Erro caixa_eletronico : " + ex.getMessage());
			numeroConta = solicitaNumeroConta();
			// recursão
			return validarContaNoBancoDados(numeroConta);
		}

	}

	public static void iniciar() {
		System.out.println(
				"   ______    ___     ____   _  __    ___            ______    __     ______  ______    ____    ____     _   __    ____   ______   ____             __   ___    __ __    __       _ \n"
						+ "  / ____/   /   |   /  _/  | |/ /   /   |          / ____/   / /    / ____/ /_  __/   / __ \\  / __ \\   / | / /   /  _/  / ____/  / __ \\          _/_/  |__ \\  / // /   / /_     | |\n"
						+ " / /       / /| |   / /    |   /   / /| |         / __/     / /    / __/     / /     / /_/ / / / / /  /  |/ /    / /   / /      / / / /         / /    __/ / / // /_  / __ \\    / /\n"
						+ "/ /___    / ___ | _/ /    /   |   / ___ |        / /___    / /___ / /___    / /     / _, _/ / /_/ /  / /|  /   _/ /   / /___   / /_/ /         / /    / __/ /__  __/ / / / /   / / \n"
						+ "\\____/   /_/  |_|/___/   /_/|_|  /_/  |_|       /_____/   /_____//_____/   /_/     /_/ |_|  \\____/  /_/ |_/   /___/   \\____/   \\____/         / /    /____/   /_/   /_/ /_/  _/_/  \n"
						+ "                                                                                                                                              |_|                           /_/    ");
		String numeroConta = CaixaEletronico.solicitaNumeroConta();
		Conta conta = validarContaNoBancoDados(numeroConta);
		apresentarBoasVindas(conta);
		menuDoCaixa(conta);

	}

	private static String solicitaNumeroConta() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o numero da conta para iniciar !!! ");
		String numeroConta = scanner.next();
		return numeroConta;
	}

	private static void apresentarBoasVindas(Conta conta) {
		System.out.println("Olá, " + conta.getNomeCliente() + " " + "\nBanco: " + conta.getBanco() + " " + "\nconta :  "
				+ conta.getNumeroConta() + " " + "\nSeja Bem vindo!!\n");
	}

	public static void menuDoCaixa(Conta conta) {
		System.out.println("\nSelecione uma das opções abaixo");
		System.out.println("(0) SAIR");
		System.out.println("(1) SAQUE");
		System.out.println("(2) SALDO");
		System.out.println("(3) DEPOSITO");
		Scanner scanner = new Scanner(System.in);
		switch (scanner.nextInt()) {
		case 1 -> {
			saque(conta);
			menuDoCaixa(conta);

		}
		case 2 -> {
			saldo(conta);
			menuDoCaixa(conta);
		}
		case 3 -> {
			deposito(conta);
			menuDoCaixa(conta);
		}
		case 0 -> {
			System.out.println("Caixa Finalizado!");
			break;
		}
		}
	}

	private static void deposito(Conta conta) {
		System.out.println("===Selecione uma das opções abaixo para o depósito===");
		System.out.println("(1) MESMA TITULARIDADE");
		System.out.println("(2) OUTRA TITULARIDADE");
		System.out.println("(0) VOLTAR");

		Scanner scan = new Scanner(System.in);
		int operacao = scan.nextInt();
		switch (operacao) {
		case 1 -> {
			System.out.println("===Digite o valor do deposito:=== ");
			double valorDeposito = scan.nextDouble();
			System.out.println("A conta que irá receber o Depósito: " + conta.getNumeroConta());
			if (valorDeposito > 0) {
				System.out.println("Depósito efetuado: " + valorDeposito);
				double saldo = conta.getSaldo();
				saldo += valorDeposito;
				conta.setSaldo(saldo);

			} else {
				System.out.println("Operação Inválida!");
			}

		}
		case 2 -> {
			System.out.println("===A conta que irá receber o Depósito: ===");
			int contaTitularidadeDiferente = scan.nextInt();
			System.out.println("Digite o valor do deposito: ");
			double valorDeposito = scan.nextDouble();
			System.out.println("Deposito efetuado!");
		}
		case 0 -> menuDoCaixa(conta);
		default -> throw new IllegalStateException("Valor inesperado: " + operacao);
		}
		;

	}

	private static void saldo(Conta conta) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===Extrato selecionado===");
		if (conta instanceof ContaCorrente) {
			System.out.println("Saldo da conta Corrente R$ " + conta.getSaldo());
		} else {
			System.out.println("Saldo da conta Poupanca R$ " + conta.getSaldo());
		}
	}

	private static void saque(Conta conta) {
		System.out.println("===Saque selecionado, informe o valor desejado===");
		System.out.println("[1] R$20.00");
		System.out.println("[2] R$50.00");
		System.out.println("[3] R$100.00");

		Scanner scanner = new Scanner(System.in);
		int operacao = scanner.nextInt();
		double valorSaque = switch (operacao) {
		case 1 -> 20.00;
		case 2 -> 50.00;
		case 3 -> 100.00;
		default -> {
			throw new IllegalStateException("Valor inesperado: " + operacao);
		}
		};

		conta.saque(valorSaque);

	}
}
