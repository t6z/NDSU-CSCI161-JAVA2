/**
 * Compares hired numbers of two Employee classes.
 * Return -1 if b hired > a hired
 * Return 0 if they are equal
 * Return 1 if a hired > b hired
 * @author tsmal
 */
public class HiredComparator implements Comparator<Employee> {

    public HiredComparator() {
    }

    @Override
    public int compare(Employee a, Employee b) {
        if (a == null || b == null) {
            
        }

        int returnValue = 0;

        int aHired = a.getHired();
        int bHired = b.getHired();

        if (aHired == bHired) {
            returnValue = 0;
        }
        if (aHired > bHired) {
            returnValue = 1;
        }
        if (aHired < bHired) {
            returnValue = -1;
        }

        return returnValue;
    }
}
