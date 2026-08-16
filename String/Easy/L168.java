package String.Easy;

// 168. Excel Sheet Column Title

public class L168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) return "";
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            // int rem = columnNumber%26;
            // if(rem == 0){
            //     char c = 'Z';
            //     sb.append(c);
            //     columnNumber = columnNumber/26-1;
            // }else{
            //     char c = (char)(rem+'A'-1);
            //     sb.append(c);
            //     columnNumber = columnNumber/26;
            // }
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(new L168().convertToTitle(columnNumber));
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)