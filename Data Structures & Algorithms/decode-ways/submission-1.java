class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }
    public int solve(int indx, String s, int[] dp) {
        if (indx == s.length()) {
            return 1;
        }
        if (dp[indx] != -1) {
            return dp[indx];
        }
        if (s.charAt(indx) == '0')
            return 0;

        int notpick = solve(indx + 1, s, dp);
        int pick = 0;

        if (indx + 1 < s.length()) {
            int num = (s.charAt(indx) - '0') * 10 + (s.charAt(indx + 1) - '0');
            if (num >= 10 && num <= 26) {
                pick = solve(indx + 2, s, dp);
            }
        }
        return dp[indx] = pick + notpick;
    }
}
