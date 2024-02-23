package vaiNuBankModel.src.repository;

import vaiNuBankModel.src.models.BankAccount;

import java.util.ArrayList;

public class BankAccountRepository {
    private static final ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void addAccount(BankAccount account) throws Exception {
        boolean successfulRegistration = accounts.add(account);
        if (successfulRegistration) {
            System.out.println("Account registered successfully!");
        } else {
            throw new Exception("Error while registering account.");
        }
    }

    public static BankAccount findAccountByNumber(int accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber)
                .findAny()
                .orElse(null);
    }

    public static boolean deleteAccount(BankAccount account) {
        return accounts.remove(account);
    }

    public static void listAccounts() {
        accounts.forEach(System.out::println);
    }
}
