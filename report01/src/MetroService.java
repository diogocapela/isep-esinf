import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MetroService {

    private DoublyLinkedList<Estacao> estacoes;
    private List<Bilhete> bilhetes;
    private Map<Integer, Estacao> estacoesMap;
    private Integer numEstacoes;

    public MetroService(DoublyLinkedList estacoes, List bilhetes) {
        this.estacoes = estacoes;
        this.bilhetes = bilhetes;
        estacoesMap = new HashMap();
        numEstacoes = 0;
    }

    public DoublyLinkedList<Estacao> getEstacoes() {
        return estacoes;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    /**
     * Adds a station to the station linked list in the correct sorted order.
     * @param estacao
     */
    public void addEstacao(Estacao estacao) {
        ListIterator<Estacao> it = estacoes.listIterator();
        while (it.hasNext()) {
            if(it.next().getNumEstacao() > estacao.getNumEstacao()) {
                it.previous();
                break;
            }
        }
        it.add(estacao);
        estacoesMap.put(estacao.getNumEstacao(), estacao);
        numEstacoes++;
    }

    /**
     * Adds a ticket to the ticket list.
     * @param bilhete
     */
    public void addBilhete(Bilhete bilhete) {
        bilhetes.add(bilhete);
    }

    /**
     * Reads and adds the stations from the file to the station linked list.
     * @param filePath
     */
    public void readEstacoesFromFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String[] lineData = line.split(",");

                int numEstacao = Integer.parseInt(lineData[0]);
                String descricao = lineData[1];
                String zona = lineData[2];

                this.addEstacao(new Estacao(numEstacao, descricao, zona));

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads and adds the tickets from the file to the tickers list.
     * @param filePath
     */
    public void readBilhetesFromFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String[] lineData = line.split(",");

                int numBilhete = Integer.parseInt(lineData[0]);
                String zonaBilhete = lineData[1];
                int numEstacaoOrigem = Integer.parseInt(lineData[2]);
                int numEstacaoDestino = Integer.parseInt(lineData[3]);

                Estacao estacaoOrigem = this.estacoesMap.get(numEstacaoOrigem);
                Estacao estacaoDestino = this.estacoesMap.get(numEstacaoDestino);

                this.addBilhete(new Bilhete(numBilhete, zonaBilhete, estacaoOrigem, estacaoDestino));

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<List<Estacao>> getMaioresSequenciasDeEstacoesQueSePodeAndarComUmBilhete(Bilhete bilhete) {
        List<List<Estacao>> sequenciaEstacoes = new ArrayList<>();
        Integer numeroDeZonasPermitidas = Integer.parseInt(bilhete.getTipo().split("")[1]);
        
        Set<Estacao> estacoesQueAnda = new HashSet();
        Set<String> zonasQueAnda = new HashSet();
        
        int maxEstacoes = 0;
        
        for(Estacao estacao : estacoes) {
            if(zonasQueAnda.size() < numeroDeZonasPermitidas) {
                estacoesQueAnda.add(estacao);
                zonasQueAnda.add(estacao.getZona());
            }
            if(estacoesQueAnda.size() > maxEstacoes) {
                maxEstacoes = estacoesQueAnda.size();
                sequenciaEstacoes.add(new ArrayList(estacoesQueAnda));
                estacoesQueAnda.clear();
                zonasQueAnda.clear();
            }
        }
        
        return sequenciaEstacoes;
    }
    
    /**
     * Returns the tickets in miss-use by the passengers.
     * @return
     */
    public List<Bilhete> getBilhetesEmTransgressao() {
        List<Bilhete> bilhetesTransgressao = new ArrayList<>();
        for(Bilhete bilhete : bilhetes) {
            String tipo = bilhete.getTipo();
            Estacao estacaoEntrou = bilhete.getEstacaoOrigem();
            Estacao estacaoSaiu = bilhete.getEstacaoDestino();
            if(estacaoEntrou.getNumEstacao() > estacaoSaiu.getNumEstacao()) {
                Estacao estacaoTemporaria = estacaoEntrou;
                estacaoEntrou = estacaoSaiu;
                estacaoSaiu = estacaoTemporaria;
            }
            Set<String> zonasEmQueAndou = new HashSet<>();
            boolean entrou = false;
            boolean saiu = false;
            ListIterator<Estacao> it = estacoes.listIterator();
            while (it.hasNext()) {
                Estacao estacao = it.next();
                String zona = estacao.getZona();
                if(estacao.equals(estacaoEntrou)) {
                    entrou = true;
                }
                if(entrou && !saiu) {
                    zonasEmQueAndou.add(zona);
                }
                if(estacao.equals(estacaoSaiu)) {
                    saiu = true;
                }
            }
            Integer numZonasPermitidas = Integer.parseInt(tipo.split("")[1]);
            Integer numeroZonasQueAndou = zonasEmQueAndou.size();
            if (numeroZonasQueAndou > numZonasPermitidas) {
                bilhetesTransgressao.add(bilhete);
            }
        }
        return bilhetesTransgressao;
    }

    public Map<Estacao, Integer> getNumeroUtilizadoresQuePassouPorCadaEstacao() {
        Map<Estacao, Integer> mapaEstacoesUtilizadores = new HashMap<>();
        for(Bilhete bilhete : bilhetes) {
            Estacao estacaoEntrou = bilhete.getEstacaoOrigem();
            Estacao estacaoSaiu = bilhete.getEstacaoDestino();
            if(estacaoEntrou.getNumEstacao() > estacaoSaiu.getNumEstacao()) {
                Estacao estacaoTemporaria = estacaoEntrou;
                estacaoEntrou = estacaoSaiu;
                estacaoSaiu = estacaoTemporaria;
            }
            boolean entrou = false;
            boolean saiu = false;
            for(Estacao estacao : estacoes) {
                if(estacao.equals(estacaoEntrou)) {
                    entrou = true;
                }
                if(entrou && !saiu) {
                    if(mapaEstacoesUtilizadores.get(estacao) == null) {
                        mapaEstacoesUtilizadores.put(estacao, 1);
                    } else {
                        int numeroPessoasQueLaPassou = mapaEstacoesUtilizadores.get(estacao);
                        numeroPessoasQueLaPassou++;
                        mapaEstacoesUtilizadores.put(estacao, numeroPessoasQueLaPassou);
                    }
                }
                if(estacao.equals(estacaoSaiu)) {
                    saiu = true;
                }
            }
        }
        return mapaEstacoesUtilizadores;
    }

}
