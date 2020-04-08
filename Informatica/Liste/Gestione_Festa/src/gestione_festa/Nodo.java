/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestione_festa;

/**
 *
 * @author crist
 */
public class Nodo {

    private Nodo link;
    private Invitato info;
    
    public Nodo(){
        this.link=null; 
    }
    public Nodo(Invitato inf) {
        this.link = null;
        this.info = new Invitato(inf);
    }

    public Invitato getInfo() {
        return this.info;
    }

    public Nodo getLink() {
        return this.link;
    }

    public void setLink(Nodo l) {
        this.link = l;
    }
}
