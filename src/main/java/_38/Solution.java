package _38;

/**
 * Created by pingcai on 17-4-10.
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路：二分查找时间复杂度为nlogn(从头到尾遍历为n)
 *
 */
public class Solution {

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 7, 7};

        System.out.println(new Solution().GetNumberOfK(arr, 111));
    }

    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
            return 0;
        }

        int len = array.length;
        int l = 0;
        int r = len - 1;
        int m = (l + r) / 2;
        while (l >= 0 && r >= 0 && array[l] <= array[r]) {
            if (k > array[m]) {
                l = m + 1;
            } else if (k < array[m]) {
                r = m - 1;
            } else {
                int s = m;
                int e = m;
                while (s > 0 && array[s - 1] == k) {
                    s -= 1;
                }
                while (e < len - 1 && array[e + 1] == k) {
                    e += 1;
                }
                return e - s + 1;
            }
            m = (l + r) / 2;
        }
        return 0;
    }
}