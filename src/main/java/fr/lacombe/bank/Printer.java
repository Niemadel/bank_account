package fr.lacombe.bank;

import java.util.List;

public class Printer {

    public String print(Transactions transactions) {

        StringBuilder AllTransactions = new StringBuilder();
        List<TransactionLine> transactionLines = transactions.getTransactions();
        for (TransactionLine transactionLine : transactionLines) {
            AllTransactions.append(transactionLine.formattedOperationType())
                    .append(transactionLine.formattedAmount())
                    .append(" balance")
                    .append(transactionLine.formattedBalance())
                    .append(" date ")
                    .append(transactionLine.formattedOperationDate())
                    .append("\n");
        }

        return AllTransactions.toString();
    }
}
