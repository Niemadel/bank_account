package fr.lacombe.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class BankAccountAcceptanceTest {

    Amount amount100 = Amount.of(new BigDecimal(100));
    Amount amount50 = Amount.of(new BigDecimal(50));

    DateProviderMock dateProviderMock = new DateProviderMock();
    LocalDate operationDate = dateProviderMock.date();

    @Test
    void deposit_of_100_and_withdraw_of_50_return_statement_with_operation_type_and_amount_and_balance_and_date() {
        Account account = new Account(dateProviderMock);
        TransactionLine expectedTransactionLine1 = new TransactionLine(OperationType.DEPOSIT, amount100, amount100, operationDate);
        Transactions expectedTransactions = new Transactions();
        expectedTransactions.add(expectedTransactionLine1);

        TransactionLine expectedTransactionLine2 = new TransactionLine(OperationType.WITHDRAW, amount50, amount50, operationDate);
        expectedTransactions.add(expectedTransactionLine2);

        account.deposit(amount100);
        account.withdraw(amount50);

        assertThat(account.getTransactions()).isEqualTo(expectedTransactions);

    }
}

