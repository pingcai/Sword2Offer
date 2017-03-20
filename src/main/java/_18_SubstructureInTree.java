/**
 * Created by pingcai on 17-3-9.
 */
public class _18_SubstructureInTree {
    public static void main(String[] args) {

        /**
         * 输入两棵树,判断第二颗是不是第一棵树的子树
         *
         *
         */

        Node root = new Node(8);

        Node left8 = new Node(8);
        Node right7 = new Node(7);
        Node left9 = new Node(9);
        Node left2 = new Node(2);
        Node end4 = new Node(4);
        Node end7 = new Node(7);

        root.left = left8;
        root.right = right7;

        left8.left = left9;
        left8.right = left2;

        left2.left = end4;
        left2.right = end7;

        Node target = new Node(8);
        target.left = new Node(9);
        target.right = new Node(2);

        System.out.println(isSubTree(root, target));

    }

    public static boolean isSubTree(Node parent, Node target) {

        boolean flag = false;

        if (parent == null || target == null) {
            return flag;
        }

        if (target.value == parent.value) {
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

    public static boolean doesJudge(Node parent, Node target) {

        if (target == null) {
            return true;
        }
        if (parent == null) {
            return false;
        }

        if(parent.value != target.value){
            return false;
        }

        return doesJudge(parent.left, target.left) && doesJudge(parent.right, target.right);
    }

    static class Node {

        int value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }
}


