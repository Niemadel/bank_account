package fr.lacombe.bank;

import java.util.Objects;

public class TransactionLine {

    private OperationType operationType;
    private Amount amount;
    private Amount balance;

    public TransactionLine(OperationType operationType, Amount amount, Amount balance) {
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionLine that = (TransactionLine) o;
        return operationType == that.operationType &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, amount, balance);
    }
}
