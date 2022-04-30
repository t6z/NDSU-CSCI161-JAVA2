/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 7.2, 7.3, 7.4 and 7.5
 * 
 * An implementation of a simple ArrayList class.
 * */
/**
 * ArrayList with abilities to insert and delete at arbitrary positions.
 * @author tsmal
 * @version 20181001
 */
public class ArrayList<E> implements ListInterface<E> {
    //instance variables
    public static final int CAPACITY=16;  //default array capacity
    private E[] data;                       //generic array used for storage
    private int size = 0;                   //current number of elements
    //constructors
    public ArrayList(){                     
        this(CAPACITY);  //constructs list with default capacity
    }
    public ArrayList(int capacity){
        data = (E[]) new Object[capacity]; //constructs list with given capacity
    }
    //public methods
    /**
     * Returns the number of elements in the array list
     * @return 
     */
    public int size(){return size;}
    /**
     * Returns whether the array list is empty
     * @return 
     */
    public boolean isEmpty(){return size==0;}
    /**
     * Returns (but does not remove) the element at index i 
     * @param i
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i,size);
        return data[i];
    }
    /**
     * Replaces the element at index i with e, and returns the replaced element
     * @param i
     * @param e
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public E set(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i,size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }
    /**
     * Inserts element e to be at index i, shifting all subsequent elements later
     * @param i
     * @param e
     * @throws IndexOutOfBoundsException
     * @throws IllegalStateException 
     */
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException{
        checkIndex(i,size+1);
        if(size == data.length)                 //not enough capacity
            resize(2*data.length);              //doubles size of data[]
        for(int k = size-1;k>=i;k--)            //start by shifting rightmost
            data[k+1] = data[k];
        data[i] = e;                            //ready to place new element
        size++;
    }
    /**
     * Removes/returns the element at index i, shifting subsequent elements earlier
     * @param i
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public E remove(int i)throws IndexOutOfBoundsException{
        checkIndex(i,size);
        E temp = data[i];
        for(int k = i;k<size-1;k++)             //shift elements to right
            data[k] = data[k+1];
        data[size-1] = null;                    //help gc
        size--;
        return temp;
    }
    /**
     * Checks whether the given index is in the range [0,n-1]
     * @param i
     * @param n
     * @throws IndexOutOfBoundsException 
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i<0 || i>=n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }
    /**
     * Resizes internal array to have given capacity >= size
     * @param capacity 
     */
    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for(int k = 0; k<size;k++)
            temp[k] = data[k];
        data = temp;
    }
}
