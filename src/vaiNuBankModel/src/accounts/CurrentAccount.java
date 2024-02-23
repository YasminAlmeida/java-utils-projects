package vaiNuBankModel.src.accounts;

import vaiNuBankModel.src.models.BankAccount;

public  class CurrentAccount extends BankAccount {
    private String creditLimit;


    public CurrentAccount(int accountNumber, String agency, String accountHolderName, String accountHolderCPF, String creditLimit) {
        super(accountNumber, agency, accountHolderName, accountHolderCPF);
        this.creditLimit = creditLimit;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount) {
        double creditLimitDouble = Double.parseDouble(creditLimit);
        if (amount > balance + creditLimitDouble) {
            System.out.println("Insufficient balance!");
        } else if(amount > 0) {
            balance -= amount;
        }
        System.out.println("Withdrawal successful.");
        System.out.println("Your balance is: " + balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void transferTo(BankAccount destinationAccount, double amount) {
        withdraw(amount);
        destinationAccount.deposit(amount);
    }

    @Override
    public String toString() {
        return "Current Account [Account Number: " + accountNumber + ", \n Agency: " + agency + ",\n  Account Holder Name: " + accountHolderName
                + ", \n Account Holder CPF: " + accountHolderCPF + ", \n Balance: " + balance + ", \n Credit Limit: " + creditLimit + "]";
    }
}
