package _50;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pingcai on 2017/4/8.
 * * 题意：找到两个节点最近的公共父节点
 * <p>
 * 如果是一棵普通的二叉树
 * <p>
 * 方法：
 */
public class Solution3 {
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
        System.out.println(new Solution3().resolve1(n1, new TreeNode(19), new TreeNode(30)).val);

    }

    /**
     * 方法一：遍历的方式去判断两个节点是否是当前点的子孙节点，直到最后一个
     */
    private TreeNode resolve1(TreeNode root, TreeNode l, TreeNode r) {
        //二叉树不包含目标节点
        if (!contains(root, l) || !contains(root, r)) {
            return null;
        }
        while (root != null) {
            if (contains(root.left, l) && contains(root.left, r)) {
                root = root.left;
            } else if (contains(root.right, l) && contains(root.right, r)) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    /**
     * 方法二：遍历找到两个节点到root的路径，再判断公共序列
     */
    private TreeNode resolve2(TreeNode root, TreeNode l, TreeNode r) {
        //二叉树不包含目标节点
        if (!contains(root, l) || !contains(root, r)) {
            return null;
        }

        Queue<TreeNode> s1 = new PriorityQueue<>();
        Queue<TreeNode> s2 = new PriorityQueue<>();

        getPath(root, l, s1);
        getPath(root, l, s2);

        while(!s1.isEmpty() && !s2.isEmpty()){
            if(!((root=s1.remove()).val == s2.remove().val)){
                return root;
            }
        }
        return null;
    }

    private boolean getPath(TreeNode root, TreeNode target, Queue<TreeNode> stack) {
        if (root == null || target == null) {
            return false;
        }
        if (root.val == target.val) {
            stack.add(root);
            return true;
        }

        stack.add(root);
        boolean found = false;

        //遍历左右子树
        int i = 0;
        TreeNode[] t = {root.left,root.right};
        while (!found && i < 2) {
            found = getPath(t[i++], target, stack);
        }
        if (!found) {
            stack.remove();
        }
        return found;
    }


    private boolean contains(TreeNode root, TreeNode son) {
        if (root == null || son == null) {
            return false;
        }
        if (root.val == son.val) {
            return true;
        }
        return contains(root.left, son) || contains(root.right, son);
    }
}
