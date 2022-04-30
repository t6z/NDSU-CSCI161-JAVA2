/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 6.11
 * 
 * An implementation of a simple LinkedQueue class.
 * */

/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList
 * @author tsmal
 * @version 20181001
 */
public class LinkedQueue<E> implements QueueInterface<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); //empty list
    public LinkedQueue(){}      //new queue relies on the initially empty list
    /**
     * Returns the number of elements in the queue
     * @return 
     */
    public int size(){return list.size();}
    /**
     * Tests whether the queue is empty
     * @return 
     */
    public boolean isEmpty(){return list.isEmpty();}
    /**
     * Inserts an element at the rear of the queue
     * @param element 
     */
    public void enqueue(E element){list.addLast(element);}
    /**
     * Returns, but does not remove, the first element in the queue
     * @return 
     */
    public E first(){return list.first();}
    /**
     * Removes and returns the first element of the queue
     * @return 
     */
    public E dequeue(){return list.removeFirst();}
}
