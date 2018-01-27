package chap001_Longest_palindromic_substring;

/**
 * Created by zhaolei on 2018/1/27
 */
public class Main1 {
    public static void main(String[] args) {
        System.err.println(getLen(insert("12")));
    }

    private static int getLen(char[] str) {
        int[] p = new int[str.length];
        int mx = 0;
        int id = 0;
        int len = 0;
        for (int i = 0; i < str.length; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i - p[i] >= 0 && p[i] + i < str.length && str[p[i] + i] == str[i - p[i]]) {
                p[i]++;
            }
            if (mx < p[i] + i) {
                mx = p[i] + i;
                id = i;
            }
            len = len < p[i] ? p[i] : len;
        }
        return len - 1;
    }

    private static final char MARK = '#';

    private static char[] insert(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MARK);
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            stringBuilder.append(MARK);
        }
        return stringBuilder.toString().toCharArray();
    }
}
