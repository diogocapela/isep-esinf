import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author DEI-ISEP
 */
public class Supermarket {
    Map <Invoice, Set<Product>> m;

    Supermarket() {
        m = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List <String> l) throws Exception {

        throw new UnsupportedOperationException("Not supported yet.");
    }
    // returns a set in which each number is the number of products in the r
    // invoice
    Map<Invoice, Integer> numberOfProductsPerInvoice() {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set <Invoice> betweenDates(LocalDate d1, LocalDate d2) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    // converts a map of invoices and troducts to a map which key is a product
    // identification and the values are a set of the invoice references
    // in which it appearss
    Map <String, Set<Invoice>> convertInvoices() {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
