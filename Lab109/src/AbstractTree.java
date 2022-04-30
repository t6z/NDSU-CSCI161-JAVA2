
import java.util.ArrayList;
import java.util.List;

/**
 * Data Structures & Algorithms 6th Edition Goodrick, Tamassia, Goldwasser 
 * Code Fragments 8.2 - 8.5, 8.16 - 8.21
 */
/**
 * An abstract base class providing some functionality of the Tree interface.
 *
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * Returns boolean true if element at position p is an internal node
     *
     * @param p
     * @return
     */
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * Returns boolean true if element at position p is an external node
     *
     * @param p
     * @return
     */
    @Override
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * Returns boolean true if Position p is root of tree
     *
     * @param p
     * @return
     */
    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of levels separating Position p from the root.
     *
     * @param p
     * @return
     */
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return +depth(parent(p));
        }
    }

    /**
     * Returns the height of the tree.
     *
     * @return
     */
    private int heightBad() { // works, but quadratic worst-case time
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p)) // only consider leaf positions
            {
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    /**
     * Returns the height of the subtree rooted at Position p.
     * @param p
     * @return 
     */
    public int height(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }

    /**
     * Returns iterable collection of positions in pre-order representation
     * @return
     */
    @Override
    public Iterable<Position<E>> positions() {
        return preOrder();
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     */
    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p)) {
            preOrderSubtree(c, snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions of the tree, representation of
     * pre-order.
     *
     * @return
     */
    public Iterable<Position<E>> preOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preOrderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     */
    private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postOrderSubtree(c, snapshot);
        }
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in
     * postorder.
     *
     * @return
     */
    public Iterable<Position<E>> postOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postOrderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Returns an iterable collection of positions of the tree in breadth-first
     * order.
     *
     * @return
     */
    public Iterable<Position<E>> breadthFirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            LinkedQueue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root()); // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p); // report this position
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c); // add children to back of queue
                }
            }
        }
        return snapshot;
    }
}
