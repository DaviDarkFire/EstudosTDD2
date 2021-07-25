public class Franc extends Money{
    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplicador) {
        return new Franc(amount * multiplicador);
    }

}
