package acwing;

/**
 * <a href="https://www.acwing.com/problem/content/59/">63. 字符串中第一个只出现一次的字符</a>
 */
public class FirstNotRepeatingChar {
    public char firstNotRepeatingChar(String s) {
        if (s == null || s.length() == 0) {
            return '#';
        }

        int[] memory = new int[256];
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            memory[s.charAt(j)]++;

            while (i < s.length() && memory[s.charAt(i)] > 1) {
                i++;
            }
            j++;
        }
        return i < s.length() ? s.charAt(i) : '#';
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().firstNotRepeatingChar("ababc"));
    }
}
