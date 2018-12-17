/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ants;

/**
 *
 * @author Maria Firdausiah
 */


import Graph.*;
public class TravelingSalesman {
    
    private Graph graph;
    private int numOfAnts, generations;
   
     //private Thread theThread;
    


    /**
     * Construct TravelingSalesman.
     * @param ants          the number of ants to run per generation
     * @param generations   the number of generations to run
     * @param evaporation   the rate of evaporation
     * @param alpha         the impact of pheromones on decision making
     * @param beta          the impact of distance in decision making
     */
    public TravelingSalesman (int ants, int generations, double evaporation, int alpha, int beta) {
        this.numOfAnts = ants;
        this.generations = generations;
        graph = IO.Import.getGraph(evaporation, alpha, beta);
    }

    /**
     * Run the algorithm.
     */
    public void run () {
        long startTime = System.currentTimeMillis();
        long endTime   = startTime + 30000;
        int gen = 0;
        
        Ant bestAnt = null;
        int bestEval = 0;

        
        
        
        while(System.currentTimeMillis()<endTime){
            Ant[] ants = createAnts(numOfAnts);
            Ant ant = travel(ants);
            updatePheromones(ants);
            
                if (bestAnt == null) {
                    bestAnt = ant;
                    bestEval = ant.eval();
                } else if (ant.eval() < bestEval) {
                    bestAnt = ant;
                    bestEval = ant.eval();
                }
                    gen++;
        }
           
        System.out.println("Generation: "+gen);
        System.out.print("Best Solution: ");
        System.out.println(bestAnt);
        System.out.println("Final Distance: " + bestEval);
        System.out.println("Iteration Time: "+(endTime-startTime));
        
    }

    /**
     * Create ants and put them on random starting positions on the graph.
     * @param quantity  the quantity of ants to create
     * @return          an array of the ants created
     */
    private Ant[] createAnts (int quantity) {
        Ant[] ants = new Ant[quantity];
        for (int i = 0; i < quantity; i++) {
            ants[i] = new Ant(graph);
        }
        return ants;
    }

    /**
     * Let each ant in the input array travel until an entire tour is completed.
     * @param ants      the ants to allow to travel
     * @return          the ant with the best evaluation
     */
    private Ant travel (Ant[] ants) {

        Ant bestAnt = null;
        int bestEval = 0;

        for (Ant ant : ants) {
            while (ant.notFinished()) {
                ant.travel();
            }

            if (bestAnt == null) {
                bestAnt = ant;
                bestEval = ant.eval();
            } else if (ant.eval() < bestEval) {
                bestAnt = ant;
                bestEval = ant.eval();
            }
        }

        return bestAnt;
    }

    /**
     * Update the pheromones in the graph based on an array of ants with
     * completed tours.
     * @param ants  the ants that will be used to update the pheromones
     */
    private void updatePheromones (Ant[] ants) {
        for (Ant ant : ants) {
            graph.updatePheromone(ant);
        }
    }

    /**
     * Sleep the thread for a specified amount of time.
     * @param ms    milliseconds to sleep for
     */
    private static void delay (int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//   
//    public void stop () {
//        
//       try {
//            //assuming it takes 20 secs to complete the task
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
