
/**
 * Compares id numbers of two Employee classes.
 * Return -1 if b id > a id
 * Return 0 if they are equal
 * Return 1 if a id > b id
 *
 * @author tsmal
 * @version 20181121
 */
public class IdComparator implements Comparator<Employee> {

    public IdComparator() {
    }

    @Override
    public int compare(Employee a, Employee b) {
        if (a == null || b == null) {
        }

        int returnValue = 0;

        int aId = a.getId();
        int bId = b.getId();

        if (aId == bId) {
            returnValue = 0;
        }
        if (aId > bId) {
            returnValue = 1;
        }
        if (aId < bId) {
            returnValue = -1;
        }

        return returnValue;
    }
}
