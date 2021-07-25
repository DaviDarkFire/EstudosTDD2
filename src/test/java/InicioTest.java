import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InicioTest {

    @Test
    public void deveTestarMultiplicacao(){
        Dollar five = new Dollar(5);
        Dollar produto = five.times(2);
        Assertions.assertThat(produto.amount).isEqualTo(10);
        produto = five.times(3);
        Assertions.assertThat(produto.amount).isEqualTo(15);

    }
}
