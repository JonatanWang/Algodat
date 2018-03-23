/*
 * Skapa en klass Car som innehåller bilmärke, 
 * årsmodell och antal körda mil. 
 * Klassen ska implementera Comparable<Car> 
 * och därmed ha en metod compareTo 
 * som ska jämföra bilmärke som sträng mellan bilar.
 * a) Skriv ett program som läser in bilar från en textfil till en array 
 * och sorterar dessa med hjälp av Java API utifrån metoden compareTo. 
 * Skriv sedan ut dessa till en ny textfilen.
 * b) Skapa nu en klass CompareCar som implementerar Comparator<Car> 
 * och använd denna för att sortera bilarna efter årsmodell istället. 
 * Skriv även ut denna ordning men till en annan fil.
 */
package T10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB27 {
    
    private static class CarSorter {
 
        private String dir;
        private Car[] cars;
        private List<Car> carsList;
        
        public CarSorter(String dir) {
            
            this.dir = dir;
            
            try {
            
                BufferedReader in = new BufferedReader(new FileReader(dir));
                int numLines = 0;
                String line = "";
                Queue<String> tokens = new LinkedList<>();
                while((line = in.readLine()) != null) {
                    tokens.offer(line);
                    numLines ++;
                }
                this.cars = new Car[numLines];
                this.carsList = new ArrayList<>();
                for (int i = 0; (i < cars.length && !tokens.isEmpty()); i ++) {
                    
                    String[] item = tokens.poll().split(" ");
                    cars[i] = new Car(item[0], item[1], item[2]);
                    carsList.add(cars[i]);
                
                }
                System.out.println("Unsorted: ");
                for (Car c : cars) {
                    System.out.println(c.toString());
                }
                
            } catch(IOException e) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
        
        public void sortByBrand() {
            Arrays.sort(this.cars);
            System.out.println("\nSorted by brand: ");
            for (Car c : cars) {
                    System.out.println(c.toString());
            }
        }
        
        public void sortByYear() {
            Collections.sort(carsList, new CompareCar());
            System.out.println("\nSorted by year: ");
            for (Car c : cars) {
                    System.out.println(c.toString());
            }
        }

        private void writeToFileByBrand(String fileName, Car[] cars) throws IOException {
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Car car : cars) {
                    writer.write(car.getBrand() + "\t\t");
                    writer.write(car.getYear() + "\t\t");
                    writer.write(car.getMilage() + "\t\t");
                    writer.newLine();
                }
                writer.flush();
            }
        }
           
        private void writeToFileByYear(String fileName, ArrayList carsList) throws IOException {
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Iterator it = carsList.iterator(); it.hasNext();) {
                    Car car = (Car) it.next();
                    writer.write(car.getBrand() + "\t\t");
                    writer.write(car.getYear() + "\t\t");
                    writer.write(car.getMilage() + "\t\t");
                    writer.newLine();
                }
                writer.flush();
            }
        }
    }
       
    public static void main(String[] args) {
                   
        String filePathRead = "src/T10/cars";
        String filePathWrite = "src/T10/carsByBrand";
        String filePathWriteList = "src/T10/carsByYear";
        CarSorter sorter = new CarSorter(filePathRead);
        sorter.sortByBrand();
        sorter.sortByYear();
        try {
            sorter.writeToFileByBrand(filePathWrite, sorter.cars);
            sorter.writeToFileByYear(filePathWriteList, (ArrayList<Car>) sorter.carsList);
        } catch (IOException ex) {
            Logger.getLogger(NB27.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
