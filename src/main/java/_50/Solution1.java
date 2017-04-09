package _50;

/**
 * Created by pingcai on 2017/4/8.
 * <p>
 * 题意：找到两个节点最近的公共父节点
 * <p>
 * 如果是二叉搜索树
 * <p>
 * 该节点满足的条件是： 刚好大于左节点刚好小于右节点
 */
public class Solution1 {
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

        System.out.println(new Solution1().resolve(n1, new TreeNode(3), new TreeNode(5)));

    }

    private TreeNode resolve(TreeNode root, TreeNode l, TreeNode r) {

        if (root.left == null && root.right == null) {
            return root.val == l.val && root.val == r.val ? root : null;
        }

        while (root != null) {
            if (root.val > l.val && root.val > r.val) {
                root = root.left;
            } else if (root.val < l.val && root.val < r.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

