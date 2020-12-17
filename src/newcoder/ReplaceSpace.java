package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    public static String replaceSpace(StringBuffer str) {
        final String s = "%20";
        final char target = ' ';
        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == target) {
                str.replace(i, i + 1, s);
            }
            i--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));
    }
}
