package _39;

/**
 * Created by pingcai on 17-4-10.
 * 参照：https://www.nowcoder.com/profile/835689/codeBookDetail?submissionId=1522888 一直奔跑的蜗牛，
 * 改进：当发现不平衡时退出，不再遍历整棵树
 */
public class IsBalanced_Solution {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;

        System.out.println(new IsBalanced_Solution().IsBalanced_Solution(n1));
    }

    private boolean balanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        IsBalanced(root);
        return balanced;
    }

    private int IsBalanced(TreeNode root) {
        if (!balanced || root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int l = IsBalanced(root.left);
        int r = IsBalanced(root.right);
        if (Math.abs(l - r) > 1) {
            balanced = false;
        }
        return l > r ? l + 1 : r + 1;
    }
}
