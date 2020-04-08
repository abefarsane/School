/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemi_es1;

/**
 *
 * @author abefa
 */
public class Stazione {
    private String id_stazione;
    private double dimRete;
    private String stato;
    
    Stazione(String id,double dimRete,String stato){
        setIdStazione(id);
        setDimRete(dimRete);
        setStato(stato);
    }
    
    Stazione(String id, double dimRete){
        this(id,dimRete,"TX");
    }
    Stazione(String id){
        this(id,0,"TX");
    }
    Stazione(String id, String stato){
        this(id,0,stato);
    }
    
    public void setIdStazione(String id){
        this.id_stazione = id;
    }
    public void setDimRete(double dimRete){
        this.dimRete = dimRete;
    }
    public void setStato(String stato){
        this.stato = stato;
    }
    
    public String getIdStazione(){
        return this.id_stazione;
    }
    public double getDimRete(){
        return this.dimRete;
    }
    public String getStato(){
        return this.stato;
    }
    
}
