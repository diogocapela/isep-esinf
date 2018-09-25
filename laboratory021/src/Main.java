import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();

        lista.add("I,INV001,2016/09/10");
        lista.add("P,EGG,12,200");
        lista.add("P,APPLE,2,140");
        lista.add("P,BUTTER,1,100");
        lista.add("I,INV002,2016/09/11");
        lista.add("P,PEAR,3,230");
        lista.add("P,CHIPS,3,320");
        lista.add("P,EGG,6,100");
        lista.add("I,INV003,2016/09/12");
        lista.add("P,BUTTER,2,200");
        lista.add("P,APPLE,3,210");
        lista.add("P,CHIPS,2,210");
        lista.add("P,PEAR,5,350");
        lista.add("I,INV004,2016/09/13");
        lista.add("P,COCONUT,1,240");
        lista.add("P,APPLE,2,140");
        lista.add("P,BUTTER,2,200");
        lista.add("P,PINEAPPLE,2,310");

        Supermarket supermarket = new Supermarket();

        try {
            supermarket.readInvoices(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
