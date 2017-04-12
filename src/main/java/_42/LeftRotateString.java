package _42;

/**
 * Created by pingcai on 17-4-12.
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {

    public static void main(String[] args) {
        String str = "q";
        System.out.println(new LeftRotateString().LeftRotateString(str, 1));
    }

    /**
     * 旋转三次
     *
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {

        if (str == null || str.length() < n) {
            return "";
        }
        char[] ch = str.toCharArray();
        int len = ch.length;
        char c = ' ';
        for (int i = 0; i < n / 2; i++) {
            c = ch[i];
            ch[i] = ch[n - i - 1];
            ch[n - i - 1] = c;
        }
        for (int i = n; i < (len + n) / 2; i++) {
            c = ch[i];
            ch[i] = ch[len + n - i - 1];
            ch[len + n - i - 1] = c;
        }
        for (int i = 0; i < len / 2; i++) {
            c = ch[i];
            ch[i] = ch[len - i - 1];
            ch[len - i - 1] = c;
        }
        return new String(ch);
    }
}