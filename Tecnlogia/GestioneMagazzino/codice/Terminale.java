package codice;
import java.util.Scanner;


public class Terminale {

    Terminale(Magazzino m){
        main(m);
    }

    public void main(Magazzino m){
    }










    public static int inputNum(String in){
        Scanner scan = new Scanner(System.in);
        int n = 0;
        boolean state = false;

        while(!state){
            
        try{
            System.out.print(in);  n = Integer.parseInt(scan.nextLine());
            state = true;
        }catch(NumberFormatException e){
            System.out.println("Inserire solo caratteri numerici.");
            state = false;
        }
    }
        return n;
    }

    public static int inputNum(String in, int possibilita){
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int poss = possibilita;
        boolean state = false;
        while(!state){
            try{
                System.out.print(in);  n = Integer.parseInt(scan.nextLine());
                state = true;
            }catch(NumberFormatException e){
                System.out.println("Inserire solo caratteri numerici.");
                state = false;
            }

            if(n == 0 || n > possibilita){
                System.out.println("Inserimento non valido, opzioni valide: da 1 a " + possibilita);
                state = false;
            }
        }
        return n;
    }
}