package edu.escuelaing.arep.INTRO.app.file_handling;

import edu.escuelaing.arep.INTRO.app.collections.LinkedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type File handle to read data from file text.
 *
 * @author Davor Cortés
 * @version 1.0
 */
public class FileHandler {

    private ArrayList<String[]> fileData;

    /**
     * Instantiates a new File handler.
     */
    public FileHandler(){
        fileData = new ArrayList<>();
    }

    /**
     * Gets file data.
     *
     * @return the file data
     */
    public ArrayList<String[]> getFileData() {
        return fileData;
    }

    /**
     * Read file.
     *
     * @param fileName the file name
     */
    public void readFile(String fileName){
            try {
                String path = "data/" + fileName;
                BufferedReader br = new BufferedReader(new java.io.FileReader(new File(path)));
                String st = "";
                while ((st = br.readLine()) != null) {
                    LinkedList<Double> dataList = new LinkedList<Double>();
                    fileData.add( st.split(" "));
                }
            } catch (IOException e){
                System.out.println("An error has occurred while reading the file");
                e.printStackTrace();
            }
    }
}
