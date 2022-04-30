
/**
 *
 * @author thomas smallarz
 * @version 20180831
 *
 * Employee is a super class to two subclasses, Hourly and Salaried. It passes
 * some variables to those subclasses. Employee contains basic getters, setters,
 * toString, and equals methods. Employee also contains a static variable
 * 'numOfEmployees' integer that has two methods: a getter and increment
 * methods.
 */
public class Employee {

    protected int id;
    protected String name;
    //static variable for number of employees total
    private static int numOfEmployees;

    /**
     * Overloaded Constructor for Employee Class
     *
     * @param id
     * @param name
     */
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * This method will return the ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * This method will return the name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method will return the number of employees
     *
     * @return
     */
    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    /**
     * This method will set a new ID
     *
     * @param newId
     */
    public void setId(int newId) {
        id = newId;
    }

    /**
     * This method will set a new Name
     *
     * @param newName
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * This method will increment the number of employees by one
     */
    public void incrementNumOfEmployees() {
        numOfEmployees++;
    }

    /**
     * This method will turn the contents of this Employee object into a string
     *
     * @return
     */
    public String toString() {
        return getClass().getName() + ":" + id + ":" + name;
    }

    /**
     * This method will compare an Object o against the object calling it and
     * return a boolean on whether they are equal or not
     *
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee e = (Employee) o;
        return id == e.id
                && name.equals(e.name);
    }
}
