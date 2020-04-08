package ES_Biblioteca;

import java.io.Serializable;
import java.time.*;
public class Biblioteca{    
    private static Nodo head;
    public static int numLibri;
    private static int i = 0;

    public Biblioteca(){
        head = null;
        numLibri = 0;
    }

    private Nodo getLinkPosizione(int posizione){
        int n = 1;
        Nodo p = head;
        
        if(p == null){
            System.out.println("Posizione errata.");
        }else if((posizione > numLibri) || (posizione < 1)){
            System.out.println("Posizione errata.");
        }
        
        
        while(p.getLink() != null && n < posizione){
            p = p.getLink();
            n++;
        }
        return p;
    }

    private Nodo creaNodo(Libro l, Nodo link){
        Nodo nodoLibro = new Nodo(l);
        nodoLibro.setLink(link);
        return nodoLibro;
    }

    public void addAtHead(Libro l){
        Nodo nodoLibro = new Nodo(l,head);
        head = nodoLibro;
        numLibri++;
    }

    public void addInQueque(Libro l){
        if(head == null){
            addAtHead(l);
        }else{
            Nodo lastNodo = getLinkPosizione(numLibri);
            lastNodo.setLink(creaNodo(l,null));
            numLibri++;
        }
    }

    public void addAtPosition(Libro l, int posizione){
        if(head == null){
            addAtHead(l);
        }else{
            if(posizione > numLibri){
                addInQueque(l);
            }else{
                Nodo nodoScorr = getLinkPosizione(posizione - 1);
                nodoScorr.setLink(creaNodo(l,nodoScorr.getLink()));
                numLibri++;
            }
        }
    }

    public boolean removeAtHead(){
        if(head == null){
            return false;
        }else{
            head = head.getLink();
            numLibri--;
            return true;
        }
    }

    public boolean removeInQueque(){
        if(head == null){
            return false;
        }
        
        Nodo nodoScorrimento = getLinkPosizione(numLibri - 1);
        nodoScorrimento.setLink(null);
        numLibri--;
        
        return true;
    }

    public boolean removeInPosition(int posizione){
        if(head == null){
            return false;
        }else if(posizione > numLibri){
            return false;
        }else{
            Nodo nodoScorrimento = getLinkPosizione(posizione);
            Nodo nodoPrecedente = getLinkPosizione(posizione - 1);
            
            nodoPrecedente.setLink(nodoScorrimento.getLink());
            numLibri--;
            return true;
        }
        
    }

    public void cercaTitolo(String titolo){
        int counter = 0;
        Iteratore it = getIterator();

        while(it.hasNext()){
            Libro nextLibro = it.next();
            if(nextLibro.getTitolo().equals(titolo)){
                counter++;
                if(counter == 1){
                    System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "CASA EDITRICE", "CODICE", "DATA PUBBLICAZIONE");
                }
                System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, nextLibro.getTitolo(), nextLibro.getEditore(), nextLibro.getCodice(), nextLibro.getDataPubb());
            }
        }

        if(counter == 0){
            System.out.println("\nNon stati trovati risultati che corrispondono al criterio di ricerca da lei inserito.");
        }
    }

    public void cercaAnno(int anno){
        int counter = 0;
        Iteratore it = getIterator();

        while(it.hasNext()){
            
            Libro nextLibro = it.next();
            if(nextLibro.getDataPubb().getYear() == anno){
                counter++;
                if(counter == 1){
                    System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "CASA EDITRICE", "CODICE", "DATA PUBBLICAZIONE");
                }
                System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, nextLibro.getTitolo(), nextLibro.getEditore(), nextLibro.getCodice(), nextLibro.getDataPubb());

            }
        }

        if(counter == 0){
            System.out.println("\nNon stati trovati risultati che corrispondono al criterio di ricerca da lei inserito.");
        }
    }

    public void cercaEditore(String editore){
        int counter = 0;
        Iteratore it = getIterator();

        while(it.hasNext()){
            
            Libro nextLibro = it.next();
            if(nextLibro.getEditore().equals(editore)){
                counter++;
                if(counter == 1){
                    System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "CASA EDITRICE", "CODICE", "DATA PUBBLICAZIONE");
                }
                System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, nextLibro.getTitolo(), nextLibro.getEditore(), nextLibro.getCodice(), nextLibro.getDataPubb());

            }
        }

        if(counter == 0){
            System.out.println("\nNon stati trovati risultati che corrispondono al criterio di ricerca da lei inserito.");
        }
    }

    public void cercaCodice(String codice){
        int counter = 0;
        Iteratore it = getIterator();

        while(it.hasNext()){
            
            Libro nextLibro = it.next();
            if(nextLibro.getEditore().equals(codice)){
                counter++;
                if(counter == 1){
                    System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "CASA EDITRICE", "CODICE", "DATA PUBBLICAZIONE");
                }
                System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, nextLibro.getTitolo(), nextLibro.getEditore(), nextLibro.getCodice(), nextLibro.getDataPubb());

            }
        }

        if(counter == 0){
            System.out.println("\nNon stati trovati risultati che corrispondono al criterio di ricerca da lei inserito.");
        }
    }

    public void showAll(){
        Iteratore it = getIterator();
        int counter = 0;
        while(it.hasNext()){
            Libro nextLibro = it.next();
            if(counter == 0){
                System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "CASA EDITRICE", "CODICE", "DATA PUBBLICAZIONE");
            }
            counter++;
            System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, nextLibro.getTitolo(), nextLibro.getEditore(), nextLibro.getCodice(), nextLibro.getDataPubb());
        }
    }
    public Iteratore getIterator(){
        Iteratore it = new Iteratore(head);
        return it;
    }

    //CLASSE LIBRO
    public class Libro{
        private String titolo;
        private String editore;
        private String codice;
        private LocalDate annoPubblicazione;
        
        Libro(String titolo, String editore, String codice, LocalDate annoPubb){
            this.titolo = titolo;
            this.editore = editore;
            this.codice = codice;
            this.annoPubblicazione = annoPubb;
        }
        Libro(Libro l){
            this.titolo = l.getTitolo();
            this.editore = l.getEditore();
            this.codice = l.getCodice();
            this.annoPubblicazione = l.getDataPubb();
        }
        
        public String getTitolo(){
            return this.titolo;
        }
        public String getEditore(){
            return this.editore;
        }
        public String getCodice(){
            return this.codice;
        }
        public LocalDate getDataPubb(){
            return this.annoPubblicazione;
        }
    }
    
    //CLASSE LIBRO EXCEPTION
    public class LibroException extends Exception{
        private String messaggio;
        
        public LibroException(String messaggio){
            this.messaggio = messaggio;
        }
        
        public void getError(){
            System.out.println(messaggio);
        }
    }
    
    
    //CLASSE NODO
    private class Nodo{
        private Libro info;
        private Nodo link;
        
        Nodo(Libro info){
            this.info = info;
            this.link = null;
        }
        Nodo(Libro info, Nodo link){
            this.info = info;
            this.link = link;
        }
        
        public void setInfo(Libro lib){
            this.info = lib;
        }
        public void setLink(Nodo link){
            this.link = link;
        }
        public Libro getInfo(){
            return this.info;
        }
        public Nodo getLink(){
            return this.link;
        }
    }
    
    
    //CLASSE ITERATORE
    public class Iteratore{
        private Nodo nodo;
        private Nodo restore = nodo;
        
        Iteratore(Nodo n){
            this.nodo = n;
            restore = n;
        }
        Iteratore(){
            
        }
        public void restoreCounting(){
            this.nodo = restore;
        }
        public boolean hasNext(){
            return (!(nodo == null));
        }
        
        public Libro next(){
            if(nodo == null){
                return null;
            }
            Libro l = nodo.getInfo();
            nodo = nodo.getLink();
            return l;
        }
    }


}