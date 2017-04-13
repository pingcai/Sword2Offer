package _44;

import java.util.Arrays;

/**
 * Created by pingcai on 17-4-12.
 */
public class Solution {

    public static void main(String[] args) {

        int[] arr = {1, 3, 0, 5, 0};

        System.out.println(new Solution().isContinuous(arr));
    }

    public boolean isContinuous(int[] arr) {

        if (arr == null || arr.length != 5) {
            return false;
        }

        Arrays.sort(arr);

        int zeroNumber = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
            if (i > 0 && arr[i] != 0 && arr[i - 1] == arr[i]) {
                return false;
            }
        }

        int gap = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                continue;
            }
            gap += arr[i + 1] - arr[i] - 1;
        }
        return gap > zeroNumber ? false : true;
    }
}
