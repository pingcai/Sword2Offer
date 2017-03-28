package _25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by pingcai on 17-3-23.
 */


public class Solution {

    public static void main(String[] args){
        //这是模拟的数据
        TreeNode root = new TreeNode(10);
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(12);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(7);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;

        System.out.println(new Solution().FindPath(root,22));
    }

    /**
     * until 到达叶子节点 or 得到 target的值
     * 使用栈保存经过的路径
     *
     * @param root
     * @param target
     * @return
     */

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        f(root, target, list, new Stack<TreeNode>(), 0);
        return list;
    }

    //递归
    public void f(TreeNode root, int target, ArrayList<ArrayList<Integer>> arrayLists, Stack<TreeNode> stack, int current) {

        if (root == null) {
            return;
        }

        current += root.val;
        stack.push(root);

        boolean leaf = root.left == null && root.right == null;

        if (target == current && leaf) {

            ArrayList<Integer> list = new ArrayList<>();

            Iterator<TreeNode> it = stack.iterator();

            while (it.hasNext()) {
                list.add(it.next().val);
            }
            arrayLists.add(list);
        }
        if (root.left != null) {
            f(root.left, target, arrayLists, stack, current);
        }
        if (root.right != null) {
            f(root.right, target, arrayLists, stack, current);
        }
        stack.pop();
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}