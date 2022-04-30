/**
 *
 * @author tsmal
 * @version 20181121
 */
public class NameComparator implements Comparator<Employee> {

    public NameComparator() {
    }

    @Override
    public int compare(Employee a, Employee b) throws NullPointerException {
        if (a == null || b == null) {
            
        }

        String aName = a.getName();
        String bName = b.getName();
        /**
         * If a is longer than b. Then only compare for b's length If b is
         * longer than a. Then only compare for a's length
         */
        if (aName.length() == bName.length()) {
            for (int i = 0; i < aName.length(); i++) {
                if (compareChar(aName.charAt(i), bName.charAt(i)) == 1) {
                    return 1;
                } else if (compareChar(aName.charAt(i), bName.charAt(i)) == -1) {
                    return -1;
                }
            }
            return 0;
        } else if (aName.length() < bName.length()) {
            for (int i = 0; i < aName.length(); i++) {
                if (compareChar(aName.charAt(i), bName.charAt(i)) == 1) {
                    return 1;
                } else if (compareChar(aName.charAt(i), bName.charAt(i)) == -1) {
                    return -1;
                }
            }
            return -1;
        } else {
            for (int i = 0; i < bName.length(); i++) {

                if (compareChar(aName.charAt(i), bName.charAt(i)) == 1) {
                    return 1;
                } else if (compareChar(aName.charAt(i), bName.charAt(i)) == -1) {
                    return -1;
                }
            }
            return 1;
        }
    }

    public static int compareChar(char a, char b) {
        int aInt = (int) a;
        int bInt = (int) b;

        if (aInt == bInt) {
            return 0;
        } else if (aInt < bInt) {
            return 1;
        } else {
            return -1;
        }
    }
}
