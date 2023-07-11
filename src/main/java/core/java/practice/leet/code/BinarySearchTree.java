package core.java.practice.leet.code;

import javax.swing.*;

public class BinarySearchTree {


    static class Node {
        private int value;
        private Node left;

        private Node rigth;

        public Node(int i, Node o, Node o1) {
            this.value = i;
            this.left = o;
            this.rigth = o1;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRigth() {
            return rigth;
        }

        public void setRigth(Node rigth) {
            this.rigth = rigth;
        }
    }

    public Node addNode(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        } else if (root.getValue() < newNode.getValue()) {
            root.setLeft(addNode(root.getLeft(), newNode));
        } else {
            root.setRigth(addNode(root.getRigth(), newNode));
        }
        return root;
    }

    public int searchElement(Node root, int value) {
        int searchIndex = -1;
        while (root != null) {
            searchIndex++;
            if (root.getValue() == value) {
                return searchIndex;
            } else if (root.getValue() < value) {
                root = root.getLeft();
            } else {
                root = root.getRigth();
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        Node root = null;
        BinarySearchTree tree = new BinarySearchTree();
        for (int i : nums) {
            root = tree.addNode(root, new Node(i, null, null));
        }
        System.out.println(tree.searchElement(root, 12));

    }


}
