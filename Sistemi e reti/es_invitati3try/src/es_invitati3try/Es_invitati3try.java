/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati3try;

/**
 *
 * @author abefa
 */
public class Es_invitati3try {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Invitato i1 = new Invitato("Cristian","Mannella");
        Invitato i2 = new Invitato("Antonio", "Sarli");
        Invitato i3 = new Invitato("Giuseppe","Lorusso");
        Invitato i4 = new Invitato("Abdollah","Farsane");
        
        
        Lista f = new Lista();
        f.aggiungiInCoda(i1);
        f.aggiungiInCoda(i2);
        f.aggiungiInCoda(i3);
        f.aggiungiInCoda(i4);
        Iteratore iteratore = f.getIterator();
        Invitato inv;
        while(iteratore.hasNext()){
            inv = new Invitato(iteratore.next());
            System.out.println(inv.getNome());
        }
    }
    
}
