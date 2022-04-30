/**
 * Bag interface that contains method declarations
 * @author tsmal
 * @version 20180907
 */
public interface BagInterface {
    /**
     * To be used to get the current size of array of objects
     * @return 
     */
    int getCurrentSize();

    /**
     * To be used to check emptiness of array
     * @return 
     */
    boolean isEmpty();

    /**
     * To be used to add a member to the array
     * @param num 
     */
    void add(int num);

    /**
     * To be used to remove a certain number from the array
     * @param num 
     */
    void remove(int num);

    /**
     * To be used to remove a random number from the array
     */
    void remove();

    /**
     * To be used to clear all entries in array
     */
    void clear();

    /**
     * To be used to get the frequency of a certain number within array
     * @param num
     * @return 
     */
    int getFrequencyOf(int num);

    /**
     * To check if array holds a specific number
     * @param num
     * @return 
     */
    boolean contains(int num);

    /**
     * To return string holding contents of object
     * @return 
     */
    String toString();

    /**
     * check if object o is equal to object called on
     * @param o
     * @return 
     */
    boolean equals(Object o);
}
