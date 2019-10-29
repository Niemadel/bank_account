package fr.lacombe.bank;

import java.math.BigDecimal;

public class Account {

    private Transactions transactions = new Transactions();
    private Amount balance = Amount.of(BigDecimal.ZERO);
    private DateProvider dateProvider;

    public Account(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    public void deposit(Amount amount) {
        balance = this.balance.add(amount);
        TransactionLine transactionLine = new TransactionLine(OperationType.DEPOSIT, amount, balance, dateProvider.date());
        transactions.add(transactionLine);
    }

    public void withdraw(Amount amount) {
        balance = this.balance.subtract(amount);
        if (balance.notOverDraft()) {
            TransactionLine transactionLine = new TransactionLine(OperationType.WITHDRAW, amount, balance, dateProvider.date());
            transactions.add(transactionLine);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public Amount getBalance() {
        return balance;
    }

    public Transactions getTransactions() {
        return transactions;
    }

}
