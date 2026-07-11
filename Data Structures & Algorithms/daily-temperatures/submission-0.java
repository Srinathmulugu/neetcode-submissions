class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
                }
                if (st.isEmpty()) {
                    ans[i] = 0;
                } else {
                    ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
}
