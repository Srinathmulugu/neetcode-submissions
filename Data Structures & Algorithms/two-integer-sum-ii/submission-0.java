class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[2];
        int i =0;
        while(left < right){
            if(nums[left] + nums[right] == target){
                  return new int[] {left + 1, right + 1};
            }
            if(nums[left] + nums[right] < target){

                 left++;
            }
            if(nums[left] + nums[right] > target){
                right --;
            }
            
        }
        return ans;
    }
}
