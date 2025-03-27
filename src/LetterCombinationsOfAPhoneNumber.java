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
 * Input: '23'
 * Output: ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf'].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    static char[][] sMapper;

    static {
        sMapper = new char[10][];
        sMapper[0] = new char[0];
        sMapper[1] = new char[0];
        sMapper[2] = new char[]{'a', 'b', 'c'};
        sMapper[3] = new char[]{'d', 'e', 'f'};
        sMapper[4] = new char[]{'g', 'h', 'i'};
        sMapper[5] = new char[]{'j', 'k', 'l'};
        sMapper[6] = new char[]{'m', 'n', 'o'};
        sMapper[7] = new char[]{'p', 'q', 'r', 's'};
        sMapper[8] = new char[]{'t', 'u', 'v'};
        sMapper[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        char[][] mappers = new char[digits.length()][];
        for (int i = 0; i < digits.length(); i++) {
            mappers[i] = sMapper[digits.charAt(i) - 48];
        }
        dfs(mappers, result, new StringBuilder(), 0);
        return result;
    }

    private static void dfs(char[][] mappers, List<String> result, StringBuilder stringBuilder, int layer) {
        if (layer == mappers.length) {
            result.add(stringBuilder.toString());
            return;
        }
        for (char ch : mappers[layer]) {
            stringBuilder.append(ch);
            dfs(mappers, result, stringBuilder, layer + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
    }
}