package fr.lacombe.bank;

import java.math.BigDecimal;

public class Account {

    private Operations operations = new Operations();
    private Amount balance = Amount.of(BigDecimal.ZERO);
    private DateProvider dateProvider;

    public Account() {
        dateProvider = () -> null;
    }

    public Account(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    public void deposit(Amount amount) {
        balance = this.balance.add(amount);
        OperationLine operationLine = new OperationLine(OperationType.DEPOSIT, amount, balance, dateProvider.date());
        operations.add(operationLine);
    }

    public void withdraw(Amount amount) {
        balance = this.balance.subtract(amount);
        if (balance.notOverDraft()) {
            OperationLine operationLine = new OperationLine(OperationType.WITHDRAW, amount, balance, dateProvider.date());
            operations.add(operationLine);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public Amount getBalance() {
        return balance;
    }

    public Operations getOperations() {
        return operations;
    }

}
