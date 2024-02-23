package vaiNuBankModel.src.interfaces;

import vaiNuBankModel.src.models.BankAccount;

public interface BankingOperations {
    void withdraw(double amount);

    void deposit(double amount);

    void transferTo(BankAccount destinationAccount, double amount);
}
