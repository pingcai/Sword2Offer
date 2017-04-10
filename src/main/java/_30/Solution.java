package _30;

import java.util.ArrayList;

/**
 * Created by pingcai on 2017/3/30.
 * <p>
 * top k 问题,可用堆排序完成(大顶堆/小顶堆)
 * <p>
 * 时间复杂度为 nlogk
 * <p>
 * 常见于各种面试题 如 一万条数据取前一百条
 */
public class Solution {

    public static void main(String[] args) {

        int[] arr = {1, 23, 5, 346, 457, 84, 54, 4545, 345, 745868, 456, 34534, 745, 34534, 74574, 42, 1234, 96776, 6786546, 45, 47, 88};
        System.out.println(new Solution().GetLeastNumbers_Solution(arr, 5));

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> l = new ArrayList<>();

        if (input == null || k <= 0 || input.length < k) {
            return l;
        }

        int[] arr = new int[k]; // 目标堆
        System.arraycopy(input, 0, arr, 0, k); // 填充堆
        build_heap(arr);//构建堆

        for (int i = k; i < input.length; i++) {
            if (input[i] < arr[0]) { // 与最大的元素比较 ,大顶堆
                arr[0] = input[i];
                max_heap(arr, 0, k - 1);
            }
        }

        //删点排序
        for (int i = k - 1; i > 0; i--) {
            swap(arr, 0, i);
            max_heap(arr, 0, i - 1);
        }

        for (int i = 0; i < k; i++) {
            l.add(arr[i]);
        }
        return l;
    }

    //自底向上堆排
    public void build_heap(int[] arr) {
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            max_heap(arr, i, len);
        }
    }

    // 调整节点
    public void max_heap(int[] arr, int i, int len) {
        int largest = i;
        int left = (i << 1) + 1;
        int right = left + 1;
        //找出三者最大
        if (left <= len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right <= len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (arr[largest] > arr[i]) {
            swap(arr, largest, i);
            max_heap(arr, largest, len);
        }
    }

    private void swap(int[] arr, int largest, int i) {
        int t = arr[largest];
        arr[largest] = arr[i];
        arr[i] = t;
    }

}


