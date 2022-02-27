public class Bilhete {

    private Integer numBilhete;
    private String tipo;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;

    public Bilhete(Integer numBilhete, String tipo, Estacao estacaoOrigem, Estacao estacaoDestino) {
        this.numBilhete = numBilhete;
        this.tipo = tipo;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
    }

    public Integer getNumBilhete() {
        return numBilhete;
    }

    public String getTipo() {
        return tipo;
    }

    public Estacao getEstacaoOrigem() {
        return estacaoOrigem;
    }

    public Estacao getEstacaoDestino() {
        return estacaoDestino;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Bilhete bilhete = (Bilhete) object;
        return java.util.Objects.equals(numBilhete, bilhete.numBilhete);
    }

    public int hashCode() {
        return numBilhete.hashCode();
    }
}
