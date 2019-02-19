# isep-esinf

Resolução dos exercícios das aulas de ESINF ISEP 2018/2019.

### Collections

```java
/*
Elabore um método que recebe uma lista de strings e altera as strings que são repetidas adicionando-lhe a
ordem de repetição dessa string na lista. Por exemplo a lista de strings:
["carro", "auto", "auto", "autocarro", "carro", "carro", "autocarro", "auto"] é transformada em:
["carro", "auto", "auto 1", "autocarro", "carro 1", "carro 2", "autocarro 1", "auto 2"]
Considere o método com a seguinte assinatura: List<String> renomear(List<String> lst)
 */

public List<String> renomear(List<String> lst) {
    List<String> novaLista = new ArrayList<>();
    Map<String, Integer> mapa = new HashMap<>();
    for(String palavra : lst) {
        if(mapa.containsKey(palavra)) {
            int number = mapa.get(palavra) + 1;
            mapa.put(palavra, number);
            novaLista.add(palavra + " " + number);
        } else {
            mapa.put(palavra, 0);
            novaLista.add(palavra);
        }
    }
    return novaLista;
}
```

```java
/*
Elabore um método que recebe um mapa de sinónimos, onde a chave é uma palavra e o valor é uma lista de
sinónimos dessa palavra. O objetivo é devolver uma lista com as palavras que aparecem como sinónimos mais
do que i vezes. A lista de retorno não deve ter sinónimos repetidos. Considere a seguinte assinatura:
List<String> maisSinonimos(Map<String, List<String>> mapSyn, Integer i)
*/

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
```


### Trees

```java
boolean isLeaf(BTNode node, int data) {
    if(node == null) return false;
    if(node.getLeft() == null && node.getRight() == null) return true;
    isLeaf(node.getLeft());
    isLeaf(node.getRight());
}

boolean getList(List<Integer> lista, int counter, Tree<> visitados) {
    if(node == null) {
        return true;
    }

    visitados.node

    if(node.getLeft() == null && node.getRight() == null) {
        lista.add(counter);
        counter = counter - node.getValue();
    }
    
    visitados++;
    
    getList(node.getLeft());
    getList(node.getRight());
}

```