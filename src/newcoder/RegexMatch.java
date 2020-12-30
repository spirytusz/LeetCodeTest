package newcoder;

/**
 * Link: https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&&tqId=11205&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * <p>
 * 解析：分是三种情况：
 * 1. s == p, str和pattern指针同时+1, s++, p++
 * 2. p == '.', 同1, str和pattern指针同时+1, s++, p++
 * 3. p + 1 == '*',表明p可以重复0次、1次或多次尝试s + 1, p和s, p + 2
 */
public class RegexMatch {

    public boolean match(char[] str, char[] pattern) {
        return matchDp(str, pattern);
    }

    private boolean matchInternal(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if (str.length == strIndex) {
            if (pattern.length == patternIndex) {
                return true;
            } else if (matchWildcard(pattern, patternIndex + 1)) {
                return matchInternal(str, pattern, strIndex, patternIndex + 2);
            } else {
                return false;
            }
        } else {
            if (matchWildcard(pattern, patternIndex + 1)) {
                if (matchCharacter(str[strIndex], pattern[patternIndex])) {
                    return matchInternal(str, pattern, strIndex, patternIndex + 2) || matchInternal(str, pattern, strIndex + 1, patternIndex);
                } else {
                    return matchInternal(str, pattern, strIndex, patternIndex + 2);
                }
            } else if (patternIndex < pattern.length && matchCharacter(str[strIndex], pattern[patternIndex])) {
                return matchInternal(str, pattern, strIndex + 1, patternIndex + 1);
            } else {
                return false;
            }
        }
    }

    private boolean matchDp(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length == 0) return true;
        boolean[][] result = new boolean[str.length + 1][pattern.length + 1];
        for (int s = 0; s <= str.length; s++) {
            for (int p = 0; p <= pattern.length; p++) {
                if (p == 0) {
                    result[s][p] = s == 0;
                } else {
                    if (pattern[p - 1] != '*') {
                        result[s][p] = (s > 0 && (pattern[p - 1] == str[s - 1] || pattern[p - 1] == '.')) && result[s - 1][p - 1];
                    } else {
                        result[s][p] |=  (p > 1 && result[s][p - 2]) || ((s > 0 && p > 1 && (pattern[p - 2] == str[s - 1] || pattern[p - 2] == '.')) && result[s - 1][p]);
                    }
                }
            }
        }
        return result[str.length][pattern.length];
    }

    private boolean matchCharacter(char s, char p) {
        return s == p || p == '.';
    }

    private boolean matchWildcard(char[] pattern, int index) {
        return index < pattern.length && pattern[index] == '*';
    }

    public static void main(String[] args) {
        System.out.println(new RegexMatch().match("a".toCharArray(), "ab*".toCharArray()));
    }
}
