/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_liste;

/**
 *
 * @author crist
 */
public class Lista {

    private Nodo head;//Il nodo iniziale della lista
    private int elementi; //Il numero di elementi della lista

    public Lista() { //Costruttore
        head = null; //Setta il primo nodo ovvero l'head a null 
        elementi = 0;//Elementi = 0
    }

    public void visitaLista() { //Serve a visualizzare i vari elementi della lista
        Nodo p = head; // Impo
        while (p != null) {
            esamina(p.getInfo());
            p = p.getLink();
        }
    }
    public void creaLista() {
        Nodo p = head;
        while (p != null) {
       //     Automobile a=new Automobile("Smart","HHD78S","Fiat");
      //      p.setInfo(a);
            p = p.getLink();
        }
    }

    public void esamina(Automobile info) {
        System.out.println("La macchina " + info.getNome() + " di marca " + info.getMarca() + " possiede la targa " + info.getTarga() + ".");
    }

    public void inserisciInTesta() {
        Nodo pn = new Nodo();
        pn.setLink(head);
        head = pn;
        elementi++;
    }

    public void inserisciInCoda() {
        Nodo p = head;
        Nodo pn = new Nodo();

        if (p == null) {
            inserisciInTesta();
        } else {
            while (p.getLink() != null) {
                p = p.getLink();
            }
        }
        pn.setLink(null);
        p.setLink(pn);
        elementi++;
    }

    public void inserisciInPosizione(int posizione) {
        Nodo p = head;
        Nodo pn = new Nodo();
        int i = 1;
        if ((posizione <= 1) || (head == null)) {
            inserisciInTesta();
        } else if (posizione > elementi) {
            inserisciInCoda();
        } else {
            while (i < posizione - 1) {
                p = p.getLink();
                i++;
            }
            pn.setLink(p.getLink());
            p.setLink(pn);
            elementi++;
        }
    }
    
}
