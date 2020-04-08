/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classinested;

/**
 *
 * @author abefa
 */
public class ClasseEsterna {
    private int x = 10;
    
    public void creaClasseLocalInner(){
        int y = 20;
        
        class InnerClass{
            public void accediEsterna(){
                System.out.println("Attributo della classe che ospita la classe inner: " + x);
            }
            
            public void accediInterna(){
                System.out.println("Attributo del metodo che ospita la classe inner: " + y);
            }
    }
        
        InnerClass p1 = new InnerClass();
        InnerClass p2 = new InnerClass();
        
        p1.accediEsterna();
        p2.accediInterna();
    }
}
