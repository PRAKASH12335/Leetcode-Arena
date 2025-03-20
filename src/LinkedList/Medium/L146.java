package src.LinkedList.Medium;

// 146. LRU Cache

import java.util.HashMap;

public class L146 {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    Node head = new Node();
    Node tail = new Node();
    HashMap<Integer, Node> map;
    int cacheCapacity;

    public L146(int capacity) {
        cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    private void add(Node node) {
        node.next = head.next;
        ;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    private void remove(Node node) {
        Node node_next = node.next;
        Node node_prev = node.prev;
        node_next.prev = node_prev;
        node_prev.next = node_next;
    }

    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            value = node.value;
            remove(node);
            add(node);
        }
        return value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            add(node);
        } else {
            if (map.size() == cacheCapacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node temp = new Node();
            temp.key = key;
            temp.value = value;
            add(temp);
            map.put(key, temp);
        }
    }

    public static void main(String[] args) {
        L146 lRUCache = new L146(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

// Time Complexity - O(1)
// Space Complexity - O(N)