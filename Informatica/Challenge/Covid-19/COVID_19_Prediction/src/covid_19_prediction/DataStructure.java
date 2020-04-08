/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid_19_prediction;
import java.time.LocalDate;
/**
 *
 * @author abefa
 */
public class DataStructure {
    private String stato;
    private LocalDate data;
    private int totActPos;
    private int newActPos;
    private int dimessi;
    private int tamponi;
    private int totCasi;
    
    DataStructure(String data,String stato, String totActPos,String newActPos,String dimessi,String tamponi, String totCasi){
        setData(data);
        setStato(stato);
        setTotActPos(totActPos);
        setNewPos(newActPos);
        setNDimessi(dimessi);
        setNTamp(tamponi);
        setTotCasi(totCasi);
    }
    
    void setData(String data){
        String[] split = data.substring(1, 11).split("/");
        this.data = LocalDate.of(Integer.parseInt(split[2]),Integer.parseInt(split[1]),Integer.parseInt(split[0]));
    }
    void setStato(String stato){
        this.stato = stato;
    }
    void setTotActPos(String actPos){
        this.totActPos = Integer.parseInt(actPos);
    }
    void setNewPos(String newPos){
        this.newActPos = Integer.parseInt(newPos);
    }
    void setNDimessi(String dimessi){
        this.dimessi = Integer.parseInt(dimessi);
    }
    void setNTamp(String tamp){
        this.tamponi = Integer.parseInt(tamp);
    }
    void setTotCasi(String totcasi){
        this.totCasi = Integer.parseInt(totcasi);
    }
    
    LocalDate getData(){
        return this.data;
    }
    String getStato(){
        return this.stato;
    }
    int getTotActPos(){
        return this.totActPos;
    }
    int getNewPos(){
        return this.newActPos;
    }
    int getNDimessi(){
        return this.dimessi;
    }
    int getNTamp(){
        return this.tamponi;
    }
    int getTotCasi(){
        return this.totCasi;
    }
}
