package _18;

/**
 * Created by pingcai on 17-3-9.
 */
public class SubstructureInTree {
    public static void main(String[] args) {

        /**
         * 输入两棵树,判断第二颗是不是第一棵树的子树
         *
         *
         */

        TreeNode root = new TreeNode(8);

        TreeNode left8 = new TreeNode(8);
        TreeNode right7 = new TreeNode(7);
        TreeNode left9 = new TreeNode(9);
        TreeNode left2 = new TreeNode(2);
        TreeNode end4 = new TreeNode(4);
        TreeNode end7 = new TreeNode(7);

        root.left = left8;
        root.right = right7;

        left8.left = left9;
        left8.right = left2;

        left2.left = end4;
        left2.right = end7;

        TreeNode target = new TreeNode(8);
        target.left = new TreeNode(9);
        target.right = new TreeNode(2);

        System.out.println(new SubstructureInTree().HasSubtree(root, target));

    }

    public boolean HasSubtree(TreeNode parent, TreeNode target) {

        boolean flag = false;

        if (parent == null || target == null) {
            return flag;
        }

        if (target.val == parent.val) {
            flag = doesJudge(parent, target);
        }
        if (!flag) {
            flag = doesJudge(parent.left, target);
        }
        if (!flag) {
            flag = doesJudge(parent.right, target);
        }
        return flag;
    }

    public boolean doesJudge(TreeNode parent, TreeNode target) {

        if (target == null) {
            return true;
        }
        if (parent == null) {
            return false;
        }

        if(parent.val != target.val){
            return false;
        }

        return doesJudge(parent.left, target.left) && doesJudge(parent.right, target.right);
    }


}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;

    }
}