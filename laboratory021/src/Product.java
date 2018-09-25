public class Product implements Comparable<Product> {
    private String identification;
    private int quantity;
    private long price;

    Product(String identification, int quantity, long price ) {
        this.identification = identification;
        this.quantity = quantity;
        this.price = price;
    }

    Product(String identification ) {
        this(identification,0,0);
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo(Product o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}