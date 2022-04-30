
/**
 *  DoubleStack. Has usual Stack methods for both "red" and "blue" stacks.
 * 
 * @author tsmal
 * @version 20181009
 */
public class DoubleStack<E> implements DoubleStackInterface<E> {

    private E[] data;
    private static final int CAPACITY = 6;
    private int cap;
    private int redSize;
    private int blueSize;

    //Constructors
    public DoubleStack(int n) {
        data = (E[]) new Object[n];
        cap = n;
    }

    public DoubleStack() {
        data = (E[]) new Object[CAPACITY];
        cap = CAPACITY;
    }

    /**
     * Returns the number of elements in the red stack
     *
     * @return number of elements in the red stack
     */
    public int redSize() {
        return redSize;
    }

    /**
     * Returns the number of elements in the blue stack
     *
     * @return number of elements in the stack
     */
    public int blueSize() {
        return blueSize;
    }

    /**
     * Tests whether the red stack is empty
     *
     * @return true if stack is empty, false otherwise
     */
    public boolean redIsEmpty() {
        return redSize == 0;
    }

    /**
     * Tests whether the stack is empty
     *
     * @return true if stack is empty, false otherwise
     */
    public boolean blueIsEmpty() {
        return blueSize == 0;
    }

    /**
     * Inserts an element at the top of the stack
     *
     * @param e the element to be inserted
     */
    public void redPush(E e) {
        if ((blueSize + redSize) == cap) {
            throw new IllegalStateException("Stack is full");
        } else {
            data[redSize] = e;
            redSize++;
            System.out.println("Red Push: " + e);
        }
    }

    /**
     * Inserts an element at the top of the blue stack
     *
     * @param e the element to be inserted
     */
    public void bluePush(E e) {
        if ((blueSize + redSize) == cap) {
            throw new IllegalStateException("Stack is full");
        } else {
            data[cap - blueSize - 1] = e;
            blueSize++;
            System.out.println("Blue Push: " + e);
        }
    }

    /**
     * Returns, but does not remove, the element at the top of the red stack
     *
     * @return top element in the stack
     */
    public E redTop() {
        if(redSize == 0)
            return null;
        return data[redSize - 1];
    }

    /**
     * Returns, but does not remove, the element at the top of the blue stack
     *
     * @return top element in the stack
     */
    public E blueTop() {
        if(blueSize == 0)
            return null;
        return data[cap - blueSize];
    }

    /**
     * Removes and returns the top element from the red stack
     *
     * @return element removed (or null if empty)
     */
    public E redPop() {
        if (redSize == 0) {
            return null;
        } else {
            E temp = data[redSize - 1];
            data[redSize - 1] = null;
            redSize--;
            return temp;
        }
    }

    /**
     * Removes and returns the top element from the blue stack
     *
     * @return element removed (or null if empty)
     */
    public E bluePop() {
        if (blueSize == 0) {
            return null;
        } else {
            E temp = data[cap - blueSize];
            data[cap - blueSize] = null;
            blueSize--;
            return temp;
        }
    }

    /**
     * Returns string value with contents of red and blue stack
     *
     * @return
     */
    public String toString() {
        String redStack = "";
        String blueStack = "";
        for (int i = redSize-1; i >= 0; i--) {
            redStack += data[i] + " ";
        }
        
        for(int i = cap-blueSize; i<cap; i++){
            blueStack += data[i]  + " ";
        }
        String output = getClass().getName() + " : Red Stack: " + redStack + " : Blue Stack: " + blueStack;
        return output;
    }

    public boolean equals(Object o) {
        if (!(o instanceof DoubleStack)) {
            return false;
        }
        DoubleStack ds = (DoubleStack) o;
        return ds.data == data && ds.blueSize == blueSize && ds.redSize == redSize;
    }
}
