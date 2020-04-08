/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionebiblioteca;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
/**
 *
 * @author abefa
 */
public class UserInterface {
    
    UserInterface(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static int inputNumber(String frase){
        int number = 0;
        String input;
        boolean success = false;
        
        Scanner scan = new Scanner(System.in);
            while(success != true){
                System.out.print(frase); 
                input = scan.nextLine();
                try{
                    number = Integer.parseInt(input);
                    break;
                }catch(NumberFormatException e){
                    System.out.println("Inserire solo caratteri numerici. Grazie.");
                    success = false;
                }
            }
            
            return number;
    }
    
    private static String input(String frase){
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
