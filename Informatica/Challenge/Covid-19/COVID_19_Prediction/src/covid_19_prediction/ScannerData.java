/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid_19_prediction;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author abefa
 */
public class ScannerData {
    private Scanner scanData;
    private String path = "/Users/" + System.getProperty("user.name") + "/Desktop/dati-andamento-nazionale/dpc-covid19-ita-andamento-nazionale.csv";
    String[] header;
    String[] strSplit;
    
    
    
    ScannerData() throws FileNotFoundException{
        exeScan();
    }
    
    void exeScan() throws FileNotFoundException{
        
        File fileCSV = new File(path);
        scanData = new Scanner(fileCSV);
        header = scanData.nextLine().split(";");
        while(scanData.hasNextLine()){
            Interface.arraySize++;
        }
        int i = 0;
        while(scanData.hasNextLine()){
            strSplit = scanData.nextLine().split(";");
            Interface.data[i] = new DataStructure(strSplit[0],strSplit[1],strSplit[6],strSplit[7],strSplit[8],strSplit[11],strSplit[10]);
            i++;
        }
        
    }
}
