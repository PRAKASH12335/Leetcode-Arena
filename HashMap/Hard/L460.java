package HashMap.Hard;

// 460. LFU Cache

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value, freq;
    Node next, prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DLL {
    int size;
    Node head, tail;

    public DLL() {
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addToDLL(Node node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
        size++;
    }

    public void removeFromDLL(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }
}

public class L460 {
    Map<Integer, Node> cache;
    Map<Integer, DLL> freqMap;
    int capacity, currSize, minFreq;

    public L460(int capacity) {
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.value;
    }

    public void updateNode(Node node) {
        // Remove the node from freqMap DLL
        int currFreq = node.freq;
        DLL currList = freqMap.get(currFreq);
        currList.removeFromDLL(node);

        if (currFreq == minFreq && currList.size == 0)
            minFreq++;

        // Add the node to new FreqMap
        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.addToDLL(node);
        freqMap.put(node.freq, newList);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        // Update the node with key and value  if it already exists
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            // Update the node with key and value if not exists
            currSize++;
            if (currSize > capacity) {
                DLL minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeFromDLL(minFreqList.tail.prev);
                currSize--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            DLL currList = freqMap.getOrDefault(1, new DLL());
            currList.addToDLL(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        L460 lfu = new L460(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}

// Time complexity - O(1)
// Space complexity - O(N)