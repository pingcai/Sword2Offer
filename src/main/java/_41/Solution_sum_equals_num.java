package _41;

import java.util.ArrayList;

/**
 * Created by pingcai on 17-4-10.
 * 和为sum的两个数，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution_sum_equals_num {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 8};
        System.out.println(new Solution_sum_equals_num().FindNumbersWithSum(arr, 9));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0) {
            return list;
        }
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            if (array[l] + array[r] > sum) {
                r--;
            } else if (array[l] + array[r] < sum) {
                l++;
            } else {
                int lv = array[l];
                int rv = array[r];
                if (list.isEmpty()) {
                    list.add(lv);
                    list.add(rv);
                } else {
                    if (list.get(0) * list.get(1) > lv * rv) {
                        list.set(0, lv);
                        list.set(1, rv);
                    }
                }
                l++;
            }
        }
        return list;
    }

}
