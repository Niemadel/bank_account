package fr.lacombe.bank;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {

    private BigDecimal money;
    private static final BigDecimal OVER_DRAFT_LIMIT = new BigDecimal(-300);

    public Amount(BigDecimal money) {
        this.money = money;
    }

    public static Amount of(BigDecimal money) {
        return new Amount(money);
    }

    public Amount add(Amount amountDeposited) {
        return new Amount(money.add(amountDeposited.money));
    }

    public Amount substrac(Amount amountWithdrawn) {
        return new Amount(money.subtract(amountWithdrawn.money));
    }

    public boolean notOverDraft() {
        return money.compareTo(OVER_DRAFT_LIMIT) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(money, amount.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }


}
