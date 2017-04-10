package _40;

/**
 * Created by pingcai on 2017/4/9.
 * <p>
 * 描述：数组A中，除了某一个数字x之外，其他数字都出现了三次，而x出现了一次。请给出最快的方法，找到x。
 * <p>
 * 思路：
 * <p>
 * 设只出现一次的数为 x;
 * 所有数字某一位上1的和如果能被三整除，则x上的这一位为0，否则为1
 * 然后用1的位数拼凑出x
 * <p>
 * 对整型可用32位数组保存
 * <p>
 * 时间复杂度还是n
 */
public class Solution_three_one {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 2, -2, 2, -5,-5,-5};
        int[] n1 = new int[1];
        new Solution_three_one().FindNumsAppearOnce(arr, n1);
        System.out.println(n1[0]);
    }

    public void FindNumsAppearOnce(int[] arr, int n[]) {

        int[] m = new int[32];

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < arr.length; j++) {
                m[i] += numberOfPosition(arr[j], i);
            }
        }

        for (int i = 0; i < m.length; i++) {
            if(m[i] % 3 == 0){
                continue;
            }else{
                n[0] += 1 << i;
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
     * n的二进制第i上的数字（0或1）
     */
    private int numberOfPosition(int n, int i) {
        for (int j = 0; j < i; j++) {
            n = n >> 1;
        }
        return n & 1;
    }
}