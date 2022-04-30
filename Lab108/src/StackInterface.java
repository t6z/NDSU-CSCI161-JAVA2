/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.1
 * 
 * An implementation of a simple Stack interface.
 * */

/**
 * A collection of objects that are inserted and removed according to the last-in
 * first-out principle. Although similar in purpose, this interface differs from
 * java.util.Stack
 * @author tsmal
 * @version 20181001
 */
public interface StackInterface<E> {
    /**
     * Returns the number of elements in the stack
     * @return number of elements in the stack
     */
    int size();
    /**
     * Tests whether the stack is empty
     * @return true if stack is empty, false otherwise
     */
    boolean isEmpty();
    /**
     * Inserts an element at the top of the stack
     * @param e the element to be inserted
     */
    void push(E e);
    /**
     * Returns, but does not remove, the element at the top of the stack
     * @return top element in the stack
     */
    E top();
    /**
     * Removes and returns the top element from the stack
     * @return element removed (or null if empty)
     */
    E pop();
}
