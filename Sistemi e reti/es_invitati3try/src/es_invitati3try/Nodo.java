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
public class Nodo {
    private Invitato info;
    private Nodo link;
    
    
    Nodo(Invitato p){
        this.info = new Invitato(p);
        this.link = null;
    }
    Nodo(){
        this.info = null;
        this.link = null;
    }
    
    public Invitato getInfo(){
        return this.info;
    }
    public Nodo getLink(){
        return this.link;
    }
    public void setInfo(Invitato p){
        this.info = p;
    }
    public void setLink(Nodo link){
        this.link = link;
    }
    
}
