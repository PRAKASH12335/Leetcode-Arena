package src.LinkedList.Medium;

// 1472. Design Browser History

class BNode {
    String url;
    BNode prev;
    BNode next;

    BNode(String url) {
        this.url = url;
    }
}

public class L1472 {
    BNode currPage;

    public L1472(String homepage) {
        currPage = new BNode(homepage);
    }

    public void visit(String url) {
        BNode newPage = new BNode(url);
        currPage.next = newPage;
        newPage.prev = currPage;
        currPage = newPage;
    }

    public String back(int steps) {
        while (steps > 0) {
            if (currPage.prev != null)
                currPage = currPage.prev;
            else
                break;
            steps--;
        }
        return currPage.url;
    }

    public String forward(int steps) {
        while (steps > 0) {
            if (currPage.next != null)
                currPage = currPage.next;
            else
                break;
            steps--;
        }
        return currPage.url;
    }

    public static void main(String[] args) {
        L1472 browserHistory = new L1472("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

// Time Complexity - O(Steps)
// Space Complexity - O(N)