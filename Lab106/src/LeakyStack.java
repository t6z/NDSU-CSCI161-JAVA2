
/**
 * Leaky Stack implementing the Stack Interface and using a DoublyLinkedList as storage
 * Acts like a regular Linked Stack until CAPACITY = size. Then stack "leaks" from bottom when
 * adding to top
 *
 * @author tsmal
 * @version 20181006
 */
public class LeakyStack<E> implements StackInterface<E> {

    private int cap;    //Capacity of Leaky Stack
    private static final int CAPACITY = 5;
    private DoublyLinkedList<E> data = new DoublyLinkedList<>();

    //CONSTRUCTORS
    /**
     * Overloaded Constructor that sets capacity (cap)
     *
     * @param cap
     */
    public LeakyStack(int cap) {
        this.cap = cap;
    }

    /**
     * Default Constructor
     */
    public LeakyStack() {
        cap = CAPACITY;
    }

    /**
     * Returns the size of the Stack
     *
     * @return
     */
    public int size() {
        return data.size();
    }

    /**
     * Tests whether the Stack is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Inserts an element to the top of the Stack
     *
     * @param element
     */
    public void push(E element) {
        if (data.size() == cap) {
            data.removeLast();
            data.addFirst(element);
            System.out.println("Item pushed in: " + element);
        } else {
            data.addFirst(element);
            System.out.println("Item pushed in: " + element);
        }
    }

    /**
     * Returns but does not remove the first element in the Stack
     *
     * @return
     */
    public E top() {
        return data.first();
    }

    /**
     * Removes and returns the first element in the Stack
     *
     * @return
     */
    public E pop() {
        return data.removeFirst();
    }

    /**
     * Returns string containing contents of Leaky Stack object
     *
     * @return
     */
    public String toString() {
        DoublyLinkedList<E> temp = new DoublyLinkedList<>();
        String output = "";
        int k = data.size();
        
        for (int i = 1; i <= k; i++) {
            temp.addFirst(data.removeLast());
            output = temp.first() + " " + output;
        }
        data = temp;
        output = getClass().getName() + " : " + output;
        return output;
    }

    /**
     * Returns boolean value comparing Object o and LeakyStack object for
     * equality
     *
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if(!(o instanceof LeakyStack)){             //Same Class?
            return false;
        }
        LeakyStack ls = (LeakyStack) o;             //Safe Cast
        
        if(ls.size()!=data.size())                  //Same Size?
            return false;
        
        DoublyLinkedList<E> temp = new DoublyLinkedList<>();
        int k = data.size();
        for(int i = 1; i <= k; i++){                //Compare each element
            temp.addFirst(data.removeLast());
            if(temp.first() != ls.data.removeFirst())
                return false;
        }
        data = temp;
        return true;
    }
}
