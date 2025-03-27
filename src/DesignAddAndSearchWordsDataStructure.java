
/**
 * <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">211. Design Add and Search Words Data Structure</a>
 *
 * <p>Design a data structure that supports adding new words and finding if a string matches any previously added string.</p>
 *
 * <p>Implement the <code>WordDictionary</code> class:</p>
 *
 * <ul>
 * 	<li><code>WordDictionary()</code>&nbsp;Initializes the object.</li>
 * 	<li><code>void addWord(word)</code> Adds <code>word</code> to the data structure, it can be matched later.</li>
 * 	<li><code>bool search(word)</code>&nbsp;Returns <code>true</code> if there is any string in the data structure that matches <code>word</code>&nbsp;or <code>false</code> otherwise. <code>word</code> may contain dots <code>&#39;.&#39;</code> where dots can be matched with any letter.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * [&quot;WordDictionary&quot;,&quot;addWord&quot;,&quot;addWord&quot;,&quot;addWord&quot;,&quot;search&quot;,&quot;search&quot;,&quot;search&quot;,&quot;search&quot;]
 * [[],[&quot;bad&quot;],[&quot;dad&quot;],[&quot;mad&quot;],[&quot;pad&quot;],[&quot;bad&quot;],[&quot;.ad&quot;],[&quot;b..&quot;]]
 * <strong>Output</strong>
 * [null,null,null,null,false,true,true,true]
 *
 * <strong>Explanation</strong>
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord(&quot;bad&quot;);
 * wordDictionary.addWord(&quot;dad&quot;);
 * wordDictionary.addWord(&quot;mad&quot;);
 * wordDictionary.search(&quot;pad&quot;); // return False
 * wordDictionary.search(&quot;bad&quot;); // return True
 * wordDictionary.search(&quot;.ad&quot;); // return True
 * wordDictionary.search(&quot;b..&quot;); // return True
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= word.length &lt;= 25</code></li>
 * 	<li><code>word</code> in <code>addWord</code> consists of lowercase English letters.</li>
 * 	<li><code>word</code> in <code>search</code> consist of <code>&#39;.&#39;</code> or lowercase English letters.</li>
 * 	<li>There will be at most <code>2</code> dots in <code>word</code> for <code>search</code> queries.</li>
 * 	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>addWord</code> and <code>search</code>.</li>
 * </ul>
 */
public class DesignAddAndSearchWordsDataStructure {


    private static class PrefixTreeNode {
        char value;
        PrefixTreeNode[] nodes;
        boolean wordEnd = false;

        public PrefixTreeNode(char c) {
            value = c;
            nodes = new PrefixTreeNode[26];
        }
    }

    private final PrefixTreeNode root = new PrefixTreeNode('*');

    public void addWord(String word) {
        PrefixTreeNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new PrefixTreeNode(c);
            }
            node = node.nodes[index];
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, PrefixTreeNode startNode) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                String substring = word.substring(i + 1);
                for (PrefixTreeNode candidateNode : startNode.nodes) {
                    if (candidateNode != null && search(substring, candidateNode)) {
                        return true;
                    }
                }
                return false;
            }
            int index = c - 'a';
            if (startNode.nodes[index] == null) {
                return false;
            }
            startNode = startNode.nodes[index];
        }
        return startNode.wordEnd;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        DesignAddAndSearchWordsDataStructure dictionary = new DesignAddAndSearchWordsDataStructure();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));
    }

    private static void testCase2() {
        DesignAddAndSearchWordsDataStructure dictionary = new DesignAddAndSearchWordsDataStructure();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search(".at"));

        dictionary.addWord("bat");
        System.out.println(dictionary.search(".at"));
        System.out.println(dictionary.search("an."));
        System.out.println(dictionary.search("a.d."));
        System.out.println(dictionary.search("b."));
        System.out.println(dictionary.search("a.d"));
        System.out.println(dictionary.search("."));
    }

    private static void testCase3() {
        DesignAddAndSearchWordsDataStructure dictionary = new DesignAddAndSearchWordsDataStructure();
        dictionary.addWord("a");
        dictionary.addWord("ab");

        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search("a."));
        System.out.println(dictionary.search("ab"));
        System.out.println(dictionary.search(".a"));
        System.out.println(dictionary.search(".b"));
        System.out.println(dictionary.search("ab."));
        System.out.println(dictionary.search("."));
        System.out.println(dictionary.search(".."));
    }
}
