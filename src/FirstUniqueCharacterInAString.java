/**
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">387. First Unique Character in a String</a>
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[][] mapCountWithIndex = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mapCountWithIndex[c - 'a'][0]++;
            mapCountWithIndex[c - 'a'][1] = i;
        }
        int result = Integer.MAX_VALUE;
        for (int[] countWithIndex: mapCountWithIndex) {
            if (countWithIndex[0] == 1 && result > countWithIndex[1]) {
                result = countWithIndex[1];
            }
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("leetcode"));
    }
}
