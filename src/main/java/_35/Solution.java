package _35;

/**
 * Created by pingcai on 2017/3/31.
 */
public class Solution {

    public static void main(String[] args) {

        String str = "aac";

        System.out.println((char)new Solution().FirstNotRepeatingChar(str));


    }
    //要求返回的是下标
    public int FirstNotRepeatingChar(String str) {
        int[] arr = new int[256];
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (arr[chs[i]] == 0) {
                arr[chs[i]] = 1;
            } else {
                arr[chs[i]] = arr[chs[i]] + 1;
            }
        }
        for (int i = 0; i < chs.length; i++) {
            if (arr[chs[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

}
