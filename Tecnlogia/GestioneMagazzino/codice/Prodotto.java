package codice;

public class Prodotto {
    private String tipoProdotto;
    private String marcaProdotto;
    private int numInStock;
    private Fornitore fornitore = null;

    Prodotto(String tipo, String marca, int numInStock, Fornitore f){
        this.tipoProdotto = tipo;
        this.marcaProdotto = marca;
        this.numInStock = numInStock;
        this.fornitore = f;
    }

    public String getTipoProdotto(){
        return this.tipoProdotto;
    }
    public String getMarcaProdotto(){
        return this.marcaProdotto;
    }
    public int getNumInStock(){
        return this.numInStock;
    }
    public Fornitore getFornitore(){
        return this.fornitore;
    }

}