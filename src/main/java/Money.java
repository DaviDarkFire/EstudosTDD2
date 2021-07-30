public class Money implements Expression{
    protected int amount;
    protected String currency;

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    Money times(int multiplicador) {
        return new Money(amount * multiplicador, currency);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency.equals(money.currency());
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    String currency(){
        return currency;
    }

    public String toString(){
        return amount+" "+ currency;

    }

    Expression plus(Money addend) {
        return new Sum(this, addend);
    }
}
