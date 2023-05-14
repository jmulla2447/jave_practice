package core.java.practice.leet.code;


import java.awt.*;
import java.security.PrivateKey;

class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class CustomQueue {
    private Node rear;
    private Node front;

    private int cap;

    private int size;

    public CustomQueue(int cap) {
        this.cap = cap;
    }

    public boolean enqueue(int val) {
        Node newNode = new Node(val);
        if (size == cap) {
           throw new IllegalArgumentException("overflow");
        }
        if (front == null) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
        return true;
    }

    public int dequeue() {
        if (size == 0) {
           throw new IllegalArgumentException("underflow");
        }
        int val = front.getVal();
        if (front == rear) {
            rear = null;
            front = null;
        } else {
            Node tempNode = front.getNext();
            front.setNext(null);
            front = tempNode;
        }
        size--;
        return val;
    }

    public int getSize() {
        return size;
    }
}
