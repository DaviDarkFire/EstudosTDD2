import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {

    @Test
    public void deveTestarMultiplicacao() {
        Money five = Money.dollar(5);
        Assertions.assertThat(Money.dollar(10)).isEqualTo(five.times(2));
        Assertions.assertThat(Money.dollar(15)).isEqualTo(five.times(3));
    }

    @Test
    public void deveTestarIgualdade() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() {
        Assertions.assertThat("USD").isEqualTo(Money.dollar(1).currency());
        Assertions.assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    @Test
    public void testAdicaoSimples(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        Assertions.assertThat(reduced).isEqualTo(Money.dollar(10));
    }

    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        Assertions.assertThat(sum.augend).isEqualTo(five);
        Assertions.assertThat(sum.addend).isEqualTo(five);
    }

    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assertions.assertThat(result).isEqualTo(Money.dollar(7));
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        Assertions.assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        Assertions.assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    public void testIdentityRate() {
        Assertions.assertThat(new Bank().rate("USD", "USD")).isEqualTo(1);
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        Assertions.assertThat(result).isEqualTo(Money.dollar(10));
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        Assertions.assertThat(result).isEqualTo(Money.dollar(15));
    }

    @Test
    public void testSumTimes() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        Assertions.assertThat(result).isEqualTo(Money.dollar(20));
    }
}
