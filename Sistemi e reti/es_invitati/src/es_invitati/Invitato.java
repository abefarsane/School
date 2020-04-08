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
public class Invitato {
    private String nome;
    private char sesso;
    private String telefono;
    
    public Invitato(String nome, char sesso, String telefono){
        this.nome = nome;
        this.sesso = sesso;
        this.telefono = telefono;
    }
    
    public Invitato(Invitato oggetto){
        this.nome = oggetto.getNome();
        this.sesso = oggetto.getSesso();
        this.telefono = oggetto.getTelefono();
    }
    
    public String getNome(){
        return this.nome;
    }
    public char getSesso(){
        return this.sesso;
    }
    public String getTelefono(){
        return this.telefono;
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
}
