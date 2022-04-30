import java.util.Random;

/**
 *
 * @author tsmal
 * @version 20181010
 */
public class LuckyNumber {
    private String name;
    private int luckyNumber;
    /**
     * Overloaded Constructor
     * Assigns random integer for luckyNumber
     * @param n for name
     */
    public LuckyNumber(String n){
        Random rand = new Random();
        luckyNumber = rand.nextInt(10);
        name = n;
    }
    /**
     * Returns name
     * @return 
     */
    public String getName(){
        return name;
    }
    /**
     * Returns luckyNumber
     * @return 
     */
    public int getLuckyNumber(){
        return luckyNumber;
    }
    /**
     * Returns string with contents of LuckyNumber object
     * @return 
     */
    public String toString(){
        return getClass().getName() + "\t" + name + "\t" + luckyNumber
                + "\n";
    }
    /**
     * Returns boolean value. True if o is equal to LuckyObject called on
     * @param o
     * @return 
     */
    public boolean equals(Object o){
        if(!(o instanceof LuckyNumber))
            return false;
        LuckyNumber l = (LuckyNumber) o;
        return l.luckyNumber == luckyNumber && l.name.equals(name);
    }
}
