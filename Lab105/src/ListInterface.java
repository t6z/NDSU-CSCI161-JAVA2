/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 7.1
 * 
 * An implementation of a simple List interface.
 * */

/**
 * A simplified version of the java.util.List interface
 * @author tsmal
 * @version 20181001
 */
public interface ListInterface<E> {
    /**
     * Returns the number of elements in this list
     * @return 
     */
    int size();
    /**
     * Returns whether the list is empty.
     * @return 
     */
    boolean isEmpty();
    /**
     * Returns (but does not remove) the element at index i
     * @param i
     * @return
     * @throws IndexOutOfBoundsException 
     */
    E get(int i) throws IndexOutOfBoundsException;
    /**
     * Replaces the element at index i with e, and returns the replaced element
     * @param i
     * @param e
     * @return
     * @throws IndexOutOfBoundsException 
     */
    E set(int i, E e) throws IndexOutOfBoundsException;
    /**
     * Inserts element e to be at index i, shifting all subsequent elements later.
     * @param i
     * @param e
     * @throws IndexOutOfBoundsException 
     */
    void add(int i, E e) throws IndexOutOfBoundsException;
    /**
     * Removes/returns the element at index i, shifting subsequent elements earlier.
     * @param i
     * @return
     * @throws IndexOutOfBoundsException 
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
