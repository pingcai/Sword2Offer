package _29;

/**
 * Created by pingcai on 2017/3/30.
 * <p>
 * 找出数组中个数超过长度一般的数
 */
public class Solution {

    public static void main(String[] args) {

        //int[] arr = {1, 2, 2, 3, 5, 2, 3, 3, 2, 2, 2, 1};
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        System.out.println(new Solution().MoreThanHalfNum_Solution(arr));

    }

    public int MoreThanHalfNum_Solution(int[] array) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int times = 1;

        int result = array[0];

        for (int i = 0; i < array.length; i++) {

            if (times == 0) {
                times = 1;
                result = array[i];
                continue;
            }

            if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }

        if (!(times > 1)) {
            result = 0;
        }

        return result;
    }
}