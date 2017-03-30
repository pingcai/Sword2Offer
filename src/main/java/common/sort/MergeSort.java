package common.sort;

import java.util.Arrays;

/**
 * Created by pingcai on 2017/3/29.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {

    }


}
