public class Magazzino{
    private Nodo head;
    private int nProdotti;


    public Nodo getLinkPosizione(int pos){
        int n = 1;
        Nodo p = head;
        if(p == null){
            System.out.println("Il magazzino non contiene prodotti.");
        }else if((pos > nProdotti) || (pos < 1)){
            System.out.println("Posizione inserita errata.");
        }

        while(p.getLink() != null && n < pos){
            p = p.getLink();
            n++;
        }
        return p;
    }

    public void addAtHead(Prodotto p){
        Nodo nodo = new Nodo(p,head);
        head = nodo;
        nProdotti++;
    }
    public void addInQueque(Prodotto p){
        if(head == null){
            addAtHead(p);
        }else{
            Nodo nodo =getLinkPosizione(nProdotti);
            nodo.setLink(new Nodo(p));
            nProdotti++;
        }
    }
    public void addAtPosition(Prodotto p, int pos){
        if(pos > nProdotti){
            addInQueque(p);
        }else if(head == null){
            addAtHead(p);
        }else{
            Nodo nodo = getLinkPosizione(pos - 1);
            nodo.setLink(new Nodo(p,nodo.getLink()));
            nProdotti++;
        }
    }
    public boolean removeAtHead(){
        if(head == null){
            return false;
        }else{
            head = head.getLink();
            nProdotti--;
            return true;
        }
    }
    public boolean removeInQueque(){
        if(head == null){
            return false;
        }else{
            Nodo s = getLinkPosizione(nProdotti - 1);
            s.setLink(null);
            nProdotti--;
            return true;
        }
    }
    public boolean removeAtPosition(int pos){
        if(head == null){
            return false;
        }else if(pos > nProdotti){
            System.out.println("Posizione inserita non valida.");
            return false;
        }else{
            Nodo s = getLinkPosizione(pos - 1);
            Nodo k = getLinkPosizione(pos);
            s.setLink(k.getLink());
            nProdotti--;
            return true;
        }
    }


    class Nodo{
        private Prodotto info;
        private Nodo link;

        Nodo(Prodotto info, Nodo link){
            this.info = info;
            this.link = link;
        }
        Nodo(Prodotto info){
            this.info = info;
            this.link =null;
        }

        public void setLink(Nodo link){
            this.link = link;
        }
        public void setInfo(Prodotto info){
            this.info = info;
        }
        public Nodo getLink(){
            return this.link;
        }
        public Prodotto getInfo(){
            return this.info;
        }
    }

    class Iteratore{
        private Nodo nodo = null;

        Iteratore(Nodo head){
            this.nodo = head;
        }
        public boolean hasNext(){
            return (!(nodo == null));
        }
        public Prodotto next(){
            if(nodo == null){
                return null;
            }

            Prodotto p = nodo.getInfo();
            nodo = nodo.getLink();
            return p;
        }
    }

    public Iteratore getIteratore(){
        return new Iteratore(head);
    }



    class Prodotto{
        class Categoria{
            class Tech{

            }
            class Abbigliamento{

            }
            class Casa{

            }
        }
    }
}