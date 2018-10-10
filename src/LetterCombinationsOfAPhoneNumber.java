import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Status: AC
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    static String[][] mapper;

    static {
        mapper = new String[10][];
        mapper[0] = new String[0];
        mapper[1] = new String[0];
        mapper[2] = new String[]{"a", "b", "c"};
        mapper[3] = new String[]{"d", "e", "f"};
        mapper[4] = new String[]{"g", "h", "i"};
        mapper[5] = new String[]{"j", "k", "l"};
        mapper[6] = new String[]{"m", "n", "o"};
        mapper[7] = new String[]{"p", "q", "r", "s"};
        mapper[8] = new String[]{"t", "u", "v"};
        mapper[9] = new String[]{"w", "x", "y", "z"};
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        String[][] subMapper = new String[digits.length()][];
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - 48;
            if (digit >= 10 || digit <= 1) {
                return new ArrayList<>();
            }
            subMapper[i] = mapper[digit];
        }
        List<String> result = new ArrayList<>();
        DFS(result, subMapper, new StringBuilder(), 0);
        return result;
    }

    private static void DFS(List<String> container, String[][] subMapper, StringBuilder stringBuilder, int depth) {
        if (depth < subMapper.length) {
            for (int i = 0; i < subMapper[depth].length; i++) {
                stringBuilder.append(subMapper[depth][i]);
                DFS(container, subMapper, stringBuilder, depth + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        } else {
            container.add(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

}