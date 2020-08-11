package edu.escuelaing.arep.INTRO.app.collections;


import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;


/**
 * The N type Linked list.
 *
 * @author Davor Cortés
 * @version 1.0
 * @param <N> the type parameter
 */
public class LinkedList<N> implements Iterable<N>{

    private Node<N> head, tail;
    private int length;

    /**
     * Instantiates a new Linked list.
     */
    public LinkedList(){
        head = tail = null;
        length = 0;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size(){
        return length;
    }

    /**
     * Add new Node whit data.
     *
     * @param data the data
     */
    public void add(N data){
        Node<N> newNode = new Node<N>(data);
        if (head == null) {
            head = tail = newNode;
        }
        tail.setNext(newNode);
        tail = newNode;
        length ++;
    }


    /**
     * Remove the first element and  return his value. .
     *
     * @return the n
     * @throws NoSuchElementException the no such element exception
     */
    public N pop() throws NoSuchElementException{

        if (head == null ) throw new NoSuchElementException("void");
        Node<N> currentHead = head;
        head = head.getNext();
        length --;
        return currentHead.getData();
    }

    /**
     * Remove first element.
     *
     * @throws NoSuchElementException the no such element exception
     */
    public void remove() throws  NoSuchElementException{
        pop();
    }

    public Iterator<N> iterator() {
        return new Iterator<N>() {
            private Node<N> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public N next() {
                N data = currentNode.getData();
                currentNode = currentNode.getNext();
                return data;
            }
        };
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                head +
                '}';
    }

}
