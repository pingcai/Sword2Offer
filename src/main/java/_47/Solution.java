package _47;

/**
 * Created by pingcai on 17-4-12.
 * 求1+2+3+...+res，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 参照https://www.nowcoder.com/profile/572581/codeBookDetail?submissionId=114328
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().Sum_Solution(5));
    }

    public int res = 0;

    public int Sum_Solution(int n) {
        check(n);
        return res;
    }

    private boolean check(int n) {
        this.res += n;
        return n > 0 && check(n - 1);
    }


}
