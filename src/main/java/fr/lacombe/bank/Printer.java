package fr.lacombe.bank;

import java.util.List;

public class Printer {

    public String print(Account account) {

        StringBuilder AllOperations = new StringBuilder();
        List<OperationLine> operationLines = account.getOperations().getOperationsList();
        for (OperationLine operationLine : operationLines) {
            AllOperations.append(operationLine.formattedOperationType())
                    .append(operationLine.formattedAmount())
                    .append(" balance")
                    .append(operationLine.formattedBalance())
                    .append(" date ")
                    .append(operationLine.formattedOperationDate())
                    .append("\n");
        }

        return AllOperations.toString();
    }
}
