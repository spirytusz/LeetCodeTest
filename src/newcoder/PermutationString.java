package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&&tqId=11180&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationString {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        permutationInternal(str, result, new StringBuilder(), new HashMap<>(), used);
        return result;
    }

    private void permutationInternal(String str, ArrayList<String> result, StringBuilder cache, HashMap<String, Integer> map, boolean[] used) {
        if (cache.length() == str.length() && !map.containsKey(cache.toString())) {
            result.add(cache.toString());
            map.put(cache.toString(), 1);
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    cache.append(str.charAt(i));
                    permutationInternal(str, result, cache, map, used);
                    cache.deleteCharAt(cache.length() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationString().permutation("aab"));
    }
}
