package _27;
/**
 * Created by pingcai on 2017/3/26.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution {

    public static void main(String[] args) {
        //这是模拟的数据
        TreeNode root = new TreeNode(10);
        TreeNode r1 = new TreeNode(6);
        TreeNode r2 = new TreeNode(14);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(8);
        TreeNode r5 = new TreeNode(12);
        TreeNode r6 = new TreeNode(16);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        System.out.println(new Solution().Convert(root));
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }
        TreeNode pLastNodeInList = ConvertNode(pRootOfTree, null);

        //找到第一个位置
        while (pLastNodeInList != null && pLastNodeInList.left != null) {
            pLastNodeInList = pLastNodeInList.left;
        }
        return pLastNodeInList;
    }
    /**
     * 中序遍历
     * @param node
     * @param pLastNodeInList
     */
    public TreeNode ConvertNode(TreeNode node, TreeNode pLastNodeInList) {
        if (node == null) return null;

        if (node.left != null) {
            pLastNodeInList = ConvertNode(node.left, pLastNodeInList);
        }

        // 双向的链表
        node.left = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.right = node;
        }

        //Java是引用传递，需注意！！！ 所以这里修改为返回 pLastNodeInList
        pLastNodeInList = node;

        if (node.right != null) {
            pLastNodeInList = ConvertNode(node.right, pLastNodeInList);
        }
        return pLastNodeInList;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {this.val = val;}
}
