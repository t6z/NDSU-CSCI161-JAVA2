
/**
 * Scores class that implements BagInterface. Initializes all methods described
 * in BagInterface, and holds three new methods: get, toString, and equal.
 *
 * @author tsmal
 * @version 20180907
 */
import java.util.Random;

public class Scores implements BagInterface {

    //Instance Variables
    private int sizeOfArray;
    private int count;
    private int[] list;

    /**
     * Generic Constructor used if no sizeOfArray is used as parameter
     */
    public Scores() {
        sizeOfArray = 50;
        list = new int[sizeOfArray];
    }

    /**
     * Overloaded Constructor. Takes in a sizeOfArray to create an int array
     *
     * @param sizeOfArray
     */
    public Scores(int sizeOfArray) {
        this.sizeOfArray = sizeOfArray;
        list = new int[sizeOfArray];
    }

    /**
     * Returns the count which equals the current size
     *
     * @return
     */
    public int getCurrentSize() {
        return count;
    }

    /**
     * Returns a boolean type. Array empty returns true, if not than false
     *
     * @return
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clears the count
     */
    public void clear() {
        count = 0;
        System.out.println("The array has been cleared.");
    }

    /**
     * Parameter is an integer num.
     *
     * If count equals sizeOfArray then it creates a temp array that is
     * 2*sizeOfArray. Then, copies list onto temp, and sets list reference equal
     * to temp, and temp reference to null. Then adds number passed into method.
     *
     * If count does not equal sizeOfArray then it puts num in list[count]
     *
     * @param num
     */
    public void add(int num) {
        if (count == sizeOfArray) {
            //if the count IS equal to array size

            //create new temp array double the size of list, copy list onto temp,
            //change reference of list to temp, then make temp reference null
            int[] temp = new int[(2 * sizeOfArray)];

            for (int i = 0; i < count; i++) {
                temp[i] = list[i];
            }
            list = temp;
            temp = null;
            list[count] = num;

        } else {
            //if the count IS NOT equal to array size
            this.list[count] = num;
        }

        count++;
    } //end of add method

    /**
     * Parameter passed into method is integer num. Increments an int frequency
     * if num occurs in array
     *
     * @param num
     * @return
     */
    public int getFrequencyOf(int num) {
        int frequency = 0;
        for (int i = 0; i < count; i++) {
            if (num == list[i]) {
                frequency++;
            }
        }
        return frequency;
    }

    /**
     * Searches array for int num passed into method
     *
     * @param num
     * @return
     */
    public boolean contains(int num) {
        for (int i = 0; i < count; i++) {
            if (num == list[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the first account of num passed into method, then shifts all
     * other numbers to the left to fill new gap
     *
     * @param num
     */
    public void remove(int num) {
        if (0 == count) {
            throw new IllegalArgumentException("Array is empty");
        } else {
            for (int i = 0; i < count; i++) {
                if (list[i] == num) {
                    for (int j = i + 1; j < count; j++) {
                        list[j - 1] = list[j];
                    }
                    System.out.printf("The first occurance of %d was removed.%n",num);
                    break;
                }
            }
        }
        count--;
    } //end of remove(int num)

    /**
     * Removes a random member of the array between indexes 0 and Count-1.
     */
    public void remove() {
        if (0 == count) {
            throw new IllegalArgumentException("Array is empty");
        } else {
            Random randomRemove = new Random();
            int randomIndex = randomRemove.nextInt(count);

            for (int j = randomIndex + 1; j < count; j++) {
                list[j - 1] = list[j];
            }
        }
        count--;
        System.out.println("A number was removed.");
    } //end of remove()
    /**
     * retrieves number at index i in list array
     * @param i
     * @return 
     */
    public int get(int i) {
        int number = 0;
        try {
            number = list[i];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("You goofed! " + aioobe.toString());
        }
        return number;
    }
    /**
     * returns string with contents of object
     * @return 
     */
    public String toString() {
        String str = getClass().getName() + " " + ":" + " Size of Array: " + sizeOfArray + " : Count of Array: " + count + " : ";
        for (int i = 0; i < count; i++) {
            str += list[i] + ":";
        }
        return str;
    }
    /**
     * returns boolean value. True if object passed in is exact/equal to object
     * being called from, returns false otherwise
     * @param o
     * @return 
     */
    public boolean equal(Object o) {
        if (!(o instanceof Scores)) {
            return false;
        }
        Scores s = (Scores) o;
        return s.list == this.list && s.count == this.count && s.sizeOfArray == this.sizeOfArray;
    }
}
