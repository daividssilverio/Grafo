package grafo;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: daivi_000
 * Date: 13/11/12
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class Grafo {
    private int qtVertices;
    private final String datasets = "datasets" + File.separator;
    HashMap<Integer, String> chaveVertice;
    List<Componente> componentes;

    public Grafo(String nomeArquivo) {
        chaveVertice = new HashMap<Integer, String>();
        componentes = new ArrayList<Componente>();
        lerDeArquivo(nomeArquivo);
    }

    public static void main(String args[]) throws FileNotFoundException {
        Grafo g = new Grafo("Wiki-Vote.txt");

        int i = 0;
        int size = 0;
        for (Componente c : g.componentes) {
            System.out.println(i++);
            size += c.getVertices().size();
            for (String s : c.getVertices()) {
                System.out.println("\t-" + s);
                for (String v : c.getLigacoesVertice(s))
                    System.out.println("\t|" + v);
                System.out.println();
            }
        }

        System.out.println(g.qtVertices + ", " + size);
    }

    private void lerDeArquivo(String nomeDoArquivo) {
        Map<String, Set<String>> verticeArestas = new HashMap<String, Set<String>>();

        try {
            Scanner scanner = new Scanner(new File(datasets + nomeDoArquivo));
            this.qtVertices = scanner.nextInt();

            while (scanner.hasNext()) {
                String primeiro, segundo;
                primeiro = scanner.next();
                segundo = scanner.next();


                if (!chaveVertice.containsValue(primeiro)) {
                    // primeira aparicao do vertice primeiro
                    chaveVertice.put(chaveVertice.size(), primeiro);
                    verticeArestas.put(primeiro, new HashSet<String>());
                }

                if (!chaveVertice.containsValue(segundo)) {
                    // primeira aparicao do vertice primeiro
                    chaveVertice.put(chaveVertice.size(), segundo);
                    verticeArestas.put(segundo, new HashSet<String>());
                }

                verticeArestas.get(primeiro).add(segundo);
                verticeArestas.get(segundo).add(primeiro);
            }

            while (chaveVertice.size() != this.qtVertices) {
                chaveVertice.put(chaveVertice.size(), null);
            }

            scanner.close();

            componentes = Util.separaGrafo(verticeArestas);

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

