import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/">151. Reverse Words in a String</a>
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        List<String> strings = new ArrayList<>();
        StringBuilder tempChars = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                tempChars.append(s.charAt(i));
            } else {
                if (tempChars.length() > 0) {
                    strings.add(tempChars.toString());
                }
                tempChars.delete(0, tempChars.length());
            }
        }
        if (tempChars.length() != 0) {
            strings.add(tempChars.toString());
        }
        StringBuilder builder = new StringBuilder();
        for (int i = strings.size() - 1; i >= 0; i--) {
            builder.append(strings.get(i));
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("Friend     "));
    }
}
