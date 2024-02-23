package vaiNuBankModel.src.models;

import vaiNuBankModel.src.interfaces.BankingOperations;

public abstract class BankAccount implements BankingOperations {
    protected int accountNumber;
    protected String agency;
    protected String accountHolderName;
    protected String accountHolderCPF;
    protected double balance;

    public BankAccount(int accountNumber, String agency, String accountHolderName, String accountHolderCPF) {
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.accountHolderName = accountHolderName;
        this.accountHolderCPF = accountHolderCPF;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderCPF() {
        return accountHolderCPF;
    }

    public void setAccountHolderCPF(String accountHolderCPF) {
        this.accountHolderCPF = accountHolderCPF;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    public abstract void transferTo(BankAccount destinationAccount, double amount);

    @Override
    public String toString() {
        return "Bank Account \n  [Account Number: " + accountNumber + "\n , Agency: " + agency + ", \n Account Holder Name: " + accountHolderName
                + "\n , Account Holder CPF: " + accountHolderCPF + ", \n Balance: " + balance + "]";
    }
}
