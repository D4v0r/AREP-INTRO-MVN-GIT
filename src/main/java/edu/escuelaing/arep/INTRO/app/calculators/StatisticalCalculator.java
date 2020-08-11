package edu.escuelaing.arep.INTRO.app.calculators;


/**
 * The type Statistical calculator.
 */
public class StatisticalCalculator extends Calculator{


    /**
     * Instantiates a new Statistical calculator.
     */
    public StatisticalCalculator() {
        super();
    }

    /**
     * Calculate the Mean.
     *
     * @return mean of dataset.
     * @throws CalculatorException the calculator exception
     */
    public double mean() throws  CalculatorException{
        if(data == null) throw  new  CalculatorException(CalculatorException.NULL_DATA);
        double calculation = 0;
        for (Double x:data
             ) {
            calculation += x / data.size();
        }
        calculation = Math.round(calculation * 100);
        return calculation / 100;
    }

    /**
     * Calculate Standar deviation.
     *
     * @return standar deviation of dataset.
     * @throws CalculatorException the calculator exception
     */
    public double standarDeviation() throws  CalculatorException{
        if(data == null) throw  new  CalculatorException(CalculatorException.NULL_DATA);
        double calculation = 0;
        double mean =  mean();
        for (Double x: data
            ){
            calculation += Math.pow(x - mean, 2)/(data.size() - 1);
        }
        calculation = Math.sqrt(calculation);
        calculation = Math.round(calculation * 100);
        return calculation / 100;
    }

}
