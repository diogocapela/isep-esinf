import java.time.LocalDate;
import java.util.*;

public class Supermarket {

    Map<Invoice, Set<Product>> m;

    Supermarket() {
        m = new HashMap<>();
    }

    // Reads invoices from a list of String
    void readInvoices(List<String> l) throws Exception {
        Invoice currentInvoiceReference = null;
        for(String line : l) {
            String[] lineData = line.split(",");
            if("I".equals(lineData[0])) {
                Invoice invoice = new Invoice(lineData[1], lineData[2]);
                currentInvoiceReference = invoice;
                m.put(invoice, new HashSet<>());
            }
            if("P".equals(lineData[0])) {
                Set<Product> products = m.get(currentInvoiceReference);
                products.add(new Product(lineData[1], Integer.parseInt(lineData[2]), Long.parseLong(lineData[3])));
            }
        }




        for (Invoice name: m.keySet()){
            String key =name.toString();
            String value = m.get(name).toString();
            System.out.println(key + " " + value);
        }
    }

    // returns a set in which each number is the number of products in the r
    // invoice
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        Map<Invoice, Integer> mapa = new HashMap<>();

        for (Invoice invoice: m.keySet()){
            Set<Product> products = m.get(invoice);
            mapa.put(invoice, products.size());
        }

        return mapa;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> invoicesWithDates = new HashSet<>();

        for(Invoice invoice : m.keySet()) {
            if(invoice.getDate().compareTo(d1) > 0 && invoice.getDate().compareTo(d2) < 0) {
                invoicesWithDates.add(invoice);
            }
        }

        return  invoicesWithDates;
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        long sum = 0;

        for(Invoice invoice: m.keySet()) {
            for(Product product: m.get(invoice)) {
                if(product.getIdentification().equals(productId)) {
                    sum = sum + product.getPrice() * product.getQuantity();
                }
            }
        }

        return sum;
    }

    // converts a map of invoices and products to a map which key is a product
    // identification and the values are a set of the invoice references
    // in which it appears
    Map<String, Set<Invoice>> convertInvoices() {
        Map<String, Set<Invoice>> novoMapa = new HashMap<>();

        for(Invoice invoice: m.keySet()) {
            for(Product product: m.get(invoice)) {
                novoMapa.put(product.getIdentification(), new HashSet<>());
            }
        }

        for(Invoice invoice: m.keySet()) {
            for(Product product: m.get(invoice)) {
                Set<Invoice> invoicesDoProducto = novoMapa.get(product.getIdentification());
                invoicesDoProducto.add(invoice);
            }
        }

        return novoMapa;
    }
}
