package fr.lacombe.bank;

import java.util.List;

public class Account {

    private Transactions transactions = new Transactions();

    public void deposit(Amount amount) {
        transactions.add(amount);
    }


    public List<Amount> getStatement() {
        return transactions.getOperationsAmount();
    }

}
