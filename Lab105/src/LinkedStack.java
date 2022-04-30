/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 6.4
 * 
 * An implementation of a simple LinkedStack class.
 * */

/**
 * Implementation of a Stack using a SinglyLinkedList as storage
 * @author tsmal
 * @version 20181001
 */
public class LinkedStack<E> implements StackInterface<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedStack(){}
    /**
     * Returns the size of the Stack
     * @return 
     */
    public int size(){
        return list.size();
    }
    /**
     * Tests whether the Stack is empty
     * @return 
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
     * Inserts an element to the top of the Stack
     * @param element 
     */
    public void push(E element){
        list.addFirst(element);
    }
    /**
     * Returns but does not remove the first element in the Stack
     * @return 
     */
    public E top(){
        return list.first();
    }
    /**
     * Removes and returns the first element in the Stack
     * @return 
     */
    public E pop(){
        return list.removeFirst();
    }
}
