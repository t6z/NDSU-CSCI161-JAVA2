
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Client file that includes the main method. Uses a text file inputted by the
 * user to scan for infix expressions, get the postfix version of the
 * expression, the evaluated expression,and different traversals of the
 * expression tree. Also includes a static method for determining if a infix
 * expression is valid or no.
 *
 * @author tsmal
 * @version 20181104
 */
public class Client {

    public static void main(String[] args) throws FileNotFoundException {
        //Ask for file path input
        String filePath;
        System.out.println("Please input the absolute path and file name (as one string)");
        Scanner scan = new Scanner(System.in);
        filePath = scan.nextLine();
        System.out.println("This is the file path you entered:\n" + filePath + "\n");

        //Used to scan entire next line
        Scanner fileScan = new Scanner(new File(filePath));

        //Create ArrayList of type String and add each infix expression to it from file
        ArrayList<String> expressionList = new ArrayList();
        while (fileScan.hasNextLine()) {
            expressionList.add(fileScan.nextLine());
        }

        //Create new instance of ShuntingYardAlgorithm, and a string "temp" to hold infix expressions during for loop
        ShuntingYardAlgorithm sya = new ShuntingYardAlgorithm();
        String temp;
        for (int i = 0; i < expressionList.size(); i++) {
            //set temp to infix expression
            temp = expressionList.get(i);
            //print infix expression
            System.out.println("\n" + temp);
            //print if the expression is valid or not, and continue to next loop of for if invalid
            System.out.print("This expression is : ");
            if (isExpressionValid(temp)) {
                System.out.println("valid");

            } else {
                System.out.println("invalid\n");
                continue;
            }
            //If it is valid, then make a new scanner for infix string and insert elements into a LinkedQueue
            Scanner inFixScan = new Scanner(temp);
            LinkedQueue<String> inFix = new LinkedQueue();
            LinkedQueue<String> inFixTree = new LinkedQueue();
            String x;
            while (inFixScan.hasNext()) {
                x = inFixScan.next();
                inFix.enqueue(x);
                inFixTree.enqueue(x);
            }
            //Pass infix linked queue to inFixToPostFix method and store in new LinkedQueue "postFix"
            LinkedQueue<String> postFix = sya.inFixToPostFix(inFix);
            LinkedQueue<String> postFixTree = sya.inFixToPostFix(inFixTree);
            //Print out contents of postFix LinkedQueue
            LinkedQueue<String> tempPostFix = new LinkedQueue();
            System.out.println("Postfix: ");
            String s;
            while (!(postFix.isEmpty())) {
                s = postFix.dequeue();
                System.out.print(s + " ");
                tempPostFix.enqueue(s);
            }
            postFix = tempPostFix;
            System.out.println("\nPostfix evaluated: ");
            System.out.println(sya.evaluatePostFix(postFix));
            
            LinkedBinaryTree<String> expTree = sya.postFixToBinaryTree(postFixTree);
            System.out.println("Pre-Order Traversal of Expression Tree:");
            printPreOrder(expTree,expTree.root());
            System.out.println("\nIn-Order Traversal of Expression Tree:");
            printInOrder(expTree,expTree.root());
            System.out.println("\nPost-Order Traversal of Expression Tree:");
            printPostOrder(expTree,expTree.root());
            System.out.println("\nEuler's Tour of Expression Tree:");
            printExpression(expTree,expTree.root());
            System.out.println("");
        }

    }//end of main method 

    /**
     * Determines if the scanned in-fix string expression is valid
     *
     * @param s
     * @return boolean true if it is valid, false otherwise
     */
    private static boolean isExpressionValid(String s) {
        /**
         * There are three requirements for an expression to be valid. 1. You
         * cannot have two numbers/doubles in a row 2.
         * Parenthesis/Brackets/Curly Braces must match 3. There cannot be any
         * operators at the beginning or end of string, after an open bracket,
         * or before a closed bracket
         *
         */

        /**
         * This if statement followed by a while loop will check if an operator
         * is at the beginning of the string, and if there are two numbers next
         * to each other
         */
        Scanner validScan1 = new Scanner(s);
        if (validScan1.hasNext("\\+") || validScan1.hasNext("\\-") || validScan1.hasNext("\\/") || validScan1.hasNext("\\*")) {
            return false;
        }
        while (validScan1.hasNext()) {
            //If it has two integers or doubles in a row then it is invalid
            if (validScan1.hasNextDouble() || validScan1.hasNextInt()) {
                validScan1.next();
                if (validScan1.hasNextDouble() || validScan1.hasNextInt()) {
                    return false;
                }
            } else {
                validScan1.next();
            }
        }

        /**
         * This next while loop will check to make sure that no operators are
         * after an open parenthesis, or are before a closed parenthesis.
         *
         */
        Scanner validScan2 = new Scanner(s);
        String recent = "";
        while (validScan2.hasNext()) {
            recent = validScan2.next();
            //if there is an operator and then a close bracket then it is invalid
            if ("/".equals(recent) || "+".equals(recent) || "*".equals(recent) || "-".equals(recent)) {
                if (validScan2.hasNext("\\)") || validScan2.hasNext("\\]") || validScan2.hasNext("\\}")) {
                    return false;
                }
            }

            //if there is a open bracket than an operator then it is invalid
            if ("(".equals(recent) || "{".equals(recent) || "[".equals(recent)) {
                if (validScan2.hasNext("\\+") || validScan2.hasNext("\\-") || validScan2.hasNext("\\/") || validScan2.hasNext("\\*")) {
                    return false;
                }
            }
        }

        //Checks if there is an operator at the end of the string
        if ("/".equals(recent) || "+".equals(recent) || "*".equals(recent) || "-".equals(recent)) {
            return false;
        }

        /**
         * This Scan will check to make sure the parenthesis/brackets match up
         */
        Scanner validScan3 = new Scanner(s);
        LinkedStack<String> match = new LinkedStack();
        while (validScan3.hasNext()) {
            switch (validScan3.next()) {
                case "(":
                    match.push("(");
                    break;
                case ")":
                    if ("(".equals(match.top())) {
                        match.pop();
                    } else {
                        return false;
                    }
                    break;
                case "[":
                    match.push("[");
                    break;
                case "]":
                    if ("[".equals(match.top())) {
                        match.pop();
                    } else {
                        return false;
                    }
                    break;
                case "{":
                    match.push("{");
                    break;
                case "}":
                    if ("{".equals(match.top())) {
                        match.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!(match.isEmpty())) {
            return false;
        }

        return true;
    }//end of isExpressionValid method
    
    //Normal Printing Methods
    /**
     * Prints pre-order representation of subtree of T rooted at p
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void printPreOrder(AbstractTree<E> T, Position<E> p) {
        Iterable<Position<E>> x = T.preOrder();
        for (Position<E> a : x) {
            System.out.print(a.getElement() + " ");
        }
    }
    
    /**
     * Prints in-order representation of subtree of T rooted at p
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void printInOrder(AbstractBinaryTree<E> T, Position<E> p) {
        Iterable<Position<E>> x = T.inOrder();
        for (Position<E> a : x) {
            System.out.print(a.getElement() + " ");
        }
    }

    /**
     * Prints post-order representation of subtree of T rooted at p
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void printPostOrder(AbstractTree<E> T, Position<E> p) {
        Iterable<Position<E>> x = T.postOrder();
        for (Position<E> a : x) {
            System.out.print(a.getElement() + " ");
        }

        //  for(Position<E> c : T.children(p)){
        //      printPostOrder(T,c);
        //  }
        //  System.out.print(p.getElement());
    }

    //Special Printing Methods

    /**
     * Prints parenthesized representation of subtree of T rooted at p.
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void printExpression(AbstractBinaryTree<E> T, Position<E> p) {
        if(T.left(p) != null){
            System.out.print("(");
            printExpression(T,T.left(p));
        }
        System.out.print(p.getElement());
        if(T.right(p) != null){
            printExpression(T, T.right(p));
            System.out.print(")");
        }
    }

}//end of client file
