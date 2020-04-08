/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati4try;

/**
 *
 * @author abefa
 */
public class Nodo {
    private Invitato info;
    private Nodo link;
    
    Nodo(Invitato a){
        this.info = a;
        this.link = null;
    }
    
    public void setInfo(Invitato a){
        this.info = a;
    }
    public void setLink(Nodo n){
        this.link = n;
    }
    
    public Invitato getInfo(){
        return info;
    }
    public Nodo getLink(){
        return link;
    }
}
