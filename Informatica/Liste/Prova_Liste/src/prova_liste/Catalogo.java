/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_liste;
import java.util.*;
/**
 *
 * @author crist
 */
public class Catalogo {
    LinkedList<Automobile> catalogo;
    public Catalogo(){
        catalogo=new LinkedList<Automobile>();
    }
    public void aggiungiAutomobile(Automobile a){
        catalogo.add(a.clone());
    }
    public void eliminaProdotto(int codice){
        Iterator<Automobile> i=catalogo.iterator();
        Automobile a;
        while(i.hasNext()){
            catalogo=i.next();
            if(catalogo.getCodice()==codice)
        }
    }
}
