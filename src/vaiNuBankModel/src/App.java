package vaiNuBankModel.src;

import vaiNuBankModel.src.accounts.CurrentAccount;
import vaiNuBankModel.src.accounts.SavingsAccount;
import vaiNuBankModel.src.models.BankAccount;
import vaiNuBankModel.src.repository.BankAccountRepository;

import java.util.Date;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create Checking Account");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Edit Account");
            System.out.println("4. Search Account by Number");
            System.out.println("5. Delete Account");
            System.out.println("6. List Accounts");
            System.out.println("7. Make a deposit");
            System.out.println("8. Make a withdrawal");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        createCheckingAccount();
                        break;
                    case 2:
                        createSavingsAccount();
                        break;
                    case 3:
                        editAccount();
                        break;
                    case 4:
                        searchAccountByNumber();
                        break;
                    case 5:
                        deleteAccount();
                        break;
                    case 6:
                        BankAccountRepository.listAccounts();
                        break;
                    case 7:
                        System.out.print("Enter the account number: ");
                        int accountNumber = Integer.parseInt(scanner.nextLine());
                        BankAccount account = BankAccountRepository.findAccountByNumber(accountNumber);
                        if (account != null) {
                            System.out.print("Enter the amount to deposit: ");
                            double amount = Double.parseDouble(scanner.nextLine());
                            account.deposit(amount);
                            System.out.println("Deposit successful!");
                            System.out.println("Your new balance is: " + account.getBalance());
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 8:
                        System.out.print("Enter the account number: ");
                        accountNumber = Integer.parseInt(scanner.nextLine());
                        account = BankAccountRepository.findAccountByNumber(accountNumber);
                        if (account != null) {
                            System.out.print("Enter the amount to withdraw: ");
                            double amount = Double.parseDouble(scanner.nextLine());
                            account.withdraw(amount);
                            System.out.println("Withdrawal successful!");
                            System.out.println("Your new balance is: " + account.getBalance());
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 9:
                        System.out.println("Thank you for using our services.");
                        return;
                    default:
                        System.out.println("Invalid option! Please choose a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static void searchAccountByNumber() {
        System.out.print("Account Number: ");
        int number = Integer.parseInt(scanner.nextLine());
        BankAccount account = BankAccountRepository.findAccountByNumber(number);
        System.out.println(account.toString());
    }

    private static void createCheckingAccount() {
        System.out.println("\nCreating Checking Account");
        System.out.print("Account Number: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.print("Branch: ");
        String branch = scanner.nextLine();
        System.out.print("Account Holder's Name: ");
        String name = scanner.nextLine();
        System.out.print("Account Holder's CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Credit Limit: ");
        String creditLimit = scanner.nextLine();
        CurrentAccount checkingAccount = new CurrentAccount(number, branch, name, cpf, creditLimit);
        try {
            BankAccountRepository.addAccount(checkingAccount);
            System.out.println("Account created successfully!");
            System.out.println("Your account details are: " + checkingAccount.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createSavingsAccount() {
        System.out.println("\nCreating Savings Account");
        System.out.print("Account Number: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.print("Branch: ");
        String branch = scanner.nextLine();
        System.out.print("Account Holder's Name: ");
        String name = scanner.nextLine();
        System.out.print("Account Holder's CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Birthday (dd/mm/yyyy): ");
        String birthdayStr = scanner.nextLine();
        Date birthday = parseDate(birthdayStr);
        SavingsAccount savingsAccount = new SavingsAccount(number, branch, name, cpf, birthday);
        try {
            BankAccountRepository.addAccount(savingsAccount);
            System.out.println("Account created successfully!");
            System.out.println("Your account details are: " + savingsAccount.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void editAccount() {
        try {
            System.out.print("Enter the account number for editing: ");
            int accountNumber = Integer.parseInt(scanner.nextLine());
            BankAccount account = BankAccountRepository.findAccountByNumber(accountNumber);
            if (account != null) {
                System.out.println("Account found: " + account);
                if (account instanceof SavingsAccount) {
                    System.out.print("New Anniversary Date (dd/mm/yyyy): ");
                    String newAnniversaryDateStr = scanner.nextLine();
                    Date newAnniversaryDate = parseDate(newAnniversaryDateStr);
                    ((SavingsAccount) account).setAnniversaryDate(newAnniversaryDate);
                    System.out.println("Anniversary date updated successfully!");
                } else {
                    System.out.println("Account type not supported for editing. Just the savings account can be edited.");
                }
            } else {
                System.out.println("Account not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number format!");
        } catch (Exception e) {
            System.out.println("Error editing account: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteAccount() throws Exception {
        System.out.print("Enter the account number to delete: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());
        BankAccount account = BankAccountRepository.findAccountByNumber(accountNumber);
        if (account != null) {
            boolean removed = BankAccountRepository.deleteAccount(account);
            if (removed) {
                System.out.println("Account deleted successfully!");
            } else {
                System.out.println("Error deleting the account.");
            }
        } else {
            throw new Exception("Account not found!");
        }
    }

    private static Date parseDate(String dateStr) {
        String[] dateParts = dateStr.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        return new Date(year - 1900, month - 1, day);
    }
}
