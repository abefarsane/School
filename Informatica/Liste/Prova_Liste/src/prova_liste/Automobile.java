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
public abstract class Automobile {
    String nome="";
    String targa="";
    String marca="";
    int codice=0;
    public Automobile(String _nome,String _targa,String _marca,int cod){
        this.nome=_nome;
        this.targa=_targa;
        this.marca=_marca;
        this.codice=cod;
    }
    public Automobile(Automobile a){
        this(a.getNome(),a.getTarga(),a.getMarca(),a.getCodice());
    }
    public String getNome(){return this.nome;}
    public String getTarga(){return this.targa;}
    public String getMarca(){return this.marca;}    
    public int getCodice(){return this.codice;}    
    @Override
    public Automobile clone() {
        try{
        return super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println("Errore "+e);
            return null;
        }
    }
}
