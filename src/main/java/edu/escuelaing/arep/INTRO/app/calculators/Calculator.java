package edu.escuelaing.arep.INTRO.app.calculators;

import edu.escuelaing.arep.INTRO.app.collections.LinkedList;

/**
 * The type Calculator.
 *
 * @author Davor Cortés
 * @version  1.0
 */
public class Calculator {

    /**
     * The Data.
     */
    protected LinkedList<Double> data;

    /**
     * Instantiates a new Calculator.
     */
    public Calculator(){
        this.data = null;
    }

    /**
     * Put data.
     *
     * @param data the data
     */
    public void putData(LinkedList<Double> data){
        this.data = data;
    }

    /**
     * Erase data.
     */
    public void eraseData(){
        this.data = null;
    }

    /**
     * Show data.
     */
    public void showData(){
        System.out.println(data);
    }

}
