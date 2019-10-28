package fr.lacombe.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    Amount amount100 = Amount.of(new BigDecimal(100));
    Amount amount50 = Amount.of(new BigDecimal(50));

    @Test
    void deposit_of_100_on_account_save_100_on_account() {
        Account account = new Account();

        account.deposit(amount100);

        assertThat(account.getBalance()).isEqualTo(amount100);
    }

    @Test
    void deposit_of_100_plus_deposit_of_50_save_150_on_account() {
        Account account = new Account();

        account.deposit(amount100);
        account.deposit(amount50);

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(150)));
    }

    @Test
    void withdraw_of_50_return_statement_of_minus_50() {
        Account account = new Account();

        account.withdraw(amount50);

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(-50)));
    }

    @Test
    void withdraw_of_120_and_withdraw_of_80_return_statement_of_minus_200() {
        Account account = new Account();

        account.withdraw(Amount.of(new BigDecimal(120)));
        account.withdraw(Amount.of(new BigDecimal(80)));

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(-200)));
    }

    @Test
    void withdraw_of_100_and_deposit_of_50_return_statement_of_minus50() {
        Account account = new Account();

        account.withdraw(Amount.of(new BigDecimal(100)));
        account.deposit(Amount.of(new BigDecimal(50)));

        assertThat(account.getBalance()).isEqualTo(Amount.of(new BigDecimal(-50)));
    }

    @Test
    void deposit_of_100_return_statement_with_operation_type_and_amount_and_balance() {
        Account account = new Account();
        TransactionLine expectedTransactionLine = new TransactionLine(OperationType.DEPOSIT, amount100, amount100);
        Transactions expectedTransactions = new Transactions();
        expectedTransactions.add(expectedTransactionLine);

        account.deposit(amount100);

        assertThat(account.getTransactions()).isEqualTo(expectedTransactions);

    }

}
