class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, nums, ans, curr);
        return ans;
    }
    public void backtrack(int index, int[] nums, List<List<Integer>> ans, List<Integer> curr) {
       
            ans.add(new ArrayList<>(curr));
           

        for(int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, nums, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
