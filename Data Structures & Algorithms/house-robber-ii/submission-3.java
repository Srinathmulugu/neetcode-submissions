class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        int r = find(nums, 0, n - 2, dp);
        int nr = find(nums, 1, n - 1, dp2);
        return Math.max(r, nr);
    }
    public int find(int[]nums, int indx, int end, int[] dp){
          if(indx > end){
               return 0;
          }
          if(dp[indx] != -1){
             return dp[indx];
          }
          int rob =  nums[indx] + find(nums, indx + 2, end, dp);
          int nrob = find(nums, indx + 1, end, dp);
          dp[indx] =  Math.max(rob, nrob);
          return dp[indx];
    }
}
