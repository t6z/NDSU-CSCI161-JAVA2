
/**
 *
 * @author tsmal
 * @version 20180831
 *
 * Salaried is a subclass to Employee Salaried contains basic getters, setters,
 * toString, and equals methods. Salaried also contains a static variable
 * 'numOfSalaried' integer that has two methods: a getter and increment methods.
 */
public class Salaried extends Employee {

    private String title;
    private int salary;
    //static variable for number of salaried workers
    public static int numOfSalaried;

    /**
     * Overload Constructor for Salaried Class
     *
     * @param id
     * @param name
     * @param title
     * @param salary
     */
    public Salaried(int id, String name, String title, int salary) {
        super(id, name);
        this.salary = salary;
        this.title = title;
    }

    /**
     * Returns Salary as Integer
     *
     * @return
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Returns Title as String
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns number of salaried employees as integer
     *
     * @return
     */
    public int getNumOfSalaried() {
        return numOfSalaried;
    }

    /**
     * sets a new salary
     *
     * @param newSalary
     */
    public void setSalary(int newSalary) {
        salary = newSalary;
    }

    /**
     * sets a new title
     *
     * @param newTitle
     */
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    /**
     * increments the numOfSalaried by one
     */
    public void incrementNumOfSalaried() {
        numOfSalaried++;
    }

    /**
     * returns String with contents of object
     *
     * @return
     */
    public String toString() {
        return getClass().getName() + ":" + super.id + ":" + super.name + ":" + title + ":" + salary;
    }

    /**
     * Given Object o, will compare against Salaried object called and return
     * boolean on whether they are equal or not
     *
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (!(o instanceof Salaried)) {
            return false; //Checks if o is an instance
        }
        Salaried s = (Salaried) o;
        return id == s.id //if o is an instance, compares all instance variables to see if equal
                && name.equals(s.name)
                && title.equals(s.title)
                && salary == s.salary;
    }
}
