/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid_19_prediction;
import java.io.*;
/**
 *
 * @author abefa
 */
public class COVID_19_Prediction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ScannerData r = new ScannerData();
        Interface ui = new Interface(r);
    }
    
}
