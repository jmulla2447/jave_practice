package core.java.practice.leet.code.tree;

import core.java.practice.leet.code.BinarySearchTree;

public class ValidateBST {

    private static boolean isBST = false, flag = true;
    private static TreeNode firstRoot;

    public static boolean isValidBST(TreeNode root) {
        if (flag) {// this is important conditon input : [5,1,4,null,null,3,6] then output should be false
            firstRoot = root;
            flag = false;
        }
        if (root == null) isBST = true;
        if (root.getLeft() == null && root.getRigth() == null) isBST = true;
        if ((root.getLeft() != null && root.getLeft().getValue() > root.getValue() && root.getLeft().getValue() > firstRoot.getValue()) ||
                (root.getRigth() != null && root.getRigth().getValue() < root.getValue() && root.getRigth().getValue() < firstRoot.getValue())) {
            return false;
        } else if (root.getLeft() != null) {
            isValidBST(root.getLeft());
        } else if (root.getRigth() != null) {
            isValidBST(root.getRigth());
        }
        return isBST;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        TreeNode root = null;
        for (int i : nums) {
            root = TreeNode.addNode(root, new TreeNode(i, null, null));
        }
        System.out.println(isValidBST(root));
    }
}
