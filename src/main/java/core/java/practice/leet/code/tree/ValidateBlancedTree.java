package core.java.practice.leet.code.tree;

import java.util.ArrayList;

public class ValidateBlancedTree {

    public boolean isValid(TreeNode root) {
        boolean isBal = false;
        if (root == null || root.getLeft() == null && root.getRigth() == null) {
            isBal = true;
        } else if (root.getLeft() != null ^ root.getRigth() != null) {
            isBal = false;
        } else {
            isBal = isValid(root.getLeft());
            isBal = isBal ? isValid(root.getRigth()) : false;
        }
        return isBal;
    }
    ArrayList<Integer> plist = new ArrayList();
    ArrayList<Integer> qlist = new ArrayList();

    public boolean isSameTree(TreeNode p, TreeNode q) {

        boolean isSame = false;
        while (true) {
            if (p != null ^ q != null) {
                return isSame;
            } else if (p == null && q == null) {
                 break;
            }
            if (p.getLeft() != null ^ q.getLeft() != null) {
                return isSame;
            }
            if (p.getRigth() != null ^ q.getRigth() != null) {
                return isSame;
            }
            plist.add(p.getValue());
            qlist.add(q.getValue());
            isSameTree(p.getLeft(), q.getLeft());
            isSameTree(p.getRigth(), q.getRigth());
        }

       return plist.containsAll(qlist);
    }
}
