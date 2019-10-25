package fr.lacombe.bank;

public class Account {

    private Transactions transactions;

    public void deposit(int amount) {
        transactions = new Transactions(amount);

    }

    public void withdraw(int amount) {
        transactions = new Transactions(-amount);
    }

    public int getStatement() {
        return transactions.getAmount();
    }

}
