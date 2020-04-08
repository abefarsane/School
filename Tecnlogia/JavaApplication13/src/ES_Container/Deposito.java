package ES_Container;

public class Deposito{
    public  int numPiazze;
    private Nodo head;
    private int numContTot;
    Deposito(){
        numPiazze = 0;
    }

    public Nodo getLinkPosizione(int posizione){
        int n = 1;
        Nodo p = head;
        
        if(p == null){
            System.out.println("Posizione errata.");
        }else if((posizione > numPiazze) || (posizione < 1)){
            System.out.println("Posizione errata.");
        }
        
        
        while(p.getLink() != null && n < posizione){
            p = p.getLink();
            n++;
        }
        return p;
    }
    public int getNumTotContainer(){
        return this.numContTot;
    }

    public Piazza.Container searchContainerByCode(int code){
        Iteratore it = getIteratore();
        while(it.hasNext()){
            Piazza p = it.next();
            Piazza.Iteratore itP = p.getIterator();
            while(itP.hasNext()){
                Piazza.Container c = itP.next();
                if(c.getCode() == code){
                    return c;
                }
            }
        }
        System.out.println("\nNon e' stato trovato nessun container in deposito con il seguente codice identificativo:  " + code);
        return null;
    }

    public int getNumPiazze(){
        return this.numPiazze;
    }

    public void getPiazzaImpilabile(){
        Iteratore it = getIteratore();
        int[] nCon = new int[numPiazze];
        int[] piazzeImpilabili;
        int i = 0;


        while(it.hasNext()){
            Piazza p = it.next();
            nCon[i] = p.getNumContainer();
            if(nCon[i] == 5){
                
            }
            i++;
        }

        

    }

    public static int trovaNumPiuPiccolo(int[] array){
        if (array.length == 0)
            return -1;
    
        int index = 0;
        int min = array[index];
    
        for (int i = 1; i < array.length; i++){
            if (array[i] <= min){
            min = array[i];
            index = i;
            }
        }
        return index;
    }


    public void addAtHead(Piazza p){
        Nodo nodoPiazza = new Nodo(p,head);
        head = nodoPiazza;
        numPiazze++;
    }

    public void addAtQueque(Piazza p){
        if(head == null){
            addAtHead(p);
        }else{
            Nodo lastNodo = getLinkPosizione(numPiazze);
            lastNodo.setLink(new Nodo(p,null));
            numPiazze++;
        }
    }

    public void addAtPosition(Piazza p, int posizione){
        if(head == null){
            addAtHead(p);
        }else if(posizione > numPiazze){
            addAtQueque(p);
        }else{
            Nodo nS = getLinkPosizione(posizione - 1);
            nS.setLink(new Nodo(p,nS.getLink()));
            numPiazze++;
        }
    }

    public boolean removeAtHead(){
        if(head == null){
            return false;
        }else{
            head = head.getLink();
            numPiazze--;
            return true;
        }
    }

    public boolean removeInQueque(){
        if(head == null){
            return false;
        }else{
            Nodo nS = getLinkPosizione(numPiazze - 1);
            nS.setLink(null);
            numPiazze--;
            return true;
        }
    }

    public boolean removeAtPosition(int posizione){
        if(head == null){
            return false;
        }else if(posizione > numPiazze){
            System.out.println("\nPosizione inserita errata.");
            return false;
        }else{
            Nodo nS = getLinkPosizione(posizione);
            Nodo nP = getLinkPosizione(posizione - 1);
            nP.setLink(nS.getLink());
            numPiazze--;
            return true;
        }
    }

    public void showAll(){
        Iteratore it = getIteratore();
        int counter = 0;

        while(it.hasNext()){
            Piazza p = it.next();
            if(counter == 0){
                System.out.format("\n|%1$-15s|%2$-18s|%3$-12s|\n", "NUMERO PIAZZA", "NUMERO CONTAINER","POSTI LIBERI"); 
            }
            counter++;
            System.out.format("|%1$-15s|%2$-18s|%3$-12s|\n", counter, p.getNumContainer(), (5-p.getNumContainer()) + " su 5");
        }
    }

        public class Nodo{
        private Piazza info;
        private Nodo link;

        Nodo(Piazza info){
            this.info = info;
            this.link = null;
        }

        Nodo(Piazza info, Nodo link){
            this.info = info;
            this.link = link;
        }
        
        public void setLink(Nodo link){
            this.link = link;
        }
        public void setInfo(Piazza info){
            this.info = info;
        }

        public Nodo getLink(){
            return this.link;
        }
        public Piazza getInfo(){
            return this.info;
        }
    }

        //CLASSE ITERATORE
        public class Iteratore{
            private Nodo nodo;
            private Nodo restore = nodo;
            
            Iteratore(Nodo n){
                this.nodo = n;
                restore = n;
            }
            Iteratore(){
                
            }
            public void restoreCounting(){
                this.nodo = restore;
            }
            public boolean hasNext(){
                return (!(nodo == null));
            }
            
            public Piazza next(){
                if(nodo == null){
                    return null;
                }
                Piazza l = nodo.getInfo();
                nodo = nodo.getLink();
                return l;
            }
        }

        public Iteratore getIteratore(){
            return new Iteratore(head);
        }

        
public class Piazza{
    public int nContainer = 0;
    public Nodo head;


    public Piazza(){
        head = null;
        nContainer = 0;    
    }

    public Nodo getLinkPosizione(int posizione){
        Nodo p = head;
        int n = 1;
        if(p == null){
            System.out.println("Posizione errata.");
        }else if(posizione > nContainer || posizione < 1){
            System.out.println("Posizione errata.");
        }

        while(p.getLink() != null && n < posizione){
            p = p.getLink();
            n++;
        }

        return p;
    }

    Nodo creaNodo(Container info, Nodo link){
        Nodo nodoContainer = new Nodo(info);
        nodoContainer.setLink(link);
        return nodoContainer;
    }

    public void push(Container info){
        Nodo p = creaNodo(info, head);
        head = p;
        numContTot++;
        nContainer++;
    }

    public Container pop(){
        if(head == null){
            return null;
        }

        Nodo p = head;
        head = p.getLink();
        nContainer--;
        numContTot--;
        return p.getInfo();
    }

    public void showAll(){
        Iteratore ite = getIterator();
        int counter = 0;
        if(getNumContainer() == 0){
            
        }else{
            while(ite.hasNext()){
                Container c = ite.next();
                if(counter == 0){
                System.out.format("\n|%1$-5s|%2$-24s|%3$-40s|", "N", "CODICE IDENTIFICATIVO","DESCRIZIONE"); 
                }
                counter++;
                System.out.format("\n|%1$-5s|%2$-24s|%3$-40s|", counter, c.getCode(),c.getInfo()); 
            }
        }
    }

    public Iteratore getIterator(){
        Iteratore it = new Iteratore(head);
        return it;
    }

    public int getNumContainer(){
        return this.nContainer;
    }






    public class Container{
        private String info;
        private int code;

        Container(int code, String info){
            this.info = info;
            this.code = code;
        }

        Container(Container con){
            this.info = con.getInfo();
            this.code = con.getCode();
        }

        public String getInfo(){
            return this.info;
        }
        public int getCode(){
            return this.code;
        }

    }

    

    class Nodo{
        private Container info;
        private Nodo link;

        Nodo(Container info){
            this.info = info;
            this.link = null;
        }

        Nodo(Container info, Nodo link){
            this.info = info;
            this.link = link;
        }
        
        public void setLink(Nodo link){
            this.link = link;
        }
        public void setInfo(Container info){
            this.info = info;
        }

        public Nodo getLink(){
            return this.link;
        }
        public Container getInfo(){
            return this.info;
        }
    }

    public class Iteratore{
        private Nodo nodo;

        Iteratore(Nodo nodo){
            this.nodo = nodo;
        }

        public boolean hasNext(){
            return (!(nodo == null));
        }

        public Container next(){
            if(nodo == null){
                return null;
            }

            Container cont = nodo.getInfo();
            nodo = nodo.getLink();
            return cont;
        }
    }
}
}