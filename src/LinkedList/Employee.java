package LinkedList;

/**
 * The Employee class used implements an application that
 * will store and process the employee data.
 *
 * @author Randeep Singh Virk
 * @version 1.0
 * @updated 2022-01-20
 * @since 2022-01-20
 */
public class Employee implements Comparable<Employee> {
    /**
     * Variables to store the employeeId, firstName, and lastName.
     */
    private final int employeeId; //
    private final String firstName;
    private final String lastName;

    /**
     * Default constructor.
     *
     * @param employeeId The employee's id.
     */
    public Employee(int employeeId) {
        this.employeeId = employeeId;
        firstName = null;
        lastName = null;
    }

    /**
     * Instance constructor that has three parameters.
     *
     * @param employeeId The employee's id.
     * @param firstName  The employee's first name.
     * @param lastName   The employee's last name.
     */
    public Employee(int employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the employeeId.
     *
     * @return employeeId Returns the employee's id.
     */
    public int getEmployeeID() {
        return employeeId;
    }

    /**
     * Gets the firstName.
     *
     * @return firstName Returns the employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the lastName.
     *
     * @return lastName Returns the employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * The comparison of employees based on the EmployeeID (Larger values are bigger than smaller values).
     *
     * @param id The employee id's.
     * @return Return the comparison between two employees id.
     */
    public int compareTo(Employee id) {
        return Integer.compare(this.employeeId, id.employeeId);
    }

    /**
     * Returns the string consisting employeeId, firstName, and lastName.
     *
     * @return Returns the string consisting employeeID, firstName, and lastName.
     */
    public String toString() {
        return getEmployeeID() + " " + getFirstName() + " " + getLastName();
    }
}
