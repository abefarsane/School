/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestione_festa;

import es_invitati3try.EccezioneFesta;

/**
 *
 * @author crist
 */
public class Lista {

    private Nodo head;
    private static int elementi = 0;

    public Lista() {
        this.head = null;
        elementi = 0;
    }

    public void aggiungiInTesta(Invitato a) {
        Nodo nodoRichiesto = new Nodo(a);
        if (head == null) {//Lista vuota
            head = new Nodo();
            head.setLink(nodoRichiesto);
        } else {
            nodoRichiesto.setLink(head.getLink());
            head.setLink(nodoRichiesto);
        }
        elementi++;
    }

    public void aggiungiInCoda(Invitato a) {
        Nodo nodoScorrimento = head;
        Nodo nodoRichiesto = new Nodo(a);
        if (nodoScorrimento == null) {
            aggiungiInTesta(a);
        } else {
            while (nodoScorrimento.getLink() != null) {
                nodoScorrimento = nodoScorrimento.getLink();
            }
            nodoScorrimento.setLink(nodoRichiesto);
            elementi++;
        }
    }

    public void aggiungiPosizione(int posizione, Invitato a) throws EccezioneFesta{
        Nodo temp = head;
        if (posizione > elementi) {
            aggiungiInCoda(a);
        } else {
            if (temp.getLink() != null) { // SE LA PRIMA CELLA E' VUOTA
                for (int i = 1; i < posizione; i++) {
                    temp = temp.getLink();
                }                
                Nodo nRichiesto = new Nodo(a);               
                nRichiesto.setLink(temp.getLink());
                temp.setLink(nRichiesto);
                elementi++;
            } else {
                aggiungiInTesta(a);
            }

        }
    }

    public void visitaLista() {
        Nodo temp = head;
        int i = 1;
        while (temp != null && temp.getLink() != null) {
            temp = temp.getLink();
            System.out.println("Il festeggiato n°" + i + " si chiama "
                    + temp.getInfo().getNome()
                    + "," + temp.getInfo().getCognome() + ".");
            i++;
        }
    }
    public void visitaRicorsiva(Nodo p){
        
        if(p==null){
            return;
        }else{
           System.out.println("Il festeggiato  si chiama "
                    + p.getInfo().getNome()
                    + "," + p.getInfo().getCognome() + "."); 
           visitaRicorsiva(p.getLink());
        }
    }
    public Nodo getHead(){
        return this.head;
    }

    public void eliminaInTesta() {
        if (head != null && head.getLink() != null) {
            head.setLink(head.getLink().getLink());
            elementi--;
        }
    }

    public void eliminaInCoda() {
        Nodo scorrimento = head;
        Nodo copia = new Nodo();
        if (scorrimento != null && scorrimento.getLink() != null) {
            while (scorrimento.getLink() != null) {
                copia = scorrimento;
                scorrimento = scorrimento.getLink();
            }            
            copia.setLink(null);
            elementi--;
        }
    }

    public void eliminaInPosizione(int posizione) {
        Nodo scorri = head;
        Nodo copia = new Nodo();
        if (head != null) {
            if (posizione > elementi) {
                eliminaInCoda();
            } else {
                for (int i = 1; i < posizione; i++) {
                    copia = scorri;
                    scorri = scorri.getLink();
                }                
                copia.setLink(scorri.getLink());
                elementi--;
            }
        }

    }
}
