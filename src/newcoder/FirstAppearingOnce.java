package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&&tqId=11207&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnce {

    private final StringBuilder builder = new StringBuilder();

    public void insert(char ch) {
        builder.append(ch);
    }

    public char firstAppearingOnce() {
        for (int i = 0; i < builder.length(); i++) {
            char target = builder.charAt(i);
            boolean appearOnce = true;
            for (int j = 0; j < builder.length(); j++) {
                if (i != j && target == builder.charAt(j)) {
                    appearOnce = false;
                    break;
                }
            }
            if (appearOnce) {
                return target;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.insert('g');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('o');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('o');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('g');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('l');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
        firstAppearingOnce.insert('e');
        System.out.println(firstAppearingOnce.firstAppearingOnce());
    }

}
