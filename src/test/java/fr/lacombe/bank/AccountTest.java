package fr.lacombe.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void deposit_of_100_on_account_save_100_on_account() {
        AccountHistory accountHistory = new AccountHistory();
        Account account = new Account(accountHistory);

        account.deposit(100);

        assertThat(100).isEqualTo(accountHistory.addDeposit(100));
    }
}
