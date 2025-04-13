package org.jokeoa.models;
import org.jokeoa.interfaces.ListIn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements ListIn<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Node class for the Double Linked List.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an item to the end of the list.
     * @param item the element to be added
     */
    @Override
    public void add(T item) {
        addLast(item);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    public void set(int index, T item) {
        checkElementIndex(index);
        Node<T> current = getNodeAt(index);
        current.data = item;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(item);
            return;
        }

        if (index == size) {
            addLast(item);
            return;
        }

        Node<T> successor = getNodeAt(index);
        Node<T> predecessor = successor.prev;
        Node<T> newNode = new Node<>(item);

        newNode.next = successor;
        newNode.prev = predecessor;
        predecessor.next = newNode;
        successor.prev = newNode;

        size++;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * @param item the element to add
     */

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     * @param item the element to add
     */

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    public T get(int index) {
        checkElementIndex(index);
        return getNodeAt(index).data;
    }

    /**
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    /**
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */

    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    public void remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        Node<T> nodeToRemove = getNodeAt(index);
        Node<T> predecessor = nodeToRemove.prev;
        Node<T> successor = nodeToRemove.next;

        predecessor.next = successor;
        successor.prev = predecessor;

        // Help GC
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.data = null;

        size--;
    }

    /**
     * Removes and returns the first element from this list.
     * @throws NoSuchElementException if this list is empty
     */

    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> oldHead = head;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = oldHead.next;
            head.prev = null;
            // Help GC
            oldHead.next = null;
        }

        oldHead.data = null; // Help GC
        size--;
    }

    /**
     * Removes and returns the last element from this list.
     * @throws NoSuchElementException if this list is empty
     */

    public void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> oldTail = tail;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = oldTail.prev;
            tail.next = null;
            // Help GC
            oldTail.prev = null;
        }

        oldTail.data = null; // Help GC
        size--;
    }

    /**
     * Sorts this list according to the natural ordering of its elements.
     * All elements in this list must implement the Comparable interface.
     * @throws ClassCastException if the list contains elements that are not mutually comparable
     */
    @SuppressWarnings("unchecked")

    public void sort() {
        if (size <= 1) {
            return;
        }


        Object[] array = toArray();

        Arrays.sort(array, (Comparator<Object>) (o1, o2) -> {
            return ((Comparable<Object>) o1).compareTo(o2);
        });

        Node<T> current = head;
        for (int i = 0; i < array.length; i++) {
            current.data = (T) array[i];
            current = current.next;
        }
    }

    /**
     * @param object element to search for
     * @return the index of the first occurrence of the specified element in this list,
     *         or -1 if this list does not contain the element
     */

    public int indexOf(Object object) {
        int index = 0;
        if (object == null) {
            for (Node<T> current = head; current != null; current = current.next) {
                if (current.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> current = head; current != null; current = current.next) {
                if (object.equals(current.data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * @param object element to search for
     * @return the index of the last occurrence of the specified element in this list,
     *         or -1 if this list does not contain the element
     */

    public int lastIndexOf(Object object) {
        int index = size - 1;
        if (object == null) {
            for (Node<T> current = tail; current != null; current = current.prev) {
                if (current.data == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (Node<T> current = tail; current != null; current = current.prev) {
                if (object.equals(current.data)) {
                    return index;
                }
                index--;
            }
        }
        return -1;
    }

    /**
     *
     * @param object element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */

    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    /**
     * @return an array containing all of the elements in this list in proper sequence
     */

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            result[i++] = current.data;
        }
        return result;
    }

    /**
     * Removes all of the elements from this list.
     */

    public void clear() {
        // Help GC by breaking references
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @return the number of elements in this list
     */

    public int size() {
        return size;
    }

    /**
     * @return an iterator over the elements in this list in proper sequence
     */

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;


            public boolean hasNext() {
                return current != null;
            }


            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Returns the node at the specified index.
     * @param index index of the node
     * @return the node at the specified index
     */
    private Node<T> getNodeAt(int index) {
        // Optimize: check if index is closer to head or tail
        if (index < (size >> 1)) {
            // Start from head
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            // Start from tail
            Node<T> current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    /**
     * Checks if the given index is valid for accessing elements.
     * @param index index to check
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * @return a string representation of this list
     */

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node<T> current = head;
        while (current.next != null) {
            sb.append(current.data);
            sb.append(", ");
            current = current.next;
        }
        sb.append(current.data);

        sb.append(']');
        return sb.toString();
    }
}