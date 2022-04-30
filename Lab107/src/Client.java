/**
 * 
 * @author tsmal
 * @version 20181013
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating new LuckyNumberList object lnl
        LuckyNumberList lnl = new LuckyNumberList();
        
        //Hardcoding new LuckyNumber objects a-j
        LuckyNumber a = new LuckyNumber("Tammy");
        LuckyNumber b = new LuckyNumber("John");
        LuckyNumber c = new LuckyNumber("Phil");
        LuckyNumber d = new LuckyNumber("Dakota");
        LuckyNumber e = new LuckyNumber("Melissa");
        LuckyNumber f = new LuckyNumber("Orion");
        LuckyNumber g = new LuckyNumber("Mitch");
        LuckyNumber h = new LuckyNumber("Molly");
        LuckyNumber i = new LuckyNumber("Derek");
        LuckyNumber j = new LuckyNumber("Carey");
        
        //Adding LuckyNumber objects (a-j) to lnl
        lnl.addLuckyNumber(a);
        lnl.addLuckyNumber(b);
        lnl.addLuckyNumber(c);
        lnl.addLuckyNumber(d);
        lnl.addLuckyNumber(e);
        lnl.addLuckyNumber(f);
        lnl.addLuckyNumber(g);
        lnl.addLuckyNumber(h);
        lnl.addLuckyNumber(i);
        lnl.addLuckyNumber(j);
        
        LuckyNumber x;
        String even;
        String prime;
        //Using default Iterator
        Iterator<Position<LuckyNumber>> ListIterator = lnl.positions().iterator();
        System.out.println("Printed Using Default Iterator");
        while ( ListIterator.hasNext() ){
            x = ListIterator.next().getElement();
            if(lnl.isEven(x.getLuckyNumber()))
                even = "Even";
            else
                even = "Odd";
            
            if(lnl.isPrime(x.getLuckyNumber()))
                prime = "Prime";
            else
                prime = "Not Prime";

            System.out.printf(x.getName() + "\t" + x.getLuckyNumber() + "\t" + even + "\t" + prime + "\n");
        }
        System.out.printf( "\n\n" );
        
        //Using Prime Iterator
        Iterator<Position<LuckyNumber>> PrimeIterator = lnl.primePositions().iterator();
        System.out.println("Printed Using Prime Iterator");
        while(PrimeIterator.hasNext()){
            x = PrimeIterator.next().getElement();
            if(lnl.isEven(x.getLuckyNumber()))
                even = "Even";
            else
                even = "Odd";
            
            if(lnl.isPrime(x.getLuckyNumber()))
                prime = "Prime";
            else
                prime = "Not Prime";

            System.out.printf(x.getName() + "\t" + x.getLuckyNumber() + "\t" + even + "\t" + prime + "\n");
        }
        System.out.printf("\n\n");
        
        //Using Even Iterator
        Iterator<Position<LuckyNumber>> EvenIterator = lnl.evenPositions().iterator();
        System.out.println("Printed Using Even Iterator");
        while(EvenIterator.hasNext()){
            x = EvenIterator.next().getElement();
            if(lnl.isEven(x.getLuckyNumber()))
                even = "Even";
            else
                even = "Odd";
            
            if(lnl.isPrime(x.getLuckyNumber()))
                prime = "Prime";
            else
                prime = "Not Prime";

            System.out.printf(x.getName() + "\t" + x.getLuckyNumber() + "\t" + even + "\t" + prime + "\n");
        }
        System.out.printf("\n\n");
       
        
        
        
    }
}
