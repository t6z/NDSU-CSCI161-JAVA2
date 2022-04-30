
/**
 * 
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 3.17, 3.18
 *
 * An implementation of a DoublyLinkedList class.
 * 
 * */

/**
 *
 * @author tsmal
 * @version 20181008
 */
public class DoublyLinkedList<E> {

    //------------- nested Node class --------------
    private static class Node<E> {

        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    //instance variables of the DoublyLinkedList
    private Node<E> header;                         //header sentinel
    private Node<E> trailer;                        //trailer sentinel
    private int size = 0;                           //number of elements in list

    /**
     * Constructs new empty list
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    /**
     * Returns the number of elements in the linked list
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns, but does not remove, the first element of the list
     *
     * @return
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    /**
     * Returns, but does not remove, the last element of the list
     *
     * @return
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    //public update methods
    /**
     * adds element e to front of list
     *
     * @param e
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * adds element e to end of list
     *
     * @param e
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * removes and returns element e from front of list
     *
     * @return
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    /**
     * removes and returns element e from end of list
     *
     * @return
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    //private update methods
    /**
     * Adds element e to the linked list between the given nodes.
     *
     * @param e
     * @param predecessor
     * @param successor
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        //create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element
     *
     * @param node
     * @return
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
} //---------- end of DoublyLinkedList class -----------
