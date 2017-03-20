import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pingcai on 2017/2/24.
 */
public class _06_ConstructBinaryTree {


    /**
     * 输入 中序和前序序列，重建出原本的序列，并返回根节点
     * <p>
     * 可能情况：
     * 1.空指针
     * 2.只有左子树
     * 3.只有右子树
     * 4.只有根节点
     * 5.序列有误
     *
     * @param preOrder 前序
     * @param inOrder  中序
     * @param length   长度
     * @return
     */
    private static Node construct(int[] preOrder, int[] inOrder, int length) {
        if (preOrder == null || inOrder == null || preOrder.length <= 0 || inOrder.length <= 0 || length <= 0) {
            return null;
        }
        return core(preOrder, inOrder, length);
    }

    private static Node core(int[] preOrder, int[] inOrder, int length) {

        if (inOrder == null || preOrder == null || length <= 0) {
            return null;
        }

        Node root = new Node();
        root.value = preOrder[0];

        //只有一个根节点
        if (length == 1 && preOrder == inOrder) {
            return root;
        }

        // 找到根节点在中序遍历的位置
        int index = -1;
        int rootInOrder = 0;
        while (index < length && rootInOrder != root.value) {
            rootInOrder = inOrder[++index];
        }

        if (rootInOrder == inOrder[length - 1] && rootInOrder != root.value) {
            throw new RuntimeException("input error ");
        }

        int leftLength = index; // 新数组的长度（左子树）
        int rightLength = length - index - 1;
        if (leftLength > 0) {

            int[] leftPreOrder = new int[leftLength];
            System.arraycopy(preOrder, 1, leftPreOrder, 0, leftLength);

            int[] leftInOrder = new int[leftLength];
            System.arraycopy(inOrder, 0, leftInOrder, 0, leftLength);

            root.left = core(leftPreOrder, leftInOrder, leftLength);
            if (root.left != null) {
                root.left.root = root;
            }
        }
        if (leftLength < length) {

            int[] rightPreOrder = new int[rightLength];
            System.arraycopy(preOrder, index + 1, rightPreOrder, 0, rightLength);

            int[] rightInOrder = new int[rightLength];
            System.arraycopy(inOrder, index + 1, rightInOrder, 0, rightLength);

            root.right = core(rightPreOrder, rightInOrder, rightLength);
            if (root.right != null) {
                root.right.root = root;
            }
        }

        return root;
    }

    private static void dfs(Node node) {

        if(node == null){
            return ;
        }

        System.out.println(node.value + "\t");

        dfs(node.left);
        dfs(node.right);

    }


    private static void bfs(Node node) {
        System.out.println(node.value + "\t");
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            Node root = queue.poll();
            if (root == null) {
                continue;
            }
            Node left = root.left;
            if (left != null) {
                System.out.println(left.value + "\t");
                queue.add(left);
            }
            Node right = root.right;
            if (right != null) {
                System.out.println(right.value + "\t");
                queue.add(right);
            }
        }

    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        Node node = construct(preOrder, inOrder, preOrder.length);
        dfs(node);
    }
}

/**
 * 简单的节点，就不考虑什么封装性了
 */
class Node {
    Node root;
    Node left;
    Node right;
    int value;

    @Override
    public String toString() {

        String tree =

                value + "\n" + left + "\t" + right;

        return tree;
    }
}
