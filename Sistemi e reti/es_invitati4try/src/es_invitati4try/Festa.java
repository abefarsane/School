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
public class Festa {
    private Nodo head;
    private int elementi;
    
    public Festa(){
        head = null;
        elementi = 0;
    }
    
    private Nodo getLinkPosizione(int posizione) throws FestaException{
        int n = 1;
        Nodo p = head;
        
        if(head == null){
            throw new FestaException("Lista vuota");
        }
        if((posizione > elementi) || (posizione < 1)){
            throw new FestaException("Posizione errata");
        }
        
        while((p.getLink() != null) && (n < posizione)){
            p = p.getLink();
            n++;
        }
        
        return p;
    }
    
    private Nodo creaNodo(Invitato persona, Nodo link){
        Nodo nuovoNodo = new Nodo(persona);
        nuovoNodo.setLink(link);
        return nuovoNodo;
    }
    
    public void inserisciInTesta(Invitato persona){
        Nodo p = creaNodo(persona, head);
        head = p;
        elementi++;
    }
    
    public void inserisciInCoda(Invitato persona){
        if(head == null){
            inserisciInTesta(persona);
        }else{
            try{
                Nodo p = getLinkPosizione(elementi);
                p.setLink(creaNodo(persona,null));
                elementi++;
            }catch(FestaException exception){
                
            }
        }
    }
    
    public void inseriscInPosizione(Invitato persona, int posizione) throws FestaException{
        if(posizione <= 1){
            inserisciInTesta(persona);
        }else{
            if(elementi < posizione){
                inserisciInCoda(persona);
            }else{
                Nodo p = getLinkPosizione(posizione - 1);
                p.setLink(creaNodo(persona,p.getLink()));
                elementi++;
            }
        }
    }
    
    public void eliminaInTesta() throws FestaException{
        if(head == null){
            throw new FestaException("Lsita vuota");
        }
        head = head.getLink();
        elementi--;
    }
    
    public void eliminaInCoda() throws FestaException{
        if(head == null){
            throw new FestaException("Lista vuota");
        }
        Nodo p = getLinkPosizione(elementi - 1);
        p.setLink(null);
        elementi--;
    }
    
    public void eliminaInPosizione(int posizione) throws FestaException{
        if(posizione == 1){
            eliminaInTesta();
        }else{
            if(posizione == elementi){
                eliminaInCoda();
            }else{
                Nodo ps = getLinkPosizione(posizione);
                Nodo pp = getLinkPosizione(posizione - 1);
                pp.setLink(ps.getLink());
                elementi--;
            }
        }
    }
    
    public String visita(Nodo p){
        if(p == null){
            return "";
        }
        return p.getInfo().toString() + "\n" + visita(p.getLink());
    }
    
    public String elenco(){
        return visita(head);
    }
    
    public String toString(){
        Nodo p = head;
        String lista = new String("head -> ");
        
        if(p == null){
            return lista + "null";
        }
        
        while(p != null){
            lista = lista + "[" + p.getInfo().toString() + "]";
            if(p.getLink() == null){
                lista = lista + "null";
            }else{
                lista = lista + "+] -> ";
                p = p.getLink();
            }
        }
        return lista;
    }
    
    public Iteratore getIterator(){
        Iteratore i = new Iteratore(head);
        return i;
    }
    
    
    
}
