package _24;

/**
 * Created by pingcai on 17-3-23.
 */

class Test {
    public static void main(String[] args) {

        int[] arr = {5, 7, 6, 9, 11, 10, 8};
        //int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new Solution().VerifySquenceOfBST(arr));
    }
}

public class Solution {
    public boolean VerifySquenceOfBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return v(arr, 0, arr.length - 1);
    }
    /**
     * 5, 7, 6, 11, 10, 8
     * <p>
     * 1.最后一个数为根节点
     * 2.找出左右子树 左 < root   右 > root
     * 3.递归
     */
    public boolean v(int[] arr, int left, int right) {

        if (left >= right) {
            return true;
        }
        //找出分界点 分界点属于右子树
        int mid = left;
        while (mid < right) {
            if (arr[mid] > arr[right]) {
                break;
            }
            mid ++;
        }
        // 检查右子树是否都大于根节点
        int i = mid;
        while (i < right) {
            if (arr[i] < arr[right]) {
                return false;
            }
            i ++;
        }
        return v(arr, left, mid - 1) && v(arr, mid, right - 1);
    }
}
