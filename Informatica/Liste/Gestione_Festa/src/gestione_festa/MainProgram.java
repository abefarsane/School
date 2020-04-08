package gestione_festa;
import java.util.*;
/**
 *
 * @author crist
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Invitato primo = new Invitato("Primo", "Festeggiato");
        Invitato secondo = new Invitato("Secondo", "Festeggiato");
        Invitato terzo = new Invitato("Terzo", "Festeggiato");
        Invitato quarto = new Invitato("Quarto", "Festeggiato");
        Invitato quinto = new Invitato("Quinto", "Festeggiato");
        Invitato sesto = new Invitato("Sesto", "Festeggiato");
        Invitato settimo = new Invitato("Settimo", "Festeggiato");
        Invitato ottavo = new Invitato("Ottavo", "Festeggiato");
        LinkedList<Invitato> stronzo=new LinkedList<Invitato>();
        stronzo.addFirst(primo);
        stronzo.add(secondo);
        stronzo.add(sesto);
        stronzo.add(quarto);
        stronzo.remove(2);
        Iterator<Invitato> stronzino=stronzo.iterator();
        Invitato temp;
        while(stronzino.hasNext()){
            temp=stronzino.next();
            System.out.println("L'invitato si chiama:"+temp.getNome()+","+temp.getCognome());            
        }
    }
}
