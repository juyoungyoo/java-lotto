package lotto.model;

import lotto.exception.MinimumAmountException;

import java.util.Objects;

public class Money {

    public static final Money ZERO = Money.won(0);
    private long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money won(long amount) {
        if (amount < 0) {
            throw new MinimumAmountException(amount);
        }
        return new Money(amount);
    }

    public long countAvailable(Money money) {
        long count = this.amount / money.amount;
        if (count <= 0) {
            throw new MinimumAmountException(amount);
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return amount == money1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }

    public Money plus(Money money) {
        return Money.won(this.amount + money.amount);
    }

    public Money times(long count) {
        return Money.won(amount * count);
    }

    public Money subtract(Money money) {
        return Money.won(amount - money.amount);
    }
}