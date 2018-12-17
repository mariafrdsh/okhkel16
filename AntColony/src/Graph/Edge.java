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
public class Edge extends Node{
      private double pheromone;

    /**
     * Constructs the Edge.
     * @param name      The name of the Edge.
     * @param x         The x coordinate of the Edge on the locale.
     * @param y         The y coordinate of the Edge on the locale.
     */
    public Edge (String name, int x, int y) {
        super(name, x, y);
        pheromone = 0.01;
    }

    public void setPheromone (double pheromone) {
        this.pheromone = pheromone;
    }

    public double getPheromone () {
        return pheromone;
    }

    @Override
    public String toString () {
        return "Edge{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
}
}
