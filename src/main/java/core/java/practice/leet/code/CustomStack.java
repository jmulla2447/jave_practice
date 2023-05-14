package core.java.practice.leet.code;

public class CustomStack {

    private int size;
    private int cap;

    private Node front, rear;

    public CustomStack(int cap) {
        this.cap = cap;
    }


    public void push(int val) {
        Node newNode = new Node(val);
        if (cap == size) {
            throw new IllegalArgumentException("overflow");
        }
        if (front == null) {
            front = newNode;
        } else {
            front.setNext(newNode);
            Node temp = front;
            front = newNode;
            front.setPre(temp);
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("underflow");
        }
        int val =  front.getVal();
        if(front.getPre()==null){
            front = null;
        }else{
            Node temp =  front.getPre();
            temp.setNext(null);
            front=temp;
        }
        size--;
        return val;
    }

}
