package _31;

/**
 * Created by pingcai on 2017/3/30.
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(new Solution().FindGreatestSumOfSubArray(arr));

    }

    /**
     * 动态规划:
     * f(i) = arr[i] , i == 0 || f(i-1) < 0
     * f(i) = arr[i] + f(i-1) , f(i-1) > 0
     */
    public int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        r(arr, 0, arr.length - 1);
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    private void r(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i > 0 && arr[i - 1] > 0) {
                arr[i] += arr[i - 1];
            }
        }
    }


    /* 方法 1

    public int FindGreatestSumOfSubArray(int[] arr){

        if(arr == null || arr.length == 0){
            return -1;
        }

        int cur = 0;
        int great = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if(cur >= 0){
                cur += v;
            }else{
                cur = v;
            }
            if(great < cur){
                great = cur;
            }
        }
        return great;
    }*/

}