import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;


class Main{
    public static void main(String[] args) {
        Auto a1 = new Auto("Ford","Mustang",3000,2019,2);
        Auto a2 = new Auto("Audi","A3",1600,2016,5);
        Auto a3 = new Auto("BMW","M5",2600,2020,4);
        LinkedList<Auto> concessionaria = new LinkedList<Auto>();

        concessionaria.add(a1);
        concessionaria.add(a2);
        concessionaria.add(a3);

        
        int i = 0;
        for(Iterator it = concessionaria.iterator();it.hasNext();){
            Auto a = (Auto) it.next();
            if(i == 0){
                System.out.format("|%1$-10|%2$-10|%3$-10|%4$-10|%5$-10|","MARCA","MODELLO","CILINDRATA","ANNO ACQUISTO","NUM POSTI");
            }
            System.out.format("|%1$-10|%2$-10s|%3$-10s|%4$-10s|%5$-10s|",a.getMarca(),a.getModello(),a.getCilindrata(),a.getAnnoAcquisto(),a.getNumPosti());
            i++; 
        }
        
    }
}