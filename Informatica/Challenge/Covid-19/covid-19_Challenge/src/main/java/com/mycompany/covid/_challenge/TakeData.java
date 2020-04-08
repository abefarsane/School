/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covid._challenge;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author abefa
 */
public class TakeData {
    private String[] allData;
    private int numDays;
    public Data[] arrayGiorni;
    
    public TakeData() throws FileNotFoundException,IOException{
        Scanner scan = new Scanner(new File("C:\\Users\\abefa\\Desktop\\Scuola\\Informatica\\Challenge\\Covid-19\\covid-19_Challenge\\dati-andamento-nazionale\\dpc-covid19-ita-andamento-nazionale.csv"));
        String cons = scan.nextLine();
        while(scan.hasNextLine()){
            numDays++;
        }
        setNewObj(numDays,scan);
    }
    
    
    private void setNewObj(int n_obj,Scanner scan){
        this.arrayGiorni = new Data[n_obj];
        
        for(int i = 0; i<n_obj;i++){
            allData = scan.nextLine().split(";");
            arrayGiorni[i] = new Data(allData[5],allData[6],allData[9]);
        }
    }
}
