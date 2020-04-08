/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati;

/**
 *
 * @author abefa
 */
public class Nodo {
    private Invitato info;
    private Nodo link;
    
    public Nodo(Invitato oggetto){
        info = new Invitato(oggetto);
        link = null;
    }
    
    public void setInfo(Invitato oggetto){
        info = new Invitato(oggetto);
    }
    public Invitato getInfo(){
        return new Invitato(info);
    }
    public void setLink(Nodo link){
        this.link = link;
    }
    public Nodo getLink(){
        return this.link;
    }
}
