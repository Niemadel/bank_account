package fr.lacombe.bank;

import java.math.BigDecimal;

public class Account {

    private Transactions transactions = new Transactions();
    private Amount balance = Amount.of(new BigDecimal(0));


    public void deposit(Amount amount) {
        balance = this.balance.add(amount);
        TransactionLine transactionLine = new TransactionLine(OperationType.DEPOSIT, amount, balance);
        transactions.add(transactionLine);
    }

    public void withdraw(Amount amount) {
        balance = this.balance.substrac(amount);
        TransactionLine transactionLine = new TransactionLine(OperationType.WITHDRAW, amount, balance);
        transactions.add(transactionLine);
    }

    public Amount getBalance() {
        return balance;
    }

    public Transactions getTransactions() {
        return transactions;
    }
}
