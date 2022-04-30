/**
 *  Double Stack interface with all basic Stack methods for two stacks stored within one array
 * @author tsmal
 * @version 20181007
 */
public interface DoubleStackInterface<E> {
    /**
     * Returns the number of elements in the red stack
     * @return number of elements in the red stack
     */
    int redSize();
    /**
     * Tests whether the red stack is empty
     * @return true if stack is empty, false otherwise
     */
    boolean redIsEmpty();
    /**
     * Inserts an element at the top of the stack
     * @param e the element to be inserted
     */
    void redPush(E e);
    /**
     * Returns, but does not remove, the element at the top of the red stack
     * @return top element in the stack
     */
    E redTop();
    /**
     * Removes and returns the top element from the red stack
     * @return element removed (or null if empty)
     */
    E redPop();
    /**
     * Returns the number of elements in the blue stack
     * @return number of elements in the stack
     */
    int blueSize();
    /**
     * Tests whether the stack is empty
     * @return true if stack is empty, false otherwise
     */
    boolean blueIsEmpty();
    /**
     * Inserts an element at the top of the blue stack
     * @param e the element to be inserted
     */
    void bluePush(E e);
    /**
     * Returns, but does not remove, the element at the top of the blue stack
     * @return top element in the stack
     */
    E blueTop();
    /**
     * Removes and returns the top element from the blue stack
     * @return element removed (or null if empty)
     */
    E bluePop();
    /**
     * Returns string value with contents of red and blue stack
     * @return 
     */
    String toString();
    /**
     * Compares object o to object called on for equality
     * @param o
     * @return 
     */
    boolean equals(Object o);
}
