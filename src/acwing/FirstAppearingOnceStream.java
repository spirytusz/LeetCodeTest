package acwing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.acwing.com/problem/content/60/">64. 字符流中第一个只出现一次的字符</a>
 */
public class FirstAppearingOnceStream {
    private final Queue<Character> firstAppearCharacters = new LinkedList<>();
    private final int[] memory = new int[256];

    public void insert(char ch) {
        int appearCount = memory[ch];
        if (appearCount == 0) {
            firstAppearCharacters.offer(ch);
        } else {
            firstAppearCharacters.remove(ch);
        }
        memory[ch]++;
    }

    public char firstAppearingOnce() {
        return firstAppearCharacters.isEmpty() ? '#' : firstAppearCharacters.peek();
    }

    public static void main(String[] args) {
        String str = "google";
        FirstAppearingOnceStream stream = new FirstAppearingOnceStream();
        for (char c : str.toCharArray()) {
            stream.insert(c);
            System.out.print(stream.firstAppearingOnce());
        }
    }
}
