package core.java.practice.leet.code.tree;

public class TreeNode {
    private int value;
    private TreeNode left;

    private TreeNode rigth;

    public TreeNode(int i, TreeNode o, TreeNode o1) {
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

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRigth() {
        return rigth;
    }

    public void setRigth(TreeNode rigth) {
        this.rigth = rigth;
    }

    public static TreeNode addNode(TreeNode root, TreeNode newNode) {
        if (root == null) {
            return newNode;
        } else if (root.getValue() > newNode.getValue()) {
            root.setLeft(addNode(root.getLeft(), newNode));
        } else {
            root.setRigth(addNode(root.getRigth(), newNode));
        }
        return root;
    }
}
