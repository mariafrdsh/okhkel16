/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Maria Firdausiah
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Vertex extends Node implements Iterable<Edge> {
    private HashMap<Integer, Edge> hashMap = new HashMap<>();
    private ArrayList<Edge> list;

    /**
     * Construct the Vertex.
     * @param name      The name of the Vertex
     * @param x         The x coordinate of the Vertex on the locale
     * @param y         The y coordinate of the Vertex on the locale
     */
    public Vertex (String name, int x, int y) {
        super(name, x, y);
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Add a Node to the hashMap. If the Node is as Vertex, creates an Edge equivalent,
     * then adds the Edge to the hashMap, otherwise adds it in directly.
     * @param n         The Node that will be added to the hashMap
     */
    public void addEdge (Node n) {
        if (n instanceof Vertex) {
            Edge e = new Edge(n.getName(), n.getX(), n.getY());
            hashMap.put(e.hashCode(), e);
            list.add(e);
        }
        else {
            hashMap.put(n.hashCode(), (Edge)n);
            list.add((Edge)n);
        }
    }

    public Edge getEdge (Node n) {
        return hashMap.get(n.hashCode());
    }

    /**
     * Check to see if an Edge with the same immutable properties as the specified Node exists.
     * @param n         The Node that will be checked to see if it exists
     * @return          True if an Edge with the same properties exists in the hashMap
     */
    public boolean contains (Node n) {
        return hashMap.containsValue(n.hashCode());
    }

    /**
     * Check the total number of Edges contained in this Vertex.
     * @return          The total number of Edges the Vertex contains.
     */
    public int getTotalEdges () {
        return hashMap.size();
    }

    @Override
    public Iterator<Edge> iterator () {
        return list.iterator();
    }

    @Override
    public String toString () {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", edges=" + hashMap +
                '}';
}
    
}
