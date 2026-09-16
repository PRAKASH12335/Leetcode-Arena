package Stack.Medium;

// 901. Online Stock Span

import java.util.Stack;

class Pair {
    int price;
    int span;
    public Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

public class L901 {
    Stack<Pair> st;
    public L901() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while(!st.isEmpty() && st.peek().price <= price){
            span += st.pop().span;
        }
        st.push(new Pair(price, span));
        return span;
    }

    public static void main(String[] args) {
        L901 stockSpanner = new L901();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)