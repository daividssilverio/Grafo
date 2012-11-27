import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

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
    HashMap<String, HashSet<String>> verticeArestas;

    public Grafo(String nomeArquivo) {
        chaveVertice = new HashMap<Integer, String>();
        verticeArestas = new HashMap<String, HashSet<String>>();
        lerDeArquivo(nomeArquivo);
    }

    public static void main(String args[]) throws FileNotFoundException {
        Grafo g = new Grafo("Wiki-Vote.txt");

        for (Integer i : g.chaveVertice.keySet()) {
            String v = g.chaveVertice.get(i);
            System.out.println(i + " : " + v);
            HashSet<String> set = g.verticeArestas.get(v);

            for (String s: set) {
                System.out.println("\t|" + s);
            }

            System.out.println();
        }
        System.out.println(g.qtVertices);
    }

    private void lerDeArquivo(String nomeDoArquivo) {

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

