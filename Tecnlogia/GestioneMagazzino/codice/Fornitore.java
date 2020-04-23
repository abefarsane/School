package codice;

public class Fornitore {
    private String nomeFornitore;
    private int IDFornitore;

    Fornitore(String nomeFornitore, int IDFornitore){
        this.nomeFornitore = nomeFornitore;
        this.IDFornitore = IDFornitore;
    }

    public String getNomeFornitore(){
        return this.nomeFornitore;
    }
    public int getIDFornitore(){
        return this.IDFornitore;
    }
}