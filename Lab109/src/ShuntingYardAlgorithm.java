
import java.util.Scanner;

/**
 *
 * @author tsmal
 */
public class ShuntingYardAlgorithm {

    /**
     * Default constructor for ShuntingYardAlgorithm class. Does not execute any
     * code.
     */
    public ShuntingYardAlgorithm() {
    }

    /**
     * Takes in a LinkedQueue of type String containing a infix expression and
     * will convert this to a postfix expression (in the form of a LinkedQueue
     * of type String) that can be evaluated for its numeric (integer) value by
     * passing it through the evaluatePostFix() method.
     *
     * @param a
     * @return
     */
    public LinkedQueue inFixToPostFix(LinkedQueue a) {
        LinkedQueue<String> right = a;
        LinkedQueue<String> left = new LinkedQueue();
        LinkedStack<String> bottom = new LinkedStack();

        while (!(right.isEmpty())) {
            Scanner stringScan = new Scanner(right.first());
            if (stringScan.hasNextDouble()) {
                left.enqueue(right.dequeue());
            }
            if (!(right.first() == null)) {
                switch (right.first()) {
                    case "(":
                        bottom.push(right.dequeue());
                        break;
                    case "[":
                        bottom.push(right.dequeue());
                        break;
                    case "{":
                        bottom.push(right.dequeue());
                        break;
                    case "+":
                        bottom.push(right.dequeue());
                        break;
                    case "-":
                        bottom.push(right.dequeue());
                        break;
                    case "*":
                        bottom.push(right.dequeue());
                        break;
                    case "/":
                        bottom.push(right.dequeue());
                        break;

                    case ")":
                        while (!"(".equals(bottom.top())) {
                            left.enqueue(bottom.pop());
                        }
                        right.dequeue();
                        bottom.pop();
                        break;

                    case "}":
                        while (!"{".equals(bottom.top())) {
                            left.enqueue(bottom.pop());
                        }
                        right.dequeue();
                        bottom.pop();
                        break;
                    case "]":
                        while (!"[".equals(bottom.top())) {
                            left.enqueue(bottom.pop());
                        }
                        right.dequeue();
                        bottom.pop();
                        break;
                    default:
                        break;
                }//End of switch case 
            }
        }//End of while loop

        //Incase there are any more operands on the bottom stack after the right queue is empty
        while (!(bottom.isEmpty())) {
            left.enqueue(bottom.pop());
        }
        return left;
    }//end of inFixToPostFix

    /**
     *
     * @param inFix
     * @return
     */
    public double evaluatePostFix(LinkedQueue postFix) {
        double output;
        double l;
        double r;
        String temp;
        LinkedQueue<String> right = postFix;
        LinkedStack<Double> bottom = new LinkedStack();

        //True until right is empty
        while (!(right.isEmpty())) {
            //While the first item on right queue doesn't equal an operator and is not empty
            while (!"/".equals(right.first()) && !"*".equals(right.first()) && !"+".equals(right.first()) && !"-".equals(right.first()) && !right.isEmpty()) {
                temp = right.dequeue();
                Scanner stringToNum = new Scanner(temp);
                if (stringToNum.hasNextDouble()) {
                    bottom.push(stringToNum.nextDouble());
                }
            }
            if (right.first() != null && bottom.size() >= 2) {
                switch (right.dequeue()) {
                    case "/":
                        r = bottom.pop();
                        l = bottom.pop();
                        bottom.push(l / r);
                        break;
                    case "*":
                        r = bottom.pop();
                        l = bottom.pop();
                        bottom.push(l * r);
                        break;
                    case "+":
                        r = bottom.pop();
                        l = bottom.pop();
                        bottom.push(l + r);
                        break;
                    case "-":
                        r = bottom.pop();
                        l = bottom.pop();
                        bottom.push(l - r);
                        break;
                }
            }
        }
        output = bottom.pop();
        return output;
    }//end of evaluatePostFix

    public LinkedBinaryTree<String> postFixToBinaryTree(LinkedQueue<String> lq) {
        LinkedStack<LinkedBinaryTree> expStack = new LinkedStack();
        LinkedQueue<String> postFix = new LinkedQueue();
        String s;
        while(!(lq.isEmpty())){
            s = lq.dequeue();
            postFix.enqueue(s);
        }
        String temp;
        while (!(postFix.isEmpty())) {
            temp = postFix.dequeue();
            //If the temp is a number
            if (!"/".equals(temp) && !"*".equals(temp) && !"+".equals(temp) && !"-".equals(temp)) {
                LinkedBinaryTree<String> tempTree2 = new LinkedBinaryTree();
                tempTree2.addRoot(temp);
                expStack.push(tempTree2);
            }
            //If the temp is an operator
            if ("/".equals(temp) || "*".equals(temp) || "+".equals(temp) || "-".equals(temp)) {
                LinkedBinaryTree<String> tempTree1 = new LinkedBinaryTree();
                LinkedBinaryTree<String> l = new LinkedBinaryTree();
                LinkedBinaryTree<String> r = new LinkedBinaryTree();
                tempTree1.addRoot(temp);
                r = expStack.pop();
                l = expStack.pop();
                tempTree1.attach(tempTree1.root(), l, r);
                expStack.push(tempTree1);
            }
        }
        return expStack.pop();
    }
}//end of ShuntingYardAlgorithm
