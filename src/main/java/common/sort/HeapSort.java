package common.sort;

import java.util.Arrays;

/**
 * Created by pingcai on 2017/3/29.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private void sort(int[] arr) {
        build_heap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            max_heap(arr, 0, i - 1);
        }
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
