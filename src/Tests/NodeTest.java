package Tests;

import LinkedList.Employee;
import LinkedList.Node;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/// <summary>
/// EmployeeTest - A class for testing the Employee class
/// Employee - A class for representing an employee with a first name, last name and EmployeeID.
///            Must be comparable with itself based on the EmployeeID
///
/// @author: Randeep Singh Virk
/// @version 1.0
/// @since 2022-02-08
/// </summary>
public class NodeTest {
    //region Constructor Tests
    /// <summary>
    /// Test the empty constructor to ensure the values are set to the proper defaults.
    /// </summary>
    @Test
    public void Empty_Constructor_Test() {
        Node<Employee> node = new Node<Employee>();
        assertNotNull(node);
        assertNull(node.getElement());
        assertNull(node.getNext());
        assertNull(node.getPrevious());

    }

    /// <summary>
    /// Test the parameter constructor to ensure the values are being set properly in the created instance.
    /// </summary>
    @Test
    public void AllParameters_Constructor_Test() {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        Node<Employee> previousNode = new Node<Employee>(employee1, null, null);
        Node<Employee> nextNode = new Node<Employee>(employee2, null, null);

        Node<Employee> node = new Node<Employee>(employee3, previousNode, nextNode);

        assertNotNull(node);
        Assertions.assertEquals(node.getElement(), employee3);
        Assertions.assertEquals(node.getNext(), nextNode);
        Assertions.assertEquals(node.getPrevious(), previousNode);

    }
    //endregion

    //region Properties Test
    /// <summary>
    /// Test the Element property to ensure that it is being set and retrieved properly.
    /// </summary>
    @Test
    public void Element_Test() {
        Employee employeeTest = new Employee(1);

        Node<Employee> node = new Node<Employee>();
        node.setElement(employeeTest);

        Assertions.assertEquals(node.getElement(), employeeTest);

    }

    /// <summary>
    /// Test the Previous property to ensure it is being set and retrieved properly.
    /// </summary>
    @Test
    public void Previous_Test() {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Node<Employee> previousNode = new Node<Employee>(employee1, null, null);
        Node<Employee> testNode = new Node<Employee>(employee2, null, null);

        testNode.setPrevious(previousNode);

        Assertions.assertEquals(testNode.getPrevious(), previousNode);

    }

    /// <summary>
    /// Test the Next property to ensure it is being set and retrieved properly.
    /// </summary>
    @Test
    public void Next_Test() {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Node<Employee> nextNode = new Node<Employee>(employee1, null, null);
        Node<Employee> testNode = new Node<Employee>(employee2, null, null);

        testNode.setNext(nextNode);

        Assertions.assertEquals(testNode.getNext(), nextNode);

    }
    //endregion
}