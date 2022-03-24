package LinkedList;

import java.util.NoSuchElementException;

/**
 * The LinkedList class used implements an application that will execute the linked-list data.
 *
 * @author Randeep Singh Virk
 * @version 1.0
 * @updated 2022-02-08
 * @since 2022-01-20
 */
public class LinkedList<T extends Comparable<T>> {

    //region Milestone 1
    /**
     * Variables size, head, tail for the linked-list.
     */
    public int size;
    public Node<T> head;
    public Node<T> tail;

    /**
     * Initializes all class variables to their default values.
     */
    public LinkedList() {
        clear();
    }

    /**
     * Adds the first Node to the linked-list.
     *
     * @param element The new element which will add at the first Node in the linked-list.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<T>(element, null, head);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrevious(newNode);
        }
        head = newNode;
        size++;
    }

    /**
     * Resets the LinkedList to the same condition it was in when it was first instantiated by the constructor.
     */
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * True if the linked-list is empty, false if the linked-list contains 1 or more Nodes.
     *
     * @return Returns the zero size of the linked-list.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the first/head element of the linked-list.
     *
     * @return Returns the element value contained by the Head Node.
     * @throws Exception If the linked-list is empty.
     */
    public T getFirst() throws Exception {
        if (isEmpty()) throw new NoSuchElementException();
        return head.getElement();
    }

    /**
     * Gets the last/tail element of the linked-list.
     *
     * @return Returns the element value contained by the Tail Node.
     * @throws Exception If the linked-list is empty.
     */
    public T getLast() throws Exception {
        if (isEmpty()) throw new NoSuchElementException();
        return tail.getElement();
    }

    /**
     * Adds the last Node.
     *
     * @param element The new element which will add at the last Node in the linked-list.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<T>(element, tail, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;

        size++;
    }

    //endregion

    //region Milestone 2

    /**
     * Sets the first element to the linked-list.
     *
     * @param element The new element which will replace the first element in the linked list.
     * @return Returns the old element.
     * @throws Exception If the linked-list is empty.
     */
    public T setFirst(T element) throws Exception {
        if (isEmpty()) throw new NoSuchElementException();

        T data = head.getElement();
        head.setElement(element);
        return data;
    }

    /**
     * Sets the last element to the linked-list.
     *
     * @param element The new element which will replace the last element in the linked list.
     * @return Returns the old element.
     * @throws Exception If the linked-list is empty.
     */
    public T setLast(T element) throws Exception {
        if (isEmpty()) throw new NoSuchElementException();

        T data = getLast(); //tail.getElement();
        tail.setElement(element);
        return data;
    }

    /**
     * Gets the head/first element in the linked-list.
     *
     * @return Returns the head/first element in the linked-list.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Gets the tail/last element in the linked-list.
     *
     * @return Returns the tail/last element in the linked-list.
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Gets the size of the linked-list.
     *
     * @return Returns the size of the linked-list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Removes the first Node in the linked-list. Return the removed node’s element.
     *
     * @return Return the removed node’s element.
     * @throws Exception If the linked-list is empty.
     */
    public T removeFirst() throws Exception {
        if (isEmpty()) throw new NoSuchElementException();

        Node<T> temp = head;
        if (head == tail) {
            head = tail = null;
        } else {
            // Move the head pointer to the next node
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
        return temp.getElement();
    }

    /**
     * Remove the last Node in the linked-list.
     *
     * @return Returns the removed node’s element.
     * @throws Exception If the linked-list is empty.
     */
    public T removeLast() throws Exception {
        if (isEmpty())
            throw new NoSuchElementException();

        // Move the tail pointer to the previous node
        Node<T> temp = tail;

        if (tail == head) {
            tail = head = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;

        return temp.getElement();
    }

    /**
     * Gets the Node specified at the position.
     *
     * @param position The position of the Node specified.
     * @return Returns the element at the position specified.
     */
    private Node<T> getNodeByPosition(int position) {
        if (position < 1 || position > size) throw new NoSuchElementException();

        Node<T> current = head;

        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Returns the value of the element contained in the Node at the position specified in the parameter.
     *
     * @param position The position of the Node specified.
     * @return Returns the element in the Node found at the position.
     * @throws Exception If the position provided is not valid: zero, negative or above the size of the list.
     */
    public T get(int position) throws Exception {
        return getNodeByPosition(position).getElement();
    }

    /**
     * Removes the Node at the position specified. Returns the old element’s value of the removed Node.
     *
     * @param position The position of the Node specified.
     * @return The element in the Node found at the position specified.
     * @throws Exception If the position provided is not valid: zero, negative or above the size of the list.
     */
    public T remove(int position) throws Exception {
        Node<T> current = getNodeByPosition(position);
        T data = null;

        if (position == 1) {
            data = head.getElement();
            if (head.getNext() == null) {
                head = tail = null;
            } else {
                head = head.getNext();
                head.setPrevious(null);
            }

        } else if (position == size) {
            data = tail.getElement();
            tail = tail.getPrevious();
            tail.setNext(null);
        } else {
            data = current.getElement();

            Node<T> before = current.getPrevious();
            Node<T> after = current.getNext();

            before.setNext(after);
            after.setPrevious(before);

//            (current.getNext()).setPrevious(current.getPrevious());
//            (current.getPrevious()).setNext(current.getNext());
        }
        size--;
        return data;
    }

    /**
     * Finds the Node at the position specified and replaces the element on that node with a new element. Returns the old element’s value.
     *
     * @param element  The new element which will replace the element specified at the position.
     * @param position The position of the node specified.
     * @return Returns the old element’s value.
     * @throws Exception If the position provided is not valid: zero, negative or above the size of the list.
     */
    public T set(T element, int position) throws Exception {
        if (position < 1 || position > size) throw new NoSuchElementException();

        Node<T> current = head;
        T data = null;

        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        data = current.getElement();
        current.setElement(element);

        return data;
    }

    /**
     * Finds the Node at the position specified and adds a new node after it.
     *
     * @param element  The new element which will be added after the node specified at the position.
     * @param position The position of the node specified.
     * @throws Exception If the position provided is not valid: zero, negative or above the size of the list.
     */
    public void addAfter(T element, int position) throws Exception {
        if (position < 1 || position > size) throw new NoSuchElementException();

        Node<T> current = head;

        if (position == getSize()) {
            Node<T> newNode = new Node<T>(element, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(element, current, current.getNext());

            current.getNext().setPrevious(newNode);
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Finds the Node at the position specified and adds a new node before it.
     *
     * @param element  The new element which will be added before the node specified at the position.
     * @param position The position of the node specified.
     * @throws Exception If the position provided is not valid: zero, negative or above the size of the list.
     */
    public void addBefore(T element, int position) throws Exception {
        if (position < 1 || position > size) throw new NoSuchElementException();

        Node<T> current = head;

        if (position == 1) {
            Node<T> newNode = new Node<T>(element, null, head);
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        } else {
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(element, current.getPrevious(), current);
            (current.getPrevious()).setNext(newNode);
            current.setPrevious(newNode);
        }
        size++;
    }

    //endregion

    //region Milestone 3

    /**
     * Finds the first node found with the specified element value and returns that node’s value.
     *
     * @param element
     * @return Returns the node's value.
     */
    private Node<T> getNodeByElement(T element) {

        if (element == null) throw new NullPointerException(); // If no such element is in the linked-list.
        if (isEmpty()) throw new NoSuchElementException(); // If the linked-list is empty.

        Node<T> current = head;

        while (current != null && (current.getElement().compareTo(element) != 0)) {
            current = current.getNext();
        }
        if (current == null) {
            throw new NoSuchElementException();
        }
        return current;
    }

    /**
     * @param element
     * @return
     * @throws Exception
     */
    public T get(T element) throws Exception {

        Node<T> current = getNodeByElement(element);
        T data = null;

        data = current.getElement();

        return data;
    }

    /**
     * Finds the Node at the position specified and adds a new node after it.
     *
     * @param element    The new element which will be added after the provided element.
     * @param oldElement The provided element after which the new element will be added.
     * @throws Exception If the oldElement provided is not present in the linked-list.
     */
    public void addAfter(T element, T oldElement) throws Exception {

        Node<T> current = getNodeByElement(oldElement);

        if (current == tail) {
            Node<T> newNode = new Node<T>(element, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            Node<T> newNode = new Node<T>(element, current, current.getNext());
            current.getNext().setPrevious(newNode);
            current.setNext(newNode);
        }

        size++;
    }

    /**
     * Finds the Node at the position specified and adds a new node before it.
     *
     * @param element    The new element which will be added after the provided element.
     * @param oldElement The provided element before which the new element will be added.
     * @throws Exception If the oldElement provided is not present in the linked-list.
     */
    public void addBefore(T element, T oldElement) throws Exception {

        Node<T> current = getNodeByElement(oldElement);
        if (current == head) {
            Node<T> newNode = new Node<T>(element, null, head);
            head.setPrevious(newNode);
            head = newNode;
        } else {
            Node<T> newNode = new Node<T>(element, current.getPrevious(), current);
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);
        }

        size++;
    }

    /**
     * Removes the first node found with the specified element value and returns that node’s value.
     *
     * @param element The element which will be removed from the linked-list.
     * @return Returns the node's value.
     * @throws Exception If the element provided is not present in the linked-list.
     */
    public T remove(T element) throws Exception {

        Node<T> current = getNodeByElement(element);
        T data = current.getElement();

        if (current.getPrevious() == null && current.getNext() == null) {
            head = tail = null;
        } else if (current == head) {
            head = head.getNext();
            head.setPrevious(null);
        } else if (current == tail) {
            tail = tail.getPrevious();
            tail.setNext(null);
        } else {
            Node<T> before = current.getPrevious();
            Node<T> after = current.getNext();

            before.setNext(after);
            after.setPrevious(before);
        }

        size--;
        return data;
    }

    /**
     * Finds the first node found with the specified oldElement value and replaces the element on that node with a new element.
     *
     * @param element    The new element which will replace the old element.
     * @param oldElement The oldElement which will be replaced with the new element.
     * @return Returns the original value of the found Node’s element.
     * @throws Exception If the oldElement provided is not present in the linked-list.
     */
    public T set(T element, T oldElement) throws Exception {
        Node<T> current = getNodeByElement(oldElement);
        T data = null;

        data = current.getElement();
        current.setElement(element);

        return data;
    }

    /**
     * Add the element into the linked-list in natural ascending order.
     *
     * @param element The new element which will be added in natural ascending order.
     */
    public void insert(T element) {

        if (head == null) {
            Node<T> newNode = new Node<T>(element);
            head = newNode;
            tail = newNode;

        } else {
            Node<T> current = head;
            Node<T> prev = null;

            while (current != null && element.compareTo(current.getElement()) > 0) {
                prev = current;
                current = current.getNext();
            }

            if (current == null) {
                Node<T> newNode = new Node<T>(element, tail, null);
                tail.setNext(newNode);
                tail = newNode;
            } else if (current == head) {
                Node<T> newNode = new Node<T>(element, null, head);
                head.setPrevious(newNode);
                head = newNode;
            } else {
                Node<T> newNode = new Node<T>(element, prev, current);
                prev.setNext(newNode);
                current.setPrevious(newNode);
            }
        }
        size++;
    }

    /**
     * Sort the elements inside the linked-list into ascending order.
     */
    public void sortAscending() {
//        Node<T> node = head;
//        clear();
//
//        while(node != null) {
//            insert(node.getElement());
//            node = node.getNext();
//        }

        boolean isSorted = false;
        for (int i = 0; i < size - 1 && !isSorted; i++) {
            Node<T> left = head;
            isSorted = true;
            for (int j = 0; j < size - 1 - i; j++) {
                Node<T> right = left.getNext();

                if (left.getElement().compareTo(right.getElement()) > 0) {
                    T temp = left.getElement();
                    left.setElement(right.getElement());
                    right.setElement(temp);
                    isSorted = false;
                }
                left = right;
            }
        }
    }


    //endregion

} // End of the LinkedList class.

