/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19;

/**
 *
 * @author abefa
 */
public class Data {
    private int attualmentePos;
    private int attualmenteNewP;
    private int tot_casi;
    
    public Data(String attPos,String attNewP,String tot_casi){
        this.attualmentePos = Integer.parseInt(attPos);
        this.attualmenteNewP = Integer.parseInt(attNewP);
        this.tot_casi = Integer.parseInt(tot_casi);
    }
    
    public int getAttPos(){
        return attualmentePos;
    }
    public int getArraNewP(){
        return attualmenteNewP;
    }
    public int getTotCasi(){
        return tot_casi;
    }
}
