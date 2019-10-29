package fr.lacombe.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class BankAccountAcceptanceTest {

    Amount amount100 = Amount.of(new BigDecimal(100));
    Amount amount50 = Amount.of(new BigDecimal(50));
    Printer printer = new Printer();
    DateProviderMock dateProviderMock = new DateProviderMock();

    @Test
    void deposit_of_100_and_withdraw_of_50_return_statements_with_operation_type_and_amount_and_balance_and_date() {
        Account account = new Account(dateProviderMock);
        String expectedTransactionList =
                "DEPOSIT 100 balance 100 date 2019-10-29\n" +
                        "WITHDRAW 50 balance 50 date 2019-10-29\n";

        account.deposit(amount100);
        account.withdraw(amount50);

        assertThat(printer.print(account)).isEqualTo(expectedTransactionList);

    }
}

