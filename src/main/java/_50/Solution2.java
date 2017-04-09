package _50;

import java.util.Stack;

/**
 * Created by pingcai on 2017/4/8.
 * * 题意：找到两个节点最近的公共父节点
 * <p>
 * 如果是带父节点的普通二叉树
 * <p>
 * 方法：用两个栈保存各自节点从根节点的路径，然后找到最后一个相同节点
 */
public class Solution2 {
    public static void main(String[] args) {

        TreeNodeWithParent n1 = new TreeNodeWithParent(19);
        TreeNodeWithParent n2 = new TreeNodeWithParent(10);
        TreeNodeWithParent n3 = new TreeNodeWithParent(30);
        TreeNodeWithParent n4 = new TreeNodeWithParent(5);
        TreeNodeWithParent n5 = new TreeNodeWithParent(15);
        TreeNodeWithParent n6 = new TreeNodeWithParent(3);
        TreeNodeWithParent n7 = new TreeNodeWithParent(6);
        TreeNodeWithParent n8 = new TreeNodeWithParent(12);
        TreeNodeWithParent n9 = new TreeNodeWithParent(17);

        n1.left = n2;
        n1.right = n3;
        n2.parent = n1;
        n3.parent = n1;

        n2.left = n4;
        n2.right = n5;
        n4.parent = n2;
        n5.parent = n2;

        n4.left = n6;
        n4.right = n7;
        n6.parent = n4;
        n7.parent = n4;

        n5.left = n8;
        n5.right = n9;
        n8.parent = n5;
        n9.parent = n5;

        System.out.println(new Solution2().resolve(n1, new TreeNodeWithParent(3), new TreeNodeWithParent(5)));
    }

    private TreeNodeWithParent resolve(TreeNodeWithParent root, TreeNodeWithParent l, TreeNodeWithParent r) {

        Stack<TreeNodeWithParent> s1 = new Stack<>();
        Stack<TreeNodeWithParent> s2 = new Stack<>();

        // 找到两个节点在二叉树中的位置
        l = findInTree(root, l);
        r = findInTree(root, r);
        if(l == null || r== null){
            return null;
        }

        while (l != null) {
            s1.push(l);
            l = l.parent;
        }
        while (r != null) {
            s2.push(r);
            r = r.parent;
        }
        while (!s1.empty() && !s2.empty()) {
            if (s1.peek().val == s2.peek().val) {
                root = s1.pop();
                s2.pop();
            } else {
                break;
            }
        }
        return root;
    }

    private TreeNodeWithParent findInTree(TreeNodeWithParent root, TreeNodeWithParent l) {
        if (root == null) {
            return null;
        }
        if (root.val == l.val) {
            return root;
        }
        TreeNodeWithParent tmp = null;
        tmp = findInTree(root.left, l);
        if (tmp != null) {
            return tmp;
        }
        tmp = findInTree(root.right, l);
        return tmp;
    }
}

