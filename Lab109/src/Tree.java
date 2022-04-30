import java.util.Iterator;
/**
 * Data Structures & Algorithms 6th Edition Goodrick, Tamassia, Goldwasser 
 * Code Fragments 8.1
 */
/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 * @param <E>
 */
public interface Tree<E> extends Iterable<E> {
    /**
     * @return position of root
     */
    Position<E> root();
    /**
     * Returns the parent of the element at position p.
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    /**
     * Returns an iterable collection of positions 
     * of the children of the element at position p
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    Iterable<Position<E>> children(Position<E> p)
            throws IllegalArgumentException;
    /**
     * Returns an integer value with number of children of
     * element at position p
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;
    /**
     * Returns a boolean value of true if element at position p is an internal node
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    /**
     * Returns a boolean value of true if element at position p is an external node
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    /**
     * Returns a boolean value of true if element at position p is a root node
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    /**
     * Returns an integer with size of tree
     * @return 
     */
    int size();
    /**
     * Returns a boolean value of true if tree is empty (no root)
     * @return 
     */
    boolean isEmpty();
    /**
     * Returns an Iterator 
     * @return 
     */
    @Override
    Iterator<E> iterator();
    /**
     * Returns an iterable collection of positions 
     * @return 
     */
    Iterable<Position<E>> positions();
}
