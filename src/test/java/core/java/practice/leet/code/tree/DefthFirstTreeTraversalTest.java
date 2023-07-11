package core.java.practice.leet.code.tree;

import core.java.practice.leet.code.spring.MergeTwoLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DefthFirstTreeTraversalTest {

    TreeNode root = null;

    @BeforeEach
    private void dataSetup() {
        int[] nums = {-1, 0, 3, 5, 9, 12,3,3,1,2,0};

        for (int i : nums) {
            root = TreeNode.addNode(root, new TreeNode(i, null, null));
        }
    }

    @Test
    void visitNode() {
        DefthFirstTreeTraversal treeTraversal = new DefthFirstTreeTraversal(3);
        System.out.println(treeTraversal.visitNode(root));
    }
}
