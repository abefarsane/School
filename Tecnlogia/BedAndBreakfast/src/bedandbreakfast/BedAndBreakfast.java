/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bedandbreakfast;

/**
 *
 * @author abefa
 */
public class BedAndBreakfast {
    private String DenominazioneStruttura, Indirizzo, Comune, Provincia, Telefono;
    private int NroCivico,Cap;
    
    public BedAndBreakfast(String den, String indirizzo, int nrCivico, int cap, String comune, String provincia, String telefono){
        this.DenominazioneStruttura = den;
        this.Indirizzo = indirizzo;
        this.Comune = comune;
        this.Provincia = provincia;
        this.Telefono = telefono;
        this.NroCivico = nrCivico;
        this.Cap = cap;
    }
    
    public String getDen(){
        return DenominazioneStruttura;
    }
    public String getIndirizzo(){
        return Indirizzo;
    }
    public int getNrCivico(){
        return NroCivico;
    }
    public int getCap(){
        return Cap;
    }
    public String getComune(){
        return Comune;
    }
    public String getProvincia(){
        return Provincia;
    }
    public String getTelefono(){
        return Telefono;
    }
}
