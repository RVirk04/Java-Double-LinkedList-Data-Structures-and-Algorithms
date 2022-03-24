package LinkedList;

/**
 * The Node class used implements an application that
 * will store and process the Linked-list data.
 *
 * @author Randeep Singh Virk
 * @version 1.0
 * @updated 2022-01-20
 * @since 2022-01-20
 */
public class Node<T> {

    /**
     * Variables to store element, previousNode, and nextNode.
     */
    private T element;
    private Node<T> previousNode;
    private Node<T> nextNode;

    /**
     * Default constructor.
     */
    public Node() {
    }

    /**
     * Instance constructor with one parameter element.
     *
     * @param element The element.
     */
    public Node(T element) {
        this.element = element;
    }

    /**
     * Instance constructor with three parameter element, previousNode, and nextNode.
     *
     * @param element      The element.
     * @param previousNode The previous Node.
     * @param nextNode     The next Node.
     */
    public Node(T element, Node<T> previousNode, Node<T> nextNode) {
        this.element = element;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    /**
     * Gets the element.
     *
     * @return element Gets the element.
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the new element.
     *
     * @param element Sets the new element.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Gets the previous Node.
     *
     * @return previousNode Returns the previous Node.
     */
    public Node<T> getPrevious() {
        return previousNode;
    }

    /**
     * Sets the previous Node.
     *
     * @param prev Sets the previous Node.
     */
    public void setPrevious(Node<T> prev) {
        this.previousNode = prev;
    }

    /**
     * Gets the next Node.
     *
     * @return nextNode Returns the next Node.
     */
    public Node<T> getNext() {
        return nextNode;
    }

    /**
     * Sets the nextNode.
     *
     * @param next Sets the next Node.
     */
    public void setNext(Node<T> next) {
        this.nextNode = next;
    }
}

