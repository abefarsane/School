/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19_sec;

/**
 *
 * @author abefa
 */
public class DataStructure {
    private int numPos = 0;
    private int numNewPos = 0;
    private int tot_casi = 0;
    
    DataStructure(int numPos,int numNewPos){
        this.numPos = numPos;
        this.numNewPos = numNewPos;
    }
    
    public int getNumPos(){
        return this.numPos;
    }
    public int getNumNewPos(){
        return this.numNewPos;
    }
}
