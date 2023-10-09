package lesson8;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<Account> accounts;
    private List<Transaction> transactions;

    public Bank() {
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public Account createAccount(int accountNumber, double initialBalance) {
        if (getAccountByNumber(accountNumber) != null) {
            System.out.println("Account with the same number already exists.");
            return null;
        }
        Account newAccount = new Account(accountNumber, initialBalance);
        accounts.add(newAccount);
        return newAccount;
    }

    public boolean deposit(int accountNumber, double amount) {
        Account account = getAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;
        }
        account.deposit(amount);
        transactions.add(new Transaction(accountNumber, TransactionType.DEPOSIT, amount));
        return true;
    }

    public boolean withdraw(int accountNumber, double amount) {
        Account account = getAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }
        if (amount <= 0 || amount > account.getBalance()) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        account.withdraw(amount);
        transactions.add(new Transaction(accountNumber, TransactionType.WITHDRAWAL, amount));
        return true;
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private Account getAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }

    private class Account {
        private int accountNumber;
        private double balance;

        public Account(int accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            balance -= amount;
        }
    }

    private class Transaction {
        private int accountNumber;
        private TransactionType type;
        private double amount;

        public Transaction(int accountNumber, TransactionType type, double amount) {
            this.accountNumber = accountNumber;
            this.type = type;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Account " + accountNumber + ": " + type + " $" + amount;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount(1, 1000);
        bank.createAccount(2, 500);

        bank.deposit(1, 200);
        bank.withdraw(2, 100);

        bank.withdraw(1, 1500);

        bank.printTransactions();
    }
}
