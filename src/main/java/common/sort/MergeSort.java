package common.sort;

import java.util.Arrays;

/**
 * Created by pingcai on 2017/3/29.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new MergeSort().sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public void sort(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2 || l >= r) {
            return;
        }
        int m = (l + r) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private void merge(int[] arr, int l, int center, int r) {
        int[] tmpArr = new int[arr.length];//临时数组
        int index = l; //排序后，拷贝回原数组的索引
        int i = l;//临时数组排序过程中的索引
        int j = l;//原数组前半部分的索引
        int k = center + 1;//原数组后半部分的索引
        while (j <= center && k <= r) {
            //从两个数组中取出最小的放入中间数组
            if (arr[j] <= arr[k]) {
                tmpArr[i++] = arr[j++];
            } else {
                tmpArr[i++] = arr[k++];
            }

        }
        //剩余部分依次放入中间数组
        while (j <= center) {
            tmpArr[i++] = arr[j++];
        }
        while (k <= r) {
            tmpArr[i++] = arr[k++];
        }
        //将中间数组中的内容复制回原数组
        while (index <= r) {
            arr[index] = tmpArr[index++];
        }
    }
}
