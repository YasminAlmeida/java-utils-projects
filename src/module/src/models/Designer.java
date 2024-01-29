package module.src.models;

import module.src.utils.DecimoTerceiro;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class Designer extends Colaborador {

	public Designer() {
		super();
	}

	public Designer(String nome, String cpf, String rg, double salario, String matricula, String genero,
					Date dataDeContratacao, String modeloDeContratacao, String senioridade, boolean estaAtivo) {
		super(nome, cpf, rg, salario, matricula, genero, dataDeContratacao, modeloDeContratacao, senioridade, estaAtivo);
	}

	@Override
	public void calcularValeTransporte() {
		double desconto = getSalario() * 0.06;
		setSalario(getSalario() - desconto);
	}

	@Override
	public void calcularValeRefeicao() {
		double desconto = getSalario() * 0.03;
		setSalario(getSalario() - desconto);
	}

	@Override
	public void calcularFgts() {
		double desconto = getSalario() * 0.08;
		setSalario(getSalario() - desconto);
	}

	@Override
	public void calcularDecimoTerceiro() {
		Scanner sc = new Scanner(System.in);
		double salario = sc.nextDouble();
		DecimoTerceiro.calcularDecimoTerceiro(salario);
		sc.close();
	}

	private String formatarDuasCasasDecimais(double valor) {
		DecimalFormat formato = new DecimalFormat("#0.00");
		return formato.format(valor);
	}

	@Override
	public void visualizar() {
		System.out.println("\n\nColaborador: " + getNome() + ", do CPF: " + getCpf() + " ]" + "\nSalario: " + formatarDuasCasasDecimais(getSalario())
				+ "\nMatricula: " + getMatricula() + "\nGênero: " + getGenero() + "\nContratado no dia: " + getDataDeContratacao() + "\nNa modalidade: " +
				getModeloDeContratacao() + "\nSenioridade: " + getSenioridade() + "\nStatus: " + (getEstaAtivo() ? "Vinculado" : "Sem vinculo"));
	}
}
