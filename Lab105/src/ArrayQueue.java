/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.10
 * 
 * An implementation of a simple ArrayQueue class.
 * */

/**
 * Implementation of the queue ADT using a fixed-length array
 * @author tsmal
 * @version 20181001
 */
public class ArrayQueue<E> implements QueueInterface<E> {
    //instance variables
    private E[] data;
    private int f = 0;
    private int sz = 0;
    
    //constructors
    public ArrayQueue(){
        data = (E[]) new Object[5];          //Constructs with default capacity
    }
    
    public ArrayQueue(int capacity){
        data = (E[]) new Object[capacity];      //Constructs with given capacity
    }
    
    //methods
    /**
     * Returns the number of elements in the queue
     * @return 
     */
    public int size(){return sz;}
    /**
     * Tests whether the queue is empty
     * @return 
     */
    public boolean isEmpty(){return(sz==0);}
    /**
     * Inserts an element at the rear of the queue
     * @param e
     * @throws IllegalStateException 
     */
    public void enqueue(E e)throws IllegalStateException{
        if(sz==data.length) throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length;     //use modular arithmetic
        data[avail] = e;
        sz++;
    }
    /**
     * Returns, but does not remove, the first element of the queue (null if empty)
     * @return 
     */
    public E first(){
        if(isEmpty())return null;
        return data[f];
    }
    /**
     * Removes and returns the first element of the queue ( null if empty )
     * @return 
     */
    public E dequeue(){
        if(isEmpty())return null;
        E answer = data[f];
        data[f] = null;                         //dereference to help gc
        f = (f+1) % data.length;
        sz--;
        return answer;
    }
}
