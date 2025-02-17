import java.util.*;

/**
 * <a href="https://leetcode.com/problems/lru-cache/description/">146. LRU Cache</a>
 *
 * <p>Design a data structure that follows the constraints of a <strong><a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU" target="_blank">Least Recently Used (LRU) cache</a></strong>.</p>
 *
 * <p>Implement the <code>LRUCache</code> class:</p>
 *
 * <ul>
 * 	<li><code>LRUCache(int capacity)</code> Initialize the LRU cache with <strong>positive</strong> size <code>capacity</code>.</li>
 * 	<li><code>int get(int key)</code> Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li>
 * 	<li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if the <code>key</code> exists. Otherwise, add the <code>key-value</code> pair to the cache. If the number of keys exceeds the <code>capacity</code> from this operation, <strong>evict</strong> the least recently used key.</li>
 * </ul>
 *
 * <p>The functions <code>get</code> and <code>put</code> must each run in <code>O(1)</code> average time complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * [&quot;LRUCache&quot;, &quot;put&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;get&quot;, &quot;get&quot;]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * <strong>Output</strong>
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * <strong>Explanation</strong>
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= capacity &lt;= 3000</code></li>
 * 	<li><code>0 &lt;= key &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
 * 	<li>At most <code>2 * 10<sup>5</sup></code> calls will be made to <code>get</code> and <code>put</code>.</li>
 * </ul>
 */
public class LruCache {

    private static class Node {
        Integer key;
        Integer value;

        Node prev;
        Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> map;

    private final Node latest = new Node(null, null);
    private final Node oldest = new Node(null, null);

    public LruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);

        latest.next = oldest;
        oldest.prev = latest;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.value = value;
            insert(node);

            return;
        }

        if (map.size() >= capacity) {
            Node node = oldest.prev;
            remove(node);
            map.remove(node.key);
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
    }

    private void insert(Node target) {
        Node next = latest.next;

        next.prev = target;

        target.prev = latest;
        target.next = next;

        latest.next = target;
    }

    private void remove(Node target) {
        Node prev = target.prev;
        Node next = target.next;
        prev.next = next;
        next.prev = prev;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        System.out.println("testCase1");
        LruCache lRUCache = new LruCache(2);

        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}

        System.out.println(lRUCache.get(1));    // return 1

        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}

        System.out.println(lRUCache.get(2));    // returns -1 (not found)

        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}

        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4

        System.out.println();
        System.out.println();
    }

    private static void testCase2() {
        System.out.println("testCase2");
        LruCache cache = new LruCache(2); // null
        System.out.println(cache.get(2)); // -1
        cache.put(2, 6); // null
        System.out.println(cache.get(1)); // -1
        cache.put(1, 5); // null
        cache.put(1, 2); // null
        System.out.println(cache.get(1)); // 2
        System.out.println(cache.get(2)); // 6

        System.out.println();
        System.out.println();
    }

    private static void testCase3() {
        System.out.println("testCase3");
        LruCache cache = new LruCache(1); // null

        System.out.println(cache.get(6)); // -1
        System.out.println(cache.get(8));  // -1

        cache.put(12, 1); // null

        System.out.println(cache.get(2)); // -1

        cache.put(15, 11); // null
        cache.put(5, 2); // null
        cache.put(1, 15); // null
        cache.put(4, 2); // null

        System.out.println(cache.get(5));  // -1

        cache.put(15, 15); // null

        System.out.println();
        System.out.println();
    }
}
