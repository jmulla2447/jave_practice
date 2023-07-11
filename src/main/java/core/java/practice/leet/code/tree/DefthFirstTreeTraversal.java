package core.java.practice.leet.code.tree;

public class DefthFirstTreeTraversal {

    private int count;
    private int target;
    DefthFirstTreeTraversal(int target){
        this.target = target;
    }
    public int visitNode(TreeNode rootNode) {
        int value = rootNode.getValue();
        if (value == target) {
            count++;
        }
        if(rootNode.getLeft()!= null){
            rootNode =  rootNode.getLeft();
            visitNode(rootNode);
        }else if(rootNode.getRigth()!= null){
            rootNode = rootNode.getRigth();
            visitNode(rootNode);
        }
        return count;
    }
}
