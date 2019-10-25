package fr.lacombe.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    Account account = new Account();

    @Test
    void deposit_of_100_on_account_save_100_on_account() {
        account.deposit(100);

        assertThat(account.getStatement()).isEqualTo(100);
    }

}
