/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid_19_prediction;

/**
 *
 * @author abefa
 */
public class Interface {
    static int arraySize;
    static public DataStructure[] data = new DataStructure[arraySize];
    
    Interface(ScannerData r){
        for(DataStructure data: data){
            System.out.println(data.getStato() + "    " + data.getData());
        } 
    }
    
}
