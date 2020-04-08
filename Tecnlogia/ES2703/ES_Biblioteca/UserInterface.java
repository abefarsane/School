package ES_Biblioteca;

import java.util.Scanner;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Serializable;


public class UserInterface{
    private Biblioteca exe = new Biblioteca();

    public void addExamples(){
        Biblioteca.Libro l1 = exe.new Libro("La sabbia e le stelle.", "SEI", "9788805070794", LocalDate.of(2000, 5, 7));
        Biblioteca.Libro l2 = exe.new Libro("Divina Commedia.", "Mondadori Education", "9788800228572", LocalDate.of(2017, 3, 2));
        Biblioteca.Libro l3 = exe.new Libro("Storia e storiografia plus. ", "D'Anna", "788881049820", LocalDate.of(2020, 9, 23));
        Biblioteca.Libro l4 = exe.new Libro("La sabbia e le stelle.", "Trinity Whitebridge", "9780194512831", LocalDate.of(2020, 11, 7));
        Biblioteca.Libro l5 = exe.new Libro("First masterclass.", "Oxford University Press", "9780194512831", LocalDate.of(2020, 1, 22));
    
        exe.addAtHead(l1);
        exe.addInQueque(l2);
        exe.addAtHead(l3);
        exe.addAtHead(l4);
        exe.addAtHead(l5);
    }
    
    UserInterface(){
        addExamples();
    }

    public void mainMenu() throws IOException, InterruptedException{
        clean();
        System.out.println("_______________________________________________________________________________________");
        System.out.println("                                    -- BENVENUTO --                                    ");
        System.out.println("---------------------------------------------------------------------------------------\n\n");
        System.out.println(" 1 - Visualizza elenco completo.");
        System.out.println(" 2 - Modifica elenco.");
        System.out.println(" 3 - Filtra.");
        System.out.println(" 4 - Chiudi programma.\n"); 
        
        switch(inputNum("Digita il numero dell'opzione desiderata: ",4)){
            case 1:{
                System.out.println("Elenco completo:");
                exe.showAll();
                askReturn();
                break;
            }
            case 2:{
                System.out.println("\nModifica elenco: ");
                System.out.println(" 1 - Rimuovi libro.");
                System.out.println(" 2 - Aggiungi libro.");
                System.out.println("\n\nElenco completo:");
                exe.showAll();

                switch(inputNum("\nDigita il numero dell'opzione desiderata: ",3)){
                    case 1:{
                        System.out.println("\nOPZIONI: ");
                        System.out.println(" 1 - Rimuovi in coda.");
                        System.out.println(" 2 - Rimuovi in testa.");
                        System.out.println(" 3 - Rimuovi in posizione.");

                        switch(inputNum("\nDigita il numero dell'opzione desiderata: ",3)){
                            case 1:{
                                if(exe.removeInQueque()){
                                    System.out.println("\nRimozione in coda avvenuta con successo.");
                                }else{
                                    System.out.println("\nErrore durante la rimozione in coda, lista vuota.");
                                }
                                askReturn();
                                break;
                            }
                            case 2:{
                                if(exe.removeAtHead()){
                                    System.out.println("\nRimozione in testa avvenuta con successo.");
                                }else{
                                    System.out.println("\nErrore durante la rimozione in testa, lista vuota.");
                                }
                                askReturn();
                                break;
                            }
                            case 3:{
                                int pos = inputNum("Numero posizione:  ");
                                if(exe.removeInPosition(pos)){
                                    System.out.println("\nRimozione in posizione [" + pos + "] avvenuta con successo.");
                                }else{
                                    System.out.println("\nErrore durante la rimozione in posizione [" + pos + "]. (Lista vuota o posizione inserita invalida)");
                                }
                                askReturn();
                                break;
                            }
                        }
                        askReturn();
                        break;
                    }
                    case 2:{
                        System.out.println("\nOPZIONI: ");
                        System.out.println(" 1 - Aggiungi in coda.");
                        System.out.println(" 2 - Aggiungi in testa.");
                        System.out.println(" 3 - Aggiungi in posizione.");

                        switch(inputNum("\nDigita il numero dell'opzione desiderata: ",3)){
                            case 1:{
                                exe.addInQueque(setBookData());
                                System.out.println("\nLibro aggiunto con successo. ");
                                break;
                            }
                            case 2:{
                                exe.addAtHead(setBookData());
                                System.out.println("\nLibro aggiunto con successo.");
                                break;
                            }
                            case 3:{
                                exe.addAtPosition(setBookData(), inputNum("\nPosizione di inserimento:  "));
                                System.out.println("\nLibro aggiunto con successo.");
                                break;
                            }
                        }
                        askReturn();
                        break;
                    }
                }
                break;
            }
            case 3:{
                System.out.println("\nOPZIONI:  ");
                System.out.println(" 1 - Filtra per titolo.");
                System.out.println(" 2 - Filtra per editore.");
                System.out.println(" 3 - Filtra per codice.");
                System.out.println(" 4 - Filtra per anno.");

                switch(inputNum("\nDigita il numero dell'opzione desiderata: ",4)){
                    case 1:{
                        exe.cercaTitolo(input("Inserire titolo da cercare:  "));
                        break;
                    }
                    case 2:{
                        exe.cercaEditore(input("Inserire editore da cercare:  "));
                        break;
                    }
                    case 3:{
                        exe.cercaCodice(input("Inserire codice da cercare:  "));
                        break;
                    }
                    case 4:{
                        exe.cercaAnno(inputNum("Inserire anno da cercare:  "));
                        break;
                    }
                }
                askReturn();
                break;
            }                     
            case 4:{
                System.exit(0);
            }
            break;
        }
    }




    public static String input(String in){
        Scanner scan = new Scanner(System.in);
        System.out.print(in); return scan.nextLine();
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

    public void askReturn() throws IOException, InterruptedException{
        switch(inputNum("\nTornare al menu principale (1) o terminare il programma? (2)",2)){
            case 1:{
                mainMenu(); 
                break;
            }
            case 2:{
                System.exit(0);
                break;
            }
        }
    }

    public Biblioteca.Libro setBookData(){
        System.out.println("DATI SUL LIBRO");
            String titolo = input("Titolo:  ");
            String editore = input("Casa editrice:  ");
            String codice = input("Codice:  ");
            System.out.println("Data pubbicazione");
            boolean state = false;
            Biblioteca.Libro lib = null;


        while(!state){
            try{
                int anno = inputNum("Anno:    ");
                int mese = inputNum("Mese:    ");
                int gg = inputNum("Giorno:  ");
                lib = exe.new Libro(titolo, editore, codice, LocalDate.of(anno, mese, gg));
                state = true;
            }catch(java.time.DateTimeException w){
                System.out.println("\nErrore di inserimento della data. Reinseriscila.\n");
                state = false;
            }
        }
        return lib;
    }

    public void clean() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

}