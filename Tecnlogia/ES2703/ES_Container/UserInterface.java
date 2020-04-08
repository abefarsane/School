package ES_Container;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;
import java.text.NumberFormat;

public class UserInterface {
    private Deposito exe = new Deposito();

    
    UserInterface(){
        Deposito.Piazza p1 = exe.new Piazza();
        Deposito.Piazza p2 = exe.new Piazza();
        Deposito.Piazza p3 = exe.new Piazza();
        Deposito.Piazza p4 = exe.new Piazza();
        Deposito.Piazza p5 = exe.new Piazza();

        Deposito.Piazza.Container c1 = p1.new Container(86995,"Testo descrittivo.");
        Deposito.Piazza.Container c2 = p1.new Container(36289,"Testo descrittivo.");
        Deposito.Piazza.Container c3 = p2.new Container(28171,"Testo descrittivo.");
        Deposito.Piazza.Container c4 = p2.new Container(99827,"Testo descrittivo.");
        Deposito.Piazza.Container c5 = p2.new Container(44392,"Testo descrittivo.");
        Deposito.Piazza.Container c6 = p2.new Container(59287,"Testo descrittivo.");
        Deposito.Piazza.Container c7 = p2.new Container(12098,"Testo descrittivo.");
        Deposito.Piazza.Container c8 = p2.new Container(32922,"Testo descrittivo.");
        Deposito.Piazza.Container c9 = p2.new Container(13278,"Testo descrittivo.");
        Deposito.Piazza.Container c10 = p2.new Container(29348,"Testo descrittivo.");
        Deposito.Piazza.Container c11 = p2.new Container(78312,"Testo descrittivo.");
        Deposito.Piazza.Container c12 = p2.new Container(34898,"Testo descrittivo.");
        Deposito.Piazza.Container c13 = p2.new Container(23882,"Testo descrittivo.");

        p1.push(c1);
        p1.push(c2);
        p2.push(c3);
        p2.push(c4);
        p2.push(c5);
        p2.push(c6);
        p2.push(c7);
        p3.push(c8);
        p3.push(c9);
        p4.push(c10);
        p4.push(c11);
        p4.push(c12);
        p5.push(c13);

        exe.addAtQueque(p1);
        exe.addAtQueque(p2);
        exe.addAtQueque(p3);
        exe.addAtQueque(p4);
        exe.addAtQueque(p5);
    }

    public void mainMenu() throws IOException, InterruptedException {
        System.out.println("_______________________________________________________________________________________");
        System.out.println("                                    -- BENVENUTO --                                    ");
        System.out.println("---------------------------------------------------------------------------------------\n\n");

        System.out.println(" 1 - Visualizza le piazze e il numero di container stanziati in ognuna delle piazze.");
        System.out.println(" 2 - Analizza una piazza nello specifico.");
        System.out.println(" 3 - Cerca container.");
        System.out.println(" 4 - Rimuovi/Aggiungi container.");
        System.out.println(" 5 - Termina esecuzione.\n");

        switch(inputNum("\nDigita il numero dell'opzione desiderata: ",5)){
            case 1:{
                clean();
                System.out.println("\nElenco piazze disponibili nel deposito.\n");
                exe.showAll();
                break;
            }
            case 2:{
                clean();
                System.out.println("\nElenco piazze presenti nel deposito.\n");
                exe.showAll();
                int pos = inputNum("\nInserisci il numero della piazza da analizzare:  ",exe.getNumPiazze());
                Deposito.Piazza piazza = exe.getLinkPosizione(pos).getInfo();
                System.out.println("\nPiazza numero " + pos);
                if(piazza.getNumContainer() == 0){
                    System.out.println("Lista vuota. Non e' possibile analizzare alcun container.");
                    break;
                }else{
                piazza.showAll();
                break;
                }
            }
            case 3:{
                boolean stato = true;
                
                    do{
                        clean();
                        System.out.println("Numero totale container presenti in deposito: " + exe.getNumTotContainer());
                        int code = inputNum("\nInserire il codice identificativo del container da trovare:  ");
                        Deposito.Piazza.Container c = exe.searchContainerByCode(code);
                        if(c != null){
                            System.out.format("\n|%1$-30s|%2$-50s|", "CODICE IDENTIFICATIVO","DESCRIZIONE"); 
                            System.out.format("\n|%1$-30s|%2$-50s|", c.getCode(), c.getInfo());
                        }else{
                        }
                        
                        if(inputNum("\nCerca nuovo container (1) o termina esecuzione operazione (2):  ",2) == 1){
                            stato = true;
                            clean();
                        }else{
                            stato = false;
                        }
                    }while(stato);
                break;
            }
            case 4:{
                clean();
                System.out.println("\nNumero totale container presenti in deposito: " + exe.getNumTotContainer());
                System.out.println("\nElenco piazze presenti nel deposito.\n");
                exe.showAll();

                switch(inputNum("\nDigita (1) per prelevare container oppure (2) per impilare nuovo container:  ",2)){
                    case 1:{ 
                        int pos = inputNum("\n\nInserisci il numero della piazza da cui prelevare il container:  ",exe.getNumPiazze());
                        Deposito.Piazza piazza = exe.getLinkPosizione(pos).getInfo();
                        
                        if(piazza.getNumContainer() == 0){
                            System.out.println("\nLA PIAZZA NUMERO " + pos + " E' VUOTA.");
                            break;
                        }else{
                            System.out.println("\nPiazza numero " + pos);
                            piazza.showAll();
                            piazza.pop();
                            System.out.println("\nPiazza numero " + pos + " aggiornata.");
                            piazza.showAll();
                            break;
                        }

                    }
                    case 2:{
                        int pos = inputNum("\n\nInserisci il numero della piazza dove piazzare il nuovo container:  ",exe.getNumPiazze());
                        Deposito.Piazza piazza = exe.getLinkPosizione(pos).getInfo();
                        
                        if(piazza.getNumContainer() == 5){
                            System.out.println("\nLA PIAZZA NUMERO " + pos + " HA RAGGIUNTO IL NUMERO MASSIMO DI CONTAINER IMPILABILI.");
                            break;
                        }else{
                            System.out.println("\nPiazza numero " + pos);
                            piazza.showAll();
                            piazza.push(setContainerInfo());
                            System.out.println("\nPiazza numero " + pos + " aggiornata dopo impilamento nuovo container.");
                            piazza.showAll();
                            break;
                        }
                    }
                }
                break;
            }
            case 5:{
                System.exit(0);
                break;
            }
        }
        askReturn();
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

    public void askReturn() throws IOException, InterruptedException {
        switch(inputNum("\n\nTornare al menu principale (1) o terminare il programma? (2):  ",2)){
            case 1:{
                clean();
                mainMenu(); 
                break;
            }
            case 2:{
                System.exit(0);
                break;
            }
        }
    }
    public void clean() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public Deposito.Piazza.Container setContainerInfo(){
        int code = inputNum("\n\nInserisci codice da dare al nuovo container:  ");
        String descrizione = input("Inserisci una descrizione breve per il contenuto del container:  ");
        Deposito.Piazza p = exe.new Piazza();
        return p.new Container(code,descrizione);
    }
}