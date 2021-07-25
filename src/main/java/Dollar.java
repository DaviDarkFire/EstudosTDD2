public class Dollar extends Money{

    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplicador) {
        return new Dollar(amount * multiplicador);
    }

}
