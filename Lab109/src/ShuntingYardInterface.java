/**
 * Interface for ShuntingYardAlgorithm.
 * It has three methods. One converts infix expression to postfix expression,
 * one evaluates a postfix expression, and one converts a postfix expression to 
 * a binary expression tree.
 * @author tsmal
 * @version 20181105
 */
public interface ShuntingYardInterface {
    /**
     * Takes a LinkedQueue of type String that is a infix valid expression, and
     * converts and returns a LinkedQueue of type String that is the postfix version
     * of the infix expression.
     * @param a
     * @return 
     */
    public LinkedQueue inFixToPostFix(LinkedQueue a);
    /**
     * Takes a LinkedQueue of type String that is a postfix expression, and evaluates
     * it using the queue and stack approach
     * @param postFix
     * @return 
     */
    public double evaluatePostFix(LinkedQueue postFix);
    /**
     * Takes a LinkedQueue of type String that holds a postfix expression and 
     * converts/returns a LinkedBinaryTree expression tree of expression.
     * @param lq
     * @return 
     */
    public LinkedBinaryTree postFixToBinaryTree(LinkedQueue lq);
    
    
}
