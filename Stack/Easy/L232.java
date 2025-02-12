package Stack.Easy;

// 232. Implement Queue using Stacks

import java.util.Stack;

public class L232 {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public L232() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        st2.push(x);
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    public int pop() {
        return st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public boolean empty() {
        return st1.isEmpty();
    }

    public static void main(String[] args) {
        L232 obj = new L232();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)