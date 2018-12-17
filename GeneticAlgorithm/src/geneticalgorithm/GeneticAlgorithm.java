/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

 
 import java.io.PrintWriter;
 import java.io.IOException;
import java.io.FileWriter;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import java.util.ArrayList;
    
public class GeneticAlgorithm {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
         // Create and add our cities
        long startTimes = System.currentTimeMillis();
        String dataset = "E:\\SISTEM INFORMASI ITS\\SEM 7\\OKH\\FP\\datasets\\hiddeninstance2.csv";
        File file = new File(dataset); // TODO: read about File Names
        
        try {
            Scanner inputStream = new Scanner(file);
        
            int data=inputStream.nextInt();
            City kota[]=new City[data];
        
            
             int  index=0;
             
            while (inputStream.hasNext()){
            String csv=inputStream.next();
            String array1[]= csv.split(",");
            
            kota[index]=new City(index+1,Integer.parseInt(array1[0]),Integer.parseInt(array1[1]));
            TourManager.addCity(kota[index]);
            index++;
             

        }
        inputStream.close();

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
         
         

        // Initialize population
        Population pop = new Population(25, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());
           
        long startTime = System.currentTimeMillis();
        long endTime   = startTime + 30000;
        // Evolve population for 100 generations
        pop = Algorithm.evolvePopulation(pop);
        //for (int i = 0; i < 100; i++) {
            int gen = 0;
            while(System.currentTimeMillis()<endTime){
                pop = Algorithm.evolvePopulation(pop);
                gen++;
            }
            
        //}

        // Print final results
        System.out.println("Number of cities: " + pop.getFittest().tourSize());
        System.out.println("Generation: "+gen);
        System.out.println("Best Solution:");
        Tour solution = pop.getFittest();
        System.out.println(solution);
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        
        //write solution to csv file in GeneticAlgorithm project folder
        String csvName = "Solution.csv";
        File csvFile = new File(csvName);
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));){
            for(int i=0; i < solution.tourSize(); i++){
                csvWriter.println(solution.getCity(i));
                if (i == solution.tourSize()-1){
                    csvWriter.println(solution.getCity(0));
                }
                
            }
            } catch (IOException e) {
                //Handle exception
                e.printStackTrace();
            }
            long endTimes = System.currentTimeMillis();
         System.out.println("Iteration Time: "+(endTime-startTime));
         System.out.println("Total Time: "+(endTimes-startTimes));
        
    }
    
    
}
