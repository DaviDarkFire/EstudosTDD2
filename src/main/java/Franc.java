public class Franc extends Money {

    Franc(int amount) {
        this.amount = amount;
        currency = "CHF";
    }

    Money times(int multiplicador) {
        return new Franc(amount * multiplicador);
    }

}
