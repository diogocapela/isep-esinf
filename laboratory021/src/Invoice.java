import java.time.LocalDate;

/**
 *
 * @author DEI-ISEP
 */
public class Invoice implements Comparable<Invoice> {
    private String reference;
    private LocalDate date;

    public Invoice(String reference, String date) {
        this.reference=reference;
        if (date!=null) {
            String s[] = date.split("/");
            this.date = LocalDate.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
    }

    public Invoice(String reference) {
        this(reference, "1900/01/01");
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
    public int compareTo(Invoice o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}