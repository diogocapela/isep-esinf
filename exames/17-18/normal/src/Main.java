import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("carro");
        lista.add("auto");
        lista.add("auto");
        lista.add("autocarro");
        lista.add("carro");
        lista.add("carro");
        lista.add("autocarro");
        lista.add("auto");

        System.out.println(lista);
        System.out.println(renomear(lista));

    }

    public static List<String> renomear(List<String> lst) {
        List<String> novaLista = new ArrayList<>();
        Map<String, Integer> mapa = new HashMap<>();
        for(int i = 0; i < lst.size(); i++) {
            String palavra = lst.get(i);
            if(mapa.containsKey(palavra)) {
                int number = mapa.get(palavra) + 1;
                mapa.put(palavra, number);
                novaLista.add(lst.get(i) + " " + number);
            } else {
                novaLista.add(lst.get(i));
                mapa.put(palavra, 0);
            }
        }
        return novaLista;
    }



    public static List<String> maisSinonimos(Map<String, List<String>> mapSyn, Integer i) {
        Map<String, Integer> mapaPalavras = new HashMap<>();
        for(String key : mapSyn.keySet()) {
            List<String> sinonimos = mapSyn.get(key);
            for(String sinonimo : sinonimos) {
                if (mapaPalavras.containsKey(sinonimo)) {
                    mapaPalavras.put(sinonimo, mapaPalavras.get(sinonimo) + 1);
                } else {
                    mapaPalavras.put(sinonimo, 1);
                }
            }
        }
        List<String> listaPalavrasAparecemMais = new ArrayList<>();
        for(String key : mapaPalavras.keySet()) {
            if(mapaPalavras.get(key) > i) {
                listaPalavrasAparecemMais.add(key);
            }
        }
        return listaPalavrasAparecemMais;
    }

}
