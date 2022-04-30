
import java.util.Objects;

/**
 *
 * @author tsmal
 * @version 20181128
 */
public class IntegerComparator implements Comparator<Integer>{
    /**
     * Default constructor
     */
    public IntegerComparator(){}
    
    /**
     * Compares two Integer objects of their integer values
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(Integer a, Integer b){
        if(Objects.equals(a, b)){
            return 0;
        }
        else if(a.intValue() > b.intValue()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
