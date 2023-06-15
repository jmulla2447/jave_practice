package core.java.practice.leet.code.tree;



class Node{
    private int priority;
    private int data;
    private Node left;
    private Node right;

    public Node(int priority, int data) {
        this.priority = priority;
        this.data=data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
public class Heapify {

    private Node root;

    public void addNode(int priority, int data){
        Node newNode =  new Node(priority, data);
        if(root== null){
            root =  newNode;
        }else if(root.getData() == newNode.getData()){
            root.setPriority(root.getPriority()+1);
        }
    }


}
