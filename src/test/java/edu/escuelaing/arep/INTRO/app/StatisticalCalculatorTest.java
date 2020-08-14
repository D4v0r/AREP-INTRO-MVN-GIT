package edu.escuelaing.arep.INTRO.app;

import edu.escuelaing.arep.INTRO.app.calculators.CalculatorException;
import edu.escuelaing.arep.INTRO.app.calculators.StatisticalCalculator;
import edu.escuelaing.arep.INTRO.app.collections.LinkedList;
import edu.escuelaing.arep.INTRO.app.file_handling.FileHandler;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for  Statistical calculator.
 *
 * @author  Davor Cortes
 * @version 1.0
 */
public class StatisticalCalculatorTest extends TestCase {

    private static StatisticalCalculator calculator = new StatisticalCalculator();

    /**
     * Instantiates a new Statistical calculator test.
     *
     * @param testName the test name
     */
    public StatisticalCalculatorTest(String testName){
        super(testName);
    }

    /**
     * Suite test.
     *
     * @return the test
     */
    public static Test suite()
    {
        TestSuite suite = new TestSuite( );
        suite.addTest(new StatisticalCalculatorTest("statisticalCalculationTest1"));
        suite.addTest(new StatisticalCalculatorTest("statisticalCalculationTest2"));
        suite.addTest(new StatisticalCalculatorTest("statisticalCalculationTest3WithDataFromATextFile"));
        suite.addTest(new StatisticalCalculatorTest("statisticalCalculationFailure"));
        return suite;
    }

    /**
     * Statistical calculation test
     * Test for column 1.
     */
    public static void statisticalCalculationTest1(){
        String[] estimateProxySize = {"160", "591", "114", "229", "230", "270", "128", "1657", "624", "1503"};
        LinkedList<Double> dataList = new LinkedList<>();
        for (String x:estimateProxySize
             ) {
            Double number = Double.parseDouble(x);
            dataList.add(number);
        }
        calculator.putData(dataList);
        try {
            assertTrue(calculator.mean()== 550.6 && calculator.standarDeviation() == 572.03);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Statistical calculation test 2
     * Test for column 2.
     */
    public static void statisticalCalculationTest2(){
        String[] developmentHours = {"15.0", " 69.9",  "6.5",  "22.4", "28.4", "65.9", "19.4", "198.7", "38.8", "138.2"};
        LinkedList<Double> dataList = new LinkedList<>();
        for (String x:developmentHours
        ) {
            Double number = Double.parseDouble(x);
            dataList.add(number);
        }
        calculator.putData(dataList);
        try {
            assertTrue(calculator.mean()== 60.32 && calculator.standarDeviation() == 62.26);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test for file handler and calculator operations.
     */
    public static void statisticalCalculationTest3WithDataFromATextFile(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.readFile("dataTest1.txt");
        calculator.putData(fileHandler.getFileData().get(0));
        try {
            assertTrue(calculator.mean()== 20.6 && calculator.standarDeviation() == 32.26);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Statistical calculation failure
     * Test failure when calculator's data is null.
     */
    public static void statisticalCalculationFailure(){
        calculator.eraseData();
        try{
            calculator.mean();
        } catch (Exception e){
            assertEquals(e.getMessage(), CalculatorException.NULL_DATA);
        }
    }
}
