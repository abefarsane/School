/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati;

/**
 *
 * @author abefa
 */
public class Es_invitati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Invitato n1 = new Invitato("Bianchi Giovanni",'m',"0586 854822");
        Invitato n2 = new Invitato("Rossi Marta", 'f',"0586 844853");
        Invitato n3 = new Invitato("Neri Marco", 'm',"0586 44472");
        Invitato n4 = new Invitato("Verdi Roberta",'f',"0586974824");
        
        Lista f = new Lista();
        
        f.inserisciInTesta(n1);
        f.inserisciInTesta(n2);
        f.inserisciInCoda(n3);
        
        /*
        try{
            f.inseriscInPosizione(n4,42);
        }catch(FestaException e){
            System.out.println("Errore");
        }
*/
        System.out.println("Visita ricorsiva");
        System.out.println(f.elenco());
        
        System.out.println(f.toString());
    }
    
}
