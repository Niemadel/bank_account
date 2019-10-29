package fr.lacombe.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    Amount amount100 = Amount.of(new BigDecimal(100));
    Amount amount50 = Amount.of(new BigDecimal(50));
    Amount amount120 = Amount.of(new BigDecimal(120));
    Amount amount80 = Amount.of(new BigDecimal(80));

    Printer printer = new Printer();

    DateProviderMock dateProviderMock = new DateProviderMock();

    @Test
    void deposit_of_100_return_balance_of_100() {
        Account account = new Account(dateProviderMock);

        account.deposit(amount100);

        assertThat(account.getBalance()).isEqualTo(amount100);
    }

    @Test
    void deposit_of_100_plus_deposit_of_50_return_balance_of_150() {
        Account account = new Account(dateProviderMock);

        account.deposit(amount100);
        account.deposit(amount50);

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(150)));
    }

    @Test
    void withdraw_of_50_return_balance_of_minus_50() {
        Account account = new Account(dateProviderMock);

        account.withdraw(amount50);

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(-50)));
    }

    @Test
    void withdraw_of_120_and_withdraw_of_80_return_balance_of_minus_200() {
        Account account = new Account(dateProviderMock);

        account.withdraw(amount120);
        account.withdraw(amount80);

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(-200)));
    }

    @Test
    void withdraw_of_100_and_deposit_of_50_return_balance_of_minus50() {
        Account account = new Account(dateProviderMock);

        account.withdraw(amount100);
        account.deposit(amount50);

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(-50)));
    }

    @Test
    void deposit_of_100_return_statement_with_operation_type_and_amount_and_balance_and_date() {
        Account account = new Account(dateProviderMock);
        String expectedTransactionStatement = "DEPOSIT 100 balance 100 date 2019-10-29\n";

        account.deposit(amount100);

        assertThat(printer.print(account)).isEqualTo(expectedTransactionStatement);

    }

    @Test
    void withdraw_of_400_set_balance_under_minus_300_so_withdraw_is_refused() {
        Account account = new Account(dateProviderMock);

        assertThrows(UnsupportedOperationException.class,
                () -> account.withdraw(Amount.of(new BigDecimal(400))));
    }

    @Test
    void deposit_of_100_then_withdraw_of_600_set_balance_under_minus_300_so_withdraw_is_refused() {
        Account account = new Account(dateProviderMock);
        account.deposit(amount100);

        assertThrows(UnsupportedOperationException.class,
                () -> account.withdraw(Amount.of(new BigDecimal(600))));
    }

}
