
/**
 *
 * @author tsmal
 * @version 20180831
 *
 * Hourly is a subclass to Employee. Hourly contains basic getters, setters,
 * toString, and equals methods. Hourly also contains a static variable
 * 'numOfHourly' integer that has two methods: a getter and increment methods.
 *
 */
public class Hourly extends Employee {

    private String position;
    private double hourlyRate;
    //Static Variable for number of hourly employees
    public static int numOfHourly;

    /**
     * Overloaded Constructor for Hourly class
     *
     * @param id
     * @param name
     * @param position
     * @param hourlyRate
     */
    public Hourly(int id, String name, String position, double hourlyRate) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.position = position;
    }

    /**
     * Returns Hourly Rate in double
     *
     * @return
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Returns position name in String
     *
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     * returns number of Hourly Employees
     *
     * @return
     */
    public int getNumOfHourly() {
        return numOfHourly;
    }

    /**
     * Sets a new hourly rate. If new rate is less than 0.00 than it will set
     * new rate to 0.00
     *
     * @param newHourlyRate
     */
    public void setHourlyRate(double newHourlyRate) {
        if (newHourlyRate < 0.00) {
            hourlyRate = 0.00;
        } else {
            hourlyRate = newHourlyRate;
        }
    }

    /**
     * Sets a new position
     *
     * @param newPosition
     */
    public void setPosition(String newPosition) {
        position = newPosition;
    }

    /**
     * Increments the numOfHourly integer variable by one
     */
    public void incrementNumOfHourly() {
        numOfHourly++;
    }

    /**
     * Returns String that is contents of object
     *
     * @return
     */
    public String toString() {
        return getClass().getName() + ":" + super.id + ":" + super.name + ":" + position + ":" + hourlyRate;
    }

    /**
     * Compares Object o against Hourly object called on to check if they are
     * equal or not
     *
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (!(o instanceof Hourly)) {
            return false;
        }
        Hourly h = (Hourly) o;
        return id == h.id
                && name.equals(h.name)
                && position.equals(h.position)
                && Math.abs(hourlyRate - h.hourlyRate) < 0.01;

    }
}
