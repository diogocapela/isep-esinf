import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estacao {

    private Integer numEstacao;
    private String descricao;
    private String zona;
    private List<Bilhete> bilhetesValidadosEntrada;
    private List<Bilhete> bilhetesValidadosSaida;

    public Estacao(Integer numEstacao, String descricao, String zona) {
        this.numEstacao = numEstacao;
        this.descricao = descricao;
        this.zona = zona;
        bilhetesValidadosEntrada = new ArrayList<>();
        bilhetesValidadosSaida = new ArrayList<>();
    }

    public Integer getNumEstacao() {
        return numEstacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getZona() {
        return zona;
    }

    public List<Bilhete> getBilhetesValidadosEntrada() {
        return bilhetesValidadosEntrada;
    }

    public List<Bilhete> getBilhetesValidadosSaida() {
        return bilhetesValidadosSaida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estacao estacao = (Estacao) o;
        return Objects.equals(numEstacao, estacao.numEstacao);
    }

    @Override
    public int hashCode() {
        return numEstacao.hashCode();
    }

}
