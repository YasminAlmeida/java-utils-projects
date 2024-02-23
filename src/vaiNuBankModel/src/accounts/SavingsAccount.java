package vaiNuBankModel.src.accounts;

import vaiNuBankModel.src.models.BankAccount;

import java.util.Calendar;
import java.util.Date;

public class SavingsAccount extends BankAccount {

    private Date anniversaryDate;
    private double monthlyInterestRate = 0.02;
    private double lastDepositBalance;
    private int lastDepositMonth;
    private double interestRate = 0.02;

    public SavingsAccount(int accountNumber, String agency, String accountHolderName, String accountHolderCPF, Date anniversaryDate) {
        super(accountNumber, agency, accountHolderName, accountHolderCPF);
        this.anniversaryDate = anniversaryDate;
        this.lastDepositMonth = -1;
    }

    public Date getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(Date anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public int getLastDepositMonth() {
        return lastDepositMonth;
    }

    public void setLastDepositMonth(int lastDepositMonth) {
        this.lastDepositMonth = lastDepositMonth;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
        balance -= amount - interestRate;
    }

    @Override
    public void deposit(double amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int currentMonth = cal.get(Calendar.MONTH);

        if (currentMonth != lastDepositMonth) {
            balance += lastDepositBalance * monthlyInterestRate;
            lastDepositMonth = currentMonth;
            lastDepositBalance = 0.0;
        }

        lastDepositBalance += amount;
        balance += amount;
    }

    @Override
    public void transferTo(BankAccount destinationAccount, double amount) {
        withdraw(amount);
        destinationAccount.deposit(amount);
    }
}
