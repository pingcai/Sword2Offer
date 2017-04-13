package _51;

/**
 * Created by pingcai on 17-4-13.
 */
public class Solution {

    /**
     * 在 leetcode上看到的解法，因为数组中的元素总小于n，所以直接创建一个数组找到重复的元素，时间复杂度O(n)，空间复杂度O(n)
     * @param numbers
     * @param length
     * @param duplication
     * @return public boolean duplicate(int numbers[], int length, int[] duplication) {
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
    arr[numbers[i]] += 1;
    }
    for (int i = 0; i < length; i++) {
    if (arr[i] > 1) {
    duplication[0] = i;
    return true;
    }
    }
    return false;
    }*/

    /**
     * 书上的解法，时间复杂度O（n）,空间复杂度 O（1）
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        // 1 2 3 5 3

        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return false;
    }

    private void swap(int[] numbers, int n, int i) {
        int t = numbers[n];
        numbers[n] = numbers[i];
        numbers[i] = t;
    }
}

class Test {
    public static void main(String[] args) {
        int[] arr = {4,1,2,3,4};
        int[] duplication = new int[1];
        System.out.println(new Solution().duplicate(arr, arr.length, duplication));
        System.out.println(duplication[0]);
    }
}