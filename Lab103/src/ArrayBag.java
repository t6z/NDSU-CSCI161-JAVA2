
import java.util.Random;
/**
 * ArrayBag implements BagInterface. Uses all methods from BagInterface and an 
 * extra method that will return an item at a specific index of array.
 * Uses array structure as generic bag with no order of elements.
 * 
 * @author tsmal
 * @version 20180915
 * @param <E> 
 */
public class ArrayBag<E> implements BagInterface<E> {

    private E[] list;
    private int arraySize;
    private int count;
    /**
     * generic constructor. Sets arraySize to 50
     */
    public ArrayBag() {
        arraySize = 50;
        list = (E[]) new Object[arraySize];
        count = 0;
    }
    /**
     * overloaded constructor. Takes in int length
     * @param length 
     */
    public ArrayBag(int length) {
        arraySize = length;
        list = (E[]) new Object[arraySize];
        count = 0;
    }
    /**
     * returns count
     * @return 
     */
    public int getCurrentSize() {
        return count;
    }
    /**
     * returns boolean value: true if empty, false otherwise
     * @return 
     */
    public boolean isEmpty() {
        return count == 0;
    }
    /**
     * adds item to bag.
     * @param newItem
     * @throws IllegalArgumentException 
     */
    public void addItem(E newItem) throws IllegalArgumentException {
        if (count == arraySize) {
            //if the count IS equal to array size

            //create new temp array double the size of list, copy list onto temp,
            //change reference of list to temp, then make temp reference null
            E[] temp;
            temp = (E[]) new Object[arraySize * 2];
            arraySize *= 2;
            for (int i = 0; i < count; i++) {
                temp[i] = list[i];
            }
            list = temp;
            temp = null;
            list[count] = newItem;

        } else {
            //if the count IS NOT equal to array size
            list[count] = newItem;
        }
        System.out.println("A item was added");
        count++;
    } //end of add method

    /**
     * removes random item from bag and returns it
     * @return 
     */
    public E remove(){
        E itemRemoved = null;
        if (0 == count) {
            throw new IllegalArgumentException("Array is empty");
        } else {
            Random randomRemove = new Random();
            int randomIndex = randomRemove.nextInt(count);
            
            itemRemoved = list[randomIndex];
            for (int j = randomIndex + 1; j < count; j++) {
                list[j - 1] = list[j];
            }
            count--;
            System.out.println("An item was removed.");
            return itemRemoved;
        }
    }
    /**
     * removes first instance of item in bag. Returns boolean value: true if removed, false otherwise
     * @param item
     * @return 
     */
    public boolean remove(E item){
        if (0 == count) {
            System.out.println("The item cannot be removed because the array is empty...");
            return false;
        }else {
            for (int i = 0; i < count; i++) {
                if (item.equals(list[i])) {
                    for (int j = i + 1; j < count; j++) {
                        list[j - 1] = list[j];
                    }
                    System.out.println("The first occurance of item entered was removed");
                    count--;
                    return true;
                }
            }
            return false;
        }
    }
    /**
     * clears bag of contents
     */
    public void clear(){
        count = 0;
    }
    /**
     * returns int with frequency of item within bag
     * @param item
     * @return 
     */
    public int getFrequencyOf(E item){
        int frequency = 0;
        for (int i = 0; i < count; i++) {
            if (item == list[i]) {
                frequency++;
            }
        }
        return frequency;
    }
    /**
     * returns boolean value: true if item is in bag, false otherwise
     * @param item
     * @return 
     */
    public boolean contains(E item){
        for (int i = 0; i < count; i++) {
            if (item == list[i]) {
                return true;
            }
        }
        return false;
    }
    /**
     * returns item from specific index of ArrayBag
     * @param index
     * @return 
     */
    public E returnFromIndex(int index){
        return list[index];
    }
    /**
     * returns string with contents of bag
     * @return 
     */
    public String toString(){
        String str = getClass().getName() + " " + ":" + " Size of Array: " + arraySize + " : Count of Array: " + count + " : ";
        for (int i = 0; i < count; i++) {
            str += list[i] + ":";       //THIS MAY BE WRONG
        }
        return str;
    }
    /**
     * returns boolean value: true if o == item called on, false otherwise
     * @param o
     * @return 
     */
    public boolean equals(Object o){
        if (!(o instanceof ArrayBag)) {
            return false;
        }
        ArrayBag s = (ArrayBag) o;
        return s.list == this.list && s.count == this.count && s.arraySize == this.arraySize;
    }
}
