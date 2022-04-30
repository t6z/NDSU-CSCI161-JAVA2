/**
 * The only file within this package is Client.java that contains the main method
 * 3 String variables are hard-coded as different word variants using the same
 * four letters. These Strings are passed through a hashCode method and their base 
 * two version of the integers returned are displayed. Then it also shows a detailed
 * verbose version of the same method.
 * 
 * @author tsmal
 * @version 20181108
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "STOP";
        String b = "TOPS";
        String c = "POTS";

        System.out.println("Summary hash code information:");
        System.out.println("\tSTOP: " + Integer.toBinaryString(hashCode(a)));
        System.out.println("\tTOPS: " + Integer.toBinaryString(hashCode(b)));
        System.out.println("\tPOTS: " + Integer.toBinaryString(hashCode(c)));

        System.out.println("\n\nDetailed hash code information:");
        hashCodeVerbose(a);
        hashCodeVerbose(b);
        hashCodeVerbose(c);
    }

    /**
     * Data Structures & Algorithms 6th Edition Goodrick, Tamassia, Goldwasser
     * Code Fragment: 10.6
     *
     * Takes a String s as a parameter and implements the cyclic-shift hash code computation
     * described the book shown above.
     * @param s
     * @return
     */
    static int hashCode(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of the running sum
            h += (int) s.charAt(i); // add in next character
        }
        return h;
    }

    /**
     * Verbose version of hashCode that describes the processes the hashCode
     * method is going through. It prints to the System.out what operations are
     * happening and prints a binary version of the integer h. To do this it
     * uses Integer.toBinaryString() which does not contain leading zeros.
     *
     * @param s
     */
    static void hashCodeVerbose(String s) {
        System.out.println("Creating hash code for: " + s);
        int h = 0;
        int shift5;
        int shift27;
        char c;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("\nEntering hash code, pass " + i + ": " + Integer.toBinaryString(h));

            shift5 = h << 5;
            System.out.println("hashCode << 5: " + Integer.toBinaryString(shift5));
            shift27 = h >>> 27;
            System.out.println("hashCode >>> 27: " + Integer.toBinaryString(shift27));

            h = shift5 | shift27; // 5-bit cyclic shift of the running sum
            System.out.println("hashCode (h << 5) | (h >>> 27): " + Integer.toBinaryString(h));

            c = s.charAt(i);
            h += (int) c; // add in next character
            System.out.println("Adding character: " + c);
        }
        System.out.println("\nExiting hash code: " + Integer.toBinaryString(h) + "\n\n\n");
    }
}
