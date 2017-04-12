package _42;

/**
 * Created by pingcai on 17-4-12.
 */
public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence("s"));
        System.out.println(new ReverseSentence().ReverseSentence(""));
        System.out.println(new ReverseSentence().ReverseSentence("  "));
        System.out.println(new ReverseSentence().ReverseSentence(null));
        System.out.println(new ReverseSentence().ReverseSentence("i am a stu."));
    }


    public String ReverseSentence(String str) {
        if (str == null || str.matches(" *")) {
            return str;
        }
        char[] ch = str.toCharArray();
        int len = ch.length;
        int l = 0;
        //单词旋转
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                reverse(ch, l, i);
                break;
            }
            if (ch[i] == ' ') {
                reverse(ch, l, i - 1);
                l = i + 1;
            }
        }
        reverse(ch, 0, len - 1);
        return new String(ch);
    }

    private void reverse(char[] ch, int l, int r) {
        char c;
        int len = l + r;
        for (int i = l; i <= len / 2; i++) {
            c = ch[i];
            ch[i] = ch[len - i];
            ch[len - i] = c;
        }
    }
}
