
/**
 * Creates LinkedBinaryTree lbt, adds elements into tree. Then prints out tree
 * representations: preOrder, postOrder, inOrder, breathFirst, preOrderIndented,and expression
 * 
 * @author tsmal
 * @version 20181021
 */
public class Client {

    public static void main(String[] args) {

        //Create main tree
        LinkedBinaryTree<String> lbt = new LinkedBinaryTree();

        //Create needed subtrees
        LinkedBinaryTree<String> lbt1 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt2 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt3 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt4 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt5 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt6 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt7 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt8 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt9 = new LinkedBinaryTree();
        LinkedBinaryTree<String> lbt10 = new LinkedBinaryTree();

        //Create sub trees, attaching them together until main tree is created
        lbt1.addRoot("+");
        lbt1.addLeft(lbt1.root(), "5");
        lbt1.addRight(lbt1.root(), "2");

        lbt2.addRoot("-");
        lbt2.addLeft(lbt2.root(), "2");
        lbt2.addRight(lbt2.root(), "1");

        lbt3.addRoot("+");
        lbt3.addLeft(lbt3.root(), "2");
        lbt3.addRight(lbt3.root(), "9");

        lbt4.addRoot("-");
        lbt4.addLeft(lbt4.root(), "7");
        lbt4.addRight(lbt4.root(), "2");

        lbt5.addRoot("1");

        lbt6.addRoot("*");
        lbt6.attach(lbt6.root(), lbt1, lbt2);

        lbt7.addRoot("-");
        lbt7.attach(lbt7.root(), lbt4, lbt5);

        lbt8.addRoot("/");
        lbt8.attach(lbt8.root(), lbt6, lbt3);

        lbt9.addRoot("+");
        lbt9.attach(lbt9.root(), lbt8, lbt7);

        lbt10.addRoot("8");

        lbt.addRoot("*");
        lbt.attach(lbt.root(), lbt9, lbt10);

        //The string that represents the expression, i.e. (((5+2)*(2-1)/((2+9))+((7-2)-1))*8)
        System.out.println("The string that represents the expression:");
        System.out.println("(((5+2)*(2-1)/((2+9))+((7-2)-1))*8)\n");

        //The preorder traversal of the tree
        System.out.println("The pre-order traversal of the tree");
        printPreOrder(lbt, lbt.root());
        System.out.println("\n");

        //The inOrder traversal of the tree
        System.out.println("The inOrder traversal of the tree");
        printInOrder(lbt, lbt.root());
        System.out.println("\n");

        //The postOrder traversal of the tree
        System.out.println("The postOrder traversal of the tree");
        printPostOrder(lbt, lbt.root());
        System.out.println("\n");

        //The breathFirst traversal of the tree
        System.out.println("The breathFirst traversal of the tree");
        printBreathFirst(lbt, lbt.root());
        System.out.println("\n");

        //The preOrderIndent traversal of the tree
        System.out.println("The preOrderIndent traversal of the tree");
        printPreOrderIndent(lbt, lbt.root(), 1);
        System.out.println("\n");

        //The expression representation of the tree
        System.out.println("The expression representation of the tree");
        printExpression(lbt, lbt.root());
        System.out.println("\n");
    }

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

    /**
     * Prints breath-first representation of subtree of T rooted at p
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void printBreathFirst(AbstractTree<E> T, Position<E> p) {
        Iterable<Position<E>> x = T.breadthFirst();
        for (Position<E> a : x) {
            System.out.print(a.getElement() + " ");
        }
    }

    //Special Printing Methods
    /**
     * Method for creating certain amount of spaces. Used for indenting in
     * printing methods.
     *
     * @param n
     * @param x
     * @return
     */
    public static String spaces(int n) {
        String output = "";
        for (int i = 0; i <= n; i++) {
            output += " ";
        }
        return output;
    }

    /**
     * Prints pre-order representation of subtree of T rooted at p having depth
     * d.
     * 
     * 
     * Data Structures & Algorithms 6th Edition Goodrick, Tamassia, Goldwasser
     * Code Fragment: 8.23
     *
     * @param <E>
     * @param T
     * @param p
     * @param d
     */
    public static <E> void printPreOrderIndent(Tree<E> T, Position<E> p, int d) {

        System.out.println(spaces(2 * d) + p.getElement()); // indent based on d
        for (Position<E> c : T.children(p)) {
            printPreOrderIndent(T, c, d + 1); // child depth is d+1
        }
    }

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

}
