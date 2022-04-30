/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.9
 * 
 * An implementation of a simple Queue interface.
 * */

/**
 * Queue Interface defining the queue ADT, with a standard FIFO protocol
 * for insertions and removals.
 * @author tsmal
 */
public interface QueueInterface<E> {
    /**
     * Returns the number of elements in the queue
     * @return 
     */
    int size();
    /**
     * Tests whether the queue is empty
     * @return 
     */
    boolean isEmpty();
    /**
     * Inserts an element at the rear of the queue
     * @param e 
     */
    void enqueue(E e);
    /**
     * Returns, but does not remove, the first element of the queue (null if empty)
     * @return 
     */
    E first();
    /**
     * Removes and returns the first element of the queue (null if empty)
     * @return 
     */
    E dequeue();
}
