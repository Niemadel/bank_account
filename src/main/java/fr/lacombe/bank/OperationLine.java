package fr.lacombe.bank;

public class OperationLine {

    private OperationType operationType;
    private Amount amount;

    public OperationLine(OperationType operationType, Amount amount) {
        this.operationType = operationType;
        this.amount = amount;
    }
}
