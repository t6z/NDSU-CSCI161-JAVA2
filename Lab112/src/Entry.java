
/**
 *
 * @author tsmal
 * @param <K>
 * @param <V>
 */
public interface Entry<K, V> {

    K getKey(); //returns the key stored in this entry

    V getValue(); //returns the value stored in this entry

}
