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
public class Invitato {
    private String nome;
    private String cognome;
    
    
    Invitato(Invitato p){
        this.nome = p.getNome();
        this.cognome = p.getCognome();
    }
    
    Invitato(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }
    
    
    public String getNome(){
        return this.nome;
    }
    public String getCognome(){
        return this.cognome;
    }
}
