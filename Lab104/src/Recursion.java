
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class with three recursive methods inside.
 *
 * 1. Nth recursive harmonic series
 *
 * 2. Method for summing an array of numbers with size of 2^n
 *
 * 3. Prints the file system tree when given a String path
 *
 * @author tsmal
 * @version 20180927
 */
public class Recursion {

    private String output = ""; //Used in file system recursion
    private Boolean b = false;
    /**
     * Generic constructor
     */
    public Recursion() {
    }
    /**
     * Used to return boolean value b, used in Isabel's technique
     * when the array is not the power of two.
     * @return 
     */
    public boolean getB(){
        return b;
    }
    /**
     * Used to set b value used in Isabel's technique.
     * @param newB 
     */
    public void setB(boolean newB){
        b = newB;
    }
    /**
     * Takes in a double variable, finds the sum of 1/n for 1 to n (Harmonic
     * Series) Returns a double.
     *
     * @param n
     * @return
     */
    public static double nthRecursion(double n) {
        //Check if n is an integer. Must use double otherwise answer will
        //always be 1.
        if (!(n % 1 == 0)) {
            throw new IllegalArgumentException("n must be an integer...");
        }
        if (n < 1) {
            throw new IllegalArgumentException("n cannot be less than one...");
        }
        if (n == 1) {
            return 1;
        } else {
            return (1 / n) + nthRecursion(n - 1);
        }
    }

    /**
     * takes in a string that is location of a whitespace delimited text file.
     * Scans integers from such file and adds them to dynamic array bag. Then
     * calls recursive Technique method
     *
     * @param data
     * @return
     * @throws FileNotFoundException
     */
    public int isabelsRecursion(String data) throws FileNotFoundException {
        //Create scanner and ArrayBag to store data

        Scanner scanner = new Scanner(new File(data));
        ArrayBag A = new ArrayBag();
        //add numbers into a array
        while (scanner.hasNextInt()) {
            A.add(scanner.nextInt());
        }
        System.out.println(A.toString());

        //Check if it is a power of two
        if (!((A.getCurrentSize() & (A.getCurrentSize() - 1)) == 0)) {
            b = true;
            return 0;
        }

        return Technique(A);
    }

    /**
     * The recursive part of Isabel's Recursive Technique. Gets called from
     * isabelsRecursion. Takes in an ArrayBa, and returns an integer value.
     *
     * @param A
     * @return
     */
    public int Technique(ArrayBag A) {
        //If count = 1 returns number in array
        if (A.getCurrentSize() == 1) {
            return A.get(0);
        }
        //Creates ArrayBag B half the size of A
        ArrayBag B = new ArrayBag(A.getCurrentSize() / 2);
        //Adds numbers from A. If A is " 1 , 2 , 3 , 4 ". It will add 1 and 2
        //and place into A[0], and will add 3 and 4 and place into A[1].
        for (int i = 0; i < A.getCurrentSize() / 2; i++) {
            B.add((A.get(2 * i) + A.get(2 * i + 1)));
        }

        if (B.getCurrentSize() == 1) {
            return B.get(0);
        } else {
            return Technique(B);
        }
    }

    /**
     * Recursive method prints out file system tree when given a String of the
     * path
     *
     * @param path
     */
    public void list(String path) {
        File fpath = new File(path);

        if (!(fpath.isDirectory())) {
            System.out.println(path);
        } else {
            File[] files = fpath.listFiles();
            for (File f : files) {
                output = path + "\\" + f.getName();
                list(output);
            }
        }
    }
}
