package edu.escuelaing.arep.INTRO.app;

import edu.escuelaing.arep.INTRO.app.calculators.StatisticalCalculator;
import edu.escuelaing.arep.INTRO.app.collections.LinkedList;
import edu.escuelaing.arep.INTRO.app.file_handling.FileHandler;


/**
 * The main class in charge of processing the data and using the calculator.
 *
 * @author  Davor Cortés
 * @version 1.0
 */
public class App
{
    /**
     * The Calculator.
     */
    static StatisticalCalculator calculator = new StatisticalCalculator();

    /**
     * The entry point of application and data processing.
     *
     * @param args the input arguments
     */
    public static void main( String[] args ) {
        try {
            FileHandler fileHandler = new FileHandler();
            fileHandler.readFile(args[0]);
            int row = 1;
            for (LinkedList<Double> dataList:  fileHandler.getFileData()
            ) {
                calculator.putData(dataList);
                System.out.println("--------------------------------------------------------");
                System.out.println(" + Statistical Calculations for row " + row);
                System.out.println("    >  Arithmetic Mean: " + calculator.mean());
                System.out.println("    >  Standard Deviation: " + calculator.standarDeviation());
                System.out.println("--------------------------------------------------------");
                row ++;
            }
        } catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
}

