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
public class Iteratore {
    private Nodo nodo;
    
    public Iteratore(Nodo nodo){
        this.nodo = nodo;
    }
    
    public boolean hasNext(){
        return (!(nodo == null));
    }
    
    public Invitato next(){
        if(nodo == null){
            return null;
        }
        Invitato persona = new Invitato(nodo.getInfo());
        nodo = nodo.getLink();
        return persona;
    }
}
