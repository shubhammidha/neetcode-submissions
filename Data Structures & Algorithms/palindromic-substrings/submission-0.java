public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        for(int len = 2; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                
                int j = i + len-1;

                if(s.charAt(i) == s.charAt(j)){
                    if(len == 2 || dp[i+1][j-1]){
                        dp[i][j] = true;

                        if(len > maxLen){
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] == true){
                    count += 1;
                }
            }
        }
        return count;
    }
}