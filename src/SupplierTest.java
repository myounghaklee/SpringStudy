import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<ArrayList<Integer>> s = () -> {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<5; i++){
                list.add(i);
            }
            return list;
        };
        ArrayList<Integer> result = s.get();
        for(Integer tmp : result){
            System.out.println(tmp);
        }
    }
}
