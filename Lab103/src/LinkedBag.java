
import java.util.Random;
/**
 * LinkedBag implements BagInterface.
 * LinkedBag contains all methods from BagInterface and contains an extra method
 * that returns an item from a specific index of linked list
 * 
 * Uses linked list structure to store items in generic unsorted bag.
 * @author tsmal
 * @version 20180915
 * @param <E> 
 */
public class LinkedBag<E> implements BagInterface<E> {

    private int count;
    private SinglyLinkedList list;
    /**
     * default constructor
     */
    public LinkedBag() {
        count = 0;
        list = new SinglyLinkedList();
    }
    /**
     * returns count (current size)
     * @return 
     */
    public int getCurrentSize() {
        return count;
    }
    /**
     * returns boolean: true if empty, false otherwise
     * @return 
     */
    public boolean isEmpty() {
        return count == 0;
    }
    /**
     * adds item passed into method. Increments count by one
     * @param item
     * @throws IllegalArgumentException 
     */
    public void addItem(E item) throws IllegalArgumentException {
        list.addFirst(item);
        count++;
    }
    /**
     * removes random item from bag and returns it
     * @return 
     */
    public E remove() {
        E returnedItem;
        if (count == 0) {
            System.out.println("The List is empty...");
            return null;
        } else {
            Random rand = new Random();
            int randomNumber = rand.nextInt(count);

            E temp;
            for (int j = 0; j < randomNumber + 1; j++) {
                temp = (E) list.removeFirst();
                list.addLast(temp);
            }
            returnedItem = (E) list.removeFirst();
            count--;
        }
        return returnedItem;
    }
    /**
     * removes first instance of item passed into method returns boolean:
     * true if removed, false otherwise
     * @param item
     * @return 
     */
    public boolean remove(E item) {
        E temp;
        for (int j = 0; j < count; j++) {
            if ((list.first()).equals(item)) {
                list.removeFirst();
                count--;
                return true;
            }
            temp = (E) list.removeFirst();
            list.addLast(temp);
        }
        return false;
    }
    /**
     * clears entire bag, sets count to zero
     */
    public void clear() {
        count = 0;
        for (int i = 0; i < count; i++) {
            list.removeFirst();
        }
    }
    /**
     * returns int with frequency of item in bag passed into method
     * @param item
     * @return 
     */
    public int getFrequencyOf(E item) {
        E temp;
        int frequency = 0;

        for (int j = 0; j < count; j++) {
            if (item == list.first()) {
                frequency++;
            }
            temp = (E) list.removeFirst();
            list.addLast(temp);
        }
        return frequency;
    }
    /**
     * returns boolean value if item is within bag: true if it is, false otherwise
     * @param item
     * @return 
     */
    public boolean contains(E item) {
        E temp;

        for (int j = 0; j < count; j++) {
            if (item == list.first()) {
                return true;
            }
            temp = (E) list.removeFirst();
            list.addLast(temp);
        }
        return false;
    }
    /**
     * returns item from specific index of linked list
     * @param index
     * @return 
     */
    public E returnFromIndex(int index){
        E temp;
        for(int j = 0;j<index;j++){
            temp = (E) list.removeFirst();
            list.addLast(temp);
        }
        return (E) list.first();
    }
    /**
     * returns string with contents of LinkedBag
     * @return 
     */
    public String toString() {
        String output = getClass().getName() + " : " + count + " : ";
        E temp;
        for(int j = 0;j<count;j++){
            output += list.first() + " : ";
            temp = (E) list.removeFirst();
            list.addLast(temp);
        }
        return output;
    }
    /**
     *returns boolean value: true if o == item called on, false otherwise
     * @param o
     * @return 
     */
    public boolean equals(Object o) {
        if (!(o instanceof LinkedBag)) {
            return false;
        }
        LinkedBag s = (LinkedBag) o;
        return s.count == this.count && s.list == this.list;
    }
}
