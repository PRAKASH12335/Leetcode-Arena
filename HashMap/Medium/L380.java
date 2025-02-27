package HashMap.Medium;

// 380. Insert Delete GetRandom O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class L380 {

    List<Integer> list;
    HashMap<Integer, Integer> map;

    public L380() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        int size = list.size();
        list.add(val);
        map.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int currIndex = map.get(val);
        int last = list.size() - 1;
        list.set(currIndex, list.get(last));
        map.put(list.get(last), currIndex);
        map.remove(val);
        list.remove(last);
        return true;
    }

    public int getRandom() {
        if (list.size() == 0)
            return 0;
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        L380 obj = new L380();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}

// Time Complexity - O(1)
// Space Complexity - O(N)