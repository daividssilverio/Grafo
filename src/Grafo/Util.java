package grafo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: daivi_000
 * Date: 02/01/13
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static List<Componente> separaGrafo(Map<String, Set<String>> grafo) {
        ArrayList<Componente> componentes = new ArrayList<Componente>();

        while (!grafo.isEmpty()) {
            Componente comp = new Componente();
            Stack<String> pilha = new Stack<String>();
            Stack<String> chaves = new Stack<String>();
            chaves.addAll(grafo.keySet());
            pilha.add(chaves.pop());

            while (!pilha.isEmpty()) {
                String ultimo = pilha.pop();
                Set<String> ligs = grafo.remove(ultimo);

                if (ligs != null) {
                    comp.adicionaLigacoes(ultimo, ligs);
                    pilha.addAll(ligs);
                }
            }

            componentes.add(comp);
        }

        return componentes;
    }

    public static List<List<String>> bfs(Componente componente, String no) {
        List<List<String>> _bfs = new ArrayList<List<String>>();
        Stack<String> pilha_bfs = new Stack<String>();

        pilha_bfs.add(no);
        while (!pilha_bfs.isEmpty()) {
            List<String> nivel = new ArrayList<String>();
            nivel.addAll();
        }
    }
}
