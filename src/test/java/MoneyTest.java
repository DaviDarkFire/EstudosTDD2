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
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));

    }

    @Test
    public void deveTestarMultiplicacaoDeFranco() {
        Money five = Money.franc(5);
        Assertions.assertThat(Money.franc(10)).isEqualTo(five.times(2));
        Assertions.assertThat(Money.franc(15)).isEqualTo(five.times(3));

    }

    @Test
    public void testCurrency() {
        Assertions.assertThat("USD").isEqualTo(Money.dollar(1).currency());
        Assertions.assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    @Test
    public void testaIgualdadeEmClassesDiferentes(){
        assertTrue((new Money(10, "CHF")).equals(new Franc(10,"CHF")));
    }
}
