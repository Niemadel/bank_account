package fr.lacombe.bank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    Account account = new Account();
    public List<Amount> operationsAmount = new ArrayList<>();

    @Test
    void deposit_of_100_on_account_save_100_on_account() {
        account.deposit(Amount.of(100));
        operationsAmount.add(Amount.of(100));

        assertThat(account.getStatement()).isEqualTo(operationsAmount);
    }

    @Test
    void deposit_of_100_plus_deposit_of_50_save_150_on_account() {
        account.deposit(Amount.of(100));
        account.deposit(Amount.of(50));
        operationsAmount.add(Amount.of(100));
        operationsAmount.add(Amount.of(50));

        assertThat(account.getStatement()).isEqualTo(operationsAmount);
    }
}
