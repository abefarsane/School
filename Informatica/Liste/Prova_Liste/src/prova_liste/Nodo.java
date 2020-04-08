/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_liste;

/**
 *
 * @author crist
 */
public class Nodo {
    private Automobile info; //L'informazione contenuta nel nodo
    private Nodo link; //Il link del nodo
    public Nodo(){ //Costruttore di default
    
    }
 //   public Nodo(Automobile a){
  //      info=new Automobile(a);
  //      link=null; //Imposta il link al nodo successivo a null in modo che se questo è l'ultimo nodo rimane null come previsto
 //   }
  //  public void setInfo(Automobile a){
  //      info=new Automobile(a);
//    }
//    public Automobile getInfo(){
  //      return new Automobile(this.info);
 //   }
    public void setLink(Nodo _link){ //Imposta il link al nodo successivo 
        this.link=_link;
    }
    public Nodo getLink(){
        return this.link;
    }
}
