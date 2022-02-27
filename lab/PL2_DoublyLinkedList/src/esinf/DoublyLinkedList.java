/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 *
 * @author DEI-ISEP
 * @param <E> Generic list element type
 */
public class DoublyLinkedList<E> implements Iterable<E>, Cloneable {

// instance variables of the DoublyLinkedList
    private final Node<E> header;     // header sentinel
    private final Node<E> trailer;    // trailer sentinel
    private int size = 0;       // number of elements in the list
    private int modCount = 0;   // number of modifications to the list (adds or removes)

    /**
     * Creates both elements which act as sentinels
     */
    public DoublyLinkedList() {

        header = new Node<>(null, null, null);      // create header
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    /**
     * Returns the number of elements in the linked list
     *
     * @return the number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty, and false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns (but does not remove) the first element in the list
     *
     * @return the first element of the list
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element in the list
     *
     * @return the last element of the list
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

// public update methods
    /**
     * Adds an element e to the front of the list
     *
     * @param e element to be added to the front of the list
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element e to the end of the list
     *
     * @param e element to be added to the end of the list
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Removes and returns the first element of the list
     *
     * @return the first element of the list
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    /**
     * Removes and returns the last element of the list
     *
     * @return the last element of the list
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

// private update methods
    /**
     * Adds an element e to the linked list between the two given nodes.
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> n = new Node<>(e, predecessor, successor);

        predecessor.setNext(n);
        successor.setPrev(n);

        size++;
        modCount++;
    }

    /**
     * Removes a given node from the list and returns its content.
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> sucessor = node.getNext();

        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);

        modCount++;
        size--;

        return node.getElement();
    }

// Overriden methods        
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        DoublyLinkedList<E> list = (DoublyLinkedList<E>) obj;
        if (list == null) {
            return false;
        }

        ListIterator<E> objItr = list.listIterator();
        ListIterator<E> classItr = this.listIterator();

        if (this.size() != list.size()) {
            return false;
        }

        while (classItr.hasNext()) {
            if (!classItr.next().equals(objItr.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        DoublyLinkedList<E> list = new DoublyLinkedList();

        ListIterator<E> objItr = list.listIterator();
        ListIterator<E> classItr = this.listIterator();

        while (classItr.hasNext()) {
            objItr.add(classItr.next());
        }

        return list;
    }

//---------------- nested DoublyLinkedListIterator class ----------------        
    private class DoublyLinkedListIterator implements ListIterator<E> {

        private DoublyLinkedList.Node<E> nextNode, prevNode, lastReturnedNode; // node that will be returned using next and prev respectively
        private int nextIndex;  // Index of the next element
        private int expectedModCount;  // Expected number of modifications = modCount;

        public DoublyLinkedListIterator() {
            this.prevNode = header;
            this.nextNode = header.getNext();
            lastReturnedNode = null;
            nextIndex = 0;
            expectedModCount = modCount;
        }

        final void checkForComodification() {  // invalidate iterator on list modification outside the iterator
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return this.nextNode  != trailer;
        }

        @Override
        public E next() throws NoSuchElementException {
            checkForComodification();

            if (!hasNext()) {
                lastReturnedNode = null;
                throw new NoSuchElementException("End of list reached.");
            }

            lastReturnedNode = this.nextNode;
            this.prevNode = nextNode;
            this.nextNode = nextNode.getNext();
            nextIndex++;
            return lastReturnedNode.getElement();
        }

        @Override
        public boolean hasPrevious() {
            return this.prevNode != header;
        }

        @Override
        public E previous() throws NoSuchElementException {
            checkForComodification();

            if (!hasPrevious()) {
                throw new NoSuchElementException("Beginning of  list reached.");
            }

            this.nextNode = nextNode.getPrev();
            prevNode = prevNode.getPrev();

            lastReturnedNode = nextNode;
            nextIndex--;
            return lastReturnedNode.getElement();
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() throws NoSuchElementException {

            checkForComodification();

            if (lastReturnedNode == null) {
                throw new NoSuchElementException("Invalid last returned node");
            }

            if (prevNode == lastReturnedNode) {
                prevNode = lastReturnedNode.getNext();

            } else {
                nextNode = lastReturnedNode.getPrev();
                nextIndex--;
            }

            DoublyLinkedList.this.remove(lastReturnedNode);
            lastReturnedNode = null;

            expectedModCount++;
            
        }

        @Override
        public void set(E e) throws NoSuchElementException {
            if (lastReturnedNode == null) {
                throw new NoSuchElementException();
            }
            checkForComodification();

            lastReturnedNode.setElement(e);
        }

        @Override
        public void add(E e) {
            checkForComodification();

            DoublyLinkedList.this.addBetween(e, prevNode, nextNode);

            this.prevNode = prevNode.getNext();

            expectedModCount++;

        }

    }    //----------- end of inner DoublyLinkedListIterator class ----------

//---------------- Iterable implementation ----------------
    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    public ListIterator<E> listIterator() {
        return new DoublyLinkedListIterator();
    }

//---------------- nested Node class ----------------
    private static class Node<E> {

        private E element;      // reference to the element stored at this node
        private Node<E> prev;   // reference to the previous node in the list
        private Node<E> next;   // reference to the subsequent node in the list

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) { // Not on the original interface. Added due to list iterator implementation
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    } //----------- end of nested Node class ----------

}
