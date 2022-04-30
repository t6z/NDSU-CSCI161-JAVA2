/**
 * Data Structures & Algorithms 6th Edition 
 * Goodrick, Tamassia, Goldwasser
 * 
 * Code Fragment 8.6
 */

/**
 * @author tsmal
 * @param <E> 
 * @version 20181017
 */
public interface BinaryTree<E> extends Tree<E> {

    /**
     * Returns the Position of p's left child (or null if no child exists).
     * @param p
     * @return 
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's right child (or null if no child exists).
     * @param p
     * @return 
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     * @param p
     * @return 
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
