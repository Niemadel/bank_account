package fr.lacombe.bank;

import java.math.BigDecimal;

public class Account {

    private Transactions transactions = new Transactions();
    private Amount balance = Amount.of(new BigDecimal(0));


    public void deposit(Amount amount) {
        balance = this.balance.add(amount);
        OperationLine operationLine = new OperationLine(OperationType.DEPOSIT, amount);
        transactions.add(operationLine);
    }

    public void withdraw(Amount amount) {
        balance = this.balance.substrac(amount);
        OperationLine operationLine = new OperationLine(OperationType.WITHDRAW, amount);
        transactions.add(operationLine);
    }

    public Amount getBalance() {
        return balance;
    }
}
