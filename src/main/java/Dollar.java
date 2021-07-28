public class Dollar extends Money {
    Dollar(int amount) {
        this.amount = amount;
        currency = "USD";
    }

    Money times(int multiplicador) {
        return new Dollar(amount * multiplicador);
    }

}
