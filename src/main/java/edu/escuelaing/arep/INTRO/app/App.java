package edu.escuelaing.arep.INTRO.app;

import edu.escuelaing.arep.INTRO.app.calculators.StatisticalCalculator;
import edu.escuelaing.arep.INTRO.app.collections.LinkedList;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App
{
    static StatisticalCalculator calculator = new StatisticalCalculator();
    
    public static void main( String[] args )
    {
        try{
            String filePath = "data/"+args[0];
            File file = new File(filePath);
            BufferedReader br = new BufferedReader( new FileReader(file));
            String st = "";
            int iteration = 1;
            while ((st = br.readLine()) != null) {
                LinkedList<Double> dataList = new LinkedList<Double>();
                String[] dataStream = st.split(" ");
                for (String data:dataStream
                     ) {
                    dataList.add(Double.parseDouble(data));
                }
                makeCalculations(dataList, iteration);
                iteration ++;
            }
        } catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    private static void makeCalculations(LinkedList<Double> dataList, int row){
        calculator.putData(dataList);
        System.out.println("--------------------------------------------------------");
        try {
            System.out.println(" + Statistical Calculations for row " + row);
            System.out.println("    >  Arithmetic Mean: " + calculator.mean());
            System.out.println("    >  Standard Deviation: " + calculator.standarDeviation());
            System.out.println("--------------------------------------------------------");
        }catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

    }
}
