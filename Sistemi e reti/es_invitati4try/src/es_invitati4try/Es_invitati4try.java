/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_invitati4try;

/**
 *
 * @author abefa
 */
public class Es_invitati4try {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Invitato i1 = new Invitato("Bianchi Giovanni",'m',"0586 854822");
        Invitato i2 = new Invitato("Rossi Marta", 'f', "0586 844853");
        Invitato i3 = new Invitato("Neri Marco",'m',"0586 444722");
        Invitato i4 = new Invitato("Verdi Roberta",'f',"0586 974824");
        
        Festa f = new Festa();
        f.inserisciInTesta(i1);
        f.inserisciInTesta(i2);
        f.inserisciInTesta(i3);
        
        Iteratore it = f.getIterator();
        Invitato invitato;
        
        while(it.hasNext()){
            invitato = it.next();
            System.out.println(invitato.getNome() + "  " + invitato.getSesso());
        }
    }
    
}
