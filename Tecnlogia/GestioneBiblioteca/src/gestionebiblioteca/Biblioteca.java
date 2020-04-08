/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionebiblioteca;
import java.time.LocalDate;
import java.time.Month;
/**
 *
 * @author abefa
 */

public class Biblioteca{
    private static Nodo head;
    public static int numLibri;
    private static int i = 0;
    private final Nodo headForRestore = head;
    Iteratore it = getIterator();
    public Biblioteca(){
        head = null;
        numLibri = 0;
    }
    
    private Nodo getLinkPosizione(int posizione) throws LibroException{
        int n = 1;
        Nodo p = head;
        
        if(p == null){
            throw new LibroException("Non sono presenti libri in questa biblioteca.");
        }else if((posizione > numLibri) || (posizione < 1)){
            throw new LibroException("Hai inserito una posizione errata.");
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
    
    public void addInQueque(Libro l) throws LibroException{
        if(head == null){
            addAtHead(l);
        }else{
            Nodo lastNodo = getLinkPosizione(numLibri);
            lastNodo.setLink(creaNodo(l,null));
            numLibri++;
        }
    }
    
    public void addAtPosition(Libro l, int posizione) throws LibroException{
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
    
    public void removeAtHead() throws LibroException{
        if(head == null){
            throw new LibroException("La biblioteca non contiene libri.");
        }else{
            head = head.getLink();
            numLibri--;
        }
    }
    
    public void removeInQueque() throws LibroException{
        if(head == null){
            throw new LibroException("La biblioteca non contiene libri");
        }
        
        Nodo nodoScorrimento = getLinkPosizione(numLibri - 1);
        nodoScorrimento.setLink(null);
        numLibri--;
    }
    
    public void removeInPosition(int posizione) throws LibroException{
        if(head == null){
            throw new LibroException("La biblioteca non contiene libri.");
        }else if(posizione > numLibri){
            throw new LibroException("La posizione inserita non e' valida.");
        }else{
            Nodo nodoScorrimento = getLinkPosizione(posizione);
            Nodo nodoPrecedente = getLinkPosizione(posizione - 1);
            
            nodoPrecedente.setLink(nodoScorrimento.getLink());
            numLibri--;
        }
        
    }
    
    public void searchByCode(String code){
        Iteratore iterator = getIterator();
        System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "EDITOR", "CODICE", "DATA PUBBLICAZIONE");
        int counter = 0;
        
        while(iterator.hasNext()){
            Libro l = iterator.next();
            if(l.getCodice() == code){
                counter++;
                System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, l.getTitolo(), l.getEditore(), l.getCodice(), l.getDataPubb());
            }
        }
        iterator.restoreCounting();
    }
    
    public void searchByEditor(String editore){
        Iteratore iterator = getIterator();
        System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "EDITOR", "CODICE", "DATA PUBBLICAZIONE");
        int counter = 0;
        
        while(iterator.hasNext()){
            Libro l = iterator.next();
            if(l.getEditore() == editore){
                counter++;
                System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, l.getTitolo(), l.getEditore(), l.getCodice(), l.getDataPubb());
            }
        }
        iterator.restoreCounting();
    }
    
    public void searchByYear(int anno){
        Iteratore iterator = getIterator();
        System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "EDITOR", "CODICE", "DATA PUBBLICAZIONE");
        int counter = 0;
        
        
        while(iterator.hasNext()){
            Libro l = iterator.next();
            if(l.getDataPubb().getYear() == anno){
                counter++;
                System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, l.getTitolo(), l.getEditore(), l.getCodice(), l.getDataPubb());
            }
        }
        iterator.restoreCounting();
    }
    
    
    public void showAll() throws LibroException{
        int counter = 0;
        Iteratore iterator = getIterator();
        System.out.format("\n|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", "N", "TITOLO", "EDITOR", "CODICE", "DATA PUBBLICAZIONE");

        while(iterator.hasNext()){
            Libro nextLibro = iterator.next();
            counter++;
            System.out.format("|%1$-5s|%2$-30s|%3$-30s|%4$-15s|%5$-20s|\n", counter, nextLibro.getTitolo(), nextLibro.getEditore(), nextLibro.getCodice(), nextLibro.getDataPubb());
            
        }
        
        iterator.restoreCounting();
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
            Libro libro = new Libro(nodo.getInfo());
            nodo = nodo.getLink();
            return libro;
        }
    }
}
