package java8to18;


import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEx1 {
    public static void main(String[] args) {
        beforeUsingStreamEx1();
        usingStreamEx1();
    }


    /*
    Currency : 화폐 객체
    Transcation : 거래 객체
     */
    private static void beforeUsingStreamEx1() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>(); // 그릅화된 트랜잭션을 담을 Map

        for(Transaction t : transacitons){
            if(t.getPrice()>1000){
                Currency currency = t.getCurrency();
                List<Transaction>transactions transactionsByCurrencies.get(currency);
            }
        }
    }
    private static void usingStreamEx1() {
    }


    static class Currency{

    }

    static class Transaction{

    }
}
