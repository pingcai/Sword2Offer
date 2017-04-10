package _39;

/**
 * Created by pingcai on 17-4-10.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(19);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(30);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(15);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(6);
        TreeNode n8 = new TreeNode(12);
        TreeNode n9 = new TreeNode(17);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        n5.left = n8;
        n5.right = n9;

        System.out.println(new Solution().TreeDepth(n1));
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        return l > r ? l + 1 : r + 1;
    }
}
