

public class Auto {
    private String marca;
    private String modello;
    private int cilindrata;
    private int annoAcquisto;
    private int numPosti;
    static int nCars;

    Auto(String marca, String modello, int cilindrata, int annoAcquisto, int numPosti){
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.annoAcquisto = annoAcquisto;
        this.numPosti = numPosti;
        nCars++;
    }

    String getMarca(){
        return this.marca;
    }
    String getModello(){
        return this.modello;
    }
    int getCilindrata(){
        return this.cilindrata;
    }
    int getAnnoAcquisto(){
        return this.annoAcquisto;
    }
    int getNumPosti(){
        return this.numPosti;
    }
}