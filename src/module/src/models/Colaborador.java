package module.src.models;

import module.src.Interfaces.DescontosInterface;

import java.util.Date;
import java.util.Scanner;

public abstract class Colaborador implements DescontosInterface {

    private String nome;
    private String cpf;
    private String rg;
    protected double salario;
    private String matricula;
    private String genero;
    private Date dataDeContratacao;
    private String modeloDeContratacao;
    private String senioridade;
    protected boolean estaAtivo = true;

    public Colaborador() {

    }

    public Colaborador(String nome, String cpf, String rg, double salario, String matricula, String genero,
                       Date dataDeContratacao, String modeloDeContratacao, String senioridade, boolean estaAtivo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
        this.matricula = matricula;
        this.genero = genero;
        this.dataDeContratacao = dataDeContratacao;
        this.modeloDeContratacao = modeloDeContratacao;
        this.senioridade = senioridade;
        this.estaAtivo = estaAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(Date dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }

    public String getModeloDeContratacao() {
        return modeloDeContratacao;
    }

    public void setModeloDeContratacao(String modeloDeContratacao) {
        this.modeloDeContratacao = modeloDeContratacao;
    }

    public String getSenioridade() {
        return senioridade;
    }

    public void setSenioridade(String senioridade) {
        this.senioridade = senioridade;
    }

    public boolean getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public void calcularValeTransporte() {
        this.salario -= 1.06;
    }

    public void calcularValeRefeicao() {
        this.salario -= 1.03;
    }

    public void calcularFgts() {
        this.salario -= 1.08;
    }

    public void visualizar() {
        System.out.println("[Colaborador: " + this.nome + ", do CPF: " + this.cpf + " ]" + "\nSalario: " + this.salario
                + "\nStatus: " + (this.estaAtivo ? "Vinculado" : "Sem vinculo"));
    }

    public void demitir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tem certeza que deseja desvincular " + this.nome);
        Character resposta = sc.next().toLowerCase().charAt(0);
        if (resposta.equals('s')) {
            System.out.println("Você está demitido(a) e livre para o mercado de trabalho.");
            this.estaAtivo = false;
            salario = 0.0;
        }

        sc.close();
    }
}
