package _28;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by pingcai on 2017/3/28.
 */
public class Solution {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> list = new Solution().Permutation(str);
        System.out.println(list);

    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        Permutation(str.toCharArray(), 0, list);

        //记得排序，不然无法通过
        Collections.sort(list);

        return list;
    }

    public void Permutation(char[] chars, int begin, ArrayList<String> list) {
        if (begin == chars.length) {
            String str = new String(chars);
            /**
             * 查看源码： list.contaions方法：
             * o.equals(elementData[i])
             * 所以可以不用set去重
             */
            if (!list.contains(str)) {
                list.add(str);
            }
            return;
        } else {
            for (int i = begin; i < chars.length; i++) {
                char t = chars[i];
                chars[i] = chars[begin];
                chars[begin] = t;
                Permutation(chars, begin + 1, list);
                t = chars[i];
                chars[i] = chars[begin];
                chars[begin] = t;
            }
        }

    }
}