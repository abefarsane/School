package codice;
import java.util.ArrayList;
import java.util.List;

public class Magazzino {
    List<Prodotto> productStock = new ArrayList<Prodotto>();
    
    private String nome;


    Magazzino(){
        
    }

    String getNomeDitta(){
        return this.nome;
    }
}