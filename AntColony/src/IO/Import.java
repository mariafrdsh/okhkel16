/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;


import Graph.*;

import java.io.InputStream;
import java.util.Arrays;
/**
 *
 * @author Maria Firdausiah
 */
public class Import {
      /**
     * Read the specified data set and return a graph based on the set.
     * @param evaporationRate
     * @param alpha
     * @param beta
     * @return          the graph representing the data set
     */
    public static Graph getGraph (double evaporationRate, int alpha, int beta) {

        String dataSetName;
        int startingLine;

        dataSetName = "medium2.csv";
        startingLine = 1;

        String[] lines = read(dataSetName).split("\n");
        String[] words = lines[0].split(" ");
        int numOfCities = Integer.parseInt(words[0]);
        System.out.println(numOfCities);
        Vertex[] vertices = new Vertex[numOfCities];

        // Read each line and turn it into a Vertex.
        for (int i = startingLine; i < startingLine+numOfCities; i++) {
            String[] line = lines[i].split(",");
            lines[i]= ""+i;
            int x = (int)Double.parseDouble(line[0]);
            int y = (int)Double.parseDouble(line[1]);
            Vertex v = new Vertex(lines[i], x, y);
            vertices[i-startingLine] = v;
        }

        Graph graph = new Graph(evaporationRate, alpha, beta);

        // Create the spine of the graph (the vertices).
        for (int i = 0; i < numOfCities; i++) {
            graph.addVertex(vertices[i]);
        }

        // Create the edges of the graph (connect every vertex to each other).
        for (Vertex v : graph) {
            for (int i = 0; i < numOfCities; i++) {
                if (vertices[i] != v) {
                    graph.addEdge(v, vertices[i]);
                }
            }
        }

        return graph;
    }

    /**
     * Removes duplicate what spaces in a String.
     * Example: "   2  3  3,2   " becomes " 2 3 3,2 "
     * @params     the String to parse
     * @return      the String minus the duplicate white spaces
     */
    private static String removeWhiteSpace (String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i-1) == ' ') {
                if (i != s.length()) {
                    s = s.substring(0, i) + s.substring(i+1, s.length());
                    i--;
                } else {
                    s = s.substring(0, i);
                    i--;
                }
            }
        }
        return s;
    }

    /**
     * Read from a file and load it to a String.
     * @param fileName  the name of the file to read (within the same root as this class)
     * @return          a String with the contents of the file
     */
    private static String read (String fileName) {
        InputStream stream = Import.class.getResourceAsStream(fileName);
        java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
    

