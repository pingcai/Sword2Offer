package _40;

/**
 * Created by pingcai on 2017/4/9.
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4};
        int[] n1 = new int[1];
        int[] n2 = new int[1];
        new Solution().FindNumsAppearOnce(arr, n1, n2);
        System.out.println(n1[0]);
        System.out.println(n2[0]);
    }

    public void FindNumsAppearOnce(int[] arr, int n1[], int n2[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int flag = arr[0];
        for (int i = 1; i < arr.length; i++) {
            flag ^= arr[i];
        }
        int p = positionOf1(flag); //找出从低位到高位第一个1的位置
        for (int i = 0; i < arr.length; i++) {
            if (isBit1(arr[i], p)) {
                n1[0] ^= arr[i];
            } else {
                n2[0] ^= arr[i];
            }
        }

    }

    /**
     * i第p位是否为1
     *
     * @param i
     * @param p
     * @return
     */
    private boolean isBit1(int i, int p) {
        for (int j = 0; j < p; j++) {
            i = i >> 1;
        }
        return (i & 1) == 1;
    }

    /**
     * 二进制中从低到高第一个1出现的位置
     *
     * @param n
     * @return 下标从0开始
     */
    private int positionOf1(int n) {
        int i = 0;
        while ((n & 1) == 0) {
            n = n >> 1;
            i++;
        }
        return i;
    }
}