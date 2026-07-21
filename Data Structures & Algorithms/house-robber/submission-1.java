class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int idx = 0;

        Arrays.fill(dp, -1);
        return find(nums, dp, 0);
    }

    public int find(int[] nums, int[] dp, int idx){
          if(idx >= nums.length){
              return 0;
          }
          if(dp[idx] != -1){
              return dp[idx];
          }

          int rob = nums[idx] + find(nums, dp, idx + 2);
          int nrob = find(nums, dp, idx + 1);
          dp[idx] =  Math.max(rob, nrob);
          return dp[idx];
    }
}
