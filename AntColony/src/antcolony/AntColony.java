/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antcolony;

/**
 *
 * @author Maria Firdausiah
 */
import Ants.TravelingSalesman;

import java.util.Scanner;





public class AntColony {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            long startTimes = System.currentTimeMillis();
            int ants    = 50;          // Number of ants to run per generation.
            int gen     = 100;          // Number of generations.
            double evap = 0.01;          // Evaporation rate of pheromones.
            int alpha   = 15;            // Impact of pheromones on decision making.
            int beta    = 0;            // Impact of distance on decision making.
            
            System.out.println("Ants per epoch:" + ants);
            System.out.println("Epochs: " + gen);
            System.out.println("Evaporation Rate: " + evap);
            System.out.println("Alpha (pheromone impact): " + alpha);
            System.out.println("Beta (distance impact):   "+ beta);
            System.out.println("Number of Cities: ");
            
            
            
            TravelingSalesman travelingSalesman = new TravelingSalesman(ants, gen, evap, alpha, beta);
            travelingSalesman.run();
            
            long endTimes = System.currentTimeMillis();
            System.out.println("Total Time: "+(endTimes-startTimes));
           
            
            
           
        System.out.println("-------------------------COMPLETE--------------------------");
        
        
    }

   
    
   
    
}
