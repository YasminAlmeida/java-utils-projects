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
        StringBuilder sb = new StringBuilder();
        sb.append("Current Account\n")
                .append("  [Account Number: ").append(accountNumber).append(",\n")
                .append("   Agency: ").append(agency).append(",\n")
                .append("   Account Holder Name: ").append(accountHolderName).append(",\n")
                .append("   Account Holder CPF: ").append(accountHolderCPF).append(",\n")
                .append("   Balance: ").append(balance).append(",\n")
                .append("   Credit Limit: ").append(creditLimit).append("]");
        return sb.toString();
    }
}
