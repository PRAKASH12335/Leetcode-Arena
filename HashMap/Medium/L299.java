package HashMap.Medium;

// 299. Bulls and Cows

public class L299 {

    public String getHint(String secret, String guess) {
        int cows = 0, bulls = 0;
        int[] nums = new int[10];
        for(int i=0;i<secret.length();i++){
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';
            if(s == g)
                bulls++;
            else{
                if(nums[s] > 0)
                    cows++;
                if(nums[g] < 0)
                    cows++;
                nums[s]--;
                nums[g]++;
            }
        }
        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        String secret = "1807", guess = "7810";
        System.out.println(new L299().getHint(secret, guess));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)