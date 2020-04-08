/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19_sec;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author abefa
 */
public class TakeData_csv {
    private String[] splitString;
    private int num_data = 0;
    public DataStructure[] data = new DataStructure[17];
    public String[] firstLine;
    
    
    TakeData_csv() throws FileNotFoundException{
        scanner();
    }
    
    public void scanner() throws FileNotFoundException{
        String path ="C:\\Users\\abefa\\Desktop\\Scuola\\Informatica\\Challenge\\Covid-19\\COVID-19-master\\dati-andamento-nazionale\\dpc-covid19-ita-andamento-nazionale.csv";
        Scanner scan = new Scanner(new File(path));
        this.firstLine = scan.nextLine().split(";");
        int i = 0;
        while(scan.hasNextLine()){
            splitString = scan.nextLine().split(";");
            data[i] = new DataStructure(Integer.parseInt(splitString[6]),Integer.parseInt(splitString[7]));
            i++;
        }
    }
}
