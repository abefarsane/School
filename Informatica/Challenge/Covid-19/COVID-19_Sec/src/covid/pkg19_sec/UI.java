/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19_sec;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author abefa
 */
public class UI {
    private String choice;
    private TakeData_csv tk ;
    private DataStructure[] data;
    private String format = "|%1$-15s|%2$-12s|%3$-8s|"
                +                       "%3$-8s|%3$-8s|%3$-8s|"
                +                       "%3$-8s|%3$-8s|%3$-8s|"
                +                       "%3$-8s|%3$-8s|";
            
    
    UI() throws FileNotFoundException{
        this.tk = new TakeData_csv();
        this.data = tk.data;
        System.out.format(, 
                                        tk.firstLine[0],tk.firstLine[1],tk.firstLine[2].replace('_', ' '),tk.firstLine[3],
                                        tk.firstLine[4],tk.firstLine[5],tk.firstLine[6],tk.firstLine[7],
                                        tk.firstLine[8],tk.firstLine[9],tk.firstLine[10]);
    }
}
