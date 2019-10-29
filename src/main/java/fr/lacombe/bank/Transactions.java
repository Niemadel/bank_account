package fr.lacombe.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transactions {

    private List<TransactionLine> transactions = new ArrayList<>();

    public void add(TransactionLine transactionLine) {
        transactions.add(transactionLine);
    }

    public List<TransactionLine> getTransactionsList() {
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }
}
