import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {

    @Test
    public void deveTestarMultiplicacao() {
        Dollar five = new Dollar(5);
        Assertions.assertThat(new Dollar(10)).isEqualTo(five.times(2));
        Assertions.assertThat(new Dollar(15)).isEqualTo(five.times(3));
    }

    @Test
    public void deveTestarIgualdade() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        assertFalse(new Franc(5).equals(new Dollar(5)));

    }

    @Test
    public void deveTestarMultiplicacaoDeFranco() {
        Franc five = new Franc(5);
        Assertions.assertThat(new Franc(10)).isEqualTo(five.times(2));
        Assertions.assertThat(new Franc(15)).isEqualTo(five.times(3));

    }
}
