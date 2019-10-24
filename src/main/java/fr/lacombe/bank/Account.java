package fr.lacombe.bank;

public class Account {

    private AccountHistory accountHistory;

    public Account(AccountHistory accountHistory) {
        this.accountHistory = accountHistory;
    }

    public void deposit(int amount) {
        accountHistory.addDeposit(amount);
    }

}
