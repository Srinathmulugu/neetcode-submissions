class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums.length == 0)
            return 0;
        int seq = 0;

        for (int num : nums) {
            set.add(num);
        }
        for(int num : nums){
           int length = 1;
            if (!set.contains(num - 1)) {
                int current = num;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
            }
            seq = Math.max(seq, length);
        }
    
        return seq;
    }
}
