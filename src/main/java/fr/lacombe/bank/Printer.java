package fr.lacombe.bank;

import java.util.List;

public class Printer {

    public String print(Account account) {

        StringBuilder AllTransactions = new StringBuilder();
        List<TransactionLine> transactionLines = account.getTransactions().getTransactionsList();
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
