package _34;

/**
 * Created by pingcai on 2017/3/31.
 */
public class Solution {

    public static void main(String[] args) {


        System.out.println(new Solution().GetUglyNumber_Solution(1500));

    }

    public int GetUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }

        int[] arr = new int[index];
        int next = 0;
        arr[next++] = 1;

        int m2 = 0;
        int m3 = 0;
        int m5 = 0;

        while (next < index) {
            arr[next] = min(arr[m2] * 2, arr[m3] * 3, arr[m5] * 5);
            while (arr[m2] * 2 <= arr[next]) {
                m2++;
            }
            while (arr[m3] * 3 <= arr[next]) {
                m3++;
            }
            while (arr[m5] * 5 <= arr[next]) {
                m5++;
            }
            next++;
        }
        return arr[next - 1];
    }

    private int min(int a, int b, int c) {
        if (a > b) {
            a = b;
        }
        if (a > c) {
            return c;
        }
        return a;
    }
/*

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int n = 1;
        int d = 1;
        while (n < index) {
            d ++;
            if (isUgly(d)) {
                n++;
            }
        }
        return d;
    }

    public boolean isUgly(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1 ? true : false;
    }
*/


}