package core.java.practice.leet.code2;


public class Heapyfy {

    private Node[] nodes;
    private int size;

    Heapyfy(int capacity) {
        nodes = new Node[capacity];
        size = 0;
    }

    public int getParentIndex(int n) {
        return n / 2;
    }

    public int getLeftChildIndex(int n) {
        return (2 * n) + 1;
    }

    public int getRightChildIndex(int n) {
        return (2 * n) + 2;
    }

    public void add(int value) {
        Node node1 = new Node(value);
        nodes[size] = node1;
        if (size >= 1) {
            upHeap(node1, size);
        }
        size++;
    }

    private int upHeap(Node node, int index) {
        if (index == 0) {
            return 0;
        }
        int parentIndex = getParentIndex(index);
        Node parent = nodes[parentIndex];
        if (parent.value() > node.value()) {// do swap
            nodes[index] = parent;
            nodes[parentIndex] = node;
        }
        return upHeap(node, parentIndex);
    }

    public void displayHeap() {
        for (Node node : nodes) {
            System.out.println(node);
        }
    }

}


record Node(int value) {
}
