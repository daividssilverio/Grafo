package grafo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: daivi_000
 * Date: 02/01/13
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
public class Componente {
    private Map<String, Set<String>> verticeLigacoes;

    public Componente() {
        verticeLigacoes = new LinkedHashMap<String, Set<String>>();
    }

    /**
     *
     * @return Os vertices de um componente
     */
    public Set<String> getVertices() {
        return verticeLigacoes.keySet();
    }

    /**
     *
     * @param v --> Valor de uma vértice do componente
     * @return As ligações do vértice v ou null se não encontrar
     */
    public Set<String> getLigacoesVertice(String v) {
        return verticeLigacoes.get(v);
    }

    public void adicionaLigacao(String vertice, String ligacao) {
        if (verticeLigacoes.containsKey(vertice)) {
            verticeLigacoes.get(vertice).add(ligacao);
        }
        else {
            HashSet<String> lig = new HashSet<String>();
            lig.add(ligacao);
            verticeLigacoes.put(vertice, lig);
        }
    }

    public void adicionaLigacoes(String vertice, Collection<String> ligacoes) {
        for(String s: ligacoes) {
            adicionaLigacao(vertice, s);
        }
    }
}
