package fr.lacombe.bank;

import java.util.Objects;

public class Amount {

    private int money;

    public Amount(int money) {
        this.money = money;
    }

    public static Amount of(int money) {
        return new Amount(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return money == amount.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "money=" + money +
                '}';
    }
}
