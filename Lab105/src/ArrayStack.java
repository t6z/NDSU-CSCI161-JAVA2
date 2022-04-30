/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragment 6.2
 * 
 * An implementation of a simple ArrayStack class.
 * */

/**
 *
 * @author tsmal
 */
public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 5;//default array capacity
    private E[] data;                       //generic array used for storage
    private int t = -1;                     //index of the top element in stack
    public ArrayStack(){                    //constructs stack with default capacity
        data = (E[]) new Object[CAPACITY];
    }
    public ArrayStack(int capacity){        //constructs stack with given capacity
        data = (E[]) new Object[capacity];
    }
    /**
     * Returns the size of the Stack
     * @return 
     */
    public int size(){
        return (t+1);
    }
    /**
     * Tests whether the Stack is empty
     * @return 
     */
    public boolean isEmpty(){return (t==-1);}
    /**
     * Inserts new element to front of Stack
     * @param e
     * @throws IllegalStateException 
     */
    public void push(E e) throws IllegalStateException{
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;                      //increment t before storing new item
    }
    /**
     * Returns, but does not remove, the top element in Stack
     * @return 
     */
    public E top(){
        if(isEmpty()) return null;
        return data[t];
    }
    /**
     * Removes and returns the first element in the stack
     * @return 
     */
    public E pop() {
        if(isEmpty())return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
    
}
