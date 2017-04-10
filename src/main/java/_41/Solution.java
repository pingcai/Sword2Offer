package _41;

import java.util.ArrayList;

/**
 * Created by pingcai on 2017/4/9.
 * <p>
 * 打印和为sum的顺序序列
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().FindContinuousSequence(9));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3) {
            return list;
        }
        int l = 1;
        int r = 2;
        int flag = (sum + 1) / 2;
        while (l < flag) {
            ArrayList<Integer> a = new ArrayList<>();
            int s = 0;
            for (int i = l; i <= r; i++) {
                s += i;
                a.add(i);
            }
            if (s > sum) {
                l++;
            } else if (s < sum) {
                r++;
            } else {
                r++;
                list.add(a);
            }
        }
        return list;
    }
}