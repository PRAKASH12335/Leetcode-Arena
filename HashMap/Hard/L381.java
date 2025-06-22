package HashMap.Hard;

// 381. Insert Delete GetRandom O(1) - Duplicates allowed

import java.util.*;

public class L381 {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;

    public L381() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;

        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);

        int lastElement = list.get(list.size() - 1);
        list.set(removeIdx, lastElement);
        map.get(lastElement).add(removeIdx);

        map.get(lastElement).remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        L381 randomizedCollection = new L381();
        System.out.println(randomizedCollection.insert(1));   // return true since the collection does not contain 1.
        // Inserts 1 into the collection.
        System.out.println(randomizedCollection.insert(1));   // return false since the collection contains 1.
        // Inserts another 1 into the collection. Collection now contains [1,1].
        System.out.println(randomizedCollection.insert(2));   // return true since the collection does not contain 2.
        // Inserts 2 into the collection. Collection now contains [1,1,2].
        System.out.println(randomizedCollection.getRandom()); // getRandom should:
        // - return 1 with probability 2/3, or
        // - return 2 with probability 1/3.
        System.out.println(randomizedCollection.remove(1));   // return true since the collection contains 1.
        // Removes 1 from the collection. Collection now contains [1,2].
        System.out.println(randomizedCollection.getRandom()); // getRandom should return 1 or 2, both equally likely.
    }
}

// Time complexity - O(1)
// Space complexity - O(N)