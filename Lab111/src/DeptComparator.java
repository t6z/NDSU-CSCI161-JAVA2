/**
 *
 * Compares department numbers of two Employee classes.
 * Return -1 if b department > a department
 * Return 0 if they are equal
 * Return 1 if a department > b department
 * 
 * @author tsmal
 * @version 20181121
 */
public class DeptComparator implements Comparator<Employee> {

    public DeptComparator() {
    }

    @Override
    public int compare(Employee a, Employee b) {
        if (a == null || b == null) {

        }

        int returnValue = 0;

        int aDept = a.getDept();
        int bDept = b.getDept();

        if (aDept == bDept) {
            returnValue = 0;
        }
        if (aDept > bDept) {
            returnValue = 1;
        }
        if (aDept < bDept) {
            returnValue = -1;
        }

        return returnValue;
    }

}
