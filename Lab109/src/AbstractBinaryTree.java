import java.util.ArrayList;
import java.util.List;
/**
 * Data Structures & Algorithms 6th Edition Goodrick, Tamassia, Goldwasser Code
 * Fragments 8.7, 8.22
 */
/**
 * An abstract base class providing some functionality of the BinaryTree
 * interface.
 *
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null; // p must be the root
        }
        if (p == left(parent)) // p is a left child
        {
            return right(parent); // (right child might be null)
        } else // p is a right child
        {
            return left(parent); // (left child might be null)
        }
    }

    /**
     * Returns the number of children of Position p.
     *
     * @param p
     * @return
     */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    //Iterables
    /**
     * Returns an iterable collection of the Positions representing p's
     * children.
     *
     * @param p
     * @return
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     */
    private void inOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inOrderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inOrderSubtree(right(p), snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions of the tree, reported
     * inOrder.
     *
     * @return
     */
    public Iterable<Position<E>> inOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inOrderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Overrides positions to make inOrder the default order for binary trees.
     *
     * @return
     */
    @Override
    public Iterable<Position<E>> positions() {
        return inOrder();
    }

} //-------- end of AbstractBinaryTree class --------
