package Stack.Medium;

// 155. Min Stack

import java.util.Stack;

public class L155 {

    Stack<Integer> st;
    Stack<Integer> minSt;

    public L155() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty()) {
            minSt.push(val);
        } else if (val < minSt.peek()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.peek());
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
            minSt.pop();
        }
    }

    public int top() {
        return st.isEmpty() ? -1 : st.peek();
    }

    public int getMin() {
        return minSt.isEmpty() ? -1 : minSt.peek();
    }

    public static void main(String[] args) {
        L155 obj = new L155();
        obj.push(-2);
        obj.push(0);
        obj.push(3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)