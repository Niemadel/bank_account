package fr.lacombe.bank;

import java.time.LocalDate;
import java.util.Objects;

public class TransactionLine {

    private OperationType operationType;
    private Amount amount;
    private Amount balance;
    private LocalDate operationDate;

    public TransactionLine(OperationType operationType, Amount amount, Amount balance, LocalDate operationDate) {
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
        this.operationDate = operationDate;
    }

    public OperationType formattedOperationType() {
        return operationType;
    }

    public String formattedAmount() {
        return amount.toString();
    }

    public String formattedBalance() {
        return balance.toString();
    }

    public String formattedOperationDate() {
        return operationDate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionLine that = (TransactionLine) o;
        return operationType == that.operationType &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(operationDate, that.operationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, amount, balance, operationDate);
    }
}
