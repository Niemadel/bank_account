package fr.lacombe.bank;

import java.util.Objects;

public class TransactionLine {

    private OperationType operationType;
    private Amount amount;

    public TransactionLine(OperationType operationType, Amount amount) {
        this.operationType = operationType;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionLine that = (TransactionLine) o;
        return operationType == that.operationType &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, amount);
    }
}
