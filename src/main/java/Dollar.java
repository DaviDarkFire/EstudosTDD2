public class Dollar {
    int amount;
    Dollar(int amount){
        this.amount = amount;

    }

    Dollar times(int multiplicador){
       return new Dollar(amount*multiplicador);

    }
}
