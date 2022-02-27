/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author DEI-ISEP
 */
public class Supermarket {

    Map<Invoice, Set<Product>> m;

    Supermarket() {
        m = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List<String> l) throws Exception {

        Invoice cuInvoice = null;
        for (String value : l) {

            String[] words = value.split(",");

            if (words[0].toUpperCase().equals("P")) {

                if (words.length != 4) {
                    throw new Exception("The line dont contain the correct number of fields");
                }
                String identification = words[1];
                int quantity = Integer.parseInt(words[2]);
                long price = Long.parseLong(words[3]);
                m.get(cuInvoice).add(new Product(identification, quantity, price));

            }

            if (words[0].toUpperCase().equals("I")) {
                if (words.length != 3) {
                    throw new Exception("The line dont contain the correct number of fields");
                }

                String reference = words[1];
                String date = words[2];

                Invoice invoice = new Invoice(reference, date);
                cuInvoice = invoice;
                Set<Product> products = new HashSet<>();

                m.put(invoice, products);
            }

        }
    }

    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {

        Map<Invoice, Integer> map = new HashMap<>();

        m.entrySet().forEach((entry) -> {
            map.put(entry.getKey(), entry.getValue().size());
        });
        return map;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {

        Set<Invoice> invoices = new HashSet<>();

        m.entrySet().forEach((entry) -> {
            if (entry.getKey().getDate().isAfter(d1) && entry.getKey().getDate().isBefore(d2)) {
                invoices.add(entry.getKey());
            }
        });

        return invoices;
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {

        long total = 0;

        for (Map.Entry<Invoice, Set<Product>> entry : m.entrySet()) {

            for (Product product : entry.getValue()) {
                if (product.getIdentification().equals(productId)) {
                    total += product.getPrice() * product.getQuantity();
                }
            }
        }

        return total;
    }

    // converts a map of invoices and troducts to a map which key is a product 
    // identification and the values are a set of the invoice references 
    // in which it appearss
    Map<String, Set<Invoice>> convertInvoices() {

        Map<String, Set<Invoice>> map = new HashMap<>();

        for (Map.Entry<Invoice, Set<Product>> entry : m.entrySet()) {

            for (Product product : entry.getValue()) {

                if (map.containsKey(product.getIdentification())) {
                    map.get(product.getIdentification()).add(entry.getKey());
                } else {
                    Set<Invoice> invoices = new HashSet<>();
                    invoices.add(entry.getKey());
                    map.put(product.getIdentification(), invoices);
                }
            }
        }

        return map;

    }
}
