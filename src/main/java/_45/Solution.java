package _45;

/**
 * Created by pingcai on 17-4-12.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().LastRemaining_Solution(5, 2));
        System.out.println(new Solution().LastRemaining_Solution(5, 3));
    }

    //抄公式
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (m + last) % i;
        }
        return last;
    }
}
