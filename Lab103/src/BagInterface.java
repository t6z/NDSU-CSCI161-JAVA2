/**
 * Bag Interface that contains methods for a generic bag that is in no particular order
 * and can be accessed and edited
 * @author tsmal
 * @version 20180915
 * @param <T> 
 */
public interface BagInterface<T> {
    /**
     * returns int with current size of bag
     * @return 
     */
    public int getCurrentSize();
    /**
     * returns boolean value. True if bag empty, false otherwise.
     * @return 
     */
    public boolean isEmpty();
    /**
     * adds item t to bag
     * @param t
     * @throws IllegalArgumentException 
     */
    public void addItem(T t) throws IllegalArgumentException;
    /**
     * removes a random item from bag and returns item.
     * @return 
     */
    public T remove();
    /**
     * removes item t from bag and returns boolean value. True if successful
     * false if otherwise
     * @param t
     * @return 
     */
    public boolean remove(T t);
    /**
     * clears bag
     */
    public void clear();
    /**
     * returns int frequency of t in bag
     * @param t
     * @return 
     */
    public int getFrequencyOf(T t);
    /**
     * returns boolean value if bag contains item t
     * @param t
     * @return 
     */
    public boolean contains(T t);
    /**
     * Returns string with contents 
     * @return 
     */
    public String toString();
    /**
     * Equals method returns boolean value
     * @param o
     * @return 
     */
    public boolean equals(Object o);
}
