package fr.lacombe.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private Transactions transactions = new Transactions();
    private Amount balance = Amount.of(new BigDecimal(0));
    private LocalDate operationDate = new DateProvider().getNow();


    public void deposit(Amount amount) {
        balance = this.balance.add(amount);
        TransactionLine transactionLine = new TransactionLine(OperationType.DEPOSIT, amount, balance, operationDate);
        transactions.add(transactionLine);
    }

    public void withdraw(Amount amount) {
        balance = this.balance.substrac(amount);
        if (balance.notOverDraft()) {
            TransactionLine transactionLine = new TransactionLine(OperationType.WITHDRAW, amount, balance, operationDate);
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
