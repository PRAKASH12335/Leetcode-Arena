package Stack.Easy;

// 225. Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

public class L225 {

    Queue<Integer> q;

    public L225() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();
        while(size > 1){
            q.add(q.poll());
            size--;
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        L225 obj = new L225();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)