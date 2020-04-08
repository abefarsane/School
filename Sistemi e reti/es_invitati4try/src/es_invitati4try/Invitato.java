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
public class Invitato {
    private String nome;
    private char sesso;
    private String telefono;
    
    public Invitato(String nome, char sesso, String telefono){
        this.nome = nome;
        this.sesso = sesso;
        this.telefono = telefono;
    }
    
    public Invitato(Invitato invitato){
        this.nome = invitato.getNome();
        this.sesso = invitato.getSesso();
        this.telefono = invitato.getTelefono();
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSesso(char sesso){
        this.sesso = sesso;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public char getSesso(){
        return sesso;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getNome(){
        return nome;
    }
}
