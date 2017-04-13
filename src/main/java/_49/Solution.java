package _49;

/**
 * Created by pingcai on 17-4-13.
 */
public class Solution {
    public int Add(int num1, int num2) {

        int i = 0;
        int r = 0;

        do{
            r = num1 ^ num2;
            i = (num1 & num2) << 1;
            num1 = r;
            num2 = i;
        }while (num2!=0);
        return num1;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().Add(1, -2));
    }
}