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
public class Invitato {

    private String nome = "";
    private String cognome = "";

    public Invitato(String n, String c) {
        this.nome = n;
        this.cognome = c;
    }

    public Invitato(Invitato a) {
        this(a.getNome(), a.getCognome());
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }
}
