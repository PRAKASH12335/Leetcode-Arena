package Striver.DP;

// DP 52. Evaluate Boolean Expression to True

public class EvaluateBooleanExpression {
    // Recursion
    public static int recursionHelper(int i, int j, boolean isTrue, String exp) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == true) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        int ways = 0;
        for (int index = i + 1; index <= j - 1; index += 2) {
            int leftT = recursionHelper(i, index - 1, true, exp);
            int leftF = recursionHelper(i, index - 1, false, exp);
            int rightT = recursionHelper(index + 1, j, true, exp);
            int rightF = recursionHelper(index + 1, j, false, exp);

            char operator = exp.charAt(index);
            if (operator == '&') {
                if (isTrue == true) {
                    ways += leftT * rightT;
                } else {
                    ways += leftT * rightF + leftF * rightT + leftF * rightF;
                }
            } else if (operator == '|') {
                if (isTrue == true) {
                    ways += leftT * rightF + leftF * rightT + leftT * rightT;
                } else {
                    ways += leftF * rightF;
                }
            } else if (operator == '^') {
                if (isTrue == true) {
                    ways += leftT * rightF + leftF * rightT;
                } else {
                    ways += leftF * rightF + leftT * rightT;
                }
            }
        }
        return ways;
    }

    public static int evaluateExpWays(String exp) {
        int n = exp.length();
        return recursionHelper(0, n - 1, true, exp);
    }

    public static void main(String[] args) {
        String exp = "F|T^F";
        int ways = evaluateExpWays(exp);
        System.out.println("The total number of ways: " + ways);
    }
}

// Time Complexity - O(2^N)
// Space Complexity - O(N)