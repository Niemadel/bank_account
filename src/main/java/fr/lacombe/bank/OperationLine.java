package fr.lacombe.bank;

import java.time.LocalDateTime;
import java.util.Objects;

public class OperationLine {

    private OperationType operationType;
    private Amount amount;
    private Amount balance;
    private LocalDateTime operationDate;

    public OperationLine(OperationType operationType, Amount amount, Amount balance, LocalDateTime operationDate) {
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
        OperationLine that = (OperationLine) o;
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
