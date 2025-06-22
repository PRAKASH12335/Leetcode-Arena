package HashMap.Hard;

// 432. All O`one Data Structure

import java.util.HashMap;
import java.util.TreeSet;

class Pair {
    int count;
    String str;

    public Pair(int count, String str) {
        this.count = count;
        this.str = str;
    }
}

public class L432 {
    HashMap<String, Integer> count;
    TreeSet<Pair> set;

    public L432() {
        count = new HashMap<>();
        set = new TreeSet<>((a, b) -> a.count == b.count ? a.str.compareTo(b.str) : a.count - b.count);
    }

    public void inc(String key) {
        int cnt = count.getOrDefault(key, 0);
        count.put(key, cnt + 1);
        set.remove(new Pair(cnt, key));
        set.add(new Pair(cnt + 1, key));
    }

    public void dec(String key) {
        int cnt = count.getOrDefault(key, 0);
        if (cnt == 1) {
            count.remove(key);
            set.remove(new Pair(cnt, key));
        } else {
            count.put(key, cnt - 1);
            set.remove(new Pair(cnt, key));
            set.add(new Pair(cnt - 1, key));
        }
    }

    public String getMaxKey() {
        return set.isEmpty() ? "" : set.last().str;
    }

    public String getMinKey() {
        return set.isEmpty() ? "" : set.first().str;
    }

    public static void main(String[] args) {
        L432 allOne = new L432();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "leet"
    }
}

// Time complexity - O(1)
// Space complexity - O(N)